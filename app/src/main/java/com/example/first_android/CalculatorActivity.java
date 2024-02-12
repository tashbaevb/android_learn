package com.example.first_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView resultTextView;

    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.calculator);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        input.append(button.getText().toString());
        updateResult();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        input.append(button.getText().toString());
        updateResult();
    }

    public void updateResult() {
        resultTextView.setText(input.toString());
    }

    public void onClearClick(View view) {
        input.setLength(0);
        updateResult();
    }

    public void onEqualsClick(View view) {

    }
}
