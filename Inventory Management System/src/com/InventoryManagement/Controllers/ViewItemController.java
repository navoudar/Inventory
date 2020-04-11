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


@WebServlet("/ViewItemController")
public class ViewItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ViewItemController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		ItemDAO itemDao = new ItemDAO();
		
		itemList = itemDao.ListAllItems();
		
		request.setAttribute("itemList", itemList);
		request.getRequestDispatcher("ViewItems.jsp").forward(request, response);

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
