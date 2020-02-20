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

public class FeedbackDao extends GenericDao {

	static Logger myLogger = Logger.getLogger("logger");
	private Factory factory;
	private PreparedStatement ps;
	private Connection con;

	public FeedbackDao() {
		this.factory = new Factory();
	}

	// INSERT
	public int insert(String mailB, String mailS, String title, String text) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement("INSERT INTO Feedback(mailBiblioteca,mailStudente,testo,titolo) VALUES(?,?,?,?)");
			ps.setString(1, mailB);
			ps.setString(2, mailS);
			ps.setString(3, text);
			ps.setString(4, title);
			status = ps.executeUpdate();

		} catch (Exception e) {

			myLogger.info("Salvataggio feedback fallito");// definire un eccezione apposita con logger serio

		} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	public List<FeedbackInterface> select(String id1, String id2) throws SQLException {
		ResultSet rs = null;
		List<FeedbackInterface> feedbackList = new ArrayList<>();
		try {
			con = Db.getConnection();
			// a sonarlint non piace come bug
			ps = con.prepareStatement("SELECT * FROM Feedback WHERE mailBiblioteca = ? AND mailStudente = ?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			while (rs.next()) {
				feedbackList.add(factory.createProduct(1, rs.getString(TITOLO), rs.getString(TESTO),
						rs.getString(MAILB), rs.getString(MAIL)));
			}

			return feedbackList;

		}

		catch (Exception e) {
			myLogger.info("Select feedback fallito");// definire un eccezione apposita con logger serio
		} finally {
			con.close();
			ps.close();
		}
		return feedbackList;
	}

}
