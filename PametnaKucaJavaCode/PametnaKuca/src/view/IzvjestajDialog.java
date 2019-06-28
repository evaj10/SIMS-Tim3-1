package view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import konstante.Konstante;

/*
 * Dijalog za izbor izvjestaja, klasa naslednica JDialog-a
 */

public class IzvjestajDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblLogin;
	private JComboBox cmbReports;
	private JLabel lblMessage;
	private JButton btnBack;
	private JButton btnChoose;

	public IzvjestajDialog() {
		setResizable(false);
		setTitle("Inteligentna Softverska Aplikazija za Kucu - Odabir izvjestaja");
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());

		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		setWindowSize();
		setLocationRelativeTo(null);

		// postavljamo raspored komponenti
		createGUI();
		createLayout();

		// povezivanje dugmadi
		attachBtnListeners();

		// gasenje dijaloga = gasenje aplikacije
		terminateOnExit();

	}

	private void setWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width / 4, height / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());

		ImageIcon imgLogo = new ImageIcon(Konstante.APP_LOGO);
		lblLogo = new JLabel("", imgLogo, JLabel.CENTER);
		lblLogin = new JLabel("Odabir izvjestaja", JLabel.CENTER);

		// combo box za biranje izvjestaja
		Object[] items = { "VODA", "STRUJA", "GAS" };
		cmbReports = new JComboBox();
		for (int i = 0; i < items.length; i++)
			cmbReports.addItem(items[i]);
		lblMessage = new JLabel("");

		btnBack = new JButton("POVRATAK");
		btnChoose = new JButton("TRAZI");
	}

	private void createLayout() {
		add(panel);

		panel.add(lblLogo, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 5, 5), 0, 0));

		panel.add(lblLogin, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));

		panel.add(cmbReports, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));

		panel.add(lblMessage, new GridBagConstraints(0, 3, 2, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));

		panel.add(btnBack, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(55, 40, 5, 40), 0, 0));

		panel.add(btnChoose, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(57, 40, 5, 40), 0, 0));
	}

	private void attachBtnListeners() {
		// klikom na povratak se otvara dialog Login
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = new LoginDialog();
				loginDialog.setVisible(true);
				dispose();
			}
		});

		// kad se klikne trazi, za sad ispise sta se desilo, a kasnije cemo staviti da
		// se
		// posalje izvjestaj i odmah se vrati na Login (ovo zakomentarisano)
		btnChoose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * LoginDialog loginDialog=new LoginDialog(); loginDialog.setVisible(true);
				 * dispose();
				 */
				String izabrani = cmbReports.getSelectedItem().toString();
				lblMessage.setText("Izvjestaj tipa " + cmbReports.getSelectedItem().toString() + " je poslat!");
			}
		});
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

}
