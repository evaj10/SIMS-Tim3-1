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

	private JLabel lblId;
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
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

		lblId = new JLabel("");
		ImageIcon imgLogo = new ImageIcon(Konstante.COMPANY_LOGO);
		lblLogo = new JLabel("");

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
				new Insets(5, 20, 5, 20), 0, 0));

		panel.add(btnBack, new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 20, 15, 5), 0, 0));

		panel.add(btnConfirm, new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.EAST,
				GridBagConstraints.BOTH, new Insets(5, 5, 15, 20), 0, 0));
	}

	public void addPovratakListener(ActionListener a) {
		btnBack.addActionListener(a);
	}

	public void addPotvrdiListener(ActionListener a) {
		btnConfirm.addActionListener(a);
	}
	
	public void setSlika(String slika) {
		ImageIcon imgLogo = new ImageIcon(slika);
		lblLogo.setIcon(imgLogo);
	}
	
	public void setNaziv(String n) {
		lblNazivKomponente.setText(n);
	}
	
	public void setTip(String t) {
		lblTipKomponente.setText(t);
	}
	
	public void setSoba(String s) {
		lblSobaKomponente.setText(s);;
	}
	
	public void setToggleButton(boolean b) {
		tbOnOff.setSelected(b);
	}
	
	public void setOpisVrijednosti(String o) {
		lblVrijednost.setText(o);
	}
	
	public void setVrijednost(int i) {
		txfVrijednostKomponente.setText(String.valueOf(i));
		slider.setValue(i);
	}
	
	public void setId(int i) {
		lblId.setText(String.valueOf(i));
	}
	
	public int getVrijednost() {
		return Integer.parseInt(txfVrijednostKomponente.getText());
	}
	
	public boolean getOnOff() {
		return tbOnOff.isSelected();
	}
	
	public int getId() {
		return Integer.parseInt(lblId.getText());
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
