package com.pandev.androidfundamental.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one, two, three, four, five, six, seven, eight, nine, zero,
                plus, min, mul, div, equals, clear;
    private TextView info, result;

    private final char ADDICTION = '+';
    private final char SUBSTRACTION = '-';
    private final char MULTIPLECATION = '*';
    private final char DIVISION = '/';
    private final char EQU = '0';

    private double val1 = Double.NaN;
    private double val2;

    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDICTION;
                result.setText(String.valueOf(val1)+ "+");
                info.setText(null);
            }
        });
        min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBSTRACTION;
                result.setText(String.valueOf(val1)+ "-");
                info.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLECATION;
                result.setText(String.valueOf(val1)+ "*");
                info.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result.setText(String.valueOf(val1)+ "/");
                info.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQU;
                result.setText(result.getText().toString() + String.valueOf(val2)+ "=" + String.valueOf(val1));
                //5 + 4 = 9
                info.setText(null);
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (info.getText().length()>0){
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length()-1));
                }
                else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });


    }

    private void setupUIViews(){

        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        clear = (Button)findViewById(R.id.btnclear);
        div = (Button)findViewById(R.id.btndevided);
        mul = (Button)findViewById(R.id.btnmultiple);
        plus = (Button)findViewById(R.id.btnplus);
        min = (Button)findViewById(R.id.btnminus);
        equals = (Button)findViewById(R.id.btnequals);
        info = (TextView)findViewById(R.id.tvControl);
        result = (TextView)findViewById(R.id.tvResult);
    }

    private void compute(){
        if(!Double.isNaN(val1)){
            val2 = Double.parseDouble(info.getText().toString());

            switch (ACTION){
                case ADDICTION:
                    val1 = val1+val2;
                    break;
                case SUBSTRACTION:
                    val1 = val1-val2;
                    break;
                case MULTIPLECATION:
                    val1 = val1*val2;
                    break;
                case DIVISION:
                    val1 = val1/val2;
                    break;
                case EQU:
                    break;

            }
        }
        else {
            val1 = Double.parseDouble(info.getText().toString());
        }
    }
}
