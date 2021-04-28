package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class QueryExe {
	// connect to DB and get statement from DbConnection
	
	private DbConnector dbc = new DbConnector();
	private Statement stmt = dbc.state(dbc.connect());

	
	// add search all items query query method
	public ArrayList<ArrayList<Object>> allItems() {
		ArrayList<ArrayList<Object>> query = new ArrayList<ArrayList<Object>>(); 
		try {
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM planner");
			while(rs.next()) {
				ArrayList<Object> lineQ = new ArrayList<Object>();
				lineQ.add(rs.getInt(1));
				lineQ.add(rs.getString(2));
				lineQ.add(rs.getDate(3));
				lineQ.add(rs.getString(4));
				query.add(lineQ);
			}
			return query;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return query;
		}
	}
	
	private String inputItemQuery = "INSERT INTO planner (Description,Due_Date) VALUES (?, to_date(?,'yyyy-mm-dd'))";
	private PreparedStatement pstmt1 = dbc.statePrepared(dbc.connect(),inputItemQuery);
	public ArrayList<ArrayList<Object>> inputItem(String descIn, String dateIn) {
		try {
			pstmt1.setString(1, descIn);
			pstmt1.setString(2, dateIn);
			pstmt1.executeUpdate();
			
			return allItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return allItems();
		}
	}
	
	private String updateItemQuery = "UPDATE planner SET Status = ? WHERE ID = ?";
	private PreparedStatement pstmt2 = dbc.statePrepared(dbc.connect(),updateItemQuery);
	public ArrayList<ArrayList<Object>> updateItem(int idIn, String statusIn) {
		try {
			pstmt2.setString(1, statusIn);
			pstmt2.setInt(2, idIn);
			pstmt2.executeUpdate();
			
			return allItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return allItems();
		}
	}
	
	
	
	

}
