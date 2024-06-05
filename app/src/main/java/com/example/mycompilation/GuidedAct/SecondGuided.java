package com.example.mycompilation.GuidedAct;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;

public class SecondGuided extends AppCompatActivity {
    EditText name;
    ImageView ivReturn;
    Button click;
    Toast toast;
    LinearLayout main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_guided);
        init();
        showResult();
        returnClicked();
    }
    public void showResult(){
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast = Toast.makeText(getApplicationContext(),
                        "Hello " + name.getText().toString() + "! \nWelcome to Android Development!",Toast.LENGTH_SHORT);
                view = toast.getView();
                //view.getBackground().setColorFilter(Color.GREEN, PorterDuff.Mode.SRC_IN);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
    }

    public void init(){
        name = findViewById(R.id.etNameGE2);
        click = findViewById(R.id.btnClickGE2);
        ivReturn = findViewById(R.id.ivReturn2);
        main = findViewById(R.id.main);
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