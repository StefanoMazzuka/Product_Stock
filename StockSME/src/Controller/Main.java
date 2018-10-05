package Controller;

import javax.swing.JOptionPane;

import Model.ConnexionSME;
import View.Menu;

public class Main {

	public static void main(String[] args) {
		ConnexionSME con = new ConnexionSME();
		if (con.connect()) {
			JOptionPane.showMessageDialog(null, "Conectado");
			con.close();
			Menu frame = new Menu();
			frame.setVisible(true);
		}
	}
}