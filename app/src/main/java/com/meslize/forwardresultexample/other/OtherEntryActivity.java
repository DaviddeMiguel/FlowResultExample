package com.meslize.forwardresultexample.other;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.model.Profile;
import com.meslize.forwardresultexample.profile.ProfileNameStepActivity;
import com.meslize.forwardresultexample.util.ExtrasUtils;

public class OtherEntryActivity extends BaseActivity {

  private static final int PROFILE_REQUEST_CODE_FLOW = 1000;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_other_entry);

    setToolbarAsActionBar();

    findViewById(R.id.complete_profile_first).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickOtherPossibleEntryToProfile();
      }
    });

    findViewById(R.id.complete_other_possible_entry).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickCompleteOtherPossibleEntry();
      }
    });
  }

  private void onClickOtherPossibleEntryToProfile() {
    Intent intent = new Intent(this, ProfileNameStepActivity.class);
    startActivityForResult(intent, PROFILE_REQUEST_CODE_FLOW);
  }

  private void onClickCompleteOtherPossibleEntry() {
    finish();
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == PROFILE_REQUEST_CODE_FLOW && resultCode == RESULT_OK) {

      Profile profile = ExtrasUtils.getProfile(data);
      onProfileCompleted(profile);
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void onProfileCompleted(Profile profile) {
    findViewById(R.id.complete_profile_first).setVisibility(View.GONE);
    findViewById(R.id.profile_container).setVisibility(View.VISIBLE);

    TextView nameView = (TextView) findViewById(R.id.name);
    nameView.setText(profile.getName());

    TextView addressView = (TextView) findViewById(R.id.address);
    addressView.setText(profile.getAddress());
  }
}
