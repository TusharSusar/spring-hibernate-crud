package com.student.spring_hibernate_crud.service;

import com.student.spring_hibernate_crud.model.Patient;
import com.student.spring_hibernate_crud.repository.PatientDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    PatientDAO patientDAO;

    public List<Patient> getPatients () {
        return patientDAO.getPatients();
    }

    public void addPetient (Patient patient) {
        patientDAO.addPetient(patient);
    }

    public Patient getPatientByID (int pid){
        return patientDAO.getPatientByID(pid);
    }

    public void updatePatientById (int pid,Patient updatedPatient) {
        System.out.println(pid);
        patientDAO.updateUserByID(pid,updatedPatient);
    }

}
