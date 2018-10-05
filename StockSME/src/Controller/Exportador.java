package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Método para exportar las consultas a un archivo Excel.
 * @author Stefano Mazzuka
 *
 */
public class Exportador {
	/*
	 * Constructor
	 */
	/**
	 * Constructora por defecto del objeto ExcelExporter.
	 */
	public Exportador() {}

	/**
	 * Exportamos una lista de modelos a un archivo de tipo .xls.
	 * @param productos Lista de modelos a exportar.
	 * @param file Archivo donde se exportará la lista de modelos.
	 * @throws IOException
	 */
	public void exportar(ArrayList<Producto> productos, File file) throws IOException {
		FileWriter out = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(out);

		bw.write("PRODUCTO" + ";");
		bw.write("MARCA" + ";");
		bw.write("PROVEEDOR" + ";");
		bw.write("CODIGO PROVEEDOR" + ";");
		bw.write("PRESENTACION" + ";");
		bw.write("BASE COSTE UNIDAD" + ";");
		bw.write("BASE VENTA" + ";");
		bw.write("TIPO IVA" + ";");
		bw.write("CODIGO DE BARRAS" + ";");
		bw.write("CANTIDAD" + ";");

		bw.write('\n');

		for (int i = 0; i < productos.size(); i++) {
			bw.write(productos.get(i).getProducto() + ";");
			bw.write(productos.get(i).getMarca() + ";");
			bw.write(productos.get(i).getProveedor() + ";");
			bw.write(productos.get(i).getCodigoProveedor() + ";");
			bw.write(productos.get(i).getPresentacion() + ";");
			bw.write(String.valueOf(productos.get(i).getBaseCosteUnidad() + ";"));
			bw.write(String.valueOf(productos.get(i).getBaseVenta() + ";"));
			bw.write(String.valueOf(productos.get(i).getTipoIVA() + ";"));
			bw.write(String.valueOf(productos.get(i).getCodigoDeBarras() + ";"));
			bw.write(String.valueOf(productos.get(i).getCantidad() + ";"));
			
			bw.write('\n');
		}
		bw.close();
	}
}
