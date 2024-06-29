package interfaces;

import java.util.List;

import model.Bocadito;



public interface BocaditoInterface {
	
	public int registrar(Bocadito b);
	
	public int actualizar(Bocadito b);
	
	public int eliminiar(Bocadito b);
	
	public List<Bocadito> listado();
	
	public Bocadito obtener(String id);

}
