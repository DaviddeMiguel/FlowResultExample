package com.meslize.forwardresultexample.steps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;
import com.meslize.forwardresultexample.Result;

public class StepThreeActivity extends BaseActivity {

    private EditText editTextView;

    private String partialResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_three);

        setToolbarAsActionBar();

        editTextView = (EditText) findViewById(R.id.text);
        findViewById(R.id.complete_final_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completeFinalResult();
            }
        });

        partialResult = getPartialResult();
    }

    private void completeFinalResult() {
        String finalResult = editTextView.getText().toString();
        if (TextUtils.isEmpty(finalResult)) {
            Toast.makeText(this, R.string.type_something_first, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_FINAL_RESULT, new Result(partialResult, finalResult));
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private String getPartialResult() {
        return getIntent().getStringExtra(EXTRA_PARTIAL_RESULT);
    }
}
