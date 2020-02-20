// Bisogna aggiungere il riferimento ai feedback nell'entity user, anche dei messaggi. Come per servizi in library
package logic.entity;

import logic.interfaces.FeedbackInterface;

public class Feedback implements FeedbackInterface {
	private String feedbackTitle;
	private String feedbackText;
	private String feedbackStudId;
	private long idFeedback;
	private String feedbackBiblId;

	public Feedback(String feedbackTitle, String feedbackText, String feedbackStudId, String feedbackBiblId) {
		this.feedbackTitle = feedbackTitle;
		this.feedbackText = feedbackText;
		this.feedbackStudId = feedbackStudId;
		this.feedbackBiblId = feedbackBiblId;
	}

	@Override
	public void setTitle(String feedbackTitleP) {

		feedbackTitle = feedbackTitleP;

	}

	@Override
	public String getTitle() {

		return feedbackTitle;

	}

	@Override
	public void setText(String feedbackTextP) {

		feedbackText = feedbackTextP;

	}

	@Override
	public String getText() {

		return feedbackText;

	}

	@Override
	public String getStudentId() {

		return feedbackStudId;

	}

	@Override
	public void setStudentId(String feedbackStudIdP) {

		this.feedbackStudId = feedbackStudIdP;

	}

	@Override
	public long getId() {

		return idFeedback;

	}

	@Override
	public String getBibId() {

		return feedbackBiblId;

	}

	@Override
	public void setBibId(String bibIdP) {

		this.feedbackBiblId = bibIdP;

	}

}
