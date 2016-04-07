package com.meslize.forwardresultexample.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.model.Profile;
import com.meslize.forwardresultexample.util.ExtrasUtils;

public class ProfileFinalStepActivity extends BaseActivity {
  private String name;
  private String address;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_final_step);

    setToolbarAsActionBar();

    name = ExtrasUtils.getName(getIntent());
    address = ExtrasUtils.getAddress(getIntent());

    TextView nameView = (TextView) findViewById(R.id.name);
    nameView.setText(name);

    TextView addressView = (TextView) findViewById(R.id.address);
    addressView.setText(address);

    findViewById(R.id.accept).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickAccept();
      }
    });
  }

  private void onClickAccept() {
    Intent intent = new Intent();
    intent.putExtra(ExtrasUtils.EXTRA_PROFILE,
        new Profile.Builder().withName(name).withAddress(address).build());
    setResult(RESULT_OK, intent);
    finish();
  }
}
