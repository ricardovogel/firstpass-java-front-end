package com.yeet42.firstpass.guiinteraction;

public final class PasswordChecking {
    /**
     * Minimum amount of characters needed.
     */
    private static final int MINPASSWORDCHARACTERS = 6;
    /**
     * Maximum amount of characters allowed.
     */
    private static final int MAXPASSWORDCHARACTERS = 72;

    private PasswordChecking() {
    }

    /**
     * Checks if the second password in the registration form is the same.
     *
     * @param thisPassword  the first password
     * @param otherPassword the second password
     * @return true iff thisPassword is equal to otherPassword (false if either password is null)
     */
    public static boolean checkSecondPassword(final String thisPassword,
                                              final String otherPassword) {
        if (thisPassword == null || otherPassword == null) {
            return false;
        }
        return thisPassword.equals(otherPassword);
    }

    /**
     * Checks if a password matches certain conditions.
     *
     * <p>0 - length rule
     * 1 - capital rule
     * 2 - lowercase rule
     * 3 - number rule
     * 4 - special character rule
     *
     * @param pass the password to check
     * @return boolean array with the following information specified above
     */
    @Deprecated
    public static boolean[] checkPassword(final String pass) {
        return new boolean[]{
                lengthRule(pass),
                capitalRule(pass),
                lowercaseRule(pass),
                numberRule(pass),
                specialCharacterRule(pass)
        };
    }

    /**
     * Checks if the amount of characters in a passwords falls within
     * the range [6, 72].
     *
     * @param pass the password to check
     * @return true iff the amount of characters in pass falls within the range
     *     (false if password is null)
     */
    public static boolean lengthRule(final String pass) {
        if (pass == null) {
            return false;
        }
        return (pass.length() >= MINPASSWORDCHARACTERS)
                && (pass.length() <= MAXPASSWORDCHARACTERS);
    }

    /**
     * Checks if there is at least one capital letter in a password.
     *
     * @param pass the password to check
     * @return true iff there exist a capital letter in pass
     */
    public static boolean capitalRule(final String pass) {
        if (pass == null) {
            return false;
        }
        return !pass.equals(pass.toLowerCase());
    }

    /**
     * Checks if there is at least one lowercase letter in a password.
     *
     * @param pass the password to check
     * @return true iff there exist a lowercase letter in pass (false if password is null)
     */
    public static boolean lowercaseRule(final String pass) {
        if (pass == null) {
            return false;
        }
        return !pass.equals(pass.toUpperCase());
    }

    /**
     * Checks if there exists a number in a password.
     *
     * @param pass the password to check
     * @return true iff there exists a number in pass (false if password is null)
     */
    public static boolean numberRule(final String pass) {
        if (pass == null) {
            return false;
        }
        char[] numbers = "0123456789".toCharArray();
        for (char c : numbers) {
            if (pass.contains(c + "")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if there exists a special character in a password.
     * The special characters are: !@#$%^&*()-_=+<>,/?;:[{]}\|`~.
     *
     * @param pass the password to check
     * @return true iff there exists a special character in pass (false if password is null)
     */
    public static boolean specialCharacterRule(final String pass) {
        if (pass == null) {
            return false;
        }
        char[] specialCharacters = "!@#$%^&*()-_=+<>,./?;:[{]}|`~\\".toCharArray();
        for (char c : specialCharacters) {
            if (pass.contains(c + "")) {
                return true;
            }
        }
        return false;
    }
}
