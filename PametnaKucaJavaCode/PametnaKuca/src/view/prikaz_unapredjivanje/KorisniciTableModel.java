package view.prikaz_unapredjivanje;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.korisnik.Nalog;

@SuppressWarnings("serial")
public class KorisniciTableModel extends AbstractTableModel {

	private String[] columnNames ;	//niz naziva kolona
    private List<Nalog> korisnici; //referenca na klasu koja implemenitra Itablemodel

    public KorisniciTableModel(List<Nalog> korisnici) {
    	this.columnNames = new String[7];
    	this.columnNames[0] = "Korisnicko ime";
    	this.columnNames[1] = "Lozinka";
    	this.columnNames[2] = "Prezime";
    	this.columnNames[3] = "Ime";
    	this.columnNames[4] = "Pol";
    	this.columnNames[5] = "Datum rodjenja";
    	this.columnNames[6] = "Tip korisnika";
    	this.korisnici = korisnici;
   
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return korisnici.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		switch(columnIndex){
			case 0: return korisnici.get(rowIndex).getKorisnickoIme();
			case 1: return korisnici.get(rowIndex).getSifra();
			case 2: return korisnici.get(rowIndex).getKorisnik().getPrezime();
			case 3: return korisnici.get(rowIndex).getKorisnik().getIme();
			case 4:	return korisnici.get(rowIndex).getKorisnik().getPol();
			case 5:	return df.format(korisnici.get(rowIndex).getKorisnik().getDatumRodjenja());
			case 6:	return korisnici.get(rowIndex).getKorisnik().getTipKorisnika();
		}
		return "";
	}

}
