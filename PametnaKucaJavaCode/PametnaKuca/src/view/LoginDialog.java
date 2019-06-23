package view;

import java.awt.Dimension;
import view.LoginSpoljniDialog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	public LoginDialog() {
		setResizable(false);
		setTitle("Pametna kuca - Prijava");
		setIconImage(new ImageIcon("logo.png").getImage());
		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width / 4, height / 2);
		setLocationRelativeTo(null);

		// postavljamo mrezni raspored
		// setLayout(new BorderLayout());
		JPanel panel = new JPanel(new GridBagLayout());

		ImageIcon imgLogo = new ImageIcon("logo.png");
		JLabel labelLogo = new JLabel("", imgLogo, JLabel.CENTER);
		JLabel log = new JLabel("Prijava", JLabel.CENTER);

		JLabel labelaIme = new JLabel("Korisnicko ime: ");
		JTextField korisnickoIme = new JTextField();
		JLabel labelaLozinka = new JLabel("Lozinka: ");
		JTextField lozinka = new JTextField();

		JButton logIn = new JButton("ULAZAK U KUCU");
		JButton izvestaj = new JButton("IZVESTAJI");

		// dodaje se listener - ovo se poziva kad se klikne na dugme, tu cemo valjda
		// pozivati i funkcije za promjenu stanja aplikacije ??
		logIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = MainFrame.getInstance();
				mf.setVisible(true);
				dispose(); // gasenje trenutnog dialoga
			}
		});

		izvestaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginSpoljniDialog loginSpoljniDialog = new LoginSpoljniDialog();
				loginSpoljniDialog.setVisible(true);
				dispose();
			}
		});

		add(panel);

		panel.add(labelLogo, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		panel.add(log, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));
		panel.add(labelaIme, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));
		panel.add(korisnickoIme, new GridBagConstraints(0, 3, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));
		panel.add(labelaLozinka, new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 50, 5, 50), 0, 0));
		panel.add(lozinka, new GridBagConstraints(0, 5, 1, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));
		panel.add(logIn, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 80, 5, 80), 0, 0));
		panel.add(izvestaj, new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE,
				new Insets(15, 5, 5, 20), 0, 0));

	}

	public static void main(String[] args) {
		LoginDialog prozor = new LoginDialog();
		prozor.setVisible(true);
	}

}
