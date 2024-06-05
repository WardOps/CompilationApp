package com.example.mycompilation.GuidedAct;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

public class FourthGuided extends AppCompatActivity {

    EditText username, password;
    TextView result;
    Button login;
    ImageView ivReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_guided);
        init();
        showResult();
        returnClicked();
    }
    public void showResult(){
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(username.getText().toString().equals("george") && password.getText().toString().equals("floyd")){
                    result.setText("Welcome " + username.getText().toString() +"!");
                    result.setTextColor(Color.GREEN);
                    clearEntry();

                }else{
                    result.setText("Username and Password does not exist!");
                    result.setTextColor(Color.RED);
                    clearEntry();

                }
            }
        });
    }

    public void clearEntry(){
        result.setVisibility(View.VISIBLE);
        username.setText("");
        password.setText("");
        username.requestFocus();
    }

    public void init(){
        username = findViewById(R.id.etUsernameGE4);
        password = findViewById(R.id.etPasswordGE4);
        result = findViewById(R.id.tvResultGE4);
        login = findViewById(R.id.btnLoginGE4);
        ivReturn = findViewById(R.id.ivReturn);
    }
    public void returnClicked(){
        ivReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}


