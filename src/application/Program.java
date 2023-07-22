package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import db.DB;

public class Program {
	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DB.getConnection();
			st = con.prepareStatement(
			"UPDATE seller " 
			+ "set BaseSalary = BaseSalary + ? " 
			+ "WHERE  Name = ?");

			st.setDouble(1, 4500.0);
			st.setString(2, "Bob Brown");

			int row = st.executeUpdate();

			System.out.println(row);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {

			DB.closeStatemnt(st);
			DB.closeConnection();
		}
	}
}
//		Statement st = null;
//		ResultSet rs = null;
//
//		try {
//
//			con = DB.getConnection();
//			st = con.createStatement();
//			rs = st.executeQuery("SELECT * FROM seller ");
//
//			while (rs.next()) {
//				System.out.println(rs.getInt("Id") + " " + rs.getString("Name") );
//
//			}
//
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//
//		finally {
//
//			DB.closeStatemnt(st);
//			DB.closeResultSet(rs);
//			DB.closeConnection();
//		}