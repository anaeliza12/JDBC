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
import db.DbIntegrityException;

public class Program {
	public static void main(String[] args) {

		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		PreparedStatement st = null;

		try {
			con = DB.getConnection();
			st = con.prepareStatement("UPDATE SELLER SET DepartmentId = ? where Name = ?");

			st.setInt(1, 2);
			st.setString(2, "Fernanda");

			int row = st.executeUpdate();
			System.out.println(row);

		} catch (SQLException e) {
			e.printStackTrace();
		} 
		finally {

			DB.closeStatement(st);
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