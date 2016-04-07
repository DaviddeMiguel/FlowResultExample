package com.meslize.forwardresultexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import com.meslize.forwardresultexample.buy.BuyActivity;
import com.meslize.forwardresultexample.other.OtherEntryActivity;

public class MainActivity extends BaseActivity {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_main);
    setToolbarAsActionBar();

    findViewById(R.id.buy).setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onClickBuy();
      }
    });

    findViewById(R.id.other_possible_entry_to_profile).setOnClickListener(
        new View.OnClickListener() {
          @Override public void onClick(View v) {
            onClickOtherPossibleEntry();
          }
        });
  }

  private void onClickBuy() {
    Intent intent = new Intent(this, BuyActivity.class);
    startActivity(intent);
  }

  private void onClickOtherPossibleEntry() {
    Intent intent = new Intent(this, OtherEntryActivity.class);
    startActivity(intent);
  }
}
