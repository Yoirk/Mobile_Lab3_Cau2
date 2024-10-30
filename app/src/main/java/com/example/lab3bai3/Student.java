package com.example.lab3bai3;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Student implements Parcelable {
    private int id;
    private String name;
    private String mssv;
    private String birthday;
    private String hometown;
    private String email;
    private String phone;
    private String department;

    public Student(int id, String name, String mssv, String birthday, String hometown, String email, String phone, String department) {
        this.id = id;
        this.name = name;
        this.mssv = mssv;
        this.birthday = birthday;
        this.hometown = hometown;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    public Student(String name, String mssv, String birthday, String hometown, String email, String phone, String department) {
        this.name = name;
        this.mssv = mssv;
        this.birthday = birthday;
        this.hometown = hometown;
        this.email = email;
        this.phone = phone;
        this.department = department;
    }

    // Getters và Setters cho các thuộc tính
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Parcelable implementation để truyền dữ liệu Student giữa các Activity
    protected Student(Parcel in) {
        id = in.readInt();
        name = in.readString();
        mssv = in.readString();
        birthday = in.readString();
        hometown = in.readString();
        email = in.readString();
        phone = in.readString();
        department = in.readString();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(mssv);
        dest.writeString(birthday);
        dest.writeString(hometown);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(department);
    }
}

