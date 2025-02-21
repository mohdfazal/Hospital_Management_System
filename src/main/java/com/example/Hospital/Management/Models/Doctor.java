package com.example.Hospital.Management.Models;

public class Doctor {
    private String name;
    private String specialization;
    private int age;
    private int doctorId;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    private String degree;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Doctor(String name, String specialization, int age, String degree, int doctorId) {
        this.name = name;
        this.specialization = specialization;
        this.age = age;
        this.degree = degree;
        this.doctorId = doctorId;
    }
}
