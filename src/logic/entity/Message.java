package logic.entity;


public class Message {
	private String text;
	private String title;
	private String librarianId;
	private String studentId;
	private long messageId;
	
	public Message(long id, String title, String text, String librarianId, String studentId) {
		this.messageId = id;
		this.setTitle(title);
		this.setText(text);
		this.setLibrarianId(librarianId);
		this.setStudentId(studentId);
	}


	public long getId() {
		return messageId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getLibrarianId() {
		return librarianId;
	}


	public void setLibrarianId(String librarianId) {
		this.librarianId = librarianId;
	}

}
