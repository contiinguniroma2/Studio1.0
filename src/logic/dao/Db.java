package logic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Logger;

public class Db {

	static Logger myLogger = Logger.getLogger("logger");

	private Db() {

	}

	public static Connection getConnection() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "root");
		} catch (Exception e) {
			myLogger.info("Connessione fallita");
		}
		return con;
	}

}
