package com.yeet42.firstpass.data;

import java.util.Objects;

public class DataEntry {
    public String use;
    public String username;
    public String password;

    public DataEntry(String use, String username, String password) {
        this.use = use;
        this.username = username;
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
