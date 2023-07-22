package db;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
	private static Connection con = null;
	
//	static final String DB_URL = "jdbc:mysql://localhost:3306/coursejdbc?allowPublicKeyRetrieval=true&useSSL=false";
	
	public static Connection getConnection() {
		 if(con == null) {
			 try {
				 
			Properties props = loadProperties();
			String url = props.getProperty("dburl");
			con = DriverManager.getConnection(url, props);
			 }catch(SQLException e) {
				 throw new DbException(e.getMessage());
			 }
		}
		 return con;
	}
	
	
	
	private static Properties loadProperties() {
		
	
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties();
			props.load(fs);
			
			return props;
		}catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}

	public static void closeConnection() {
		try {

			if (con != null) {
			con.close();
		}
		}catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}
	
}
