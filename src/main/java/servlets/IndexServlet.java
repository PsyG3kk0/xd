package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionBocadito;
import mantenimientos.GestionTorta;
import model.Bocadito;
import model.Tienda;
import model.Torta;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet(name = "inicio", urlPatterns = { "/inicio" })
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    List<Torta> torta = new ArrayList<>();
    List<Tienda> tienda = new ArrayList<>();
    
	int item;
	double totalPagar = 0.0;
	int cantidad = 1;
	
	int idt;
	Tienda ti;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet usando metodo Get");
		List<Torta> lstTorta = new GestionTorta().listado();
		List<Bocadito> lstBocaditos = new GestionBocadito().listado();
		String accion = request.getParameter("accion");
		switch (accion) {
			case "Delete":
				Delete(request,response); break;
			case "Car":
				Carrito(request,response); break;
			case "Agre":
				AgregarTienda(request,response); break;
			default:
				request.setAttribute("lstTorta", lstTorta);
				request.setAttribute("lstBocaditos", lstBocaditos);
				request.getRequestDispatcher("Catalogo.jsp").forward(request, response);
		}		
		
	}

	private void Delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String idtorta = request.getParameter("idt");
		for(int i = 0; i < tienda.size(); i ++) {
			if(tienda.get(i).getIdtorta() == idtorta) {
				tienda.remove(i);
			}
		}
		
	}

	private void Carrito(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		totalPagar=0.0;
		request.setAttribute("tienda", tienda);
		for(int i = 0; i < tienda.size(); i ++) {
			totalPagar=totalPagar+tienda.get(i).getSubTotal();
		}
		request.setAttribute("totalPagar", totalPagar);
		request.getRequestDispatcher("tienda.jsp").forward(request, response);
		
	}

	private void AgregarTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idt= request.getParameter("id");
		Torta t= new GestionTorta().obtener(idt);
		 // Verificar si la torta ya existe en la tienda
	    Tienda ti = null;
	    for (Tienda tiendaItem : tienda) {
	        if (tiendaItem.getIdtorta().equals(t.getIdtorta())) {
	            // Si la torta ya existe en la tienda, actualizar la cantidad y el importe
	            tiendaItem.setCantidad(tiendaItem.getCantidad() + cantidad);
	            tiendaItem.setSubTotal(tiendaItem.getCantidad() * t.getPrecio());
	            ti = tiendaItem;
	            break;
	        }
	    }

	    if (ti == null) {
	        // Si la torta no existe en la tienda, agregarla como una nueva torta
	        item=item+1;
	        ti = new Tienda();
	        ti.setItem(item);
	        ti.setIdtorta(t.getIdtorta());
	        ti.setNombret(t.getNombret());
	        ti.setDescripcion(t.getDescripcion());
	        ti.setPrecioCompra(t.getPrecio());
	        ti.setCantidad(cantidad);
	        ti.setSubTotal(cantidad*t.getPrecio());
	        tienda.add(ti);
	    }
		request.setAttribute("contador", tienda.size());
		request.getRequestDispatcher("inicio?accion=home").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet usando metodo Post");
	}

}
