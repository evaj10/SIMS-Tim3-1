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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IzvjestajDialog extends JDialog {

	private static final long serialVersionUID = 1884063759494311563L;

	public IzvjestajDialog() {
		setResizable(false);
		setTitle("Pametna kuca - Odabir izvjestaja");
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
		JLabel log = new JLabel("Odabir izvjestaja", JLabel.CENTER);

		// combo box za biranje izvjestaja
		Object[] items = { "VODA", "STRUJA", "GAS" };
		JComboBox c = new JComboBox();
		for (int i = 0; i < items.length; i++)
			c.addItem(items[i]);
		JLabel l = new JLabel("");

		JButton povratak = new JButton("POVRATAK");
		JButton ok = new JButton("TRAZI");

		// klikom na povratak se itvara dialog Login
		povratak.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginDialog loginDialog = new LoginDialog();
				loginDialog.setVisible(true);
				dispose();
			}
		});

		// kad se klikne ok, za sad ispise sta se desilo, a kasnije cemo staviti da se
		// posalje izvjestaj i odmah se vrati na Login (ovo zakomentarisano)
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * LoginDialog loginDialog=new LoginDialog(); loginDialog.setVisible(true);
				 * dispose();
				 */
				String izabrani = c.getSelectedItem().toString();
				l.setText("Izvjestaj tipa " + c.getSelectedItem().toString() + " je poslat!");
			}
		});

		add(panel);

		panel.add(labelLogo, new GridBagConstraints(0, 0, 2, 1, 0, 0, GridBagConstraints.CENTER,
				GridBagConstraints.BOTH, new Insets(0, 5, 5, 5), 0, 0));
		panel.add(log, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 5, 10, 5), 0, 0));
		panel.add(c, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 50, 5, 50), 0, 0));
		panel.add(l, new GridBagConstraints(0, 3, 2, 1, 100, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 50, 5, 50), 0, 0));
		panel.add(povratak, new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(55, 40, 5, 40), 0, 0));
		panel.add(ok, new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.BOTH,
				new Insets(57, 40, 5, 40), 0, 0));
	}

}
