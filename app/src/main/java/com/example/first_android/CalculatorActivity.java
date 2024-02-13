package com.example.first_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CalculatorActivity extends AppCompatActivity {

    private TextView resultTextView;

    private String operand1 = "";
    private String operand2 = "";
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (operator.isEmpty()) {
            operand1 += buttonText;
        } else {
            operand2 += buttonText;
        }
        updateResultTextView();
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        operator = button.getText().toString();
        updateResultTextView();
    }

    public void onEqualsClick(View view) {
        if (!operand1.isEmpty() && !operand2.isEmpty() && !operator.isEmpty()) {
            double result = calculateResult();
            resultTextView.setText(String.valueOf(result));
            operand1 = String.valueOf(result);
            operand2 = "";
            operator = "";
        }
    }

    public void onClearClick(View view) {
        operand1 = "";
        operand2 = "";
        operator = "";
        resultTextView.setText("");
    }

    private void updateResultTextView() {
        resultTextView.setText(operand1 + operator + operand2);
    }

    private double calculateResult() {
        double num1 = Double.parseDouble(operand1);
        double num2 = Double.parseDouble(operand2);
        double result = 0;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return result;
    }
}
