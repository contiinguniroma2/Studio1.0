package logic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.entity.Library;

public class LibraryDao extends GenericDao {
	private Connection con;
	private PreparedStatement ps;

	// INSERT BIBLIOTECA
	public int insert(String... arg) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();

			ps = con.prepareStatement(
					"INSERT INTO Biblioteca(mailBiblioteca,passwordBiblioteca,nomeBiblioteca,indirizzo,telefonoBiblioteca,usernameBiblioteca,posti,citta) VALUES(?,?,?,?,?,?,?,?)");
			ps.setString(1, arg[0]);
			ps.setString(2, arg[1]);
			ps.setString(3, arg[2]);
			ps.setString(4, arg[3]);
			ps.setString(5, arg[4]);
			ps.setString(6, arg[5]);
			ps.setInt(7, Integer.valueOf(arg[6]));
			ps.setString(8, arg[7]);
			status = ps.executeUpdate();

		}

		catch (SQLException | NumberFormatException e) {

			myLogger.info("Salvataggio biblioteca fallito");// definire un eccezione apposita con logger serio
			return status;
			} finally {
			con.close();
			ps.close();
		}
		return status;
	}

	// UPDATE POSTI
	public int updatePosti(int posti, String mail, String tipo) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();
			ps = null;
			if (tipo.equals(CAPACITY))
				ps = con.prepareStatement("UPDATE Biblioteca SET posti = ? WHERE mailBiblioteca = ?");
			if (tipo.equals(POSTIO))
				ps = con.prepareStatement("UPDATE Biblioteca SET postiOccupati = ? WHERE mailBiblioteca = ?");
			ps.setInt(1, posti);
			ps.setString(2, mail);
			status = ps.executeUpdate();
		}

		catch (SQLException | NullPointerException e) {
			myLogger.info("Aggiornamento fallito");// definire un eccezione apposita con logger serio
			return status;
		} finally {
			con.close();
		}
		return status;
	}

	// UPDATE GENERICO
	public int update(String attr, String newValue, String entityId) throws SQLException {
		int status = 0;
		try {
			con = Db.getConnection();
			// a sonarlint non piace come bug
			ps = null;

			if (attr.equals(MAILB)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET mailBiblioteca = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(PASSWORDB)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET passwordBiblioteca = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(USERNAME)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET usernameBiblioteca = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
				status = ps.executeUpdate();
			}

			if (attr.equals(NOMEB)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET nomeBiblioteca = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(INDIRIZZO)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET indirizzo = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(CITTA)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET citta = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			if (attr.equals(TELEFONOB)) {
				ps = con.prepareStatement("UPDATE Biblioteca SET telefonoBiblioteca = ? WHERE mailBiblioteca = ?");
				fillUpdateStatement(ps, newValue, entityId);
			}

			status = ps.executeUpdate();
			con.close();
			return status;
		}

		catch (SQLException e) {
			myLogger.info("Aggiornamento Biblioteca fallito");// definire un eccezione apposita con logger serio
			return status;
		}
		
	}

	public List<Library> select(String id1, String id2) throws SQLException {
		ResultSet rs = null;
		List<Library> libraryList = new ArrayList<>();

		try {

			con = Db.getConnection();

			ps = null;
			if (id2 != null)
				ps = con.prepareStatement(
						"SELECT * FROM Biblioteca WHERE mailBiblioteca = ? AND passwordBiblioteca = ?");
			if (id2 == null)
				ps = con.prepareStatement("SELECT * FROM Biblioteca WHERE citta=?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			while (rs.next()) {
				libraryList.add(new Library(rs.getString(USERNAMEB), rs.getString(NOMEB), rs.getString(MAILB),
						rs.getString(PASSWORDB), rs.getString(INDIRIZZO), String.valueOf(rs.getInt(CAPACITY)),
						rs.getString(TELEFONOB), rs.getString(CITTA), String.valueOf(rs.getString(POSTIO))));
			}

			con.close();
			return libraryList;

		}

		catch (SQLException e) {
			myLogger.info("Select biblioteca fallito");// definire un eccezione apposita con logger serio
		}
		return libraryList;
	}
	
	public Library selectL(String id1, String id2) throws SQLException {
		ResultSet rs = null;
		Library library = null;
		try {
			con = Db.getConnection();
			ps = null;
			ps = con.prepareStatement("SELECT * FROM Biblioteca WHERE mailBiblioteca = ? AND passwordBiblioteca = ?");
			fillSelectStatement(ps, id1, id2);
			rs = ps.executeQuery();
			
			library = new Library(rs.getString(USERNAMEB), rs.getString(NOMEB), rs.getString(MAILB),
						rs.getString(PASSWORDB), rs.getString(INDIRIZZO), String.valueOf(rs.getInt(CAPACITY)),
						rs.getString(TELEFONOB), rs.getString(CITTA), String.valueOf(rs.getString(POSTIO)));
			
			con.close();
			return library;

		}

		catch (SQLException e) {
			myLogger.info("Select biblioteca fallito");// definire un eccezione apposita con logger serio
		}
		return library;
	}
	

}
