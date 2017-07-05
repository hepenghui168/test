package com.example.admin.dialog;

/**
 * Created by admin on 2017/7/5.
 */

public class InstanceClass {
    private static InstanceClass instance;
    private int state;

    public static InstanceClass getInstance() {
        if (instance == null)
            instance = new InstanceClass();
        return instance;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
