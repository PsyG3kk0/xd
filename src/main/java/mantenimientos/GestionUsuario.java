package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	
	//esto es agregar herencia
		@Override
		public Usuario validarAcceso(Usuario u) {
			Usuario u2 = null; //valor por dwefault si no encuentra 
			
			// plantilla
			Connection con=null; //obtener conexion con la BD
	        PreparedStatement pst=null; // preparar la sentencias
	        ResultSet rs = null; // guarda el resultado de la sonsulta
	        try {
	        	//obteniendo la conexion
				con = MySQLConexion.getConexion();
				
				//select * FROM tb_productos;
				//cadena con la sentencia
				String sql = "select * FROM tb_usuarios where usuario=? and clave =?";
				//preparar la sentencia y setea datos nesesarios
				pst = con.prepareStatement(sql);
				pst.setString(1, u.getUsuario());
				pst.setString(2, u.getClave());
				
				
				//guardar el resultado  ejecutando la sentencia
				rs = pst.executeQuery();
				
				
				while (rs.next()) {
					
					//crea un objeto de tipo usuario con la informacion de cada fila
					u2 = new Usuario();
					u2.setCodigo(rs.getInt("codigo"));
					u2.setUsuario(rs.getString("usuario"));
					u2.setClave(rs.getNString("clave"));
					u2.setTipo(rs.getInt("tipo"));
					
					
					
				}
				
				
			} catch (Exception e) {
				System.out.println("Error en Listado"+ e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con); // cierra la conexion
			}
			
			return u2;
		}

		@Override
		public int Registro(Usuario regi) {
			int ok=0; //valor x default en caso de error
			//plantilla
	        Connection con=null; //obtener conexion con la BD
	        PreparedStatement pst=null; // preparar la sentencias
	        try {
	        	//obteniendo la conexion
				con = MySQLConexion.getConexion();
				
				//insert into tb_productos values ('P0012','Jabon Neko',40,8.5,4,1);
				//cadena con la sentencia
				String sql = "insert into tb_usuarios values (null,?,?,?,?,?,default);";
				//preparar la sentencia y setea datos nesesarios
				pst = con.prepareStatement(sql);
				//pst.setString(1, p.getIdprod());
				pst.setString(1, regi.getNombre());
				pst.setString(2, regi.getApellido());
				pst.setInt(3, regi.getEdad());
				pst.setString(4, regi.getUsuario());
				pst.setString(5, regi.getClave());
				
				
				//actualiza la variable de control y ejecutar la sentencia
				ok = pst.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println("Error en registrar"+ e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con); // cierra la conexion
			}
	        return ok;
		}

		@Override
		public int Actualizar(Usuario u) {
			int ok=0; 
	        Connection con=null; 
	        PreparedStatement pst=null; 
	        try {
				con = MySQLConexion.getConexion();
				//cadena con la sentencia
				String sql = "UPDATE tb_usuarios SET nombre = ?, apellido = ?, edad = ?, usuario = ?, clave = ? WHERE codigo = ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, u.getNombre());
				pst.setString(2, u.getApellido());
				pst.setInt(3, u.getEdad());
				pst.setString(4, u.getUsuario());
				pst.setString(5, u.getClave());
				pst.setInt(6, u.getCodigo());
				ok = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error en actualizar"+ e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con); // cierra la conexion
			}
	        return ok;
		}

		@Override
		public int eliminar(Usuario u) {
			int ok = 0;
			Connection con= null;
			PreparedStatement pst = null;
			try {
				con= MySQLConexion.getConexion();
				//cadena con la sentencia
				String sql = "DELETE FROM tb_usuarios WHERE codigo = ?;";
				pst = con.prepareStatement(sql);
				pst.setInt(1, u.getCodigo());
				
				ok = pst.executeUpdate();
			} catch (Exception e) {
				System.out.println("Error en eliminar: "+ e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con);
			}
			return ok;
		}

		@Override
		public List<Usuario> listado() {
			List<Usuario> lista = null;
			// Plantilla
			Connection con= null; //obtener la conexión a la BD
			PreparedStatement pst = null; //preparar sentencias 
			ResultSet rs = null; //guarda el resultado (vista)de la consulta!!
			try {
				//obtiene la conexión
				con= MySQLConexion.getConexion();
				//cadena con la sentencia
				// select * from tb_productos;
				String sql = "select * from tb_usuarios";
				//preparar la sentencia y setear datos necesarios
				pst = con.prepareStatement(sql);
				//guardar el resultado, ejecutando la sentencia
				rs = pst.executeQuery();
				//pasar el resuldo temporal (vista) a la lista
				lista = new ArrayList<Usuario>();
				while (rs.next()) {
					//crear un objeto de Tipo Producto con la informacion de cada fila
					Usuario u = new Usuario();
					u.setCodigo(rs.getInt("codigo"));
					u.setNombre(rs.getString("nombre"));
					u.setApellido(rs.getString("apellido"));
					u.setEdad(rs.getInt("edad"));
					u.setUsuario(rs.getString("usuario"));
					u.setClave(rs.getString("clave"));
					//agregar a la lista
					lista.add(u);
				}
			} catch (Exception e) {
				System.out.println("Error en listado: "+ e.getMessage());
			} finally {
				MySQLConexion.closeConexion(con);
			}
			return lista;
		}

		@Override
		public Usuario obtener(int u) {
			Usuario us = null;
			// Plantilla
					Connection con= null; //obtener la conexión a la BD
					PreparedStatement pst = null; //preparar sentencias 
					ResultSet rs = null; //guarda el resultado (vista)de la consulta!!
					try {
						//obtiene la conexión
						con= MySQLConexion.getConexion();
						//cadena con la sentencia
						// select * from tb_productos;
						String sql = "select * from tb_usuarios where codigo = ?";
						//preparar la sentencia y setear datos necesarios
						pst = con.prepareStatement(sql);
						pst.setInt(1, u);
						//guardar el resultado, ejecutando la sentencia
						rs = pst.executeQuery();
						while (rs.next()) {
							//crear un objeto de Tipo Producto con la informacion de cada fila
							us = new Usuario();
							us.setCodigo(rs.getInt("codigo"));
							us.setNombre(rs.getString("nombre"));
							us.setApellido(rs.getString("apellido"));
							us.setEdad(rs.getInt("edad"));
							us.setUsuario(rs.getString("usuario"));
							us.setClave(rs.getString("clave"));
							
						}
					} catch (Exception e) {
						System.out.println("Error en obtener: "+ e.getMessage());
					} finally {
						MySQLConexion.closeConexion(con);
					}
			return us;
		}

		
}
