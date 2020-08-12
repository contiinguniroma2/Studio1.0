package logic.control;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.logging.Logger;

import logic.bean.ReportBean;
import logic.boundary.BaseBoundary;
import logic.dao.ReportDao;
import logic.entity.Report;
import logic.entity.User;
import logic.pattern.Observer;

public class ReportIssueController implements Observer{
	private User sessionUser;
	private ReportBean reportBean;
	private BaseBoundary issueListBoundary;
	private BaseBoundary issueInfoBoundary;
	private ReportDao reportDao;
	private Socket socket;
	static Logger myLogger = Logger.getLogger("logger");
	private ObjectOutputStream outToServer;
	
	public ReportIssueController(){
		//Default constructor
	}
	
	public ReportIssueController(User sessionUser, ReportBean reportBean, BaseBoundary issueListBoundary){
		this.sessionUser=sessionUser;
		this.reportBean=reportBean;
		this.issueListBoundary=issueListBoundary;
		this.reportDao=new ReportDao();
		try {
			socket = new Socket("127.0.0.1", 4444);
			outToServer = new ObjectOutputStream(socket.getOutputStream());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			myLogger.info("Apertura socket fallita");
		}
	}
	
	public void sendReport(ReportBean reportInfo) throws IOException, SQLException {
		Report newReport=new Report(reportInfo.getTitle(),reportInfo.getdescription(), 0, reportInfo.getUserId(), reportInfo.getLibrary(), "Not read");
		this.sessionUser.addReport(newReport);
		this.reportDao.saveReportOnDb(newReport);
		outToServer.writeObject(newReport);
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}
	
	
}