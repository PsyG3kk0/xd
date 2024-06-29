package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionTorta;
import model.Torta;

/**
 * Servlet implementation class CrudTortaServlet
 */
@WebServlet(name = "crudtor", urlPatterns = { "/crudtor" })
public class CrudTortaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudTortaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entró al Servlet usando metodo Get");
				
		System.out.println("Ingreso a la opción obtener");
		String id = request.getParameter("id");
		System.out.println(id);
		Torta t = new GestionTorta().obtener(id);
		System.out.println(t);

		request.setAttribute("t", t);

		List<Torta> lstTorta = new GestionTorta().listado();		
		request.setAttribute("lstTorta", lstTorta);

		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// doGet(request, response);
				System.out.println("Entró al Servlet usando metodo Post");
				// Leer la opcion seleccionada en el boton
				String opcion = request.getParameter("btnOpcion");
				switch (opcion) {
				case "reg":
					registrar(request,response); break;
				case "act":
					actualizar(request,response); break;
				case "eli":
					eliminar(request,response); break;
				case "lst":
					listado(request,response); break;
				case "obtener":
					obtener(request,response); break;
				default:
				}
	}

	private void obtener(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Ingreso a la opción obtener");
		
		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
		
	}

	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener un listado de todos los productos 
		List<Torta> lstTorta = new GestionTorta().listado();		
				
		// enviar el listado a la pagina
		request.setAttribute("lstTorta", lstTorta);
		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		// validacion
		if(!codigo.matches("[Tt][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
			return;
		}
				
		// crear objeto
		Torta t = new Torta();
		t.setIdtorta(codigo);
		System.out.println(t);
		// proceso de base de datos
		int ok = new GestionTorta().eliminar(t);
				
		request.setAttribute("mensaje", ok == 1?"Eliminación OK" : "Error al eliminar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		String nomtor = request.getParameter("txtTorta");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		// validacion
		if(!codigo.matches("[Tt][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
			return;
		}
				
		// crear objeto
		Torta t = new Torta(codigo, nomtor, descripcion, stock, precio);
		System.out.println(t);
		// proceso de base de datos
		int ok = new GestionTorta().actualizar(t);
				
		request.setAttribute("mensaje", ok == 1?"Actualizar OK" : "Error al actualizar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
				
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		String nomtor = request.getParameter("txtTorta");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		// validacion
		if(!codigo.matches("[Tt][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
			return;
		}
		
		// crear objeto
		Torta t = new Torta(codigo, nomtor, descripcion, stock, precio);
		System.out.println(t);
		// proceso de base de datos
		int ok = new GestionTorta().registrar(t);
						
		request.setAttribute("mensaje", ok == 1?"Actualizar OK" : "Error al actualizar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoTortas.jsp").forward(request, response);
		
		
	}

}
