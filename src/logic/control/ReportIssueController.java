package logic.control;

/*import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;*/
import java.util.logging.Logger;
import logic.bean.ReportBean;
import logic.constants.ReportConstants;
import logic.dao.ReportDao;
import logic.entity.Library;
import logic.entity.Report;
import logic.entity.Student;
import logic.entity.User;
import logic.exceptions.ReportDeleteException;
import logic.exceptions.ReportSaveException;
import logic.exceptions.ReportUpdateException;

public class ReportIssueController{
	private User sessionUser;
	private Library currentLibrary;
	private ReportBean reportBean;
	private ReportDao reportDao;
	/*
	private Socket socket;
	private ObjectOutputStream outToServer;
	private Thread listenerAddThread;
	private Thread listenerUpdateThread;
	private Thread listenerDeleteThread;
	*/
	static Logger myLogger = Logger.getLogger("logger");
	
	
	
	public ReportIssueController(){
		//Default constructor
	}
	
	public ReportIssueController(User sessionUser){
		this.sessionUser=sessionUser;
		this.reportDao=new ReportDao();
		/*ListenerAddThread listenerAddRunnable=new ListenerAddThread(this,7777);
		this.listenerAddThread=new Thread(listenerAddRunnable);
		this.listenerAddThread.start();
		ListenerDeleteThread listenerDeleteRunnable=new ListenerDeleteThread(this,8888);
		this.listenerDeleteThread=new Thread(listenerDeleteRunnable);
		this.listenerDeleteThread.start();*/
	}
	
	public ReportIssueController(Student sessionStudent, Library currentLibrary){
		this.sessionUser=sessionStudent;
		this.currentLibrary=currentLibrary;
		this.reportDao=new ReportDao();
		/*ListenerDeleteThread listenerDeleteRunnable=new ListenerDeleteThread(this,5555);
		this.listenerDeleteThread=new Thread(listenerDeleteRunnable);
		this.listenerDeleteThread.start();
		ListenerUpdateThread listenerUpdateRunnable=new ListenerUpdateThread(this,6666);
		this.listenerUpdateThread=new Thread(listenerUpdateRunnable);
		this.listenerUpdateThread.start();*/
		
	}
	
	public void solveIssue() throws ReportUpdateException {
		Report solvedReport=new Report(this.reportBean.getTitle(),this.reportBean.getDescription(),this.reportBean.getReportId(),this.reportBean.getStudentId(),this.sessionUser.getMail(),ReportConstants.SOLVED);
		try {
			this.reportDao.updateReport(solvedReport);
		} catch (ReportUpdateException e) {
			throw new ReportUpdateException();
		}
	
		this.sessionUser.getReports().get(findReportIndex(this.reportBean.getReportId())).setStatus(ReportConstants.SOLVED);		
		//sendOverSocket(solvedReport,6666);
	}
	
	public void readIssue() throws ReportUpdateException {
		if(this.reportBean.getStatus().contentEquals(ReportConstants.NOT_READ)) {
			Report readedReport=new Report(this.reportBean.getTitle(),this.reportBean.getDescription(),this.reportBean.getReportId(),this.reportBean.getStudentId(),this.sessionUser.getMail(),ReportConstants.READ);
			this.reportDao.updateReport(readedReport);
			this.sessionUser.getReports().get(findReportIndex(this.reportBean.getReportId())).setStatus(ReportConstants.READ);
			//sendOverSocket(readedReport,6666);
		}
	}
	
	public int findReportIndex(long reportId) {
		int i;
		for(i=0;i<this.sessionUser.getReports().size();i++) {
			if(this.sessionUser.getReports().get(i).getReportId()==reportId) return i;
		}
		return -1;
	}
	
	public void fillBeanWithSelectedReport(long reportId) {
		int reportIndex=findReportIndex(reportId);
		this.reportBean=new ReportBean(this.sessionUser.getReports().get(reportIndex).getTitle(), this.sessionUser.getReports().get(reportIndex).getDescription(), this.sessionUser.getReports().get(reportIndex).getStudentId(),this.sessionUser.getReports().get(reportIndex).getLibraryId(),this.sessionUser.getReports().get(reportIndex).getStatus(),this.sessionUser.getReports().get(reportIndex).getReportId());		
		
	}
	
	public void sendReport(ReportBean reportInfo) throws ReportSaveException {
		Report newReport=new Report(reportInfo.getTitle(),reportInfo.getDescription(), this.sessionUser.getMail(), this.currentLibrary.getMail(), ReportConstants.NOT_READ);
		try {
			this.reportDao.saveReportOnDb(newReport);
		} catch (ReportSaveException e) {
			throw new ReportSaveException();
		}
		this.sessionUser.addReport(newReport);
		//sendOverSocket(newReport,7777);
	}
	
	public void deleteReport(long reportId) throws ReportDeleteException {
		int reportIndex=findReportIndex(reportId);
		this.reportDao.deleteReportFromDb(this.sessionUser.getReports().get(reportIndex));
		this.sessionUser.removeReport(this.sessionUser.getReports().get(reportIndex));
	}
	
	public void getStudentReports() {
		this.sessionUser.setReports(this.reportDao.getReportFromDbByStudent(this.sessionUser, this.currentLibrary));
	}
	
	public void getLibraryReports() {
		this.sessionUser.setReports(this.reportDao.getReportFromDbByLibrary(this.sessionUser));
	}

	public User getSessionUser() {
		return sessionUser;
	}
	public void setSessionUser(User sessionUser) {
		this.sessionUser = sessionUser;
	}
	public ReportBean getReportBean() {
		return reportBean;
	}
	public void setReportBean(ReportBean reportBean) {
		this.reportBean = reportBean;
	}

	public Library getCurrentLibrary() {
		return currentLibrary;
	}

	public void setCurrentLibrary(Library currentLibrary) {
		this.currentLibrary = currentLibrary;
	}
	
	/*public void sendOverSocket(Report report,int port) {
		try{
			socket = new Socket("127.0.0.1", port);
			outToServer = new ObjectOutputStream(socket.getOutputStream());
			outToServer.writeObject(report);
		} catch (UnknownHostException e) {
			myLogger.info("Apertura socket fallita");
			e.printStackTrace();
		} catch (IOException e) {
			myLogger.info("Apertura stream fallita");
			e.printStackTrace();
		}
	}*/
	
}