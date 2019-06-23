package view;

import java.awt.Dimension;
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

import view.IzvjestajDialog;

public class LoginSpoljniDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	public LoginSpoljniDialog() {
		setResizable(false);
		setTitle("Pametna kuca - Prijava spoljnog korisnika");
		setIconImage(new ImageIcon("logo.png").getImage());
		// postavljamo dimenziju dijaloga u zavisnosti od velicine ekrana na cetvrtinu
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		setSize(width / 4, height / 2);
		setLocationRelativeTo(null);

		// postavljamo mrezni raspored
		JPanel panel = new JPanel(new GridBagLayout());

		ImageIcon imgLogo = new ImageIcon("logo.png");
		JLabel labelLogo = new JLabel("", imgLogo, JLabel.CENTER);
		JLabel log = new JLabel("Prijava spoljnog korisnika", JLabel.CENTER);

		JLabel labelaID = new JLabel("ID firme: ");
		JTextField IDfirme = new JTextField();

		JButton povratak = new JButton("POVRATAK");
		JButton ok = new JButton("OK");

		povratak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = new LoginDialog();
				loginDialog.setVisible(true);
				dispose();
			}
		});

		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				IzvjestajDialog izvjestajDialog = new IzvjestajDialog();
				izvjestajDialog.setVisible(true);
				dispose();
			}
		});

		add(panel);

		panel.add(labelLogo, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		panel.add(log, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));
		panel.add(labelaID, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));
		panel.add(IDfirme, new GridBagConstraints(0, 3, 2, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(5, 50, 5, 50), 0, 0));
		panel.add(povratak, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(55, 40, 5, 40), 0, 0));
		panel.add(ok, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(57, 40, 5, 40), 0, 0));
	}

}
