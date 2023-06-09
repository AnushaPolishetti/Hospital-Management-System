package com.example.Hospital_management_System;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Contoller has list of api's  that are present
@RestController  // make the spring understand we are writing api's here.
public class PatientController {


    HashMap<Integer,Patient> patientDb = new HashMap<>();

    @PostMapping("/addPatientViaParameters")
    public String addPatient(@RequestParam("patientId")Integer patientId,@RequestParam("name")String name,@RequestParam("age") Integer age,@RequestParam("disease")String disease){
        // create the patient object

        Patient patient = new Patient(patientId,name,age,disease);
        patientDb.put(patientId,patient);

        return "Patient added via request parameters";

    }

    @PostMapping("/addPatientViaRequestBody")
    public String addPatient(@RequestBody Patient patient){
        int key = patient.getPatientid();
        patientDb.put(key,patient);

        return "Patient added via request body";

    }


    @GetMapping("/getPatientInfo")
    public Patient getPatient(@RequestParam("patientId") Integer patientId){
        Patient patient = patientDb.get(patientId);
        return patient;
    }


    @GetMapping("/getAllPatients")
    public List<Patient> getAllPatients(){

        List<Patient> patients = new ArrayList<>();
        for(Patient p: patientDb.values()){
            patients.add(p);
        }

        return patients;

    }

    @GetMapping("/getPatientByName")
    public Patient getPatientByName(@RequestParam("name")String name){
        for(Patient p:patientDb.values()){
            if(p.getName().equals(name)){
                return p;
            }
        }

        return null;
    }


    @GetMapping("/getPatientsListGreaterThanAge")
    public List<Patient> getPatientsGreaterThanAge(@RequestParam("age") Integer age){
        List<Patient> patients = new ArrayList<>();
        for(Patient p:patientDb.values()){
            if(p.getAge() >  age){
                patients.add(p);
            }
        }
        return patients;
    }

}
