package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DetalleBotella;

/**
 * Servlet implementation class EliminarVentaServlet
 */
@WebServlet(name = "eliminar", urlPatterns = { "/eliminar" })
public class EliminarVentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVentaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Obj. eliminar del carro el detalle según el idprod enviado
				String idtorta = request.getParameter("cod");
				System.out.println("Eliminar el prod: " + idtorta);
				
				// obtener las variables de session de carro
				ArrayList<DetalleBotella> carro = (ArrayList<DetalleBotella>)request.getSession().getAttribute("carro");
				double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
				int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
				
				for(DetalleBotella d : carro) {
					if(d.getIdtorta().equals(idtorta)) {
						//desconectar las acumulaciones
						cantArticulos -= d.getCantidad();
						subTotalVenta -= d.getImporte();
						carro.remove(d);
						break;
					}
				}
				
				//envia las varibles a nivel de session
		        request.getSession().setAttribute("carro", carro);
		        request.getSession().setAttribute("subTotalVenta", subTotalVenta);
		        request.getSession().setAttribute("cantArticulos", cantArticulos);
		        
		        response.sendRedirect("tienda.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
