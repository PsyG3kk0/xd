package etiquetas;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MenuIndex extends TagSupport{
	private int contador;
	private int rol = 1;
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			out.println("<ul class=\"nav nav-tabs\">");

			  out.println("<li class=\"nav-item\">");
			  out.println("  <a class=\"nav-link\" aria-current=\"page\" href=\"index.jsp\">Inicio</a>");
			  out.println("</li>");
			  
			  out.println("<li class=\"nav-item\">");
			  out.println("  <a class=\"nav-link\" href=\"inicio?accion=home\">Catalogo</a>");
			  out.println("</li>");
			  
			  if (rol == 1) {
				  out.println("<li class=\"nav-item dropdown\">");
				  out.println("  <a class=\"nav-link dropdown-toggle\" data-bs-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-expanded=\"false\">Mantenimiento</a>");
				  out.println("  <ul class=\"dropdown-menu\">");
				  out.println("    <li><a class=\"dropdown-item\" href=\"MantenimientoTortas.jsp\">Matenimineto Productos</a></li>");
				  out.println("    <li><a class=\"dropdown-item\" href=\"MantenimientoUsuarios.jsp\">Matenimineto Usuarios</a></li>");
				  out.println("    <li><a class=\"dropdown-item\" href=\"MantenimientoBocaditos.jsp\">Matenimineto Bocaditos</a></li>");
				  out.println("  </ul>");
				  out.println("</li>");
			  }

			  out.println("<li class=\"nav-item\">");
			  out.println("  <a class=\"nav-link\" href=\"inicio?accion=Car\">Tienda</a>");
			  out.println("</li>");

			  out.println("<li class=\"nav-item\">");
			  out.println("  <a class=\"nav-link\" aria-current=\"page\" href=\"Nosotros.jsp\">Nosotros</a>");
			  out.println("</li>");

			  out.println("</ul>");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en MenuIndex");
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}
	
	public void setContador(int contador) {
        this.contador = contador;
    }

}
