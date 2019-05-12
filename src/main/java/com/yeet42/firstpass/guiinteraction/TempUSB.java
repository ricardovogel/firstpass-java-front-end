package com.yeet42.firstpass.guiinteraction;

import com.yeet42.firstpass.data.DataEntry;

import java.util.List;

public class TempUSB implements USBInterface {
    @Override
    public boolean addItem(DataEntry dataEntry, String masterPassword) {
        return false;
    }

    @Override
    public boolean changeEntry(String use, DataEntry newEntry, String masterPassword) {
        return false;
    }

    @Override
    public boolean deleteEntry(String use, String masterPassword) {
        return false;
    }

    @Override
    public boolean changeMasterPassword(String oldMasterPassword, String newMasterPassword) {
        return false;
    }

    @Override
    public DataEntry requestItem(String platform, String masterPassword) {
        return new DataEntry(platform, "bbb", "ccc");
    }

    @Override
    public List<String> requestPlatforms(String masterPassword) {
        return null;
    }
}