package com.example.mycompilation.GuidedAct;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mycompilation.R;

public class ThirteenthGuided extends AppCompatActivity {

    EditText studentId, studentName, studentSemGrade;
    Button addRecord, deleteRecord, editRecord, viewRecord, viewAllRecord;
    SQLiteDatabase db;
    Cursor cursor;
    AlertDialog.Builder builder;
    StringBuffer buffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirteenth_guided);
        init();
        addStudentRecord();
        deleteStudentRecord();
        editStudentRecord();
        viewStudentRecord();
        viewAllStudentRecords();
    }

    public void init() {
        studentId = findViewById(R.id.etStudentIDD);
        studentName = findViewById(R.id.etStudentNAme);
        studentSemGrade = findViewById(R.id.etStudentSemGrade);

        addRecord = findViewById(R.id.btnAddRecord);
        deleteRecord = findViewById(R.id.btnDeleteRecord);
        editRecord = findViewById(R.id.btnEditRecord);
        viewRecord = findViewById(R.id.btnViewRecord);
        viewAllRecord = findViewById(R.id.btnviewAllRecord);

        builder = new AlertDialog.Builder(this);
        db = openOrCreateDatabase("StudentDB", Context.MODE_PRIVATE, null);
        db.execSQL("DROP TABLE IF EXISTS tbl_student;");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_student (student_id INTEGER PRIMARY KEY AUTOINCREMENT, student_name TEXT, student_semGrade INTEGER);");
        studentName.requestFocus();
    }

    public void displayMessage(String title, String message) {
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

    public void clearEntries() {
        studentName.setText("");
        studentId.setText("");
        studentSemGrade.setText("");
        studentName.requestFocus();
    }

    public void addStudentRecord() {
        addRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentId.getText().toString().isEmpty() ||
                        studentName.getText().toString().isEmpty() ||
                        studentSemGrade.getText().toString().isEmpty()) {
                    displayMessage("Error!", "Please Complete the Entries");
                    return;
                }

                db.execSQL("INSERT INTO tbl_student(student_id, student_name, student_semGrade) " +
                        "VALUES('" + studentId.getText().toString() + "'," +
                        "'" + studentName.getText().toString() + "'," +
                        "'" + studentSemGrade.getText().toString() + "')");
                displayMessage("Information!", "Student Record has been successfully added!");
                clearEntries();
            }
        });
    }

    public void deleteStudentRecord() {
        deleteRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentId.getText().toString().isEmpty()) {
                    displayMessage("Information!", "Please Enter a Student ID");
                    studentId.requestFocus();
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id =" + Integer.parseInt(studentId.getText().toString()), null);
                if (cursor.moveToFirst()) {
                    db.execSQL("DELETE FROM tbl_student WHERE student_id =" + Integer.parseInt(studentId.getText().toString()));
                    displayMessage("Information!", "Student Record has been successfully deleted!");
                } else {
                    displayMessage("Error!", "Invalid Student ID");
                }
                clearEntries();
            }
        });
    }

    public void editStudentRecord() {
        editRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentId.getText().toString().isEmpty()) {
                    displayMessage("Information!", "Please Enter a Student ID");
                    studentId.requestFocus();
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id =" + Integer.parseInt(studentId.getText().toString()), null);
                if (cursor.moveToFirst()) {
                    db.execSQL("UPDATE tbl_student SET student_name='" + studentName.getText().toString() + "',student_semGrade='" + studentSemGrade.getText().toString() +
                            "'WHERE student_id='" + Integer.parseInt(studentId.getText().toString()) + "'");
                    displayMessage("Information!", "Student Record has been successfully modified!");
                } else {
                    displayMessage("Error!", "Invalid Student ID");
                }
                clearEntries();
            }
        });
    }

    public void viewStudentRecord() {
        viewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (studentId.getText().toString().isEmpty()) {
                    displayMessage("Information!", "Please Enter a Student ID");
                    studentId.requestFocus();
                    return;
                }
                cursor = db.rawQuery("SELECT * FROM tbl_student WHERE student_id =" + Integer.parseInt(studentId.getText().toString()), null);
                if (cursor.moveToFirst()) {
                    buffer = new StringBuffer();
                    buffer.append("Student ID: " + cursor.getString(0) + "\n");
                    buffer.append("Student Name: " + cursor.getString(1) + "\n");
                    buffer.append("Student SemGrade: " + cursor.getString(2) + "\n----------");
                    displayMessage("Student Record", buffer.toString());
                } else {
                    displayMessage("Error!", "Invalid Student ID");
                }
                clearEntries();
            }
        });
    }

    public void viewAllStudentRecords() {
        viewAllRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cursor = db.rawQuery("SELECT * FROM tbl_student", null);
                if (cursor.getCount() == 0) {
                    displayMessage("Information", "No Student Records Found!");
                    return;
                }
                buffer = new StringBuffer();
                while (cursor.moveToNext()) {
                    buffer.append("Student ID: " + cursor.getString(0) + "\n");
                    buffer.append("Student Name: " + cursor.getString(1) + "\n");
                    buffer.append("Student SemGrade: " + cursor.getString(2) + "\n----------\n");
                }
                displayMessage("Student Record", buffer.toString());
            }
        });
    }
}
