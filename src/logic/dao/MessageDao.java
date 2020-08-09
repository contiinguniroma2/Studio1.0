package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import logic.entity.Message;
import logic.interfaces.FeedbackInterface;
import logic.pattern.Factory;

public class MessageDao extends GenericDao {

	static Logger myLogger = Logger.getLogger("logger");
	private Connection con;
	private PreparedStatement ps;

	public MessageDao() {
	}

	// INSERT
	public long insert(Message message) throws SQLException {
		ResultSet rs = null;
		long autoId = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement(
					"INSERT INTO Messaggio(mailBiblioteca,mailStudente,testoMessaggio,titoloMessaggio) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			rs = ps.getGeneratedKeys();
			ps.setString(1, message.getLibrarianId());
			ps.setString(2, message.getStudentId());
			ps.setString(3, message.getText());
			ps.setString(4, message.getTitle());
			ps.getGeneratedKeys();
			rs.next();
			autoId = rs.getLong(1);
			ps.executeUpdate();

		} catch (Exception e) {

			myLogger.info("Salvataggio messaggio fallito");// definire un eccezione apposita con logger serio

		} finally {
			con.close();
			ps.close();
		}
		return autoId;
	}

	public List<Message> getMessagesFromDb(String idBibl, String idStud) throws SQLException {
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<>();
		try {
			con = Db.getConnection();
			ps = con.prepareStatement("SELECT * FROM Messaggio WHERE mailBiblioteca = ? AND mailStudente = ?");
			fillSelectStatement(ps, idBibl, idStud);
			rs = ps.executeQuery();
			while (rs.next()) {
				messageList.add(new Message(rs.getLong(1), rs.getString(TITOLOM), rs.getString(TESTOM),
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
	
	public int delete(String bibId, String studId) {
		int status = 0;
		try {
			Connection con = Db.getConnection();

			PreparedStatement ps = null;

			ps = con.prepareStatement("DELETE FROM Messaggio WHERE mailBiblioteca=? AND mailStudente=?");
			fillDeleteStatement(ps, bibId, studId);
			
			status = ps.executeUpdate();
			con.close();
		}

		catch (SQLException e) {
			myLogger.info("Eliminazione fallita");// definire un eccezione apposita con logger serio
		}
		return status;
	}


}
