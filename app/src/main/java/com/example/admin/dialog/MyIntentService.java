package com.example.admin.dialog;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

/**
 * Created by admin on 2017/6/29.
 */

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void startMyIntentService(Context context) {
        Intent intent = new Intent(context, MyIntentService.class);
        context.startService(intent);
    }
}
