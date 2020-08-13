package logic.control;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Logger;
import logic.bean.ReportBean;
import logic.dao.ReportDao;
import logic.entity.Library;
import logic.entity.Report;
import logic.entity.User;

public class ReportIssueController{
	private User sessionUser;
	private Library currentLibrary;
	private ReportBean reportBean;
	private ReportDao reportDao;
	//private Socket socket;
	//private ObjectOutputStream outToServer;
	static Logger myLogger = Logger.getLogger("logger");
	
	
	public ReportIssueController(){
		//Default constructor
	}
	
	public ReportIssueController(User sessionUser){
		this.sessionUser=sessionUser;
		this.reportDao=new ReportDao();
		/*try {
			socket = new Socket("127.0.0.1", 4444);
			outToServer = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			myLogger.info("Apertura socket fallita");
		}*/
	}
	
	public void sendReport(ReportBean reportInfo) throws IOException, SQLException {
		Report newReport=new Report(reportInfo.getTitle(),reportInfo.getdescription(), 0, reportInfo.getStudentId(), reportInfo.getLibraryId(), "Not read");
		this.sessionUser.addReport(newReport);
		this.reportDao.saveReportOnDb(newReport);
		//outToServer.writeObject(newReport);
	}
	
	public void getStudentReports() {
		this.sessionUser.setReports(this.reportDao.getReportFromDbByStudent(this.sessionUser));
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
	
}