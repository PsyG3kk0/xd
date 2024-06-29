package mantenimientos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.VentaInterface;
import model.CabeceraBoleta;
import model.DetalleBotella;
import utils.MySQLConexion;

public class GestionVenta implements VentaInterface{

	@Override
	public String generarNumBoleta() {
		String numero = "B0001";   // si la tabla está vacía:
		// Plantilla de BD
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "select substr(max(NUM_BOL),2) from tb_cab_boleta";
			// Devuelve el ultimo numero de boleta: B0034 
			// Separa la parte numérica "0034"
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			if (rs.next()) {
				// Lo retorna como "B" + el numero incrementado
				numero = String.format("B%04d", rs.getInt(1) + 1);
			}
		} catch (Exception e) {
			System.out.println("Error en generaNumBoleta : " + e.getMessage());
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return numero;
	}

	@Override
	public int realizarVenta(CabeceraBoleta cab, ArrayList<DetalleBotella> det) {
		int rs = 0;  // valor x default en caso de error
		// Plantilla
		Connection con = null;
		PreparedStatement pst1 = null;   // registrar en la cabecera
		PreparedStatement pst2 = null;   // registrar en la tabla detalles
		PreparedStatement pst3 = null;   // actualizar de productos
		try {
			con = MySQLConexion.getConexion();

			// ************
			// Desactivar la confirmación automática
			con.setAutoCommit(false); 
			String sql1 = "insert into tb_cab_boleta values (?,curdate(),?)";
			pst1 = con.prepareStatement(sql1);
			
			// asignamos el n mero de boleta autogenerado
			cab.setNum_bol(generarNumBoleta());
			
			// registra la cabecera
			pst1.setString(1, cab.getNum_bol());
			pst1.setInt(2, cab.getCod_cliente());
			rs = pst1.executeUpdate();

			String sql2 = "insert into tb_det_boleta values (?,?,?,?)";
			String sql3 = "update tb_tortas set stock = stock - ? where idtorta = ?";
			for (DetalleBotella d : det) {
				// registra en la tabla de Detalle de boleta
				pst2 = con.prepareStatement(sql2);
				pst2.setString(1, cab.getNum_bol()); // mismo dato de la cabecera
				pst2.setString(2, d.getIdtorta());
				pst2.setInt(3, d.getCantidad());
				pst2.setDouble(4, d.getPreciovta());
				rs += pst2.executeUpdate();
				
				// actualiza la tabla Producto
				pst3 = con.prepareStatement(sql3);
				pst3.setInt(1, d.getCantidad());
				pst3.setString(2, d.getIdtorta());

				rs += pst3.executeUpdate();
			}
			
			// ************
			// Si no hay errores, se confirma las operaciones (Transacciones)
			con.commit();
		} catch (Exception e) {
			System.out.println("Error en registrar la compra : " + e.getMessage());
			rs = 0;
			try {
				// deshace lo registrado o actualizado en este proceso
				con.rollback();
			} catch (SQLException e1) {
				System.out.println("Error al cerrar : " + e1.getMessage());
			}
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}


	

}
