package com.alanchern.floordirectory;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by alanchern on 1/12/17.
 */

public class Unit implements Parcelable {
    private int mFloor;
    private String mUnitNumber;
    private String mUnitName;

    public Unit() {}

    public Unit(int floor, String unitNumber, String unitName) {
        mFloor = floor;
        mUnitNumber = unitNumber;
        mUnitName = unitName;
    }

    private Unit(Parcel in) {
        mFloor = in.readInt();
        mUnitNumber = in.readString();
        mUnitName = in.readString();
    }

    public static final Creator<Unit> CREATOR = new Creator<Unit>() {
        @Override
        public Unit createFromParcel(Parcel in) {
            return new Unit(in);
        }

        @Override
        public Unit[] newArray(int size) {
            return new Unit[size];
        }
    };

    public int getFloor() {
        return mFloor;
    }

    public void setFloor(int floor) {
        mFloor = floor;
    }

    public String getUnitNumber() {
        return mUnitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        mUnitNumber = unitNumber;
    }

    public String getUnitName() {
        return mUnitName;
    }

    public void setUnitName(String unitName) {
        mUnitName = unitName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mFloor);
        parcel.writeString(mUnitNumber);
        parcel.writeString(mUnitName);
    }
}
