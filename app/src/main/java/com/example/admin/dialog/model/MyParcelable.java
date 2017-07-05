package com.example.admin.dialog.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by admin on 2017/7/3.
 */

public class MyParcelable implements Parcelable {

    private int data;

    protected MyParcelable(Parcel in) {
        data = in.readInt();

    }

    public static final Creator<MyParcelable> CREATOR = new Creator<MyParcelable>() {
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(data);
    }
}
