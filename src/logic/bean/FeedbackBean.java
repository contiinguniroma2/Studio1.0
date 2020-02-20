package logic.bean;

import logic.exceptions.EmptyTextFieldException;

public class FeedbackBean {

	private String title;
	private String text;

	public void setTitle(String titlep) {

		this.title = titlep;

	}

	public String getTitle() {

		return title;

	}

	public void setText(String textp) throws EmptyTextFieldException {

		if (textp.trim().equals(""))

			throw new EmptyTextFieldException("Text field can't be empty");
		else
			this.text = textp;

	}

	public String getText() {

		return text;

	}
}
