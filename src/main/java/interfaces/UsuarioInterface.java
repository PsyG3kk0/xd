package interfaces;


import java.util.List;

import model.Usuario;

public interface UsuarioInterface {

	public Usuario validarAcceso(Usuario u);
	
	public int  Registro(Usuario regi);
	
	public int  Actualizar(Usuario u);
	
	public int  eliminar(Usuario u);
	
	public List<Usuario> listado();
	
	public Usuario obtener(int u);
}
