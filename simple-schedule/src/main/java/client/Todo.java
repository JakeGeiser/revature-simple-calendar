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
	
	public void setId(int inputId) {
		this.id = inputId;
	}
	
	public void setDescription(String inputDesc) {
		this.description = inputDesc;
	}
	
	public void setDueDate(Date inputDate) {
		this.dueDate = inputDate;
	}
	
	public void setStatus(String inputStatus) {
		this.status = inputStatus;
	}
}
