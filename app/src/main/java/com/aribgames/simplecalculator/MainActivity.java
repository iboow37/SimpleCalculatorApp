package com.aribgames.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText number1Text ;
    EditText number2Text ;
    TextView resultText ;
    String operation = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            number1Text =findViewById(R.id.number1Text);
            number2Text =findViewById(R.id.number2Text);
            resultText = findViewById(R.id.resultText);
            return insets;
        });
    }
    public void sum(View view){
        operation = "sum";
    }
    public void deduct(View view){
        operation = "deduct";
    }
    public void multiply(View view){
        operation = "multiply";
    }
    public void divide(View view){
        operation = "divide";

    }
    public void resultButton(View view){
        int number1 = Integer.parseInt(number1Text.getText().toString());
        int number2= Integer.parseInt(number2Text.getText().toString());
        int result =0;

        switch (operation){
            case "sum":
                result = number1 + number2;
                break;
            case "deduct":
                result = number1 - number2;
                break;
            case "multiply":
                result = number1 * number2;
                break;
            case "divide":
                if (number2 !=0){
                    result = number1 / number2;
                }
                else {
                    resultText.setText("Connet divide by zero");
                    return;
                }
                break;
            default:resultText.setText("Please select an operation");
            return;
        }

        resultText.setText("Result: "+ result);
    }
}