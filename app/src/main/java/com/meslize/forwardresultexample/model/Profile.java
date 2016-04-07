package com.meslize.forwardresultexample.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Profile implements Parcelable {
  public static final Creator<Profile> CREATOR = new Creator<Profile>() {
    public Profile createFromParcel(Parcel source) {
      return new Profile(source);
    }

    public Profile[] newArray(int size) {
      return new Profile[size];
    }
  };
  private final String name;
  private final String address;

  private Profile(Builder builder) {
    name = builder.name;
    address = builder.address;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }

  protected Profile(Parcel in) {
    this.name = in.readString();
    this.address = in.readString();
  }

  @Override public int describeContents() {
    return 0;
  }

  @Override public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(this.name);
    dest.writeString(this.address);
  }

  public static final class Builder {
    private String name;
    private String address;

    public Builder() {
    }

    public Builder withName(String val) {
      name = val;
      return this;
    }

    public Builder withAddress(String val) {
      address = val;
      return this;
    }

    public Profile build() {
      return new Profile(this);
    }
  }
}
