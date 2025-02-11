
import java.util.ArrayList;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Objects;

import java.util.*;
import java.io.*;
import java.math.*;
import java.awt.*;
import java.lang.*;



public class PasswordCheckerUtility {
	
	/**
     * Compares the equality of two passwords (case-sensitive).
     * 
     * @param password         The password string to be checked.
     * @param passwordConfirm  The password confirmation string to compare against.
     * @throws UnmatchedException Thrown if the passwords are not identical.
     */

    public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException,
            NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
        checkLength(password);
        checkUpper(password);
        checkLower(password);
        checkDigit(password);
        checkSpecial(password);
        checkSequence(password);
        return true;
    }

    public static boolean isWeakPassword(String password) throws WeakPasswordException {
        if (password.length() >= 6 && password.length() <= 9) {
            throw new WeakPasswordException();
        }
        return false;
    }

    public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
        ArrayList<String> invalidPasswords = new ArrayList<>();
        for (String password : passwords) {
            try {
                isValidPassword(password);
            } catch (Exception e) {
                invalidPasswords.add(password + " " + e.getMessage());
            }
        }
        return invalidPasswords;
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    private static void checkLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException();
        }
    }

    private static void checkUpper(String password) throws NoUpperAlphaException {
        if (!password.matches(".*[A-Z].*")) {
            throw new NoUpperAlphaException();
        }
    }
    
    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException();
        }
    }

    private static void checkLower(String password) throws NoLowerAlphaException {
        if (!password.matches(".*[a-z].*")) {
            throw new NoLowerAlphaException();
        }
    }

    private static void checkDigit(String password) throws NoDigitException {
        if (!password.matches(".*\\d.*")) {
            throw new NoDigitException();
        }
    }

    private static void checkSpecial(String password) throws NoSpecialCharacterException {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            throw new NoSpecialCharacterException();
        }
    }

    private static void checkSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) == password.charAt(i + 2)) {
                throw new InvalidSequenceException();
            }
        }
    }

    public static BooleanSupplier hasUpperAlpha(String string) {
        return () -> string != null && string.chars().anyMatch(Character::isUpperCase);
    }

    public static boolean isValidLength(String password) throws LengthException {
        if ((password.length() < 6)) throw new LengthException();
        return (password.length() >= 6);
}
}
