package logic.pattern;

import logic.entity.Feedback;
import logic.entity.Message;
import logic.exceptions.FeedbackCreationException;
import logic.interfaces.FeedbackInterface;

public class Factory {

	public FeedbackInterface createProduct(int type, String feedbackTitle, String feedbackText, String feedbackStudId,
			String feedbackBiblId) throws FeedbackCreationException {

		if (type == 1)
			return new Feedback(feedbackTitle, feedbackText, feedbackStudId, feedbackBiblId);
		else if (type == 2)
			return new Message();
		else
			throw new FeedbackCreationException("" + type);

	}

}
