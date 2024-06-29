package listeners;

import java.util.ArrayList;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import model.DetalleBotella;
import model.Tienda;

/**
 * Application Lifecycle Listener implementation class CompraListener
 *
 */
@WebListener
public class CompraListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public CompraListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Se creo una sesión....");
        System.out.println("Id...: "+ se.getSession().getId());
        System.out.println("--------------------------------");
        //-----------variables globales a nivel de sesión
        ArrayList<Tienda> tienda = new ArrayList<>();
        
        ArrayList<DetalleBotella> carro =new ArrayList<>();
        double subTotalVenta = 0.0;
        int cantArticulos = 0;
     // enviar a nivel de sesión
        se.getSession().setAttribute("carro", carro);
        se.getSession().setAttribute("subTotalVenta", subTotalVenta);
        se.getSession().setAttribute("cantArticulos", cantArticulos);
   
        se.getSession().setAttribute("contador", tienda.size());
     // En un listener, NO va un redireccionar!!!
       
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Se creo una sesión....");
        System.out.println("Id...: "+ se.getSession().getId());
        System.out.println("--------------------------------");
    }
	
}
