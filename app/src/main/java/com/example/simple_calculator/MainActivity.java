package com.example.simple_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText numberOne=findViewById(R.id.number1);
        EditText numberTwo=findViewById(R.id.number2);
        RadioGroup operators = findViewById(R.id.radioGroup);
        RadioGroup operators2 = findViewById(R.id.radioGroup2);
        RadioButton add= findViewById(R.id.add);
        RadioButton mult = findViewById(R.id.multiply);
        RadioButton power = findViewById(R.id.power);
        RadioButton subtraction = findViewById(R.id.subtract);
        RadioButton division = findViewById(R.id.division);
        RadioButton root = findViewById(R.id.root);
        Button equal = findViewById(R.id.equal_button);
        TextView result = findViewById(R.id.result);




        operators2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //
               //
                RadioButton radio = radioGroup.findViewById(i);

                Log.d(TAG, "sub" +i);
                if(i!=-1){
                  radio.setChecked(true);
                }


            }
        });

        operators.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //
                //
                RadioButton radio = radioGroup.findViewById(i);
                Log.d(TAG, "mul" + i);

                if(i!=-1){
                    radio.setChecked(true);
                }

            }
        });









        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number1Value=Integer.parseInt(numberOne.getText().toString());
                double number2Value=Integer.parseInt(numberTwo.getText().toString());
                Integer operatorButtonId = operators.getCheckedRadioButtonId();
                Integer operatorButtonId2 = operators2.getCheckedRadioButtonId();
                DecimalFormat numberFormat = new DecimalFormat("#.00");
                double awnser;
                if(operatorButtonId== add.getId()){
                    awnser=number1Value+number2Value;
                }
                else if(operatorButtonId==mult.getId()){
                    awnser=number1Value*number2Value;
                }
                else if(operatorButtonId2==subtraction.getId()){
                    awnser=number1Value-number2Value;
                }
                else if(operatorButtonId2==division.getId()){
                    awnser=number1Value/number2Value;
                }
                else if(operatorButtonId==power.getId()){
                    awnser=Math.pow(number1Value,number2Value);
                }
                else{
                    awnser=Math.pow(number2Value, 1/number1Value);

                }

                result.setText(Double.toString(Double.parseDouble(numberFormat.format(awnser))));

            }
        });


        //Log.d(TAG, "Name!!!!!!!!!!!!!!!" + firstnumber.getText());
        //numberOne =  Integer.parseInt(firstnumber.getText());

    }

}
