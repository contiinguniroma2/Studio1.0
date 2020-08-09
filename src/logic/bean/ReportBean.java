package logic.bean;

import logic.exceptions.EmptyTextFieldException;

public class ReportBean {

	private String title;
	private String description;
	
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
}
