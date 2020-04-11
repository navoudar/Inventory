package com.InventoryManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import com.InventoryManagement.Model.User;
import com.InventoryManagement.Services.DBConnection;


@WebServlet("/UserDAO")
public class UserDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private PreparedStatement ps;
	private static Connection con;
	
	
    public UserDAO() {
        super();
       
    }
    
    public String Login(User user) {
    	
    	String Email = user.getEmail();
    	String Password = user.getPassword();
    	String dbEmail = null;
    	String dbPassword = null;
    	String dbName = null;
    	
    	try {
    		
    		con = DBConnection.getConnection();
    
    		String sql = "SELECT Email,Password,Name FROM users Where Email =? ";
    		
    		ps = con.prepareStatement(sql);
    		ps.setString(1, Email);
    		
    		ResultSet rs = ps.executeQuery();
    		
    		while(rs.next()) {
    			
    			dbEmail = rs.getString("Email");
    			dbPassword = rs.getString("Password");
    			dbName = rs.getString("Name");
    			
    			
    		}
    		
    		
    		
    		if(dbEmail.equals(Email)&& dbPassword.equals(Password)) {
    			
    			user.setName(dbName);
    			
    			return "success";
    		}
    		
    		con.close();
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "error";
    }
    

}
