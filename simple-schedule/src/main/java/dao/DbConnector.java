package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DbConnector {
	// initialize connection credentials
	private String url;
	private String user;
	private String password;
	
	// get url, user, and password from config.properties
	try {
		FileReader reader = new FileReader(
				"C:\\Users\\jgeis\\eclipse-workspace\\simple-calculator\\src\\main\\java\\jdbc\\config.properties");
		
		Properties p = new Properties();
		p.load(reader);
		
		user = p.getProperty("DB_USER");
		password = p.getProperty("DB_PASSWORD");
		url = p.getProperty("DB_URL");
	} catch (Exception e) {
		// TODO: handle exception
	}
	
	
	// connect method
	private static Connection con;
	public Connection connect() {
		try {
			System.out.println("Connecting...");
//			System.out.println(url);
//			System.out.println(user);
//			System.out.println(password);
			con = DriverManager.getConnection(url,user,password);
			System.out.println("Connected");
			return con;
		}catch(SQLException e) {
			System.out.println("Issue connecting to DB");
			return con;
		}
	}
	
	// make statement
	private Statement stmt = null;
	public Statement state(Connection C) {
		try {
			this.stmt = C.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.stmt;
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