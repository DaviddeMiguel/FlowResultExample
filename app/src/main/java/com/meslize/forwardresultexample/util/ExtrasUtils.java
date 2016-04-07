package com.meslize.forwardresultexample.util;

import android.content.Intent;
import com.meslize.forwardresultexample.model.Profile;

public class ExtrasUtils {
  public static final String EXTRA_PROFILE = "extra_profile";
  public static final String EXTRA_ADDRESS = "extra_address";
  public static final String EXTRA_NAME = "extra_name";

  public static Profile getProfile(Intent data) {
    return data == null ? null : (Profile) data.getParcelableExtra(EXTRA_PROFILE);
  }

  public static String getAddress(Intent data) {
    return data == null ? null : data.getStringExtra(EXTRA_ADDRESS);
  }

  public static String getName(Intent data) {
    return data == null ? null : data.getStringExtra(EXTRA_NAME);
  }
}
