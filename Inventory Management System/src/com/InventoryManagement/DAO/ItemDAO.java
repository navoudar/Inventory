package com.InventoryManagement.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.InventoryManagement.Model.Item;
import com.InventoryManagement.Services.DBConnection;


@WebServlet("/ItemDAO")
public class ItemDAO extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PreparedStatement ps;
	private static Connection con;
	private static Statement st;
     
	public String AddNewItem(Item item) throws SQLException {
		
		String iName = item.getIname();
		String iCode = item.getIcode();
		int iQuantity = item.getQuantity();
		double iprice = item.getPrice();
		
		
		
		try {
			Connection con = DBConnection.getConnection();
			
			String sql = "insert into items(Icode,Iname,Quantity,NetPrice)values(?,?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, iCode);
			ps.setString(2, iName);
			ps.setInt(3, iQuantity);
			ps.setDouble(4, iprice);
			
			int i = ps.executeUpdate();
			
			while(i != 0) {
				return "success";
			}
			
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return "error";
		
	}
	
	public ArrayList<Item> ListAllItems(){
		
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
		
		con = DBConnection.getConnection();
		st = con.createStatement();
		
		String sql = "select Icode,Iname,Quantity,NetPrice from items";
		
		ResultSet rst = st.executeQuery(sql);
			
		while(rst.next()) {
			
			Item items = new Item();
			items.setIcode(rst.getString(1));
			items.setIname(rst.getString(2));
			items.setQuantity(rst.getInt(3));
			items.setPrice(rst.getDouble(4));
			
			itemList.add(items);
		}	
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	
		return itemList;
		
	}
	
	
	public ArrayList<Item> FindItemById(String id) {
		Item item = new Item();
		ArrayList<Item> itemList = new ArrayList<Item>();
		try {
			
		con = DBConnection.getConnection();
		
		String sql = "select Icode,Iname,Quantity,NetPrice from items WHERE Icode= ?";
		
		ps = con.prepareStatement(sql);
		ps.setString(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			
			item.setIcode(rs.getString("Icode"));
			item.setIname(rs.getString("Iname"));
			item.setQuantity(rs.getInt("Quantity"));
			item.setPrice(rs.getDouble("NetPrice"));
			itemList.add(item);
		}
		
		
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return itemList;
		
	}
	
	public void UpdateItems(Item item) {
		
		String Icode = item.getIcode();
		String Iname = item.getIname();
		int Quantity = item.getQuantity();
		double price = item.getPrice();
		
		try {
			
			String sql = "UPDATE items SET Iname=?,Quantity=?,NetPrice=?"+" WHERE Icode=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Iname);
			ps.setInt(2, Quantity);
			ps.setDouble(3, price);
			ps.setString(4, Icode);
			ps.executeUpdate();
			
			con.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void DeleteItem(String id) {
		
		try {
			con = DBConnection.getConnection();
			
			
			String Icode = id;
			
			String sql = "DELETE FROM items WHERE Icode=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, Icode);
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
    public ItemDAO() {
        super();
       
    }

}
