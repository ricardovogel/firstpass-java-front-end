package com.yeet42.firstpass.guiinteraction;

public final class Login {

    private Login() {
    }

    public static boolean validatePassword(final String password) {
        Session.userKey = password;
        return true;
    }


    public static void register(final String password) {
    }

    public static boolean usernameTaken(final String username) {
        return false;
    }

    public static void logoutSession() {

    }
}

