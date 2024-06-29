package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bocadito;
import model.DetalleBotella;

/**
 * Servlet implementation class VentaBocaditoServlet
 */
@WebServlet(name = "ventaboca", urlPatterns = { "/ventaboca" })
public class VentaBocaditoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VentaBocaditoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entro al post de venta");
		// obtener la cantidad
		int cantidad = Integer.parseInt(request.getParameter("cantidad"));

		// obtener los productos (atributos) a nivel de sesión (objetos -> Torta, Bocadito)
		Bocadito b = (Bocadito)request.getSession().getAttribute("b");
		//Actualizar las variables de session de carro
		ArrayList<DetalleBotella> carro = (ArrayList<DetalleBotella>)request.getSession().getAttribute("carro");
		double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		
		boolean existeBocadito = false;
		for (DetalleBotella detalle : carro) {
		    if (detalle.getId_boca().equals(b.getId_boca())) {
		        // Si el bocadito ya existe en el carro, actualizar la cantidad y el importe
		        detalle.setCantidad(detalle.getCantidad() + cantidad);
		        detalle.setImporte(detalle.getCantidad() * b.getPrecio_boca());
		        existeBocadito = true;
		    }
		}
		
		if (!existeBocadito) {
		    // Si el bocadito no existe en el carro, agregarlo como un nuevo producto
		    DetalleBotella d = new DetalleBotella();
		    d.setId_boca(b.getId_boca());
		    d.setNomboca(b.getNombre_boca());
		    d.setCantidad(cantidad);
		    d.setPreciovta(b.getPrecio_boca());
		    d.setImporte(cantidad * b.getPrecio_boca());
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
