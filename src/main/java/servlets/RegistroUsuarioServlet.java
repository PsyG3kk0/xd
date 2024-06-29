package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mantenimientos.GestionUsuario;
import model.Usuario;

/**
 * Servlet implementation class RegistroUsuarioServlet
 */
@WebServlet(name = "rs", urlPatterns = { "/rs" })
public class RegistroUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistroUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Entró al Servlet usando método Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entró al Servlet usando método Post");

		String opcion = request.getParameter("btnOpcion");
		switch (opcion) {
		case "ini":
			inicio(request, response);
			break;
		case "reg":
			registrar(request, response);
			break;

		default:
		}
	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

	private void registrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entró al Servlet usando método Post");

		// entradas

		String nombre = request.getParameter("txtnombre");
		String apellido = request.getParameter("txtapellido");

		int edad = Integer.parseInt(request.getParameter("txtedad"));

		String usuario = request.getParameter("txtusuario");
		String clave = request.getParameter("txtclave");

		// validación
		
		

		// crear el objeto
		Usuario u = new Usuario();
		// se omitió el código por ser auto_increment
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setEdad(edad);
		u.setUsuario(usuario);
		u.setClave(clave);
		// se omitió el tipo y estado por tener default

		
		
		System.out.println(u);

		
		
		// proceso en BD
		int ok = new GestionUsuario().Registro(u);
		// salidas

		
		
		request.setAttribute("mensaje", ok == 1 ? "Registro OK" : "Error al Registrar");
		request.setAttribute("estilo", "alert alert-success");
		request.getRequestDispatcher("Login.jsp").forward(request, response);

	}

}
