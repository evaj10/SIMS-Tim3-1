package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import konstante.Konstante;
import model.Aplikacija;

/*
 * Glavni frame za prikaz tlocrta i manipulisanje komponentama i korisnicima, klasa naslednica JFrame-a
 */

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1884063759494311563L;

	// glavni prozor je singlton
	private static MainFrame instance = null;
	
	private static boolean made = false;
	
	private JPanel panel;

	private MenuBar menuBar;

	private JButton btnKreiranjeKorisnika = new JButton("Kreiranje korisnika");
	private JButton btnUnapredjivanjeKorisnika = new JButton("Unapredjivanje korisnika");
	private JButton btnIzmenaPodatakaKorisnika = new JButton("Izmena podataka korisnika");
	private JButton btnBrisanjeKorisnika = new JButton("Brisanje korisnika");
	private JButton btnPregledKorisnika = new JButton("Pregled korisnika");
	private JButton btnIzmenaPodataka = new JButton("Izmena sopstvenih podataka");
	private JButton btnLogOut = new JButton("Log Out");
	
	private Aplikacija app;
	
	int x;
	int y;

	public static MainFrame getInstance() {
		if (instance == null) {
			instance = new MainFrame();
			instance.initGUI();
		}
		return instance;
	}
	
	public static boolean getMade() {
		return made;
	}
	
	public static void setMade(boolean in) {
		made = in;
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

		// sobe.setLayout(new GridBagLayout());
		// sobe.setLayout(new GridLayout(7,1,0,10));

		// dodavanje dugmeta za svaku sobu u tlocrtu
		/*
		 * for (Soba s : app.getTlocrt().getSobe()) { JButton btnSoba = new
		 * JButton(s.getIme()); sobe.add(btnSoba); }
		 */

		JScrollPane spSobeScroll = new JScrollPane(sobePain);
		spSobeScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(spSobeScroll, BorderLayout.WEST);

		JPanel opcijePain = new JPanel();
		opcijePain.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 0, Color.gray));
		opcijePain.setPreferredSize(preferredSize);
		opcijePain.setLayout(new GridLayout(7, 1, 0, 10));

		opcijePain.add(btnKreiranjeKorisnika);
		opcijePain.add(btnUnapredjivanjeKorisnika);
		opcijePain.add(btnIzmenaPodatakaKorisnika);
		opcijePain.add(btnBrisanjeKorisnika);
		opcijePain.add(btnPregledKorisnika);
		opcijePain.add(btnIzmenaPodataka);
		opcijePain.add(btnLogOut);

		panel.add(opcijePain, BorderLayout.EAST);

		JPanel centralPain = new JPanel(new BorderLayout());

		JLabel lblTlocrtImage = new JLabel();
		centralPain.add(lblTlocrtImage, BorderLayout.CENTER);

		ImageIcon imgTlocrt = new StretchIcon(
				new ImageIcon(Konstante.TLOCRT1).getImage(), false);
		lblTlocrtImage.setIcon(imgTlocrt);

		JButton btnProba = new JButton("PROBA");
		lblTlocrtImage.setLayout(null);
		btnProba.setBounds(lblTlocrtImage.getLocation().x + 200, lblTlocrtImage.getLocation().y, 100, 60);
		
		class ResizeListener extends ComponentAdapter {
			public void componentResized(ComponentEvent e) {
				//lblTlocrtImage.getIcon();
				x = getSize().width;
				y = getSize().height;
				int xw = centralPain.getSize().width;
				int yw = centralPain.getSize().height;
				//int z = lblTlocrtImage.getSize().width;
				//int p = lblTlocrtImage.getSize().height;
				
				int xp = ((xw * 100) / x) / 2;
				int yp = ((yw * 100) / y) / 2;
				
				btnProba.setBounds(lblTlocrtImage.getLocation().x + xp, 
						lblTlocrtImage.getLocation().y + yp, 
						lblTlocrtImage.getSize().width / 8, 
						lblTlocrtImage.getSize().height / 14);
				x = xw;
				y = yw;
			}
		}
		this.addComponentListener(new ResizeListener());
		
		lblTlocrtImage.add(btnProba);

		panel.add(centralPain, BorderLayout.CENTER);

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
	
	public void addVodaIzvestajListener(ActionListener a) {
		menuBar.getMiVoda().addActionListener(a);
	}
	
	public void addGasIzvestajListener(ActionListener a) {
		menuBar.getMiGas().addActionListener(a);
	}
	
	public void addStrujaIzvestajListener(ActionListener a) {
		menuBar.getMiStruja().addActionListener(a);
	}
	
	public void addKreiranjeKorisnikaListener(ActionListener a) {
		btnKreiranjeKorisnika.addActionListener(a);
		menuBar.getMiKreirajKorisnika().addActionListener(a);
	}
	
	public void addUnapredjivanjeKorisnikaListener(ActionListener a) {
		btnUnapredjivanjeKorisnika.addActionListener(a);
		menuBar.getMiUnaprediKorisnika().addActionListener(a);
	}
	
	public void addIzmenaPodatakaKorisnikaListener(ActionListener a) {
		btnIzmenaPodatakaKorisnika.addActionListener(a);
		menuBar.getMiIzmeniPodatkeKorisnika().addActionListener(a);
	}
	
	public void addBrisanjeKorisnikaListener(ActionListener a) {
		btnBrisanjeKorisnika.addActionListener(a);
		menuBar.getMiBrisanjeKorisnika().addActionListener(a);
	}
	
	public void addPregledKorisnikaListener(ActionListener a) {
		btnPregledKorisnika.addActionListener(a);
		menuBar.getMiPregledKorisnika().addActionListener(a);
	}
	
	public void addIzmenaSopstvenihPodatakaListener(ActionListener a) {
		btnIzmenaPodataka.addActionListener(a);
		menuBar.getMiIzmeniPodatke().addActionListener(a);
	}
	
	public void addLogoutListener(ActionListener a) {
		btnLogOut.addActionListener(a);
		menuBar.getMiLogout().addActionListener(a);
	}
	
}
