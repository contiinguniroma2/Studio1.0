package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import logic.interfaces.FeedbackInterface;
import logic.pattern.Factory;

public class MessageDao extends GenericDao {

	static Logger myLogger = Logger.getLogger("logger");
	private Factory factory;
	private Connection con;
	private PreparedStatement ps;

	public MessageDao() {
		this.factory = new Factory();
	}

	// INSERT
	public int insert(String messageMailB, String messageMailS, String messageTitle, String messageText)
			throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement(
					"INSERT INTO Messaggio(mailBiblioteca,mailStudente,testoMessaggio,titoloMessaggio) VALUES(?,?,?,?)");
			ps.setString(1, messageMailB);
			ps.setString(2, messageMailS);
			ps.setString(3, messageText);
			ps.setString(4, messageTitle);
			status = ps.executeUpdate();

		} catch (Exception e) {

			myLogger.info("Salvataggio messaggio fallito");// definire un eccezione apposita con logger serio

		} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	public List<FeedbackInterface> select(String idBibl, String idStud) throws SQLException {
		ResultSet rs = null;
		List<FeedbackInterface> messageList = new ArrayList<>();
		try {
			con = Db.getConnection();

			ps = con.prepareStatement("SELECT * FROM Messaggio WHERE mailBiblioteca = ? AND mailStudente = ?");
			fillSelectStatement(ps, idBibl, idStud);
			rs = ps.executeQuery();
			while (rs.next()) {
				messageList.add(factory.createProduct(1, rs.getString(TITOLOM), rs.getString(TESTOM),
						rs.getString(MAILB), rs.getString(MAIL)));
			}

			return messageList;

		}

		catch (Exception e) {
			myLogger.info("Select messaggio fallito");// definire un eccezione apposita con logger serio
		} finally {
			con.close();
			ps.close();
		}
		return messageList;
	}

}
