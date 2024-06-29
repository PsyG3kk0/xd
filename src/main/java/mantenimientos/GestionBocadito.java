package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import interfaces.BocaditoInterface;
import model.Bocadito;

import utils.MySQLConexion;

public class GestionBocadito  implements BocaditoInterface{

	@Override
	public List<Bocadito> listado() {
		List<Bocadito> lista = null;
		
				Connection con= null; 
				PreparedStatement pst = null; 
				ResultSet rs = null; 
				try {
					
					con= MySQLConexion.getConexion();
					
					
					String sql = "select * from tb_bocaditos";
					
					pst = con.prepareStatement(sql);
					
					rs = pst.executeQuery();
					
					lista = new ArrayList<Bocadito>();
					while (rs.next()) {
						
						Bocadito b = new Bocadito();
						b.setId_boca(rs.getString("id_boca"));;
						b.setNombre_boca(rs.getString("nombre_boca"));;
						b.setDescripcion_boca(rs.getString("descripcion_boca"));;
						b.setStock_boca(rs.getInt("stock_boca"));;
						b.setPrecio_boca(rs.getDouble("precio_boca"));
						
						lista.add(b);
					}
				} catch (Exception e) {
					System.out.println("Error en listado: "+ e.getMessage());
				} finally {
					MySQLConexion.closeConexion(con);
				}
				return lista;
	}

	@Override
	public Bocadito obtener(String id) {
		Bocadito b = null;
		
				Connection con= null; 
				PreparedStatement pst = null; 
				ResultSet rs = null; 
				try {
					
					con= MySQLConexion.getConexion();
					
					String sql = "select * from tb_bocaditos where id_boca = ?";
					
					pst = con.prepareStatement(sql);
					pst.setString(1, id);
					
					rs = pst.executeQuery();
					while (rs.next()) {
						
						b = new Bocadito();
						b.setId_boca(rs.getString("id_boca"));
						b.setNombre_boca(rs.getString("nombre_boca"));
						b.setDescripcion_boca(rs.getString("descripcion_boca"));
						b.setStock_boca(rs.getInt("stock_boca"));
						b.setPrecio_boca(rs.getDouble("precio_boca"));	
						
					}
				} catch (Exception e) {
					System.out.println("Error en obtener: "+ e.getMessage());
				} finally {
					MySQLConexion.closeConexion(con);
				}
		return b;
	}

	@Override
	public int registrar(Bocadito b) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql="insert into tb_bocaditos values(?,?,?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, b.getId_boca());
			pst.setString(2, b.getNombre_boca());
			pst.setString(3, b.getDescripcion_boca());
			pst.setInt(4, b.getStock_boca());
			pst.setDouble(5, b.getPrecio_boca());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en registrar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public int actualizar(Bocadito b) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql = "UPDATE tb_bocaditos SET nombre_boca = ?, descripcion_boca = ?, stock_boca = ?, precio_boca = ? WHERE id_boca = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, b.getNombre_boca());
			pst.setString(2, b.getDescripcion_boca());
			pst.setInt(3, b.getStock_boca());
			pst.setDouble(4, b.getPrecio_boca());
			pst.setString(5, b.getId_boca());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en actualizar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

	@Override
	public int eliminiar(Bocadito b) {
		int ok = 0;
		Connection con= null;
		PreparedStatement pst = null;
		try {
			con= MySQLConexion.getConexion();
			//cadena con la sentencia
			String sql = "DELETE FROM tb_bocaditos WHERE id_boca = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, b.getId_boca());
			
			ok = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error en eliminar: "+ e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return ok;
	}

}
