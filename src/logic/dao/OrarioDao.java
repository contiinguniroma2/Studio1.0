package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import logic.entity.Orario;

public class OrarioDao extends GenericDao {

	static Logger myLogger = Logger.getLogger("logger");

	// INSERT ORARIO
	public int insert(String giorno, String idBiblioteca, String orario) {
		int status = 0;
		try {
			Connection con = Db.getConnection();

			PreparedStatement ps = con
					.prepareStatement("INSERT INTO Orario(mailBiblioteca,giorno,orario) VALUES(?,?,?)");
			ps.setString(1, idBiblioteca);
			ps.setString(2, giorno);
			ps.setString(3, orario);
			status = ps.executeUpdate();
			con.close();
		}

		catch (Exception e) {

			myLogger.info("Salvataggio orario fallito");// definire un eccezione apposita con logger serio

		}
		return status;
	}

	// UPDATE ORARIO
	public int updateOrario(String newValue, String mail, String giorno) {
		int status = 0;
		try {
			Connection con = Db.getConnection();

			PreparedStatement ps = con
					.prepareStatement("UPDATE Orario SET orario = ? WHERE giorno = ? AND mailBiblioteca = ? ");
			ps.setString(1, newValue);
			ps.setString(2, giorno);
			ps.setString(3, mail);
			status = ps.executeUpdate();
			con.close();

		}

		catch (Exception e) {
			myLogger.info("Aggiornamento Orario fallito");// definire un eccezione apposita con logger serio
		}
		return status;
	}

	public List<Orario> select(String id1, String id2) {
		ResultSet rs = null;
		List<Orario> scheduleList = new ArrayList<>();
		try {
			Connection con = Db.getConnection();

			PreparedStatement ps = con.prepareStatement("SELECT * FROM Orario WHERE mailBiblioteca = ?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			while (rs.next()) {
				scheduleList.add(new Orario(rs.getString("giorno"), rs.getString("orario"), rs.getString(MAILB)));
			}
			con.close();
			return scheduleList;

		}

		catch (Exception e) {
			myLogger.info("Select orari fallito");// definire un eccezione apposita con logger serio
		}
		return scheduleList;
	}

}
