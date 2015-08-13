package edu.cmu.andrew.ruiw;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MessagingGAEServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		String phone = req.getParameter("phoneNum");
		String text =req.getParameter("message");		
		  String nextView;
		  
		  SendTextMessage ipm =new SendTextMessage();
	        /*
	         * Check if the search parameter is present.
	         * If not, then give the user instructions and prompt for a search string.
	         * If there is a search parameter, then do the search and return the result.
	         */
	        if (phone!= null && text != null) {
	            // use model to do the search and choose the result view
	            ipm.sendText(phone,text);
	            req.setAttribute("result",
	                    ipm.getXML());
	           
	            nextView = "result.jsp";
	        } else {
	            // no search parameter so choose the prompt view
	            nextView = "prompt.jsp";
	        }
	        // Transfer control over the the correct "view"
	        RequestDispatcher view = req.getRequestDispatcher(nextView);
	        try {
				view.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
}
