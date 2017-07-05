package com.example.admin.dialog;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by admin on 2017/6/29.
 */

public class BroadcastActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_broadcast);
        initView();
    }

    private void initView() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setAction(MainActivity.ACTION_NORMAL_BROADCAST);
        intent.setAction(MainActivity.ACTION_ORDER_BROADCAST);
        sendBroadcast(intent);
        sendOrderedBroadcast(intent, "order broadcast");
        sendStickyBroadcast(intent);
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

}
