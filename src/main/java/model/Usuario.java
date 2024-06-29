package model;

public class Usuario {
	private int codigo;
	private String nombre;
	private String apellido;
	private int edad;
	private String usuario;
	private String clave;
	private int tipo;
	
	public Usuario(int codigo, String nombre, String apellido, int edad, String usuario, String clave, int tipo) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.usuario = usuario;
		this.clave = clave;
		this.tipo = tipo;
	}

	public Usuario() {
		
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad
				+ ", usuario=" + usuario + ", clave=" + clave + ", tipo=" + tipo + "]";
	}
	
}
