package com.meslize.forwardresultexample;

import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new Parcelable.Creator<Result>() {
        public Result createFromParcel(Parcel source) {
            return new Result(source);
        }

        public Result[] newArray(int size) {
            return new Result[size];
        }
    };
    public final String partialResult;
    public final String finalResult;

    public Result(String partialResult, String finalResult) {
        this.partialResult = partialResult;
        this.finalResult = finalResult;
    }

    protected Result(Parcel in) {
        this.partialResult = in.readString();
        this.finalResult = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.partialResult);
        dest.writeString(this.finalResult);
    }
}
