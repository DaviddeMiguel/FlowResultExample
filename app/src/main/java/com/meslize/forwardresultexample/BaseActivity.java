package com.meslize.forwardresultexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public abstract class BaseActivity extends AppCompatActivity {

    protected static final String EXTRA_PARTIAL_RESULT = "EXTRA_PARTIAL_RESULT";
    protected static final String EXTRA_FINAL_RESULT = "EXTRA_FINAL_RESULT";

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //If RESULT_OK and the current activity does not handle the result, it means the flow is finished
        if (resultCode == RESULT_OK) {
            setResult(resultCode, data);
            finish();
        }
    }

    protected void setToolbarAsActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
