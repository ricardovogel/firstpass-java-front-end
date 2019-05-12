package com.yeet42.firstpass.guiinteraction;

import com.yeet42.firstpass.data.DataEntry;

import java.util.List;

public interface USBInterface {

    /**
     * Adds an item to the pi
     */
     boolean addItem(DataEntry dataEntry, String masterPassword);
     boolean changeEntry(String platform, DataEntry newEntry, String masterPassword);
     boolean deleteEntry(String platform, String masterPassword);
     boolean changeMasterPassword(String oldMasterPassword, String newMasterPassword);
     DataEntry requestItem(String platform, String masterPassword);
     List<String> requestPlatforms(String masterPassword);
}
