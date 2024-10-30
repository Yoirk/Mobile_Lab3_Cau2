package com.example.lab3bai3;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {
    private EditText nameEditText, mssvEditText, birthdayEditText, hometownEditText, emailEditText, phoneEditText, departmentEditText;
    private StudentDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        dbHelper = new StudentDatabaseHelper(this);

        nameEditText = findViewById(R.id.nameEditText);
        mssvEditText = findViewById(R.id.mssvEditText);
        birthdayEditText = findViewById(R.id.birthdayEditText);
        hometownEditText = findViewById(R.id.hometownEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        departmentEditText = findViewById(R.id.departmentEditText);

        findViewById(R.id.saveButton).setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();
            String mssv = mssvEditText.getText().toString().trim();
            String birthday = birthdayEditText.getText().toString().trim();
            String hometown = hometownEditText.getText().toString().trim();
            String email = emailEditText.getText().toString().trim();
            String phone = phoneEditText.getText().toString().trim();
            String department = departmentEditText.getText().toString().trim();

            if (name.isEmpty() || mssv.isEmpty()) {
                Toast.makeText(AddStudentActivity.this, "Vui lòng nhập tên và MSSV", Toast.LENGTH_SHORT).show();
            } else {
                Student student = new Student(name, mssv, birthday, hometown, email, phone, department);
                dbHelper.addStudent(student);
                Toast.makeText(AddStudentActivity.this, "Đã thêm sinh viên", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            }
        });

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
    }
}
