package Controller;

import java.awt.EventQueue;

import Model.ConnexionSME;
import View.Menu;

public class Main {

	public static void main(String[] args) {
		ConnexionSME con = new ConnexionSME();
		con.connect();
		con.close();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}