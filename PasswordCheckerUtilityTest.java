/*
 * import java.util.ArrayList;

package package1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PasswordCheckerUtilityTest {
	ArrayList<String> passwords = new ArrayList<>(5);
	

	private PasswordCheckerUtility p1;
	


	@BeforeEach
	void setUp() throws Exception {
		p1 = new PasswordCheckerUtility();
		passwords.add("hreGt345#");
	    passwords.add("Bob124$");
	    passwords.add("wake234");
		passwords.add("name1234#");
		passwords.add("Heydan321$");

		
	}

	@AfterEach
	void tearDown() throws Exception {
		passwords = null;
		
	}

	@Test
	public void TestisValidPassword() {
		//AssertTrue(passwords.get(0).isValidPassword("hreGt345#"));
		//AssertTrue(passwords.get(1).isValidPassword("Bob124$"));
		assertTrue(p1.isValidPassword("Bob124$"));
		assertEquals(p1.getInvalidPasswords(passwords), );
	}

}
 * 
 * 
 */

