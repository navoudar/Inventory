
package com.InventoryManagement.Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.InventoryManagement.DAO.UserDAO;
import com.InventoryManagement.Model.User;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
		
		String Email = request.getParameter("email");
		String Password = request.getParameter("password");
		String Name = null;
		
		User user = new User();
		user.setEmail(Email);
		user.setPassword(Password);
		
		UserDAO userDao = new UserDAO();
		String str = userDao.Login(user);
		
		Name = user.getName();
		
		if(str.equals("success")) {
			
			HttpSession session = request.getSession();
			session.setAttribute("userEmail", Email);
			session.setAttribute("UserName", Name);
			
				if(Email.equals("sandalirajapaksha10@gmail.com")) {
					RequestDispatcher rd = request.getRequestDispatcher("AdminPanel.jsp");
					rd.forward(request, response);
				}else {
			
			RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
			rd.forward(request, response);
				}
		}else
			
			response.sendRedirect("index.jsp");
		
	}

}
