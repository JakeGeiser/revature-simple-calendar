package client;

import java.sql.Date;

public class Todo {
	private int id;
	private String description;
	private Date dueDate;
	private String status;
	
	public int getId() {
		return id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public Date getDueDate() {
		return dueDate;
	}
	
	public String getStatus() {
		return status;
	}
	
}
