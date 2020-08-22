package logic.control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import logic.entity.Report;

public class ListenerAddThread implements Runnable {
	
	private ReportIssueController reportIssueController;
	private boolean running;
	private int port;
	
	public ListenerAddThread(ReportIssueController reportIssueController, int port) {
		this.reportIssueController=reportIssueController;
		this.running=true;
		this.port=port;
	}
	
	@Override
	public void run() {
		 
        ServerSocket ss = null;
        Socket socket=null;
		try {
			ss = new ServerSocket(this.port);

			while(running) {
	        socket = ss.accept(); 
	        
	        System.out.println("Connection from " + socket + "!");

	        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

	        Report newReport= (Report) objectInputStream.readObject();
	        System.out.println("Ricevuto Report"+newReport.getTitle());
	        this.reportIssueController.getSessionUser().addReport(newReport);
			}

	        
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("Closing sockets.");
        try {
			ss.close();
			socket.close();     
		} catch (IOException e) {
			e.printStackTrace();
		}
        
      
	}
	
	public void terminate() {
		running=false;
	}
	
	public boolean isRunning() {
		return running;
	}

}
