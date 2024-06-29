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
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "ls", urlPatterns = { "/ls" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Entro al servlet login usando metodo post");
		
		String opcion = request.getParameter("btnOpcion");
		switch (opcion) {
		case "ini":
			inicio(request, response);
			break;
		case "registrar":
			registrar(request, response);
			break;

		default:
		}
	}

	

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("Registro.jsp").forward(request, response);
		
	}

	private void inicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Entro al servlet login usando metodo post");
		// Entradas

				String usuario = request.getParameter("txtusuario");
				String clave = request.getParameter("txtclave");
				// validaciones

				// creamos el objeto
				Usuario u = new Usuario();
				u.setUsuario(usuario);
				u.setClave(clave);

				// lamar a la gestion

				u = new GestionUsuario().validarAcceso(u);
				// validar el acceso
				if (u == null) {

					request.setAttribute("mensaje", "usuario o clave incorecto !!!");
					request.setAttribute("estilo", "alert alert-danger");
					request.getRequestDispatcher("Login.jsp").forward(request, response);
				} else {
					request.getSession().setAttribute("user", u.getNombre() + " " + u.getApellido());
					request.getSession().setAttribute("u", u);
					request.setAttribute("mensaje", u.getNombre() + "" + u.getApellido());
					request.setAttribute("estilo", "alert alert-success");
					request.getRequestDispatcher("index.jsp").forward(request, response);

				}
		
	}

}
