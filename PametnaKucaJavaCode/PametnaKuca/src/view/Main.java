package view;

import controller.FileKontroler;
import controller.Kontroler;
import model.Aplikacija;

public class Main {

	public static void main(String[] args) {

		Aplikacija app = FileKontroler.readInputFile();
		
		LoginDialog prozor = new LoginDialog();

		Kontroler kontroler = new Kontroler(prozor, app);

		prozor.setVisible(true);
	}

}