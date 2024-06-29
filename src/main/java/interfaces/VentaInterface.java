package interfaces;

import java.util.ArrayList;

import model.CabeceraBoleta;
import model.DetalleBotella;

public interface VentaInterface {
	
	public String generarNumBoleta(); //Autogenerar el num de boleta B0001
	
	//guardar en las tablas de la boleta y actualizar los productos
	public int realizarVenta(CabeceraBoleta cab, ArrayList<DetalleBotella> det);
}
