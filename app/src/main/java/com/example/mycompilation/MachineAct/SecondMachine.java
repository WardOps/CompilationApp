package com.example.mycompilation.MachineAct;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

public class SecondMachine extends AppCompatActivity {

    ImageView ivReturn;
    private EditText firstNumber;
    private EditText secondNumber;
    private TextView tvResult;
    private Button addButton;
    private Button subButton;
    private Button divButton;
    private Button multiButton;
    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_machine);
        init();
        Clicked();
        returnClicked();
    }

    public void init() {
        firstNumber = findViewById(R.id.etFirstNumber);
        secondNumber = findViewById(R.id.etSecondNumber);
        addButton = findViewById(R.id.btnAdd);
        subButton = findViewById(R.id.btnDiff);
        divButton = findViewById(R.id.btnQuo);
        multiButton = findViewById(R.id.btnProd);
        tvResult = findViewById(R.id.tvResult);
        ivReturn = findViewById(R.id.ivReturn);
    }

    private void returnClicked() {
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void Clicked() {
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum + sNum;
                    showResult(fNum, sNum, "+");
                    clearET();
                }
            }
        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum - sNum;
                    showResult(fNum, sNum, "-");
                    clearET();
                }
            }
        });

        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum * sNum;
                    showResult(fNum, sNum, "*");
                    clearET();
                }
            }
        });

        divButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (firstNumber.getText().toString().isEmpty() || secondNumber.getText().toString().isEmpty()) {
                    restrict();
                } else {
                    double fNum = Double.parseDouble(firstNumber.getText().toString());
                    double sNum = Double.parseDouble(secondNumber.getText().toString());
                    result = fNum / sNum;
                    showResult(fNum, sNum, "/");
                    clearET();
                }
            }
        });
    }

    public void clearET() {
        firstNumber.setText("");
        secondNumber.setText("");
        firstNumber.requestFocus();
    }

    public void showResult(double fNum, double sNum, String operation) {
        if (result % 2 == 0) {
            // Even
            tvResult.setTextColor(Color.BLUE);
        } else {
            // Odd
            tvResult.setTextColor(Color.RED);
        }
        tvResult.setText(fNum + " " + operation + " " + sNum + " = " + result);
    }

    public void restrict() {
        Toast.makeText(getApplicationContext(), "Please enter all required numbers to compute.", Toast.LENGTH_SHORT).show();
    }
}
