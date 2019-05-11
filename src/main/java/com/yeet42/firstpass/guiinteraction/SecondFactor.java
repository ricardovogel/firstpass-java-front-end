package com.yeet42.firstpass.guiinteraction;

public class SecondFactor {

    public static boolean authenticate(){
        return Math.random() > .9;
    }

    public static boolean create() {
        return Math.random() > .9;
    }
}
