package logic.entity;

import logic.interfaces.FeedbackInterface;

public class Message implements FeedbackInterface {
	private String messageText;
	private String messageTitle;
	private String messageBiblId;
	private String messageStudId;
	private long messageId;

	@Override
	public void setTitle(String titleP) {
		this.messageTitle = titleP;

	}

	@Override
	public String getTitle() {
		return messageTitle;
	}

	@Override
	public void setText(String textP) {
		this.messageText = textP;

	}

	@Override
	public String getText() {
		return messageText;
	}

	@Override
	public String getStudentId() {
		return messageStudId;
	}

	@Override
	public void setStudentId(String studId) {
		this.messageStudId = studId;

	}

	@Override
	public long getId() {
		return messageId;
	}

	@Override
	public String getBibId() {

		return messageBiblId;
	}

	@Override
	public void setBibId(String bibIdp) {
		this.messageBiblId = bibIdp;
	}

}
