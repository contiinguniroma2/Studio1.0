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

	// SAVE STUDENT
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


	public int updateStudent(Student student) {
		int status = 0;
		try {
			con = Db.getConnection();
			ps = con.prepareStatement("UPDATE Studente SET mailStudente = ?, password = ?, username = ?, nome = ?, cognome = ?, telefono = ?, reportCounter = ?, isBan = ? WHERE mailStudente = ?");
			ps.setString(1, student.getMail());
			ps.setString(2, student.getPassword());
			ps.setString(3, student.getUsername());
			ps.setString(4, student.getName());
			ps.setString(5, student.getSurname());
			ps.setString(6,  student.getPhone());
			ps.setByte(7, student.getReportCounter());
			ps.setBoolean(8, student.isBanned());
			ps.setString(9, student.getCountdown());
			status=ps.executeUpdate();
		}
		catch (Exception e) {
			 myLogger.info("Aggiornamento fallito");
			 return status;
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return status;
	}


	public Student select(String id1, String id2) throws SQLException {
		ResultSet rs = null;
		Student student = null;
		try {
			con = Db.getConnection();
			ps = null;
			ps = con.prepareStatement("SELECT * FROM Studente WHERE mailStudente = ? AND password = ?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			student = new Student(rs.getString(NOMES), rs.getString(COGNOMES), rs.getString(USERNAME),
						rs.getString(MAIL), rs.getString(PASSWORD), rs.getBoolean("isBan"),
						rs.getByte("reportCounter"), rs.getString("timeStartCountdown"));
		}

		catch (SQLException e) {
			myLogger.info("Select studente fallito");// definire un eccezione apposita con logger serio
		} finally {
			con.close();
			ps.close();
		}
		return student;
	}

	public List<Student> getStudentFromDb(String idBiblio) throws SQLException {
		ResultSet rs = null;
		List<Student> studentList = new ArrayList<>();
		try {
			con = Db.getConnection();
			ps = null;
			ps = con.prepareStatement("SELECT * FROM Studente LEFT JOIN recent_student ON studente.mailStudente = recent_student.mailStudent WHERE recent_student.mailBiblioteca = ? ");
			fillSelectStatement(ps, idBiblio, null);
			rs = ps.executeQuery();
			while (rs.next()) {
				studentList.add(new Student(rs.getString(NOMES), rs.getString(COGNOMES), rs.getString(USERNAME),
						rs.getString(MAIL), "****", rs.getBoolean("isBan"),
						rs.getByte("reportCounter"), rs.getString("timeStartCountdown")));
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
