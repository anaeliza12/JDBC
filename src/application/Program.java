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
import db.DbException;
import db.DbIntegrityException;

public class Program {
	public static void main(String[] args)  {

		SimpleDateFormat stf = new SimpleDateFormat("dd/MM/yyyy");
		Connection con = null;
		Statement st = null;

		try {
			con = DB.getConnection();
			
			con.setAutoCommit(false);
			String sql1 = "UPDATE SELLER SET BaseSalary = 2090 where DepartmentId = 1 ";
			String sql2 = "UPDATE SELLER SET BaseSalary = 3090 where DepartmentId = 1";
			st = con.createStatement();

			int rows1 = st.executeUpdate(sql1);


			int x = 1;
			if (x < 2) {
				throw new SQLException("Fake Error");
			}
			int rows2 = st.executeUpdate(sql2);
			
			con.commit();

			System.out.println("rows1: " + rows1);
			System.out.println("rows2: " + rows2);
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				throw new DbException("Transaction rolled back! Caused by: " +  e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		} finally {

			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
