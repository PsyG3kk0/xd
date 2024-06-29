package model;

public class Tienda {
	private int item;
	private String idtorta;
	private String nombret;
	private String descripcion;
	private double precioCompra;
	private int cantidad;
	private double subTotal;
	
	public Tienda(int item, String idtorta, String nombret, String descripcion, double precioCompra, int cantidad,
			double subTotal) {
		this.item = item;
		this.idtorta = idtorta;
		this.nombret = nombret;
		this.descripcion = descripcion;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
	}

	public Tienda() {
		
	}

	public int getItem() {
		return item;
	}

	public void setItem(int item) {
		this.item = item;
	}

	public String getIdtorta() {
		return idtorta;
	}

	public void setIdtorta(String idtorta) {
		this.idtorta = idtorta;
	}

	public String getNombret() {
		return nombret;
	}

	public void setNombret(String nombret) {
		this.nombret = nombret;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
	
	

}
