package com.InventoryManagement.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionTest {

	public static void main(String[] args) throws SQLException{
		
		Connection con = DBConnection.getConnection();
		
		try {
			
			String sql = "select * from users";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("Name"));
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

}
