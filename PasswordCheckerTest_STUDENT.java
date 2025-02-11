

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;




/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Ugonna Umunna
 *
 */
public class PasswordCheckerTest_STUDENT {
	
ArrayList<String> passwords = new ArrayList<>(5);
	

	private PasswordCheckerUtility p1;

	@Before
	public void setUp() throws Exception {
		p1 = new PasswordCheckerUtility();
		passwords.add("hreGt345#");
	    passwords.add("Bob124$");
	    passwords.add("wake234");
		passwords.add("name1234#");
		passwords.add("Heydan321$");
		
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
            PasswordCheckerUtility.isValidPassword("abcd");
            fail("Expected LengthException");
        } catch (LengthException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
            PasswordCheckerUtility.isValidPassword("abcde1#");
            fail("Expected NoUpperAlphaException");
        } catch (NoUpperAlphaException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		 try {
	            PasswordCheckerUtility.isValidPassword("ABCDE1#");
	            fail("Expected NoLowerAlphaException");
	        } catch (NoLowerAlphaException e) {
	            assertTrue(true);
	        } catch (Exception e) {
	            fail("Unexpected exception: " + e);
	        }
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
            PasswordCheckerUtility.isWeakPassword("Abc12#");
            fail("Expected WeakPasswordException");
        } catch (WeakPasswordException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
            PasswordCheckerUtility.isValidPassword("AAAbb@123");
            fail("Expected InvalidSequenceException");
        } catch (InvalidSequenceException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		 try {
	            PasswordCheckerUtility.isValidPassword("Abcdef#");
	            fail("Expected NoDigitException");
	        } catch (NoDigitException e) {
	            assertTrue(true);
	        } catch (Exception e) {
	            fail("Unexpected exception: " + e);
	        }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
            assertTrue(PasswordCheckerUtility.isValidPassword("StrongP@ss1"));
        } catch (Exception e) {
            fail("Unexpected exception: " + e);
        }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> passwords = new ArrayList<>();
        passwords.add("short");
        passwords.add("noupper1#");
        passwords.add("NOLOWER1#");
        passwords.add("NoDigit#");
        passwords.add("NoSpecial1");
        passwords.add("AAAbb@123");

        ArrayList<String> invalid = PasswordCheckerUtility.getInvalidPasswords(passwords);
        assertEquals(6, invalid.size());
	}
	
}
