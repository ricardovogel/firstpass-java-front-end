package com.yeet42.firstpass.data;

import java.util.Objects;

public class DataEntry {
    private String platform;
    private String username;
    private String password;

    public DataEntry(String platform, String username, String password) {
        this.platform = platform;
        this.username = username;
        this.password = password;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
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
        return Objects.equals(platform, dataEntry.platform) &&
                Objects.equals(username, dataEntry.username) &&
                Objects.equals(password, dataEntry.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platform, username, password);
    }
}
