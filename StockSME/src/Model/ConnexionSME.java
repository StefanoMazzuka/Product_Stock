package Model;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class ConnexionSME {
	private final String url = "jdbc:mysql://smequantum.com/inventario_sme?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String user = "Inventario";
	private String password = "InventarioSME2018";
	private Connection connec;
	private Statement st;
	private ResultSet list; 

	/*
	 * Constructor
	 */
	/**
	 * Constructura por defecto del objeto Connexions.
	 */
	public ConnexionSME() {}

	/*
	 * Methods
	 */
	/**
	 * Crea la conexión con la base de datos.
	 * @return Devuelve un booleano que indica si se conectó o no.
	 */
	public boolean connect() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connec = DriverManager.getConnection(url, user, password);
			this.st = this.connec.createStatement();
			JOptionPane.showMessageDialog(null, "Conectado");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}
	/**
	 * Cierra la conexión con la base de datos.
	 */
	public void close() {
		try {
			connec.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
	}
	
	/**
	 * Consultamos todos los nombres de los productos.
	 * @return Devuelve un ArrayList de tipo String con todos los nombres de los productos.
	 */
	public ArrayList<String> selectProductNames() {
		connect();
		ArrayList<String> data = new ArrayList<String>();
		try {
			list = this.st.executeQuery("SELECT PRODUCTO FROM PRODUCTOS");
			while (list.next()) {
				data.add(list.getString("PRODUCTO")); 
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}
}
