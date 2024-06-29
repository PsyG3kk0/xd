package model;

public class DetalleBotella {
	private String idtorta;
	private String id_boca;
	private double preciovta;
	private int cantidad;
	private String nomboca;
	private String nomprot;
	private double importe;
	
	public DetalleBotella(String idtorta, String id_boca, double preciovta, int cantidad, String nomboca,
			String nomprot, double importe) {
		this.idtorta = idtorta;
		this.id_boca = id_boca;
		this.preciovta = preciovta;
		this.cantidad = cantidad;
		this.nomboca = nomboca;
		this.nomprot = nomprot;
		this.importe = importe;
	}

	public DetalleBotella() {
		
	}

	public String getIdtorta() {
		return idtorta;
	}

	public void setIdtorta(String idtorta) {
		this.idtorta = idtorta;
	}
	
	public String getId_boca() {
		return id_boca;
	}

	public void setId_boca(String id_boca) {
		this.id_boca = id_boca;
	}

	public double getPreciovta() {
		return preciovta;
	}

	public void setPreciovta(double preciovta) {
		this.preciovta = preciovta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public String getNomboca() {
		return nomboca;
	}

	public void setNomboca(String nomboca) {
		this.nomboca = nomboca;
	}

	public String getNomprot() {
		return nomprot;
	}

	public void setNomprot(String nomprot) {
		this.nomprot = nomprot;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "DetalleBotella [idtorta=" + idtorta + ", id_boca=" + id_boca + ", preciovta=" + preciovta
				+ ", cantidad=" + cantidad + ", nomboca=" + nomboca + ", nomprot=" + nomprot + ", importe=" + importe
				+ "]";
	}

}
