package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import konstante.Konstante;
import view.IzvjestajDialog;

/*
 * Dijalog za Login spoljnog korisnika, klasa naslednica JDialog-a
 */

public class LoginSpoljniDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblLogin;
	private JLabel lblId;
	private JTextField txfId;
	private JButton btnBack;
	private JButton btnLogin;

	public LoginSpoljniDialog() {
		setResizable(false);
		setTitle("Inteligentna Softverska Aplikazija za Kucu - Prijava spoljnog korisnika");
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
		lblLogin = new JLabel("Prijava spoljnog korisnika", JLabel.CENTER);

		lblId = new JLabel("ID firme: ");
		txfId = new JTextField();

		btnBack = new JButton("POVRATAK");
		btnLogin = new JButton("OK");
	}

	private void createLayout() {
		add(panel);

		panel.add(lblLogo, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 5, 5), 0, 0));

		panel.add(lblLogin, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));

		panel.add(lblId, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));

		panel.add(txfId, new GridBagConstraints(0, 3, 2, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));

		panel.add(btnBack, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(55, 40, 5, 40), 0, 0));

		panel.add(btnLogin, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(57, 40, 5, 40), 0, 0));
	}

	private void attachBtnListeners() {
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = new LoginDialog();
				loginDialog.setVisible(true);
				dispose();
			}
		});

		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IzvjestajDialog izvjestajDialog = new IzvjestajDialog();
				izvjestajDialog.setVisible(true);
				dispose();
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
