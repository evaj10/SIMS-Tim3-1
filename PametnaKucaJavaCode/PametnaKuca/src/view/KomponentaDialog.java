package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import konstante.Konstante;

public class KomponentaDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	private JPanel panel;

	private JLabel lblLogo;
	private JLabel lblNaziv;
	private JLabel lblNazivKomponente;
	private JLabel lblTip;
	private JLabel lblTipKomponente;
	private JLabel lblSoba;
	private JLabel lblSobaKomponente;
	private JLabel lblOnOff;
	private JToggleButton tbOnOff;
	private JLabel lblVrijednost;
	private JTextField txfVrijednostKomponente;
	private JSlider slider;

	private JButton btnBack;
	private JButton btnConfirm;

	public KomponentaDialog() {
		setResizable(false);
		setTitle("ISAK");
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());

		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		setWindowSize();
		setLocationRelativeTo(null);

		// postavljamo raspored komponenti
		createGUI();
		createLayout();
		/*
		 * // povezivanje dugmadi attachBtnListeners();
		 */
		/*
		 * // gasenje dijaloga = gasenje aplikacije terminateOnExit();
		 */

	}

	private void setWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width / 4, height / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());

		ImageIcon imgLogo = new ImageIcon(Konstante.COMPANY_LOGO);
		lblLogo = new JLabel("", imgLogo, JLabel.CENTER);

		lblNaziv = new JLabel("Naziv uredjaja:");
		lblNazivKomponente = new JLabel("?");
		lblTip = new JLabel("Tip uredjaja:");
		lblTipKomponente = new JLabel("?");
		lblSoba = new JLabel("Soba:");
		lblSobaKomponente = new JLabel("?");
		lblOnOff = new JLabel("On/Off");
		tbOnOff = new JToggleButton();
		UIManager.put("ToggleButton.select", Color.GREEN);
		SwingUtilities.updateComponentTreeUI(tbOnOff);
		lblVrijednost = new JLabel("?vrijednost?:");
		txfVrijednostKomponente = new JTextField();
		slider = new JSlider(0, 100, 50);

		slider.setMajorTickSpacing(100);
		slider.setPaintLabels(true);
		// ovaj listener moze preci u kontroler ako bude trebalo, sad je ovdje da se
		// vidi kako ce izgledati
		txfVrijednostKomponente.setText("" + slider.getValue());
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent ce) {
				txfVrijednostKomponente.setText("" + slider.getValue());
			}
		});

		btnBack = new JButton("POVRATAK");
		btnConfirm = new JButton("POTVRDI");
	}

	private void createLayout() {
		add(panel);

		panel.add(lblLogo, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(lblNaziv, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(lblNazivKomponente, new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblTip, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(lblTipKomponente, new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblSoba, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(lblSobaKomponente, new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblOnOff, new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 50, 5, 5), 0, 0));

		panel.add(tbOnOff, new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 50), 0, 0));

		panel.add(lblVrijednost, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(5, 50, 5, 5), 0, 0));

		panel.add(txfVrijednostKomponente, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.BOTH, new Insets(5, 5, 5, 50), 0, 0));

		panel.add(slider, new GridBagConstraints(0, 7, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 5, 5), 0, 0));

		panel.add(btnBack, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 5, 15, 55), 0, 0));

		panel.add(btnConfirm, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.BOTH, new Insets(5, 5, 15, 5), 0, 0));
	}

	public void addPovratakListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void addPotvrdiListener(ActionListener a) {
		btnConfirm.addActionListener(a);
	}

	private void terminateOnExit() {
		WindowListener exitListener = new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		};
		this.addWindowListener(exitListener);
	}

	// testiranje
	public static void main(String[] args) {
		KomponentaDialog kd = new KomponentaDialog();
		kd.setVisible(true);
	}

}
