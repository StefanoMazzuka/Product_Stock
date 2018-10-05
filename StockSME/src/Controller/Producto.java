package Controller;

public class Producto {
	
	private String producto;
	private String marca;
	private String proveedor;
	private String codigoProveedor;
	private String presentacion;
	private Float baseCosteUnidad;
	private Float baseVenta;
	private Float tipoIVA;
	private long codigoDeBarras;
	private int cantidad;
	private int ID;
	
	/*
	 * Constructor
	 */

	public Producto() {}
	
	/*
	 * Getters y Setters
	 */
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getCodigoProveedor() {
		return codigoProveedor;
	}

	public void setCodigoProveedor(String codigoProveedor) {
		this.codigoProveedor = codigoProveedor;
	}

	public String getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(String presentacion) {
		this.presentacion = presentacion;
	}

	public Float getBaseCosteUnidad() {
		return baseCosteUnidad;
	}

	public void setBaseCosteUnidad(Float baseCosteUnidad) {
		this.baseCosteUnidad = baseCosteUnidad;
	}

	public Float getBaseVenta() {
		return baseVenta;
	}

	public void setBaseVenta(Float baseVenta) {
		this.baseVenta = baseVenta;
	}

	public Float getTipoIVA() {
		return tipoIVA;
	}

	public void setTipoIVA(Float tipoIVA) {
		this.tipoIVA = tipoIVA;
	}

	public long getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(long codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
