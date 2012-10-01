package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class serves as the main controller for the application. In
 * enterprise design patterns this is called the "Front Controller Patttern."
 * <P>
 * The purpose of this controller is to adhere to the Single Responsibility
 * Principle. A controller can easily get very large and complex over time,
 * eventually violating this principle. By dividing your controller logic
 * up into several sub-controllers, and forwarding data from the main or front
 * controller, you get what is needed.
 * 
 * @author jlombardo
 */
public class MainController extends HttpServlet {
	
	/**
	 * Constructor of the object.
	 */
	public MainController() {
		super();
	}

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
    	String destination = "/index.jsp";
    	
        // The 'action' query string parameter is a flag that can be used by
        // a controller to help it make decisions. Here we are making the
        // decision to go to the order controller, and when it gets there
        // the action parameter is used again to help the order controller
        // decide what to do.
    	if( request.getParameter("action").equals("newList")) {
    		destination = "/order?action=newList";
    	} 
    	
    	// more flow choices to come...
    	
        
        // Redirect to destination page
        RequestDispatcher dispatcher = 
                getServletContext().getRequestDispatcher(destination);
        dispatcher.forward(request, response);

    }

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Call the convenience method, or write your own code here
        processRequest(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		// Call the convenience method, or write your own code here
        processRequest(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
    @Override
	public void init() throws ServletException {
		// Put your code here
	}

}
