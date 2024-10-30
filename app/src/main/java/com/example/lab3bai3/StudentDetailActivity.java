package com.example.lab3bai3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class StudentDetailActivity extends AppCompatActivity {
    private EditText nameEditText, mssvEditText, birthdayEditText, hometownEditText, emailEditText, phoneEditText, departmentEditText;
    private StudentDatabaseHelper dbHelper;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_detail);

        dbHelper = new StudentDatabaseHelper(this);

        student = getIntent().getParcelableExtra("student");

        nameEditText = findViewById(R.id.nameEditText);
        mssvEditText = findViewById(R.id.mssvEditText);
        birthdayEditText = findViewById(R.id.birthdayEditText);
        hometownEditText = findViewById(R.id.hometownEditText);
        emailEditText = findViewById(R.id.emailEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        departmentEditText = findViewById(R.id.departmentEditText);

        loadStudentData();

        findViewById(R.id.updateButton).setOnClickListener(v -> {
            student.setName(nameEditText.getText().toString().trim());
            student.setMssv(mssvEditText.getText().toString().trim());
            student.setBirthday(birthdayEditText.getText().toString().trim());
            student.setHometown(hometownEditText.getText().toString().trim());
            student.setEmail(emailEditText.getText().toString().trim());
            student.setPhone(phoneEditText.getText().toString().trim());
            student.setDepartment(departmentEditText.getText().toString().trim());

            dbHelper.updateStudent(student);
            Toast.makeText(StudentDetailActivity.this, "Đã cập nhật thông tin sinh viên", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK);
            finish();
        });

        findViewById(R.id.backButton).setOnClickListener(v -> finish());
    }

    private void loadStudentData() {
        nameEditText.setText(student.getName());
        mssvEditText.setText(student.getMssv());
        birthdayEditText.setText(student.getBirthday());
        hometownEditText.setText(student.getHometown());
        emailEditText.setText(student.getEmail());
        phoneEditText.setText(student.getPhone());
        departmentEditText.setText(student.getDepartment());
    }
}

