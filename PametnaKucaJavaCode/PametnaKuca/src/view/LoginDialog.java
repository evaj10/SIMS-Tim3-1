package view;

import java.awt.Dimension;
import java.awt.Font;
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

/*
 * Dijalog za Login korisnika, klasa naslednica JDialog-a
 */

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	private JPanel panel;
	private JLabel lblLogo;
	private JLabel lblLogin;
	private JLabel lblName;
	private JTextField txfUsername;
	private JLabel lblPassword;
	private JTextField txfPassword;
	private JButton btnLogIn;
	private JButton btnReport;

	public LoginDialog() {
		setResizable(false);
		setTitle("Inteligentna Softverska Aplikazija za Kucu - Prijava");
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());
		
		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		setWindowSize();
		setLocationRelativeTo(null);
		
		// postavljamo raspored komponenti
		createGUI();
		createLayout();
		
		// povezivanje dugmadi
		//attachBtnListeners();
		
		// gasenje dijaloga = gasenje aplikacije
		terminateOnExit();
	}

	private void setWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 4, screenHeight / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());

		ImageIcon imgLogo = new ImageIcon(Konstante.APP_LOGO);
		lblLogo = new JLabel("", imgLogo, JLabel.CENTER);
		lblLogo.setMaximumSize(new Dimension(100, 100));
		
		lblLogin = new JLabel("Prijava", JLabel.CENTER);
		lblLogin.setFont(new Font(Font.DIALOG,Font.BOLD,16));

		lblName = new JLabel("Korisnicko ime: ");
		txfUsername = new JTextField();
		lblPassword = new JLabel("Lozinka: ");
		txfPassword = new JTextField();

		btnLogIn = new JButton("ULAZAK U KUCU");
		btnReport = new JButton("IZVESTAJI");
	}

	private void createLayout() {
		add(panel);

		panel.add(lblLogo, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 5, 5), 0, 0));

		panel.add(lblLogin, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));

		panel.add(lblName, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));

		panel.add(txfUsername, new GridBagConstraints(0, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));

		panel.add(lblPassword, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 50, 5, 50), 0, 0));

		panel.add(txfPassword, new GridBagConstraints(0, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));

		panel.add(btnLogIn, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 80, 5, 80), 0, 0));

		panel.add(btnReport, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(15, 5, 5, 20), 0, 0));
	
	}
	
	public void addLoginListener(ActionListener a) {
		btnLogIn.addActionListener(a);
	}
	
	public void addIzvestajListener(ActionListener a) {
		btnReport.addActionListener(a);
	}
	
	/*
	private void attachBtnListeners() {
		// dodaje se listener - ovo se poziva kad se klikne na dugme, tu cemo valjda
		// pozivati i funkcije za promjenu stanja aplikacije ??
		btnLogIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = MainFrame.getInstance();
				mf.setVisible(true);
				dispose(); // gasenje trenutnog dialoga
			}
		});

		btnReport.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginSpoljniDialog loginSpoljniDialog = new LoginSpoljniDialog();
				loginSpoljniDialog.setVisible(true);
				dispose();
			}
		});
	}*/
	
	private void terminateOnExit() {
		WindowListener exitListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	//System.out.println(lblLogo.getSize().height);
                   System.exit(0);
            }
        };
        this.addWindowListener(exitListener);
	}
	
	public String getUsername() {
		return txfUsername.getText();
	}
	
	public String getPassword() {
		return txfPassword.getText();
	}
}
