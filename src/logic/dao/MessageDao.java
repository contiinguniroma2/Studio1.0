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

public class MessageDao extends GenericDao {

	static Logger myLogger = Logger.getLogger("logger");
	private Connection con;
	private PreparedStatement ps;

	public MessageDao() {
		con=Db.getInstance().getConnection();
	}

	// INSERT
	public long insert(Message message) {
		ResultSet rs = null;
		long autoId = 0;
		try {
			ps = con.prepareStatement(
					"INSERT INTO Messaggio(mailBiblioteca,mailStudente,testoMessaggio,titoloMessaggio) VALUES(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, message.getLibrarianId());
			ps.setString(2, message.getStudentId());
			ps.setString(3, message.getText());
			ps.setString(4, message.getTitle());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			rs.next();
			autoId = rs.getLong("numeroMessaggio");
			

		} catch (Exception e) {
			myLogger.info("Salvataggio messaggio fallito");// definire un eccezione apposita con logger serio

		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return autoId;
	}
	


	public List<Message> getMessagesFromDb(String idBibl, String idStud) throws SQLException {
		ResultSet rs = null;
		List<Message> messageList = new ArrayList<>();
		try {
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
			
			ps.close();
		}
		return messageList;
	}
	
	public int delete(String bibId, String studId) {
		int status = 0;
		try {

			ps = con.prepareStatement("DELETE FROM Messaggio WHERE mailBiblioteca=? AND mailStudente=?");
			fillDeleteStatement(ps, bibId, studId);
			
			status = ps.executeUpdate();
		}

		catch (SQLException e) {
			myLogger.info("Eliminazione fallita");// definire un eccezione apposita con logger serio
		}finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}


}
