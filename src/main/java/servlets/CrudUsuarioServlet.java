package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuario;
import model.Usuario;

/**
 * Servlet implementation class CrudUsuarioServlet
 */
@WebServlet(name = "crudusu", urlPatterns = { "/crudusu" })
public class CrudUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrudUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet usando metodo Get");
		
		System.out.println("Ingreso a la opción obtener");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		Usuario us = new GestionUsuario().obtener(id);
		System.out.println(us);

		request.setAttribute("us", us);

		List<Usuario> lstUsuario = new GestionUsuario().listado();		
		request.setAttribute("lstUsuario", lstUsuario);

		request.getRequestDispatcher("MantenimientoUsuarios.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entró al Servlet usando metodo Post");
		// Leer la opcion seleccionada en el boton
		String opcion = request.getParameter("btnOpcion");
		switch (opcion) {
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
		
		request.getRequestDispatcher("MantenimientoUsuarios.jsp").forward(request, response);
		
	}

	private void listado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//obtener un listado de todos los productos 
		List<Usuario> lstUsuario = new GestionUsuario().listado();		
						
		// enviar el listado a la pagina
		request.setAttribute("lstUsuario", lstUsuario);
		request.getRequestDispatcher("MantenimientoUsuarios.jsp").forward(request, response);
		
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		// validacion
	
		// crear objeto
		Usuario u = new Usuario();
		u.setCodigo(codigo);
		System.out.println(u);
		// proceso de base de datos
		int ok = new GestionUsuario().eliminar(u);
				
		request.setAttribute("mensaje", ok == 1?"Eliminación OK" : "Error al eliminar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoUsuarios.jsp").forward(request, response);
		
	}

	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entradas
		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		String nombre = request.getParameter("txtNombre");
		String apellido = request.getParameter("txtApellido");
		int edad = Integer.parseInt(request.getParameter("txtEdad"));
		String usuario = request.getParameter("txtUsuario");
		String clave = request.getParameter("txtClave");
		// validacion
		
						
		// crear objeto
		Usuario u = new Usuario(codigo, nombre, apellido, edad, usuario, clave, edad);
		System.out.println(u);
		// proceso de base de datos
		int ok = new GestionUsuario().Actualizar(u);
						
		request.setAttribute("mensaje", ok == 1?"Actualizar OK" : "Error al actualizar");
		request.setAttribute("estilo", ok == 1? "alert alert-success":"alert alert-danger");
		request.getRequestDispatcher("MantenimientoUsuarios.jsp").forward(request, response);
		
	}

}
