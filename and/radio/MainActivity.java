package com.example.myradiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton, radioOddEven, radioPositiveNegative, radioSquare, radioFactorial;
    TextView answer;
    EditText input_number;
    int numberToCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input_number = findViewById(R.id.input_number);
        radioGroup = findViewById(R.id.radio_group);
        answer = findViewById(R.id.answer);
        radioOddEven = findViewById(R.id.radio_odd_or_evan);
        radioPositiveNegative = findViewById(R.id.radio_positive_or_negative);
        radioSquare = findViewById(R.id.radio_square);
        radioFactorial = findViewById(R.id.radio_factorial);

        Button buttonCheck = findViewById(R.id.button_check);
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberToCheck = (Integer.parseInt(input_number.getText().toString()));
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);
                if (radioButton == radioOddEven){
                    if( numberToCheck %2 == 0){
                        answer.setText("Answer: Number is Even");
                    }else{
                        answer.setText("Answer: Number is Odd");
                    }
                }else if (radioButton == radioPositiveNegative){
                    if( numberToCheck>0){
                        answer.setText("Answer: Number is Positive");
                    }else if(numberToCheck< 0){
                        answer.setText("Answer: Number is Negative");
                    }else{
                        answer.setText("Answer: Number is Zero");
                    }
                }else if(radioButton == radioSquare){
                    answer.setText("Answer: Square is "+ numberToCheck * numberToCheck);
                }else if(radioButton == radioFactorial){
                    answer.setText("Answer: factorial is "+ factorial(numberToCheck));
                }

            }
        });


    }

    private int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n * factorial(n - 1);
    }

    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(this,
                "Selected Radio Button "+ radioButton.getText().toString(),
                Toast.LENGTH_SHORT
        ).show();

    }
}
