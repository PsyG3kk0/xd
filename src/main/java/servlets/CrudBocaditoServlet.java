package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionBocadito;
import mantenimientos.GestionTorta;
import model.Bocadito;
import model.Torta;

/**
 * Servlet implementation class CrudBocaditoServlet
 */
@WebServlet(name = "crudboca", urlPatterns = { "/crudboca" })
public class CrudBocaditoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudBocaditoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet usando metodo Get");
		
		System.out.println("Ingreso a la opción obtener");
		String id = request.getParameter("id");
		System.out.println(id);
		Bocadito b = new GestionBocadito().obtener(id);
		System.out.println(b);

		request.setAttribute("b", b);

		List<Bocadito> lstBocaditos = new GestionBocadito().listado();		
		request.setAttribute("lstBocaditos", lstBocaditos);

		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
		
	}

	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Bocadito> lstBocaditos = new GestionBocadito().listado();		
		
		// enviar el listado a la pagina
		request.setAttribute("lstBocaditos", lstBocaditos);
		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		// validacion
		if(!codigo.matches("[Bb][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
			return;
		}
						
		// crear objeto
		Bocadito b = new Bocadito();
		b.setId_boca(codigo);
		System.out.println(b);
		// proceso de base de datos
		int ok = new GestionBocadito().eliminiar(b);
						
		request.setAttribute("mensaje", ok == 1?"Eliminación OK" : "Error al eliminar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		String nomboca = request.getParameter("txtBocaditos");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		// validacion
		if(!codigo.matches("[Bb][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
			return;
		}
						
		// crear objeto
		Bocadito b = new Bocadito(codigo, nomboca, descripcion, stock, precio);
		System.out.println(b);
		// proceso de base de datos
		int ok = new GestionBocadito().actualizar(b);
						
		request.setAttribute("mensaje", ok == 1?"Actualizar OK" : "Error al actualizar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
		
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		String codigo = request.getParameter("txtCodigo");
		String nomboca = request.getParameter("txtBocaditos");
		String descripcion = request.getParameter("txtDescripcion");
		int stock = Integer.parseInt(request.getParameter("txtStock"));
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		// validacion
		if(!codigo.matches("[Bb][0-9]{4}")) {
			request.setAttribute("mensaje", "Código"+codigo+"no es correcto!!!");
			request.setAttribute("estilo", "alert alert-danger");
			request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
			return;
		}
								
		// crear objeto
		Bocadito b = new Bocadito(codigo, nomboca, descripcion, stock, precio);
		System.out.println(b);
		// proceso de base de datos
		int ok = new GestionBocadito().registrar(b);
								
		request.setAttribute("mensaje", ok == 1?"Actualizar OK" : "Error al actualizar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoBocaditos.jsp").forward(request, response);
		
	}

}
