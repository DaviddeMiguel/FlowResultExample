package com.meslize.forwardresultexample.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.util.ExtrasUtils;

public class ProfileAddressStepActivity extends BaseActivity {

  private EditText addressView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_address_step);

    setToolbarAsActionBar();

    addressView = (EditText) findViewById(R.id.address);
    findViewById(R.id.complete_address).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickCompleteAddress();
      }
    });
  }

  private void onClickCompleteAddress() {
    if (TextUtils.isEmpty(addressView.getText().toString())) {
      Toast.makeText(this, R.string.type_something_first, Toast.LENGTH_SHORT).show();
    } else {
      Intent intent = new Intent();
      intent.putExtra(ExtrasUtils.EXTRA_ADDRESS, addressView.getText().toString());
      setResult(RESULT_OK, intent);
      finish();
    }
  }
}
