package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.entity.Student;

public class StudentDao extends GenericDao {
	private Connection con;
	private PreparedStatement ps;

	// INSERT STUDENT
	public int insert(String mail, String password, String username, String nome, String cognome, String telefono)
			throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement(
					"INSERT INTO Studente(mailStudente,password,username,nome,cognome,telefono) VALUES(?,?,?,?,?,?)");
			ps.setString(1, mail);
			ps.setString(2, password);
			ps.setString(3, username);
			ps.setString(4, nome);
			ps.setString(5, cognome);
			ps.setString(6, telefono);
			status = ps.executeUpdate();

		}

		catch (Exception e) {

			myLogger.info("Salvataggio studente fallito");// definire un eccezione apposita con logger serio
			return status;
		} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	// UPDATE BAN
	public int updateBan(boolean isBan, String mail) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement("UPDATE Studente SET isBan = ?, WHERE mail = ? ");
			ps.setBoolean(1, isBan);
			ps.setString(2, mail);
			status = ps.executeUpdate();

		}

		catch (Exception e) {
			myLogger.info("Aggiornamento isBan fallito");// definire un eccezione apposita con logger serio
			return status;
		} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	// UPDATE REPORTCOUNTER
	public int updateReportCounter(byte newReportCounter, String mail) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement("UPDATE Studente SET reportCounter = ?, WHERE mail = ? ");
			ps.setByte(1, newReportCounter);
			ps.setString(2, mail);
			status=ps.executeUpdate();

		}

		catch (Exception e) {
			myLogger.info("Aggiornamento reportCounter fallito");// definire un eccezione apposita con logger serio
			return status;
		} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	// UPDATE GENERICO
	public int update(String attr, String newValue, String entityId) {

		int status = 0;
		try {
			con = Db.getConnection();

			ps = null;

			if (attr.equals(MAIL)) {
				ps = con.prepareStatement("UPDATE Studente SET mailStudente = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(PASSWORD)) {
				ps = con.prepareStatement("UPDATE Studente SET password = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(NOMES)) {
				ps = con.prepareStatement("UPDATE Studente SET nome = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(COGNOMES)) {
				ps = con.prepareStatement("UPDATE Studente SET cognome = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(USERNAME)) {
				ps = con.prepareStatement("UPDATE Studente SET username = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(TELEFONOS)) {
				ps = con.prepareStatement("UPDATE Studente SET telefono = ? WHERE mailStudente = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			status = ps.executeUpdate();
			con.close();
		}

		catch (Exception e) {
			myLogger.info("Aggiornamento Studente fallito");// definire un eccezione apposita con logger serio
			return status;
		}
		return status;
	}

	public List<Student> select(String id1, String id2) throws SQLException {
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			con = Db.getConnection();

			ps = null;
			ps = con.prepareStatement("SELECT * FROM Studente WHERE mailStudente = ? AND password = ?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			while (rs.next()) {
				studentList.add(new Student(rs.getString(NOMES), rs.getString(COGNOMES), rs.getString(USERNAME),
						rs.getString(MAIL), rs.getString(PASSWORD), rs.getBoolean("isBan"),
						rs.getByte("reportCounter")));
			}

			return studentList;

		}

		catch (SQLException e) {
			myLogger.info("Select studente fallito");// definire un eccezione apposita con logger serio
		} finally {
			con.close();
			ps.close();
		}
		return studentList;
	}

}
