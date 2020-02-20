package test;
//Davide
import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;
import logic.dao.StudentDao;

public class TestStudDao {
	// legal insert test
	@Test
	void insertTest1() {
		StudentDao x = new StudentDao();
		try {
			assertEquals(1, x.insert("mailProva1@live.it", "password", "usernameProva1", "nomeProva1", "cognomeProva1",
					"telProva1"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	// illegal insert test in db mail attribute is primary key
	void insertTest2() {
		StudentDao x = new StudentDao();
		try {
			assertEquals(0, x.insert("mailProva1@live.it", "passwordProva1", "usernameProva1", "nomeProva1",
					"cognomeProva1", "telProva1"));
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Test
	// illegal insert test in db phone attribute is VARCHAR(10)
	void insertTest3() {
		StudentDao x = new StudentDao();
		try {
			assertEquals(0, x.insert("mailProva2@live.it", "passwordProva2", "usernameProva2", "nomeProva2",
					"cognomeProva2", "telefonoProva2"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// legal delete test
	@Test
	void deleteTest1() {
		StudentDao x = new StudentDao();
		assertEquals(1, x.delete("Studente", "mailProva1@live.it", null));
	}

	@Test
	// illegal delete test of a not existing student
	void deleteTest2() {
		StudentDao x = new StudentDao();
		assertEquals(0, x.delete("Studente", "mailProva3@live.it", null));
	}

}
