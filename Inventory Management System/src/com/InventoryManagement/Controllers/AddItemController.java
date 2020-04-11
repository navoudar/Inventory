package com.InventoryManagement.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.InventoryManagement.DAO.ItemDAO;
import com.InventoryManagement.Model.Item;
import com.InventoryManagement.Services.DBConnection;

@WebServlet("/ItemController")
public class AddItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddItemController() {

	}

	ItemDAO itemDao;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
			
		
			
		 

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

		try {

			String iCode = request.getParameter("code");
			String iName = request.getParameter("name");
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			double price = Double.parseDouble(request.getParameter("price"));

			Item item = new Item();
			item.setIcode(iCode);
			item.setIname(iName);
			item.setQuantity(quantity);
			item.setPrice(price);

			ItemDAO itemDao = new ItemDAO();
			String str = itemDao.AddNewItem(item);

			if (str.equals("success")) {
				response.sendRedirect("AdminPanel.jsp");
			} else {
				response.sendRedirect("AddItem.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
