package com.meslize.forwardresultexample.steps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;

public class StepTwoActivity extends BaseActivity {

    public static final int REQUEST_CODE_PARTIAL_FLOW = 2000;

    private String partialResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);

        setToolbarAsActionBar();

        findViewById(R.id.go_to_step_two_dot_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStepTwoDotOne();
            }
        });
        findViewById(R.id.go_to_step_three).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStepThree();
            }
        });
    }

    private void goToStepTwoDotOne() {
        Intent intent = new Intent(this, StepTwoDotOneActivity.class);
        startActivityForResult(intent, REQUEST_CODE_PARTIAL_FLOW);
    }

    private void goToStepThree() {
        if (TextUtils.isEmpty(partialResult)) {
            Toast.makeText(this, R.string.get_partial_result_first, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(this, StepThreeActivity.class);
            intent.putExtra(EXTRA_PARTIAL_RESULT, partialResult);
            //We can pass any number less the sub-flow request code, we will no listen for it so it doesn't matter
            startActivityForResult(intent, 0);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //We wait here for the sub-flow request code to save the result, if not just let the parent deal with it
        if (requestCode == REQUEST_CODE_PARTIAL_FLOW && resultCode == RESULT_OK) {
            partialResult = getPartialResult(data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private String getPartialResult(Intent data) {
        return data == null ? "" : data.getStringExtra(EXTRA_PARTIAL_RESULT);
    }
}
