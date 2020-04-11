package com.InventoryManagement.Controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.InventoryManagement.DAO.ItemDAO;
import com.InventoryManagement.Model.Item;
import com.InventoryManagement.Services.DBConnection;


@WebServlet("/UpdateItemContoller")
public class UpdateItemContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UpdateItemContoller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String Page ="";
		
		try {
			
		String Icode = request.getParameter("Icode");
		
		ItemDAO itemDao = new ItemDAO();
		ArrayList<Item> listItem = new ArrayList<Item>();
		
		listItem = itemDao.FindItemById(Icode);
		
		request.setAttribute("listItem", listItem);
		
		
		
		request.getRequestDispatcher("Update.jsp").forward(request, response);
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
		
		String Icode = request.getParameter("code");
		String Iname = request.getParameter("name");
		int Quantity = Integer.parseInt(request.getParameter("quantity"));
		double Price = Double.parseDouble(request.getParameter("price"));
		
		Item item = new Item();
		item.setIcode(Icode);
		item.setIname(Iname);
		item.setQuantity(Quantity);
		item.setPrice(Price);
		
		ItemDAO itemDao = new ItemDAO();
		itemDao.UpdateItems(item);
		
	
 		//request.getRequestDispatcher("ViewItems.jsp").forward(request, response);
		
	}

}
