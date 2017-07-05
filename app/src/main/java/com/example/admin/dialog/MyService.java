package com.example.admin.dialog;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

/**
 * Created by admin on 2017/6/29.
 */

public class MyService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {
            Thread.sleep(20000);

        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        return super.onStartCommand(intent, flags, startId);

    }

    public static void startMyService(Context context) {
        Intent intent = new Intent(context, MyService.class);
        context.startService(intent);
    }
}
