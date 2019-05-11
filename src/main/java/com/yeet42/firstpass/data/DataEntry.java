package com.yeet42.firstpass.data;

import java.util.Objects;

public class DataEntry {
    private String use;
    private String username;
    private String password;

    public DataEntry(String use, String username, String password) {
        this.use = use;
        this.username = username;
        this.password = password;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataEntry dataEntry = (DataEntry) o;
        return Objects.equals(use, dataEntry.use) &&
                Objects.equals(username, dataEntry.username) &&
                Objects.equals(password, dataEntry.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(use, username, password);
    }
}
