package com.example.Hospital_management_System;

public class Patient {

    private int patientid;

    private String name;

    private int age;
    private String disease;

    public Patient(int patientid, String name, int age, String disease) {
        this.patientid = patientid;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }
}
