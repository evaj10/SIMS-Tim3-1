package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BrisanjeKorisnikaDialog extends JDialog{
	
	private static final long serialVersionUID = 1884063759494311563L;
	
	private JPanel panel;
	
	private JLabel lblUnosKorisnickogImena;
	private JTextField txfKorisnickoIme;
	private JButton btnZaboravili;
	public PredlogKorisnikaDialog dialog;
	private JButton btnUkloni;
	
	
	public BrisanjeKorisnikaDialog() {
		setResizable(false);
		setTitle("ISAK - Prikaz izvestaja korisniku");
		setIconImage(new ImageIcon("logo.gif").getImage());
		this.dialog = new PredlogKorisnikaDialog();
		
		setWindowSize();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		// postavljamo raspored komponenti
		createGUI();
		createLayout();
	}
	
	private void setWindowSize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 4, screenHeight / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());
		
		lblUnosKorisnickogImena = new JLabel("Unesite korisnicko ime: ", JLabel.CENTER);
		txfKorisnickoIme = new JTextField();
		
		btnZaboravili = new JButton("<html><u>Ne znate korisnicka imena u sistemu?");
		btnZaboravili.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
		
		btnUkloni = new JButton("IZBRISI");
	}

	private void createLayout() {
		add(panel);
		
		panel.add(lblUnosKorisnickogImena, new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(30, 30, 5, 30), 0, 0));
		
		panel.add(txfKorisnickoIme, new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 30, 5, 30), 0, 0));
		
		panel.add(btnZaboravili, new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(5, 30, 20, 30), 0, 0));
		
		panel.add(btnUkloni, new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
				new Insets(50, 150, 5, 30), 0, 0));
		
		
	
	}
	
	public void addIzbrisiListener(ActionListener a) {
		btnUkloni.addActionListener(a);
	}
	
	public String getTxfKorisnickoIme() {
		return txfKorisnickoIme.getText();
	}
	
	public class PredlogKorisnikaDialog extends JDialog{
		
		private static final long serialVersionUID = 1884063759494311563L;
		private JPanel panel;
		private JScrollPane scroll;
		
		public PredlogKorisnikaDialog() {
			setResizable(false);
			setTitle("ISAK - Ispis korisnika");
			setIconImage(new ImageIcon("logo.gif").getImage());
			
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;
			setSize(screenWidth / 6, screenHeight / 2);
			setLocationRelativeTo(null);
			
			// postavljamo raspored komponenti
			panel = new JPanel(new GridLayout(0,1,0,10));
			scroll = new JScrollPane(panel);
			scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			add(scroll);
			
		}
		
		public void setKorisnici(ArrayList<String> korisnici) {
			//ovde treba da se prosledi ArrayList<Korisnik> korisnici, pa onda da se za svaki
			//ali ja sam za pocetak dala da prima ArrayList<String> korisnici
			for (String korisnik : korisnici) {
				JLabel lblKorisnik = new JLabel("<html>"+korisnik+"<BR>",JLabel.CENTER);
				panel.add(lblKorisnik);
			}
		}
	}
	
	
	public static void main(String args[]) {
		ArrayList<String> korisnici = new ArrayList<String>();
		korisnici.add("mikelandjelo");
		korisnici.add("uzbuna111");
		korisnici.add("lajanjeNaZvezde");
		korisnici.add("mikelandjelo");
		korisnici.add("uzbuna111");
		korisnici.add("lajanjeNaZvezde");
		korisnici.add("mikelandjelo");
		korisnici.add("uzbuna111");
		korisnici.add("lajanjeNaZvezde");
		korisnici.add("mikelandjelo");
		korisnici.add("uzbuna111");
		korisnici.add("lajanjeNaZvezde");
		korisnici.add("mikelandjelo");
		korisnici.add("uzbuna111");
		korisnici.add("lajanjeNaZvezde");
		BrisanjeKorisnikaDialog prozor = new BrisanjeKorisnikaDialog();
		prozor.dialog.setKorisnici(korisnici);
		prozor.setVisible(true);
	}
	
}
