package dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Properties;


public class DbConnector {
	// initialize connection credentials
	private String url;
	private String user;
	private String password;
	
	
	
	// connect method
	private static Connection con;
	public Connection connect() {
		try {
			FileReader reader = new FileReader(
					"C:\\Users\\jgeis\\git\\revature-simple-calendar\\simple-schedule\\src\\main\\resources\\config.properties");
			
			Properties p = new Properties();
			p.load(reader);
			
			user = p.getProperty("DB_USER");
			password = p.getProperty("DB_PASSWORD");
			url = p.getProperty("DB_URL");
			
			System.out.println("Connecting...");
//			System.out.println(url);
//			System.out.println(user);
//			System.out.println(password);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected");
			return con;
		} catch(SQLException e) {
			System.out.println("Issue connecting to DB");
			return con;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return con;
		}
	}
	
	// make statement
	private Statement stmt = null;
	public Statement state(Connection C) {
		try {
			stmt = C.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}
	
	// make prepared statement
	private PreparedStatement pstmt = null;
	public PreparedStatement statePrepared(Connection C, String query) {
		try {
			pstmt = C.prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	
	// disconnect method
	public void disconnect() {
		if (con != null) {
	        try {
	            con.close();
	        } catch (SQLException e) { /* Ignored */}
	    }
	}

}