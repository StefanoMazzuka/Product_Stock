package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import Controller.Producto;

public class ConnexionSME {
	private final String url = "";
	private String user = "";
	private String password = "";
	private Connection connec;
	private Statement st;
	private ResultSet list; 

	/*
	 * Constructor
	 */

	public ConnexionSME() {}

	/*
	 * Métodos
	 */

	public boolean connect() {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			this.connec = DriverManager.getConnection(url, user, password);
			this.st = this.connec.createStatement();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error de conexión" + '\n' + 
					"Información del error:" + '\n' + e, "Error",JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public void close() {
		try {
			connec.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
	}	

	public ArrayList<Producto> selectAll() {
		connect();
		ArrayList<Producto> data = new ArrayList<Producto>();
		try {
			list = this.st.executeQuery("SELECT * FROM PRODUCTOS");
			while (list.next()) {
				Producto producto = new Producto();
				producto.setProducto(list.getString("PRODUCTO"));
				producto.setMarca(list.getString("MARCA"));
				producto.setProveedor(list.getString("PROVEEDOR"));
				producto.setCodigoProveedor(list.getString("CODIGO PROVEEDOR"));
				producto.setPresentacion(list.getString("PRESENTACION"));
				producto.setBaseCosteUnidad(list.getFloat("BASE COSTE UNIDAD"));
				producto.setBaseVenta(list.getFloat("BASE VENTA"));
				producto.setTipoIVA(list.getFloat("TIPO IVA"));
				producto.setCodigoDeBarras(list.getLong("CODIGO DE BARRAS"));
				producto.setCantidad(list.getInt("CANTIDAD"));
				producto.setID(list.getInt("ID"));

				data.add(producto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}

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

	public void insertProducto(Producto producto) {
		try {
			connect();
			this.st.executeUpdate("INSERT INTO PRODUCTOS (PRODUCTO, MARCA, PROVEEDOR, `CODIGO PROVEEDOR`, PRESENTACION, "
					+ "`BASE COSTE UNIDAD`, `BASE VENTA`, `TIPO IVA`, `CODIGO DE BARRAS`, CANTIDAD) VALUES('"
					+ producto.getProducto() + "', '"
					+ producto.getMarca() + "', '" 
					+ producto.getProveedor() + "', '"
					+ producto.getCodigoProveedor() + "', '" 
					+ producto.getPresentacion() + "', " 
					+ producto.getBaseCosteUnidad() + ", " 
					+ producto.getBaseVenta() + ", " 
					+ producto.getTipoIVA() + ", " 
					+ producto.getCodigoDeBarras() + ", " 
					+ producto.getCantidad() + ")");

			JOptionPane.showMessageDialog(null, "Producto agregado correctamente");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
	}

	public void deleteProducto(int ID) {
		connect();
		try {
			st.executeUpdate("DELETE FROM PRODUCTOS WHERE ID = " + ID);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
	}

	public boolean existProducto(long codigoDeBarras) {
		connect();
		boolean existe = false;
		try {
			list = st.executeQuery("SELECT PRODUCTO FROM PRODUCTOS WHERE `CODIGO DE BARRAS` = " + codigoDeBarras);
			int cont = 0;
			while (list.next()) {
				cont++;
			}
			if (cont != 0) existe = true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
			return false;
		}
		close();
		return existe;
	}

	public ArrayList<Producto> selectProductoCodigoDeBarras(long codigoDeBarras) {
		connect();
		ArrayList<Producto> data = new ArrayList<Producto>();
		try {
			list = this.st.executeQuery("SELECT * FROM PRODUCTOS WHERE `CODIGO DE BARRAS` = " + codigoDeBarras);
			while (list.next()) {
				Producto producto = new Producto();
				producto.setProducto(list.getString("PRODUCTO"));
				producto.setMarca(list.getString("MARCA"));
				producto.setProveedor(list.getString("PROVEEDOR"));
				producto.setCodigoProveedor(list.getString("CODIGO PROVEEDOR"));
				producto.setPresentacion(list.getString("PRESENTACION"));
				producto.setBaseCosteUnidad(list.getFloat("BASE COSTE UNIDAD"));
				producto.setBaseVenta(list.getFloat("BASE VENTA"));
				producto.setTipoIVA(list.getFloat("TIPO IVA"));
				producto.setCodigoDeBarras(list.getLong("CODIGO DE BARRAS"));
				producto.setCantidad(list.getInt("CANTIDAD"));
				producto.setID(list.getInt("ID"));
				
				data.add(producto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}

	public ArrayList<Producto> selectProductoMarca(String marca) {
		connect();
		ArrayList<Producto> data = new ArrayList<Producto>();
		try {
			list = this.st.executeQuery("SELECT * FROM PRODUCTOS WHERE MARCA = '" + marca + "'");
			while (list.next()) {
				Producto producto = new Producto();
				producto.setProducto(list.getString("PRODUCTO"));
				producto.setMarca(list.getString("MARCA"));
				producto.setProveedor(list.getString("PROVEEDOR"));
				producto.setCodigoProveedor(list.getString("CODIGO PROVEEDOR"));
				producto.setPresentacion(list.getString("PRESENTACION"));
				producto.setBaseCosteUnidad(list.getFloat("BASE COSTE UNIDAD"));
				producto.setBaseVenta(list.getFloat("BASE VENTA"));
				producto.setTipoIVA(list.getFloat("TIPO IVA"));
				producto.setCodigoDeBarras(list.getLong("CODIGO DE BARRAS"));
				producto.setCantidad(list.getInt("CANTIDAD"));
				producto.setID(list.getInt("ID"));
				
				data.add(producto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}

	public ArrayList<Producto> selectProductoProveedor(String proveedor) {
		connect();
		ArrayList<Producto> data = new ArrayList<Producto>();
		try {
			list = this.st.executeQuery("SELECT * FROM PRODUCTOS WHERE PROVEEDOR = '" + proveedor + "'");
			while (list.next()) {
				Producto producto = new Producto();
				producto.setProducto(list.getString("PRODUCTO"));
				producto.setMarca(list.getString("MARCA"));
				producto.setProveedor(list.getString("PROVEEDOR"));
				producto.setCodigoProveedor(list.getString("CODIGO PROVEEDOR"));
				producto.setPresentacion(list.getString("PRESENTACION"));
				producto.setBaseCosteUnidad(list.getFloat("BASE COSTE UNIDAD"));
				producto.setBaseVenta(list.getFloat("BASE VENTA"));
				producto.setTipoIVA(list.getFloat("TIPO IVA"));
				producto.setCodigoDeBarras(list.getLong("CODIGO DE BARRAS"));
				producto.setCantidad(list.getInt("CANTIDAD"));
				producto.setID(list.getInt("ID"));
				
				data.add(producto);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
		return data;
	}

	public void updateProducto(Producto producto) {
		try {
			connect();
			st.executeUpdate("UPDATE PRODUCTOS SET "
					+ "PRODUCTO = '" + producto.getProducto() + "', "
					+ "MARCA = '" + producto.getMarca()+ "', "
					+ "PROVEEDOR = '" + producto.getProveedor() + "', "
					+ "`CODIGO PROVEEDOR` = '" + producto.getCodigoProveedor() + "', "
					+ "PRESENTACION = '" + producto.getPresentacion() + "', "
					+ "`BASE COSTE UNIDAD` = " + producto.getBaseCosteUnidad() + ", "
					+ "`BASE VENTA` = " + producto.getBaseVenta() + ", "
					+ "`TIPO IVA` = " + producto.getTipoIVA() + ", "
					+ "`CODIGO DE BARRAS` = " + producto.getCodigoDeBarras() + ", "
					+ "CANTIDAD = " + producto.getCantidad() + " "
					+ "WHERE ID = " + producto.getID());
			JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.", 
					"Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
	}
	
	public void addProducto(Producto producto, int cantidad) {
		try {
			connect();
			st.executeUpdate("UPDATE PRODUCTOS SET CANTIDAD = " + (producto.getCantidad() + cantidad) + " WHERE ID = " + producto.getID());
			JOptionPane.showMessageDialog(null, "Productos agregados correctamente.", 
					"Información", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
			Logger.getLogger(ConnexionSME.class.getName()).log(Level.SEVERE, null, e);
		}
		close();
	}
}