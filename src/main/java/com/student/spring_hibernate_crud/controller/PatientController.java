package com.student.spring_hibernate_crud.controller;

import com.student.spring_hibernate_crud.model.Patient;
import com.student.spring_hibernate_crud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @GetMapping
    public List<Patient> getPatients() {
        return patientService.getPatients();
    }

    @GetMapping("/{pid}")
    public Patient getPatintByID (@PathVariable int pid) {
        return patientService.getPatientByID(pid);
    }

    @PostMapping("/add")
    public void addPatient (Patient patient) {
        patientService.addPetient(patient);
    }

}
