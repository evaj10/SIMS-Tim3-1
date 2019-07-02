package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

@SuppressWarnings("serial")
public class PrikazStanjaSobeDialog extends JDialog {
	
	private JLabel lblNazivSobe;
	
	private JLabel lblTemperatura;
	private JLabel lblBroj1;
	private JLabel lblStepeni;
	
	private JLabel lblKomponente;
	private JComboBox<String> cmbKomponente;
	
	private JLabel lblVlaznost;
	private JLabel lblBroj2;
	private JLabel lblPosto;
	
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PrikazStanjaSobeDialog dialog = new PrikazStanjaSobeDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public PrikazStanjaSobeDialog() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setBounds(100, 100, 450, 247);
		setLocationRelativeTo(null);
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		{
			lblNazivSobe = new JLabel("Naziv Sobe");
			lblNazivSobe.setFont(new Font("Tahoma", Font.PLAIN, 17));
			GridBagConstraints gbc_lblNazivSobe = new GridBagConstraints();
			gbc_lblNazivSobe.gridwidth = 2;
			gbc_lblNazivSobe.insets = new Insets(20, 20, 20, 5);
			gbc_lblNazivSobe.gridx = 4;
			gbc_lblNazivSobe.gridy = 0;
			getContentPane().add(lblNazivSobe, gbc_lblNazivSobe);
		}
		{
			lblTemperatura = new JLabel("Temperatura:");
			lblTemperatura.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblTemperatura = new GridBagConstraints();
			gbc_lblTemperatura.insets = new Insets(10, 15, 5, 5);
			gbc_lblTemperatura.gridx = 1;
			gbc_lblTemperatura.gridy = 2;
			getContentPane().add(lblTemperatura, gbc_lblTemperatura);
		}
		{
			lblBroj1 = new JLabel("broj");
			lblBroj1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblBroj = new GridBagConstraints();
			gbc_lblBroj.insets = new Insets(10, 0, 5, 5);
			gbc_lblBroj.gridx = 2;
			gbc_lblBroj.gridy = 2;
			getContentPane().add(lblBroj1, gbc_lblBroj);
		}
		{
			lblStepeni = new JLabel("\u00B0C");
			lblStepeni.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblc = new GridBagConstraints();
			gbc_lblc.insets = new Insets(10, 0, 5, 5);
			gbc_lblc.gridx = 3;
			gbc_lblc.gridy = 2;
			getContentPane().add(lblStepeni, gbc_lblc);
		}
		{
			lblKomponente = new JLabel("Komponente:");
			lblKomponente.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblKomponente = new GridBagConstraints();
			gbc_lblKomponente.insets = new Insets(10, 0, 5, 0);
			gbc_lblKomponente.gridx = 6;
			gbc_lblKomponente.gridy = 2;
			getContentPane().add(lblKomponente, gbc_lblKomponente);
		}
		{
			lblVlaznost = new JLabel("Vlaznost:");
			lblVlaznost.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblVlaznost = new GridBagConstraints();
			gbc_lblVlaznost.insets = new Insets(10, 0, 5, 5);
			gbc_lblVlaznost.gridx = 1;
			gbc_lblVlaznost.gridy = 4;
			getContentPane().add(lblVlaznost, gbc_lblVlaznost);
		}
		{
			lblBroj2 = new JLabel("broj");
			lblBroj2.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_lblBroj_1 = new GridBagConstraints();
			gbc_lblBroj_1.insets = new Insets(10, 0, 5, 5);
			gbc_lblBroj_1.gridx = 2;
			gbc_lblBroj_1.gridy = 4;
			getContentPane().add(lblBroj2, gbc_lblBroj_1);
		}
		{
			lblPosto = new JLabel("%");
			lblPosto.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(10, 0, 5, 5);
			gbc_label.gridx = 3;
			gbc_label.gridy = 4;
			getContentPane().add(lblPosto, gbc_label);
		}
		{
			cmbKomponente = new JComboBox<String>();
			cmbKomponente.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.insets = new Insets(10, 0, 5, 15);
			gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_comboBox.gridx = 6;
			gbc_comboBox.gridy = 4;
			getContentPane().add(cmbKomponente, gbc_comboBox);
		}
		{
			btnOk = new JButton("OK");
			btnOk.setFont(new Font("Tahoma", Font.PLAIN, 15));
			GridBagConstraints gbc_btnOk = new GridBagConstraints();
			gbc_btnOk.insets = new Insets(23, 15, 15, 5);
			gbc_btnOk.gridx = 5;
			gbc_btnOk.gridy = 5;
			getContentPane().add(btnOk, gbc_btnOk);
		}
	}

}
