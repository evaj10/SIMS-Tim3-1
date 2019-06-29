package view;

import controller.Kontroler;
import model.Aplikacija;

public class Main {

	public static void main(String[] args) {
		Aplikacija app = new Aplikacija();
		
		LoginDialog prozor = new LoginDialog();
		
		Kontroler kontroler = new Kontroler(prozor,app);
		
		prozor.setVisible(true);
	}

}