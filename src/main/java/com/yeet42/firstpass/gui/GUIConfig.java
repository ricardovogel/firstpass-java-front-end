package com.yeet42.firstpass.gui;

import com.yeet42.firstpass.guiinteraction.TempUSB;
import com.yeet42.firstpass.guiinteraction.USBInterface;

class GUIConfig {
    static final Scenes FIRSTSCENE = Scenes.LOGIN;
    static final Scenes AFTER_LOGIN_SCENE = Scenes.MAIN_SCREEN;
    static final int DEFAULT_HEIGHT = 600;
    static final int DEFAULT_WIDTH = 900;
    static final boolean IS_RESIZABLE = false;
    static final String PROGRAM_NAME = "FirstPass";

    static final USBInterface USB_INTERFACE = new TempUSB();
}
