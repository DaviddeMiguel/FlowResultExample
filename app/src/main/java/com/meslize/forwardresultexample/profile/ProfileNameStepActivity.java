package com.meslize.forwardresultexample.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.util.ExtrasUtils;

public class ProfileNameStepActivity extends BaseActivity {

  private static final int ADDRESS_REQUEST_CODE_FLOW = 1000;

  private EditText nameView;

  private String address;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_profile_name_step);

    setToolbarAsActionBar();

    nameView = (EditText) findViewById(R.id.name);

    findViewById(R.id.add_address).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickAddAddress();
      }
    });

    findViewById(R.id.complete_profile).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        goToStepThree();
      }
    });
  }

  private void onClickAddAddress() {
    Intent intent = new Intent(this, ProfileAddressStepActivity.class);
    startActivityForResult(intent, ADDRESS_REQUEST_CODE_FLOW);
  }

  private void goToStepThree() {
    if (TextUtils.isEmpty(nameView.getText().toString())) {
      Toast.makeText(this, R.string.complete_name_first, Toast.LENGTH_SHORT).show();
    } else if (TextUtils.isEmpty(address)) {
      Toast.makeText(this, R.string.complete_address_first, Toast.LENGTH_SHORT).show();
    } else {
      Intent intent = new Intent(this, ProfileFinalStepActivity.class);
      intent.putExtra(ExtrasUtils.EXTRA_NAME, nameView.getText().toString());
      intent.putExtra(ExtrasUtils.EXTRA_ADDRESS, address);
      //We can pass any number less the ones that we listen here, in this case ADDRESS_REQUEST_CODE_FLOW
      startActivityForResult(intent, 0);
    }
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // We wait here for ADDRESS_REQUEST_CODE_FLOW to save the result
    // If in this activity we don't care about the result obtained, just pass it to super
    // that will close this activity and send the result to the previous one
    if (requestCode == ADDRESS_REQUEST_CODE_FLOW && resultCode == RESULT_OK) {
      address = ExtrasUtils.getAddress(data);
      onAddressCompleted(address);
    } else {
      super.onActivityResult(requestCode, resultCode, data);
    }
  }

  private void onAddressCompleted(String address) {
    TextView addressView = (TextView) findViewById(R.id.address);
    addressView.setText(address);
  }
}
