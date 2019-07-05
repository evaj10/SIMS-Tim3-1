package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import konstante.Konstante;
import model.Aplikacija;

public class FileKontroler {
	
	public static Aplikacija readInputFile() {
		Aplikacija app = new Aplikacija();
		try {
			ObjectInputStream os = new ObjectInputStream(new FileInputStream(Konstante.FILE_NAME));
			try {
				app = (Aplikacija) os.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			os.close();
			return app;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;	
	}
	
	public static void writeOutputFile(Aplikacija app) {
		try {
			ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(Konstante.FILE_NAME));
			os.writeObject(app);
			os.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
