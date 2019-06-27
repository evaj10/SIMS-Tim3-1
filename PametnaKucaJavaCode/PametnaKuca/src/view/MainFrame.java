package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Aplikacija;
import konstante.Konstante;

/*
 * Glavni frame za prikaz tlocrta i manipulisanje komponentama i korisnicima, klasa naslednica JFrame-a
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1884063759494311563L;

	// glavni prozor je singlton
	private static MainFrame instance = null;

	private JPanel panel;

	private MenuBar menuBar;

	private Aplikacija app;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initGUI();
		}

		return instance;
	}

	public void initGUI() {
		setTitle("Inteligentna Softverska Aplikazija za Kucu " /* + app.getTlocrt().getNaziv() */);
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setWindowSize();
		setLocationRelativeTo(null);

		createGUI();
		setJMenuBar(menuBar);

		createLayout();
	}

	private void createGUI() {
		menuBar = new MenuBar();

	}

	private void createLayout() {
		panel = new JPanel(new BorderLayout());

		// kreiranje ScrollPane-a u levom delu prozora
		JPanel sobePain = new JPanel();
		Dimension preferredSize = new Dimension(this.getSize().width / 5, this.getSize().height);
		sobePain.setPreferredSize(preferredSize);
		sobePain.setLayout(new BoxLayout(sobePain, BoxLayout.Y_AXIS));
		
		//sobe.setLayout(new GridBagLayout());
		//sobe.setLayout(new GridLayout(7,1,0,10));
		
		// dodavanje dugmeta za svaku sobu u tlocrtu
		/*
		for (Soba s : app.getTlocrt().getSobe()) {
			JButton btnSoba = new JButton(s.getIme());
			sobe.add(btnSoba);
		}
		*/
		
		JScrollPane spSobeScroll = new JScrollPane(sobePain);
		spSobeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(spSobeScroll, BorderLayout.WEST);
		
		JPanel opcijePain = new JPanel();
		opcijePain.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.gray));
		opcijePain.setPreferredSize(preferredSize);
		opcijePain.setLayout(new GridLayout(7,1,0,10));
		
		JButton btnKreiranjeKorisnika = new JButton("Kreiranje korisnika");
		JButton btnUnapredjivanjeKorisnika = new JButton("Unapredjivanje korisnika");
		JButton btnIzmenaPodatakaKorisnika = new JButton("Izmena podataka korisnika");
		JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
		JButton btnIzvestaj = new JButton("Izvestaji");
		JButton btnIzmenaPodataka = new JButton("Izmena sopstvenih podataka");
		JButton btnLogOut = new JButton("Log Out");
		
		opcijePain.add(btnKreiranjeKorisnika);
		opcijePain.add(btnUnapredjivanjeKorisnika);
		opcijePain.add(btnIzmenaPodatakaKorisnika);
		opcijePain.add(btnBrisanjeKorisnika);
		opcijePain.add(btnIzvestaj);
		opcijePain.add(btnIzmenaPodataka);
		opcijePain.add(btnLogOut);
		
		panel.add(opcijePain, BorderLayout.EAST);
		
		add(panel);
	}

	private void setWindowSize() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);
		setMinimumSize(getSize());
	}
}
