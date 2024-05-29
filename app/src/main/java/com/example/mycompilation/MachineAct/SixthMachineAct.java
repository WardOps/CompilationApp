package com.example.mycompilation.MachineAct;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycompilation.R;
import com.example.mycompilation.databinding.ActivitySixthGuidedBinding;
import com.example.mycompilation.databinding.ActivitySixthMachineAct2Binding;
import com.example.mycompilation.databinding.ActivitySixthMachineBinding;

import java.util.ArrayList;
import java.util.List;

public class SixthMachineAct extends AppCompatActivity {
    private ActivitySixthMachineBinding binding;
    private List<String> employeeID;
    private List<String> employeeName;
    private List<String> days;
    private List<String> positionCode;
    private double rateperDay = 0;
    private double civiltaxRate = 0;
    private double sssRate = 0;
    private double TaxRate = 0;
    private String cvStatus = "";
    private Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySixthMachineBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addToList();
        setSpinnerAdapter();
        spinnerClicked();
        TaxRate();
        btnComputeClicked();
        binding.radioGroup.check(R.id.rb1);
        btnClear();
    }

    private void btnClear(){
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.spinnerEmpID.setSelection(0);
                binding.spinnerDaysWorked.setSelection(0);
                binding.spinnerPosCode.setSelection(0);
                binding.radioGroup.check(R.id.rb1);
            }
        });
    }
    private void btnComputeClicked(){
        binding.btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.spinnerEmpID.getSelectedItem().toString();
                String name = binding.textView6.getText().toString();
                String posCode = binding.spinnerPosCode.getSelectedItem().toString();

                String day = binding.spinnerDaysWorked.getSelectedItem().toString();
                double basicPay = computeBasPay();
                double sssContri = computeSSS();
                double withHolding = computeWithHoldingTax();
                double netPay = getNetPay();

                employee = new Employee(id, name, posCode, cvStatus, day, basicPay, sssContri, withHolding, netPay);

                Intent intent  = new Intent(SixthMachineAct.this, SixthMachineAct2.class);
                intent.putExtra("Employee", employee);
                startActivity(intent);
            }
        });
    }
    private double computeBasPay(){
        double basPay = 0;
        basPay = Double.parseDouble(binding.spinnerDaysWorked.getSelectedItem().toString()) * rateperDay;
        return basPay;
    }

    private double computeSSS(){
        double sssContri = 0;
        sssContri = computeBasPay() * getSSSRate();
        return sssContri;
    }

    private double getSSSRate(){
        double sssRate = 0;
        double basPay = computeBasPay();
        if(basPay == 10000 || basPay >= 10000){
            sssRate = 0.07;
        }else if(basPay >= 5000 || basPay <= 9999){
            sssRate = 0.05;
        } else if(basPay >= 1000 || basPay <= 4999){
            sssRate = 0.03;
        }else if(basPay < 1000){
            sssRate = 0.01;
        }
        return sssRate;
    }
    private double computeWithHoldingTax(){
        double withHT = 0;
        withHT = computeBasPay() * TaxRate;
        return withHT;
    }

    private double getNetPay(){
        double netPay = 0;
        netPay = computeBasPay() - (computeSSS() + computeWithHoldingTax());
        return netPay;
    }
    private void TaxRate(){
        binding.radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb1) {
                    TaxRate = 0.10;
                    cvStatus = "Single";
                } else if (checkedId == R.id.rb2) {
                    TaxRate = 0.05;
                    cvStatus = "Married";
                } else if (checkedId == R.id.rb3) {
                    TaxRate = 0.05;
                    cvStatus = "Widowed";
                }
            }
        });
    }
    public void spinnerClicked(){
        binding.spinnerEmpID.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.textView6.setText(employeeName.get(position));
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        binding.spinnerPosCode.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        rateperDay = 500;
                        break;
                    case 1:
                        rateperDay = 400;
                        break;
                    case 2:
                        rateperDay = 300;
                        break;
                    default:
                        rateperDay = 0;
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void addToList(){
        employeeID = new ArrayList<>();
        employeeName  = new ArrayList<>();
        positionCode = new ArrayList<>();
        days = new ArrayList<>();

        employeeID.add("EMP12303");
        employeeID.add("K12047352");
        employeeID.add("K12462352");
        employeeID.add("K14456452");
        employeeID.add("K54337352");
        employeeID.add("K12043643");

        employeeName.add("Paps");
        employeeName.add("Jude Mikel");
        employeeName.add("Aarron");
        employeeName.add("FaithS Sabelito");
        employeeName.add("Claire S2k");
        employeeName.add("Rey");

        positionCode.add("A");
        positionCode.add("B");
        positionCode.add("C");


        for (int i = 1; i <= 30; i++){
            days.add(String.valueOf(i));
        }
    }
    private void setSpinnerAdapter(){
        ArrayAdapter idSpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, employeeID);
        binding.spinnerEmpID.setAdapter(idSpinnerAdapter);
        ArrayAdapter idPositionAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, positionCode);
        binding.spinnerPosCode.setAdapter(idPositionAdapter);
        ArrayAdapter daysAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, days);
        binding.spinnerDaysWorked.setAdapter(daysAdapter);
    }
}