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

		Scanner tec = new Scanner(System.in);
		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		PreparedStatement ps = null;

		try {
			con = DB.getConnection();
			String script = "INSERT INTO SELLER " + "(Name, Email, BirthDate, BaseSalary, DepartmentId)"
					+ "VALUES(?,?,?,?,?) ";
			ps = con.prepareStatement(script, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, "Ana Eliza");
			ps.setString(2, "anaeliza@gmail.com");
			ps.setDate(3, new java.sql.Date(stf.parse("12/06/2004").getTime()));
			ps.setDouble(4, 3000.0);
			ps.setInt(5, 2);

			int rows = ps.executeUpdate();
			if (rows != 0) {
				ResultSet rs = ps.getGeneratedKeys();

				while (rs.next()) {

					System.out.println(rs.getInt(1));
				}

			} else
				System.out.println("No Rows affected");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

		finally {

			DB.closeStatemnt(ps);
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