package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.TortaInterface;
import model.Torta;
import utils.MySQLConexion;

public class GestionTorta implements TortaInterface {

	@Override
	public List<Torta> listado() {
		List<Torta> lista = null;
		// Plantilla
		Connection con= null; //obtener la conexión a la BD
		PreparedStatement pst = null; //preparar sentencias 
		ResultSet rs = null; //guarda el resultado (vista)de la consulta!!
		try {
			//obtiene la conexión
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			// select * from tb_productos;
			String sql = "select * from tb_tortas";
			//preparar la sentencia y setear datos necesarios
			pst = con.prepareStatement(sql);
			//guardar el resultado, ejecutando la sentencia
			rs = pst.executeQuery();
			//pasar el resuldo temporal (vista) a la lista
			lista = new ArrayList<Torta>();
			while (rs.next()) {
				//crear un objeto de Tipo Producto con la informacion de cada fila
				Torta t = new Torta();
				t.setIdtorta(rs.getString("idtorta"));
				t.setNombret(rs.getString("nombret"));
				t.setDescripcion(rs.getString("descripcion"));
				t.setStock(rs.getInt("stock"));
				t.setPrecio(rs.getDouble("precio"));
				//agregar a la lista
				lista.add(t);
			}
		} catch (Exception e) {
			System.out.println("Error en listado: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public Torta obtener(String id) {
		Torta t = null;
		// Plantilla
				Connection con= null; //obtener la conexión a la BD
				PreparedStatement pst = null; //preparar sentencias 
				ResultSet rs = null; //guarda el resultado (vista)de la consulta!!
				try {
					//obtiene la conexión
					con= MySQLConexion.getConexion();
					//cadena con la sentencia
					// select * from tb_productos;
					String sql = "select * from tb_tortas where idtorta = ?";
					//preparar la sentencia y setear datos necesarios
					pst = con.prepareStatement(sql);
					pst.setString(1, id);
					//guardar el resultado, ejecutando la sentencia
					rs = pst.executeQuery();
					while (rs.next()) {
						//crear un objeto de Tipo Producto con la informacion de cada fila
						t = new Torta();
						t.setIdtorta(rs.getString("idtorta"));
						t.setNombret(rs.getString("nombret"));
						t.setDescripcion(rs.getString("descripcion"));
						t.setStock(rs.getInt("stock"));
						t.setPrecio(rs.getDouble("precio"));	
						
					}
				} catch (Exception e) {
					System.out.println("Error en obtener: "+ e.getMessage());
				} finally {
					MySQLConexion.closeConexion(con);
				}
		return t;
	}

	@Override
	public int registrar(Torta t) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql="insert into tb_tortas values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getIdtorta());
			pst.setString(2, t.getNombret());
			pst.setString(3, t.getDescripcion());
			pst.setInt(4, t.getStock());
			pst.setDouble(5, t.getPrecio());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public int actualizar(Torta t) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql = "UPDATE tb_tortas SET nombret = ?, descripcion = ?, stock = ?, precio = ? WHERE idtorta = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getNombret());
			pst.setString(2, t.getDescripcion());
			pst.setInt(3, t.getStock());
			pst.setDouble(4, t.getPrecio());
			pst.setString(5, t.getIdtorta());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public int eliminar(Torta t) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql = "DELETE FROM tb_tortas WHERE idtorta = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getIdtorta());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

}
