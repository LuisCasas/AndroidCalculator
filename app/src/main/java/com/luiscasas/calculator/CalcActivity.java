package com.luiscasas.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CalcActivity extends Activity {

    TextView resultView;

    public enum Operation {
        ADD, SUBTRACT, DIVIDE, MULTIPLY, EQUAL
    }

    String currentNumber = "";
    String leftValue = "";
    String rightValue = "";
    Operation currentOperation;
    int result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);

        Button oneBtn = (Button)findViewById(R.id.oneBtn);
        Button twoBtn = (Button)findViewById(R.id.twoBtn);
        Button threeBtn = (Button)findViewById(R.id.threeBtn);
        Button fourBtn = (Button)findViewById(R.id.fourBtn);
        Button fiveBtn = (Button)findViewById(R.id.fiveBtn);
        Button sixBtn = (Button)findViewById(R.id.sixBtn);
        Button sevenBtn = (Button)findViewById(R.id.sevenBtn);
        Button eightBtn = (Button)findViewById(R.id.eightBtn);
        Button nineBtn = (Button)findViewById(R.id.nineBtn);
        Button zeroBtn = (Button)findViewById(R.id.zeroBtn);

        ImageButton calcBtn = (ImageButton)findViewById(R.id.calcBtn);
        ImageButton divideBtn = (ImageButton)findViewById(R.id.divideBtn);
        ImageButton multiplyBtn = (ImageButton)findViewById(R.id.multiplyBtn);
        ImageButton subtractBtn = (ImageButton)findViewById(R.id.subtractBtn);
        ImageButton sumBtn = (ImageButton)findViewById(R.id.sumBtn);

        Button clearBtn = (Button)findViewById(R.id.clearBtn);

        resultView = (TextView)findViewById(R.id.resultText);
        resultView.setText("");

        oneBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(1);
            }
        });

        twoBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(2);
            }
        });

        threeBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(3);
            }
        });

        fourBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(4);
            }
        });

        fiveBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(5);
            }
        });

        sixBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(6);
            }
        });

        sevenBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(7);
            }
        });

        eightBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(8);
            }
        });

        nineBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(9);
            }
        });

        zeroBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                numberPressed(0);
            }
        });

        divideBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.DIVIDE);
            }
        });

        multiplyBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.MULTIPLY);
            }
        });

        subtractBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.SUBTRACT);
            }
        });

        sumBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.ADD);
            }
        });

        calcBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                processOperation(Operation.EQUAL);
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                leftValue = "";
                rightValue = "";
                currentNumber = "";
                result = 0;
                currentOperation = null;
                resultView.setText("0");
            }
        });

    }

    void processOperation(Operation operation){

        if(currentOperation != null){
            if(currentNumber != ""){
                rightValue = currentNumber;
                currentNumber = "";

                switch (currentOperation){
                    case ADD:
                        result = Integer.parseInt(leftValue) + Integer.parseInt(rightValue);
                        break;
                    case DIVIDE:
                        result = Integer.parseInt(leftValue) / Integer.parseInt(rightValue);
                        break;
                    case MULTIPLY:
                        result = Integer.parseInt(leftValue) * Integer.parseInt(rightValue);
                        break;
                    case SUBTRACT:
                        result = Integer.parseInt(leftValue) - Integer.parseInt(rightValue);
                        break;
                }

                leftValue = String.valueOf(result);
                resultView.setText(leftValue);
            }
        } else {
            leftValue = currentNumber;
            currentNumber = "";
        }

        currentOperation = operation;
    }

    void numberPressed(int number){
        currentNumber += String.valueOf(number);
        resultView.setText(currentNumber);
    }
}
