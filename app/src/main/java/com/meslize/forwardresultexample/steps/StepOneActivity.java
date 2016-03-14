package com.meslize.forwardresultexample.steps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.Result;

public class StepOneActivity extends BaseActivity {

    public static final int REQUEST_CODE_COMPLETE_FLOW = 1000;

    private TextView partialResultView;
    private TextView finalResultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_one);

        setToolbarAsActionBar();

        partialResultView = (TextView) findViewById(R.id.partial_result);
        finalResultView = (TextView) findViewById(R.id.final_result);
        findViewById(R.id.go_to_step_two).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToStepTwo();
            }
        });
    }

    private void goToStepTwo() {
        Intent intent = new Intent(this, StepTwoActivity.class);
        startActivityForResult(intent, REQUEST_CODE_COMPLETE_FLOW);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_COMPLETE_FLOW && resultCode == RESULT_OK) {
            Result result = getResult(data);
            partialResultView.setText(result.partialResult);
            finalResultView.setText(result.finalResult);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private Result getResult(Intent data) {
        return data == null ? null : (Result) data.getParcelableExtra(EXTRA_FINAL_RESULT);
    }
}
