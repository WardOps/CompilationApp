package com.example.mycompilation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.GuidedAct.EighthGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided;
import com.example.mycompilation.GuidedAct.EleventhGuided2;
import com.example.mycompilation.GuidedAct.FirstGuided;
import com.example.mycompilation.GuidedAct.FourthGuided;
import com.example.mycompilation.GuidedAct.FifthGuided;
import com.example.mycompilation.GuidedAct.NinethGuided;
import com.example.mycompilation.GuidedAct.SecondGuided;
import com.example.mycompilation.GuidedAct.SeventhGuided;
import com.example.mycompilation.GuidedAct.SixthGuided;
import com.example.mycompilation.GuidedAct.TenthGuided;
import com.example.mycompilation.GuidedAct.ThirdGuided;
import com.example.mycompilation.GuidedAct.ThirteenthGuided;
import com.example.mycompilation.GuidedAct.TwelvethGuided;
import com.example.mycompilation.MachineAct.FifthMachine;
import com.example.mycompilation.MachineAct.FourthMachine;
import com.example.mycompilation.MachineAct.SecondMachine;
import com.example.mycompilation.MachineAct.SixthMachineAct;
import com.example.mycompilation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setButtonGuided();
        setMachine();
    }
    public void setButtonGuided(){

        binding.exercise1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FifthGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SixthGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SeventhGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EighthGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NinethGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TenthGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EleventhGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,EleventhGuided2.class);
                startActivity(intent);
            }
        });
        binding.exercise13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,TwelvethGuided.class);
                startActivity(intent);
            }
        });
        binding.exercise14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirteenthGuided.class);
                startActivity(intent);
            }
        });
    }
    public void setMachine(){
        binding.machine1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondMachine.class);
                startActivity(intent);
            }
        });
        binding.machine2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FourthMachine.class);
                startActivity(intent);
            }
        });
        binding.machine3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FifthMachine.class);
                startActivity(intent);
            }
        });
        binding.machine4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SixthMachineAct.class);
                startActivity(intent);
            }
        });
    }
}