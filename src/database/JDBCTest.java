package database;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "root");
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("Select * from eproduct");
				
				while(rs.next()) {
					
					System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getDouble(3));
				}
				
				//stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Headphones', 800.00, now());");
				//stmt.executeUpdate("update eproduct set name='Bluetooth', price=450 where ID = 8");
				//stmt.executeUpdate("DELETE FROM eproduct WHERE name='Desktop';");
				//stmt.executeUpdate("create database db1");
				//stmt.executeUpdate("drop database db1");
				CallableStatement stmt1 = con.prepareCall("{call add_product(?, ?)}");
				stmt1.setString(1, "Iphone");
				stmt1.setBigDecimal(2, new BigDecimal(19999.00));
				stmt1.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
