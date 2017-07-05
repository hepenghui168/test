package com.example.admin.dialog;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 2017/7/4.
 */

public class MySharedPreferrences {
    private static SharedPreferences sp;
    private static SharedPreferences.Editor editor;

    public static void getInstances(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("my_sp", Context.MODE_PRIVATE);
        }
    }

    public static void setLoveWho() {
        editor = sp.edit();
        editor.putString("love", "plus");
        editor.commit();
    }

    public static String getLoveWho() {
        return sp.getString("love", "");
    }
}
