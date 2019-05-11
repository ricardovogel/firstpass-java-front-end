package com.yeet42.firstpass.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.HashMap;
import java.util.Map;

@Deprecated
public class Passwords {
//    static private ObservableMap<String, String> encryptedPasswords;
    static private ObservableMap<String, String> passwords;

    public Passwords() {
//        encryptedPasswords = FXCollections.observableHashMap();
        passwords = FXCollections.observableHashMap();
    }

    public Passwords(Map<String, String> encryptedPasswords, String key) {
//        Passwords.encryptedPasswords = FXCollections.observableHashMap();
//        for (Map.Entry<String, String> e : encryptedPasswords.entrySet()) {
//            Passwords.encryptedPasswords.put(e.getKey(), e.getValue());
//        }
        Map<String, String> temp = Passwords.decrypt(encryptedPasswords, key);
        for (Map.Entry<String, String> e : temp.entrySet()) {
            passwords.put(e.getKey(), e.getValue());
        }
    }

    private static Map<String, String> encrypt(Map<String, String> toEncrypt, String key) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : toEncrypt.entrySet()) {
            result.put(entry.getKey(), Passwords.encrypt(entry.getValue(), key));
        }
        return result;
    }

    private static String encrypt(String toEncrypt, String key) {
        return "";
    }

    private static Map<String, String> decrypt(Map<String, String> toDecrypt, String key) {
        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, String> entry : toDecrypt.entrySet()) {
            result.put(entry.getKey(), Passwords.decrypt(entry.getValue(), key));
        }
        return result;
    }

    private static String decrypt(String toDecrypt, String key) {
        return "";
    }

    public Map<String, String> getPasswords() {
        return passwords;
    }
}
