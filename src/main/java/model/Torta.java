package model;

public class Torta {
	private String idtorta;
	private String nombret;
	private String descripcion;
	private int stock;
	private double precio;
	
	public Torta(String idtorta, String nombret, String descripcion, int stock, double precio) {
		this.idtorta = idtorta;
		this.nombret = nombret;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}
	public Torta() {
		
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
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Torta [idtorta=" + idtorta + ", nombret=" + nombret + ", descripcion=" + descripcion + ", stock="
				+ stock + ", precio=" + precio + "]";
	}
	
}
