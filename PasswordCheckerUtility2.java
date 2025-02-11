/*
  *  package package1;
  *  import java.util.ArrayList;

public class PasswordCheckerUtility {
	
	
	public PasswordCheckerUtility()
	{
		
	}

    // Compare two passwords
    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        if(password.equals(passwordConfirm))
        	return password.equals(passwordConfirm);  // Case-sensitive comparison
        else
        	return false;
    	
    }

    // Validate password using helper methods
    public static boolean isValidPassword(String password) {
        try {
            checkLength(password);
            checkUpperAlpha(password);
            checkLowerAlpha(password);
            checkDigit(password);
            checkSpecialCharacter(password);
            checkSequence(password);
            return true; // Password is valid

        } catch (Exception e) {
            System.out.println("Invalid password - " + e.getMessage());
            return false; // Return false if an exception is caught
        }
    }

    // Check if password is weak
    public static boolean isWeakPassword(String password) {
        try {
            // First, check if the password is valid
            if (!isValidPassword(password)) {
                return false; // If password is invalid, it cannot be considered weak.
            }

            // If the password length is between 6 and 9 (inclusive), it's weak
            if (password.length() >= 6 && password.length() <= 9) {
                throw new WeakPasswordException("Password is valid but considered weak (length between 6-9 characters).");
            }

            return false; // Password is valid and NOT weak

        } catch (WeakPasswordException e) {
            System.out.println("Weak password - " + e.getMessage());
            return true; // Considered weak
        }
    }

    // Get invalid passwords from a list
    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();

        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " BLANK " + e.getMessage());
            }
        }

        return invalidPasswords;
    }

    // === PRIVATE VALIDATION METHODS === //

    // Rule 1: Check password length
    private static void checkLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException("Password must be at least 6 characters long.");
        }
    }

    // Rule 2: At least one uppercase letter
    private static void checkUpperAlpha(String password) throws NoUpperAlphaException {
        if (!password.matches(".*[A-Z].*")) {
            throw new NoUpperAlphaException("Password must contain at least one uppercase letter.");
        }
    }

    // Rule 3: At least one lowercase letter
    private static void checkLowerAlpha(String password) throws NoLowerAlphaException {
        if (!password.matches(".*[a-z].*")) {
            throw new NoLowerAlphaException("Password must contain at least one lowercase letter.");
        }
    }

    // Rule 4: At least one digit
    private static void checkDigit(String password) throws NoDigitException {
        if (!password.matches(".*\\d.*")) {
            throw new NoDigitException("Password must contain at least one digit.");
        }
    }

    // Rule 5: At least one special character
    private static void checkSpecialCharacter(String password) throws NoSpecialCharacterException {
        if (!password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            throw new NoSpecialCharacterException("Password must contain at least one special character.");
        }
    }

    // Rule 6: No more than 2 of the same character in a row
    private static void checkSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                throw new InvalidSequenceException("Password must not have more than two of the same character in a row.");
            }
        }
    }
}

  */
package package1;

 
