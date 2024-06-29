package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DetalleBotella;
import model.Torta;

/**
 * Servlet implementation class VentaServlet
 */
@WebServlet(name = "venta", urlPatterns = { "/venta" })
public class VentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro al get de venta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obj. Agregar al carro de compra el detalle de lo seleccionado como compra
		System.out.println("Entro al post de venta");
		// obtener la cantidad
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		// obtener los productos (atributos) a nivel de sesión (objetos -> Torta, Bocadito)
		Torta t = (Torta) request.getSession().getAttribute("t");

		//Actualizar las variables de session de carro
		ArrayList<DetalleBotella> carro = (ArrayList<DetalleBotella>)request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");

		// Verificar si los productos ya existen en el carro
		boolean existeTorta = false;
		for (DetalleBotella detalle : carro) {
		    if (detalle.getIdtorta().equals(t.getIdtorta())) {
		        // Si la torta ya existe en el carro, actualizar la cantidad y el importe
		        detalle.setCantidad(detalle.getCantidad() + cantidad);
		        detalle.setImporte(detalle.getCantidad() * t.getPrecio());
		        existeTorta = true;
		    }
		}

		if (!existeTorta) {
		    // Si la torta no existe en el carro, agregarla como un nuevo producto
		    DetalleBotella d = new DetalleBotella();
		    d.setIdtorta(t.getIdtorta());
		    d.setNomprot(t.getNombret());
		    d.setCantidad(cantidad);
		    d.setPreciovta(t.getPrecio());
		    d.setImporte(cantidad * t.getPrecio());
		    carro.add(d);
		}

		// Recalcular el subtotal y la cantidad de artículos
		subTotalVenta = 0;
		cantArticulos = 0;
		for (DetalleBotella detalle : carro) {
		    subTotalVenta += detalle.getImporte();
		    cantArticulos += detalle.getCantidad();
		}

		//envia las varibles a nivel de session
		request.getSession().setAttribute("carro", carro);
		request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		request.getSession().setAttribute("cantArticulos", cantArticulos);

		response.sendRedirect("tienda.jsp");

	}

}
