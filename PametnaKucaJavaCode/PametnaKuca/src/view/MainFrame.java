package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MainFrame;

public class MainFrame extends JFrame {

	// glavni prozor je singleton
	private static MainFrame instance = null;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initGUI();
		}

		return instance;
	}
	


	public void initGUI() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setTitle("Pametna kuca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);

		// dodato samo jedno dugme zbog ostalih prozora
		JButton odjavi = new JButton("ODJAVA");
		odjavi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// potvrda za odjavljivanje
				String[] options = { "Da", "Ne" };
				int choice = JOptionPane.showOptionDialog(null,"Da li ste sigurni?", "Odjava", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if (choice == JOptionPane.YES_OPTION) {
					LoginDialog loginDialog = new LoginDialog();
					loginDialog.setVisible(true);
					MainFrame mf = MainFrame.getInstance();
					mf.setVisible(false);
				}
			}
		});
		JPanel panel = new JPanel(new GridBagLayout());
		add(panel);
		panel.add(odjavi, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
				new Insets(5, 5, 5, 5), 0, 0));

	}

}
