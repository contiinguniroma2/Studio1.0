package logic.bean;

import logic.exceptions.EmptyTextFieldException;

public class ReportBean {

	private String title;
	private String description;
	private String userId;
	private String status;
	private String library;
	
	public ReportBean() {
		//default constructor
	}

	public void setTitle(String title) throws EmptyTextFieldException  {

		if (title.trim().equals(""))

			throw new EmptyTextFieldException("Text field can't be empty");
		else
			this.title = title;

	}

	public String getTitle() {

		return title;

	}

	public void setdescription(String description) throws EmptyTextFieldException {

		if (description.trim().equals(""))

			throw new EmptyTextFieldException("Text field can't be empty");
		else
			this.description = description;

	}

	public String getdescription() {

		return description;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLibrary() {
		return library;
	}

	public void setLibrary(String library) {
		this.library = library;
	}
}
