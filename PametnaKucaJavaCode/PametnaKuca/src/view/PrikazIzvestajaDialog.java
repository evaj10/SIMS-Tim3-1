package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PrikazIzvestajaDialog extends JDialog{
	
	private static final long serialVersionUID = 1884063759494311563L;
	
	private JPanel panel;
	private JLabel lblLogo;
	
	private JLabel lblAdresaKuce;
	private JTextField txfAdresaKuce;
	private JLabel lblPotrazilacIzvestaja;
	private JTextField txfPotrazilacIzvestaja;
	private JLabel lblTipIzvestaja;
	private JTextField txfTipIzvestaja;
	private JLabel lblDatum;
	private JTextField txfDatum;
	
	private JLabel lblPotrosenaKolicina;
	private JTextField txfPotrosenaKolicina;
	private JLabel lblUsteda;
	private JTextField txfUsteda;
	private JLabel lblPotrosenaKolicinaPrethodni;
	private JTextField txfPotrosenaKolicinaPrethodni;
	
	public PrikazIzvestajaDialog() {
		setResizable(false);
		setTitle("ISAK - Prikaz izvestaja korisniku");
		setIconImage(new ImageIcon("logo.gif").getImage());
		
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
		setSize(screenWidth / 2, screenHeight / 2);
	}

	private void createGUI() {
		panel = new JPanel(new GridBagLayout());
		
		ImageIcon imgLogo = new ImageIcon("files.gif");
		lblLogo = new JLabel("", imgLogo, JLabel.CENTER);

		lblAdresaKuce = new JLabel("Adresa kuce: ", JLabel.CENTER);
		txfAdresaKuce = new JTextField();
		txfAdresaKuce.setEditable(false);
		
		lblPotrazilacIzvestaja = new JLabel("Potrazilac izvestaja: ", JLabel.CENTER);
		txfPotrazilacIzvestaja = new JTextField();
		txfPotrazilacIzvestaja.setEditable(false);
		
		lblTipIzvestaja = new JLabel("Tip izvestaja: ", JLabel.CENTER);
		txfTipIzvestaja = new JTextField();
		txfTipIzvestaja.setEditable(false);
		
		lblDatum = new JLabel("Datum: ",JLabel.CENTER);
		txfDatum = new JTextField();
		txfDatum.setEditable(false);
		
		lblPotrosenaKolicina = new JLabel("<html>Potrosena kolicina u<BR> ovom mesecu: ", JLabel.CENTER);
		txfPotrosenaKolicina = new JTextField();
		txfPotrosenaKolicina.setEditable(false);
		
		lblPotrosenaKolicinaPrethodni = new JLabel("<html>Potrosena kolicina u<BR> proslom mesecu: ", JLabel.CENTER);
		txfPotrosenaKolicinaPrethodni = new JTextField();
		txfPotrosenaKolicinaPrethodni.setEditable(false);
		
		lblUsteda = new JLabel("Usteda u ovom mesecu: ", JLabel.CENTER);
		txfUsteda = new JTextField();
		txfUsteda.setEditable(false);
	}

	private void createLayout() {
		add(panel);
		
		//pozicioniranje u insets je postavljanje logoa "otpilike" na sredinu  
		panel.add(lblLogo, new GridBagConstraints(1, 0, 2, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets(0, 160, 5, 5), 0, 0));
		
		panel.add(lblAdresaKuce, new GridBagConstraints(0, 1, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfAdresaKuce, new GridBagConstraints(2, 1, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));

		panel.add(lblPotrazilacIzvestaja, new GridBagConstraints(0, 2, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfPotrazilacIzvestaja, new GridBagConstraints(2, 2, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));

		panel.add(lblTipIzvestaja, new GridBagConstraints(0, 3, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfTipIzvestaja, new GridBagConstraints(2, 3, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));

		panel.add(lblDatum, new GridBagConstraints(0, 4, 2, 1, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 25, 15, 5), 0, 0));
		
		panel.add(txfDatum, new GridBagConstraints(2, 4, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 15, 15), 0, 0));

		panel.add(lblPotrosenaKolicina, new GridBagConstraints(0, 5, 2, 1, 0, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfPotrosenaKolicina, new GridBagConstraints(2, 5, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));

		panel.add(lblPotrosenaKolicinaPrethodni, new GridBagConstraints(0, 6, 2, 2, 100, 0, GridBagConstraints.WEST,
				GridBagConstraints.NONE, new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfPotrosenaKolicinaPrethodni, new GridBagConstraints(2, 6, 2, 2, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));

		panel.add(lblUsteda, new GridBagConstraints(0, 8, 2, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE,
				new Insets(5, 25, 5, 5), 0, 0));
		
		panel.add(txfUsteda, new GridBagConstraints(2, 8, 2, 1, 200, 0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
				new Insets(5, 5, 5, 15), 0, 0));
	
	}
	
	public void setAll(String txfAdresaKuce, String txfPotrazilacIzvestaja, String txfTipIzvestaja,
			String txfDatum, String txfPotrosenaKolicina, String txtPotrosenaKolicinaPrethodni, String txtUsteda) {
		/* postavlja vrednosti u sve TextField-ove preko settera
		   prikaz izvestaja je read only */
		this.setTxfAdresaKuce(txfAdresaKuce);
		this.setTxfPotrazilacIzvestaja(txfPotrazilacIzvestaja);
		this.setTxfTipIzvestaja(txfTipIzvestaja);
		this.setTxfDatum(txfDatum);
		this.setTxfPotrosenaKolicina(txfPotrosenaKolicina);
		this.setTxfPotrosenaKolicinaPrethodni(txtPotrosenaKolicinaPrethodni);
		this.setTxfUsteda(txtUsteda);
	}

	public void setTxfAdresaKuce(String txfAdresaKuce) {
		this.txfAdresaKuce.setText(txfAdresaKuce);
	}

	public void setTxfPotrazilacIzvestaja(String txfPotrazilacIzvestaja) {
		this.txfPotrazilacIzvestaja.setText(txfPotrazilacIzvestaja);
	}

	public void setTxfTipIzvestaja(String txfTipIzvestaja) {
		this.txfTipIzvestaja.setText(txfTipIzvestaja);
	}

	public void setTxfDatum(String txfDatum) {
		this.txfDatum.setText(txfDatum);
	}

	public void setTxfUsteda(String txtUsteda) {
		this.txfUsteda.setText(txtUsteda);
	}

	public void setTxfPotrosenaKolicinaPrethodni(String txtPotrosenaKolicinaPrethodni) {
		this.txfPotrosenaKolicinaPrethodni.setText(txtPotrosenaKolicinaPrethodni);
	}

	public void setTxfPotrosenaKolicina(String txfPotrosenaKolicina) {
		this.txfPotrosenaKolicina.setText(txfPotrosenaKolicina);
	}
	

	public static void main(String args[]) {
		PrikazIzvestajaDialog prozor = new PrikazIzvestajaDialog();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar calendar = Calendar.getInstance();
		prozor.setAll("Masarikova 14", "Zli blizanac - Milojica", "Gas gas", sdf.format(calendar.getTime()), "150", "200", "50");
		prozor.setVisible(true);
	}
}