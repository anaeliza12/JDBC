package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {
	public static void main(String[] args) {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {

			con = DB.getConnection();
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM department");
		
		
			while(rs.next()) {
				System.out.println(rs.getInt("Id") + " " + rs.getString("Name" ));
				
			
			}
		

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
}