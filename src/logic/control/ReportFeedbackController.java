package logic.control;

import logic.bean.FeedbackBean;
import logic.exceptions.FeedbackCreationException;
import logic.interfaces.FeedbackInterface;
import logic.pattern.Factory;

import java.util.logging.Logger;

//Singleton first 2 methods
public class ReportFeedbackController {

	private Factory factory;
	private FeedbackInterface feedback;
	private FeedbackBean feedbackBean;
	static Logger myLogger = Logger.getLogger("logger");
	private static ReportFeedbackController instance = null;
	int dummyData;

	// costruttore
	protected ReportFeedbackController(int init) {

		this.factory = new Factory();
		this.dummyData = init;

	}

	// Richiesta del singleton controller
	public static ReportFeedbackController getReportFeedbackController() {

		if (ReportFeedbackController.instance == null)
			ReportFeedbackController.instance = new ReportFeedbackController(1);
		return instance;

	}

	// Creazione di un feedback tramite factory
	public void createFeedback(String feedbackTitle, String feedbackText, String feedbackBiblId,
			String feedbackStudId) {

		try {

			this.feedback = factory.createProduct(1, feedbackTitle, feedbackText, feedbackBiblId, feedbackStudId);

		}

		catch (FeedbackCreationException e) {

			myLogger.info(e.toString());
			e.printStackTrace();

		}

	}

	public FeedbackInterface getFeedback() {
		return feedback;
	}

	public void setFeedback(FeedbackInterface feedback) {
		this.feedback = feedback;
	}

	public FeedbackBean getFeedbackBean() {
		return feedbackBean;
	}

	public void setFeedbackBean(FeedbackBean feedbackBean) {
		this.feedbackBean = feedbackBean;
	}

}
