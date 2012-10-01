package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

/**
 * This class is a sub-controller that is called by the main or front 
 * controller. See MainController for more information.
 * 
 * @author jlombardo
 */
public class OrderController extends HttpServlet {
	// Kludge to keep this in memory
	private OrderService orderService;
	private final boolean DEBUG = false;
	
	
	/**
	 * Constructor of the object.
	 */
	public OrderController() {
		super();
	}

	   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
		
                boolean responseCommitted = false;
	    	String destination = "/order.jsp";
	    	String action = request.getParameter("action");
	    	String orderEvent = request.getParameter("submit");
	    	List<MenuItem> menuList = orderService.getMenuList();
	    	List<MenuItem> orderList = orderService.getOrderList();
                String[] orderItems = null;
	    	
	    	if( action.equals("newList")) {
	    		destination = "/order.jsp";
                        
                } else if(action.equals("newCheckboxes")) {
	    		destination = "/order2.jsp";
                        
                } else if(action.equals("selectCheckboxes")) {
                    orderItems = request.getParameterValues("menuItems");
                    orderList.clear();
                    for(String item : orderItems) {
                        for(MenuItem menuItem : menuList) {
                            if(menuItem.getItemName().equals(item)) {
                                orderList.add(menuItem);
                                break;
                            }
                        }   
                    }
                    if(orderList.size() > 0) orderService.placeOrder();

                    // We need to get the value of responseCommitted back from
                    // the method because the original is passed by value (a copy)                    
                    responseCommitted = 
                            outputConfirmation(request, response, menuList, orderList, responseCommitted);
                    
	    	} else if(action.equals("selectList")) {
	    		String item = "";
	    		if(orderEvent.startsWith("Order")) {
	    			if(DEBUG) System.out.println("*** Selected item from menu ***");
	    			item = request.getParameter("menuList");
                                
                                // We have to create a clone because we cannot
                                // modify the original as we are looping through it
                                List<MenuItem> menuListClone = new ArrayList<MenuItem>();
                                menuListClone.addAll(menuList);
                                for(MenuItem i : menuListClone) {
                                    if(i.getItemName().equals(item)) {
                                        orderList.add(i);
                                        menuList.remove(i);
                                        break;
                                    }
                                }
                                
	    		} else if(orderEvent.endsWith("Remove")) {
	    			if(DEBUG) System.out.println("*** Returned item to menu ***");
	    			item = request.getParameter("orderList");
                                
                                // We have to create a clone because we cannot
                                // modify the original as we are looping through it                                
                                List<MenuItem> orderListClone = new ArrayList<MenuItem>();
                                orderListClone.addAll(orderList);
                                for(MenuItem i : orderList) {
                                    if(i.getItemName().equals(item)) {
                                        menuList.add(i);                                        
                                        orderList.remove(i);
                                        break;
                                    }
                                }

                        } else { // must be "Place Order"
                            if(orderList.size() > 0) orderService.placeOrder();
                            // We need to get the value of responseCommitted back from
                            // the method because the original is passed by value (a copy)
                             responseCommitted = 
                                     outputConfirmation(request, response, menuList, orderList, responseCommitted);
                        }
                }
	    	
	    	if(!responseCommitted) {
		    	request.setAttribute("menuList", menuList);
		    	request.setAttribute("orderList", orderList);
		        
		        // Redirect to destination page
		        RequestDispatcher dispatcher = 
		                getServletContext().getRequestDispatcher(destination);
		        dispatcher.forward(request, response);
	    	}
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
                
            
        private boolean outputConfirmation(HttpServletRequest request, HttpServletResponse response,
                List menuList, List<MenuItem> orderList, boolean responseCommitted) throws IOException {
            
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out
                            .println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
            out.println("<HTML>");
            out.println("  <HEAD><TITLE>Your meal order has been placed!</TITLE></HEAD>");
            out.println("  <BODY>");
            out.print("    <h2>Thank you! Your meal order has been placed.</h2> ");
            out.println("<p>You ordered the following:</p>");
            out.println("<ul>");
            for(MenuItem item : orderList) {
                    out.println("<li>" + item.getItemName() + "</li>");
            }
            out.println("</ul>");
            out.println("<a href='order?action=new'>Place a new order</a>");
            out.println("  </BODY>");
            out.println("</HTML>");
            out.flush();
            out.close();
            menuList.addAll(orderList);
            orderList.removeAll(orderList);
            responseCommitted = true;
            return responseCommitted;
        }
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
        @Override
	public void init() throws ServletException {
            orderService = new OrderService();
	}

}
