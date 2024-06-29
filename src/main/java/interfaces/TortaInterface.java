package interfaces;

import java.util.List;

import model.Torta;

public interface TortaInterface {
	
	public int registrar(Torta t);
	
	public int actualizar(Torta t);
	
	public int eliminar(Torta t);
	
	public List<Torta> listado();
	
	public Torta obtener(String id);
}
