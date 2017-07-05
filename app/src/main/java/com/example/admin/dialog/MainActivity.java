package com.example.admin.dialog;

import android.app.Activity;
import android.app.IntentService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.Loader;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @BindView(R.id.btn_dialog)
    Button btnDialog;
    @BindView(R.id.btn_toast)
    Button btnToast;
    @BindView(R.id.btn_snackbar)
    Button btnSnackbar;
    @BindView(R.id.tv_price_format)
    TextView tvPriceFormat;


    public static final String ACTION_NORMAL_BROADCAST = "normal_broadcast";
    public static final String ACTION_ORDER_BROADCAST = "order_broadcast";
    public static final String ACTION_SAFE_BROADCAST = "safe_broadcast";
    private MyBroadcastReceiver myBroadcastReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        initData();
        initFilter();
    }


    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void initView() {
        tvPriceFormat.setText(priceFormat());

    }

    private void initData() {
        String x = new String("abc");
        change(x);
        Log.i("hph", "x=" + x);
    }

    private void initFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(ACTION_NORMAL_BROADCAST);
        filter.addAction(ACTION_ORDER_BROADCAST);
        registerReceiver(myBroadcastReceiver, filter);

        IntentFilter safeFilter = new IntentFilter();
        safeFilter.addAction(ACTION_SAFE_BROADCAST);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcastManager.registerReceiver(myBroadcastReceiver, safeFilter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        instanceTest();
    }

    @OnClick({R.id.btn_dialog, R.id.btn_toast, R.id.btn_snackbar})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Title");
                builder.setMessage("Message");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).show();
                break;
            case R.id.btn_toast:
                Util.showToast(this, "things happened");
                break;
            case R.id.btn_snackbar:
                Snackbar.make(btnSnackbar, "data delete", Snackbar.LENGTH_LONG)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                            }
                        }).show();
                break;
        }
    }
    private String priceFormat() {
        String totalPrice = "234567.01";
        String[] priceTemp = totalPrice.split("\\.");
        if (priceTemp.length >0)
            totalPrice = priceTemp[0];
        StringBuilder sb = new StringBuilder(totalPrice);
        int length = totalPrice.length();
        for (int i=length - 3; i>0; i = i-3) {
            if (i > 0)
            sb.insert(i, ",");
        }
        if (priceTemp.length >=2) {
            sb.append(".");
            sb.append(priceTemp[1]);
        }
        return sb.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myBroadcastReceiver);
        localBroadcastManager.unregisterReceiver(myBroadcastReceiver);
    }

    private class MyBroadcastReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
                case ACTION_NORMAL_BROADCAST:
                    Toast.makeText(MainActivity.this, "normal_broadcast", Toast.LENGTH_SHORT).show();
                    break;
                case ACTION_ORDER_BROADCAST:
                    Toast.makeText(MainActivity.this, "order_broadcast", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    private void change(String x) {
        x = "even";
        SharedPreferences sp = getSharedPreferences("", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("", 0);
        editor.commit();
    }

    private void instanceTest() {
        InstanceClass.getInstance().setState(1);
        int state = InstanceClass.getInstance().getState();
    }
}
