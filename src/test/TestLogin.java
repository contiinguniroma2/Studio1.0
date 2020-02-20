package test;
//Adriano
import static org.junit.jupiter.api.Assertions.*;
import logic.control.LoginController;
import org.junit.jupiter.api.Test;

class TestLogin {

	@Test
	void testStu() throws Exception {
		assertEquals('s', LoginController.getLoginController().validateUser("stu@live.it", "1234"));
	}

	@Test
	void testLib() throws Exception {
		assertEquals('l', LoginController.getLoginController().validateUser("bib@live.it", "1234"));
	}

	// mail sbagliata password sbagliata
	@Test
	void testErr1() throws Exception {
		assertEquals('0', LoginController.getLoginController().validateUser("adsf", "dads"));
	}

	// mail giusta password sbagliata
	@Test
	void testErr2() throws Exception {
		assertEquals('0', LoginController.getLoginController().validateUser("bib@live.it", "dads"));
	}

	// password giusta mail sbagliata
	@Test
	void testErr4() throws Exception {
		assertEquals('0', LoginController.getLoginController().validateUser("adf", "1234"));
	}

}
