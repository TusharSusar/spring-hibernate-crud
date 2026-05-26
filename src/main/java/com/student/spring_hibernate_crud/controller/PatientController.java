package com.student.spring_hibernate_crud.controller;

import com.student.spring_hibernate_crud.model.Patient;
import com.student.spring_hibernate_crud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "http://127.0.0.1:5500/")
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
    public String addPatient (Patient patient) {
        System.out.println(patient);
        patientService.addPetient(patient);
        return "Inserted Successfully...";
    }

    @PutMapping("/update")
    public void updateByID (@RequestBody Patient updatedPatient) {
        patientService.updatePatientById(updatedPatient.getPid(),updatedPatient);
    }

}
