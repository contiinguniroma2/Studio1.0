package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Db {
	private Connection connection;
	private static Db dbSingletonInstance;
	private static Logger myLogger = Logger.getLogger("logger");
	private final static String DB_URL="jdbc:mysql://localhost:3306/mydb?useSSL=false";
	private final static String DB_USERNAME="root";
	private final static String DB_PASSWORD="root";

	private Db() {
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (Exception e) {
			e.printStackTrace();
			myLogger.info("Connessione fallita");
		}
	}

	public Connection getConnection() {
		return connection;
	}
	
	public void closeConnection() {
		try {
			this.connection.close();
		} catch (SQLException e) {
			myLogger.info("Chiusura connesione fallita");
			e.printStackTrace();
		}
	}

	public Connection openConnection() {
		try {
			if(!connection.isClosed()) closeConnection();
			connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			myLogger.info("Connessione fallita");
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Db getInstance() {
		if(dbSingletonInstance==null) {
			dbSingletonInstance=new Db();
		}
		return dbSingletonInstance;
	}
}
