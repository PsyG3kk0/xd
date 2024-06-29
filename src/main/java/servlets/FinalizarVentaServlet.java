package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionVenta;
import model.CabeceraBoleta;
import model.DetalleBotella;
import model.Usuario;

/**
 * Servlet implementation class FinalizarVentaServlet
 */
@WebServlet(name = "pagar", urlPatterns = { "/pagar" })
public class FinalizarVentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FinalizarVentaServlet() {
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
		// Obj. finalizar la compra
		
				//Obtener el Usuario conectado (Login)
				Usuario u = (Usuario) request.getSession().getAttribute("u");
				
				CabeceraBoleta cab = new CabeceraBoleta();
				//cab.setNum_bol(getServletInfo());
				//cab.setFch_bol(getServletInfo());
				cab.setCod_cliente(u.getCodigo());//Vienen del Login
				
				//Actualizar las variables de session de carro
				ArrayList<DetalleBotella> carro = (ArrayList<DetalleBotella>)request.getSession().getAttribute("carro");
		        double subTotalVenta = (double) request.getSession().getAttribute("subTotalVenta");
		        int cantArticulos = (int) request.getSession().getAttribute("cantArticulos");
		        

				int ok= new GestionVenta().realizarVenta(cab, carro);
				if(ok != 0) { //sin ERROR
					//limpiar
					carro.clear();
					subTotalVenta = 0;
					cantArticulos = 0;
					
					 //envia las varibles a nivel de session
			        request.getSession().setAttribute("carro", carro);
			        request.getSession().setAttribute("subTotalVenta", subTotalVenta);
			        request.getSession().setAttribute("cantArticulos", cantArticulos);
			        
			        request.getSession().setAttribute("mensaje", "Transacción finalizada con exito");
					request.getSession().setAttribute("estilo", "alert alert-success");
			        response.sendRedirect("tienda.jsp");
				} else {
					request.setAttribute("mensaje", "Transacción cancelada");
					request.setAttribute("estilo", "alert alert-danger");
					request.getRequestDispatcher("tienda.jsp").forward(request, response);
				}
	}

}
