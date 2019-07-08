package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import konstante.Konstante;
import model.komponente.Komponenta;
import model.komponente.Soba;
import view.dugmici.KomponentaButton;
import view.dugmici.SobaButton;

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
	
	private JPanel sobePain;
	private JScrollPane spSobeScroll;
	private JLabel lblTlocrtImage;
	
	private ArrayList<KomponentaButton> uredjaji = new ArrayList<KomponentaButton>();
	
	// promena velicine komponenti pri promeni velicine prozora
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
		setTitle("Inteligentna Softverska Aplikazija za Kucu");
		setIconImage(new ImageIcon(Konstante.APP_LOGO).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setWindowSize();
		setLocationRelativeTo(null);
		setResizable(false);

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
		sobePain = new JPanel();
		Dimension preferredSize = new Dimension(this.getSize().width / 5, this.getSize().height);
		sobePain.setPreferredSize(preferredSize);

		spSobeScroll = new JScrollPane(sobePain);
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

		lblTlocrtImage = new JLabel();
		centralPain.add(lblTlocrtImage, BorderLayout.CENTER);

		ImageIcon imgTlocrt = new StretchIcon(
				new ImageIcon(Konstante.TLOCRT1).getImage(), false);
		lblTlocrtImage.setIcon(imgTlocrt);	
		/*
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
		*/
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

	public void addSobe(List<Soba> sobe, ActionListener a) {
		sobePain.setLayout(new GridLayout(sobe.size(), 1, 0, 10));
		for (Soba s : sobe) {
			SobaButton s1 = new SobaButton(s);
			s1.addActionListener(a);
			sobePain.add(s1);
		}
	}

	public void addKomponente(Collection<Komponenta> komponente, ActionListener a) {
		for (Komponenta k : komponente) {
			KomponentaButton k1 = new KomponentaButton(k);
			uredjaji.add(k1);
			k1.setIcon(new ImageIcon(k.getTipKomponente().getSlika()));
			k1.addActionListener(a);
			k1.setBounds(k.getTacka().getX(), k.getTacka().getY(), 60, 60);
			lblTlocrtImage.add(k1);
		}
	}
	
	public void restrict() {
		btnBrisanjeKorisnika.setEnabled(false);
		btnIzmenaPodatakaKorisnika.setEnabled(false);
		btnKreiranjeKorisnika.setEnabled(false);
		btnUnapredjivanjeKorisnika.setEnabled(false);
		for (KomponentaButton k : uredjaji) {
			k.setEnabled(false);
		}
		menuBar.getMiBrisanjeKorisnika().setEnabled(false);
		menuBar.getMiIzmeniPodatkeKorisnika().setEnabled(false);
		menuBar.getMiKreirajKorisnika().setEnabled(false);
		menuBar.getMiUnaprediKorisnika().setEnabled(false);
	}
	
	public void permit() {
		btnBrisanjeKorisnika.setEnabled(true);
		btnIzmenaPodatakaKorisnika.setEnabled(true);
		btnKreiranjeKorisnika.setEnabled(true);
		btnUnapredjivanjeKorisnika.setEnabled(true);
		for (KomponentaButton k : uredjaji) {
			k.setEnabled(true);
		}
		menuBar.getMiBrisanjeKorisnika().setEnabled(true);
		menuBar.getMiIzmeniPodatkeKorisnika().setEnabled(true);
		menuBar.getMiKreirajKorisnika().setEnabled(true);
		menuBar.getMiUnaprediKorisnika().setEnabled(true);
	}
}
