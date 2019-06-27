package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {
	
	private JMenu mNalog;
	private JMenuItem miIzmeniPodatke;
	private JMenuItem miLogout;
	
	private JMenu mKorisnici;
	private JMenuItem miKreirajKorisnika;
	private JMenuItem miUnaprediKorisnika;
	private JMenuItem miIzmeniPodatkeKorisnika;
	private JMenuItem miPregledKorisnika;
	
	private JMenu mIzvestaji;
	private JMenuItem miVoda;
	private JMenuItem miGas;
	private JMenuItem miStruja;
	
	private JMenu mIzgled;
	private JMenu mIzgledAplikacije;
	
	public MenuBar() {
		mNalog = new JMenu("Nalog");
		miIzmeniPodatke = new JMenuItem("Izmeni sopstvene podatke");
		miLogout = new JMenuItem("Odjava");
		mNalog.add(miIzmeniPodatke);
		mNalog.add(miLogout);
		add(mNalog);
		
		mKorisnici = new JMenu("Korisnici");
		miKreirajKorisnika = new JMenuItem("Kreiraj korisnika");
		miUnaprediKorisnika = new JMenuItem("Unapredi korisnika");
		miIzmeniPodatkeKorisnika = new JMenuItem("Izmeni podatke korisnika");
		miPregledKorisnika = new JMenuItem("Pregled korisnika");
		mKorisnici.add(miKreirajKorisnika);
		mKorisnici.add(miUnaprediKorisnika);
		mKorisnici.add(miIzmeniPodatkeKorisnika);
		mKorisnici.add(miPregledKorisnika);
		add(mKorisnici);
		
		mIzvestaji = new JMenu("Izvestaji");
		miVoda = new JMenuItem("Voda");
		miGas = new JMenuItem("Gas");
		miStruja = new JMenuItem("Struja");
		mIzvestaji.add(miVoda);
		mIzvestaji.add(miGas);
		mIzvestaji.add(miStruja);
		add(mIzvestaji);
		
		mIzgled = new JMenu("Izgled");
		mIzgledAplikacije = new JMenu("Izgled aplikacije");
		mIzgled.add(mIzgledAplikacije);
		add(mIzgled);
		
		
		ButtonGroup bgLookAndFeel = new ButtonGroup();

		UIManager.LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();
		for (int i = 0; i < laf.length; i++) {
			JCheckBoxMenuItem mnucbItem = new JCheckBoxMenuItem(laf[i].getName());
			mnucbItem.setName(laf[i].getClassName());
			bgLookAndFeel.add(mnucbItem);
			if (UIManager.getLookAndFeel().getName().equals(laf[i].getName())) {

				mnucbItem.setSelected(true);
			}
			mnucbItem.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JCheckBoxMenuItem item = (JCheckBoxMenuItem) e.getSource();
					try {
						UIManager.setLookAndFeel(item.getName());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					SwingUtilities.updateComponentTreeUI(MainFrame.getInstance());

				}
			});
			mIzgledAplikacije.add(mnucbItem);
		}
	}
}
