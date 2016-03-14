package com.meslize.forwardresultexample.steps;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.meslize.forwardresultexample.BaseActivity;
import com.meslize.forwardresultexample.R;

public class StepTwoDotOneActivity extends BaseActivity {

    private EditText editTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two_dot_one);

        setToolbarAsActionBar();

        editTextView = (EditText) findViewById(R.id.text);
        findViewById(R.id.complete_partial_result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completePartialResult();
            }
        });
    }

    private void completePartialResult() {
        String result = editTextView.getText().toString();
        if (TextUtils.isEmpty(result)) {
            Toast.makeText(this, R.string.type_something_first, Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra(EXTRA_PARTIAL_RESULT, result);
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
