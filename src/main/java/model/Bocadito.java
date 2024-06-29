package model;

public class Bocadito {
	
	private String id_boca;
	private String nombre_boca;
	private String descripcion_boca;
	private int stock_boca;
	private double precio_boca;
	
	
	public Bocadito(String id_boca, String nombre_boca, String descripcion_boca, int stock_boca, double precio_boca) {
		this.id_boca = id_boca;
		this.nombre_boca = nombre_boca;
		this.descripcion_boca = descripcion_boca;
		this.stock_boca = stock_boca;
		this.precio_boca = precio_boca;
	}


	public Bocadito() {
	}


	public String getId_boca() {
		return id_boca;
	}


	public void setId_boca(String id_boca) {
		this.id_boca = id_boca;
	}


	public String getNombre_boca() {
		return nombre_boca;
	}


	public void setNombre_boca(String nombre_boca) {
		this.nombre_boca = nombre_boca;
	}


	public String getDescripcion_boca() {
		return descripcion_boca;
	}


	public void setDescripcion_boca(String descripcion_boca) {
		this.descripcion_boca = descripcion_boca;
	}


	public int getStock_boca() {
		return stock_boca;
	}


	public void setStock_boca(int stock_boca) {
		this.stock_boca = stock_boca;
	}


	public double getPrecio_boca() {
		return precio_boca;
	}


	public void setPrecio_boca(double precio_boca) {
		this.precio_boca = precio_boca;
	}


	@Override
	public String toString() {
		return "Bocadito [id_boca=" + id_boca + ", nombre_boca=" + nombre_boca + ", descripcion_boca="
				+ descripcion_boca + ", stock_boca=" + stock_boca + ", precio_boca=" + precio_boca + "]";
	}
	
	
	
	
	

}
