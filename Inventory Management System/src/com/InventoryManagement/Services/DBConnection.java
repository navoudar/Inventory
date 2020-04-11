package com.InventoryManagement.Services;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/DBConnection")
public class DBConnection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DBConnection() {
      
       
    }
    
    static Connection con = null;
    
    public static Connection getConnection() throws SQLException{
    	
    	try{
    		
    		Class.forName("com.mysql.jdbc.Driver");
    		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventoymanagementsystem", "root", "root");
    		
    		
    	}catch(ClassNotFoundException | SQLException e){
    		System.out.println("Error From DB Connection !!!!");
    		e.printStackTrace();
    	}
    	
    	return con;
    }
    

}
