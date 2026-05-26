package com.student.spring_hibernate_crud.repository;

import com.student.spring_hibernate_crud.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;

@Repository
public class PatientDAO {

    private final SessionFactory sessionFactory;
    public PatientDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Patient> patientList;

    public List<Patient> getPatients() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("from Patient", Patient.class)
                    .list();
        }
    }

    public void addPetient (Patient patient) {
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();

            session.persist(patient);
            System.out.println("Patient Added Successfully...");

            transaction.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public Patient getPatientByID (int pid) {
        Patient newPatint;
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            newPatint = session.find(Patient.class, pid);
            if (newPatint == null) System.out.println("User not found");

            transaction.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException("Patient not Found");
        }
        return newPatint;
    }

    @PutMapping("/update")
    public void updateUserByID (int pid,Patient patient) {
        try(Session session = sessionFactory.openSession()){
            Transaction tx = session.beginTransaction();

            Patient currentUser = session.find(Patient.class,pid);
            currentUser.setPname(patient.getPname());
            currentUser.setAdmittedAt(patient.getAdmittedAt());
            currentUser.setDischargedAt(patient.getDischargedAt());
            currentUser.setTreatedBy(patient.getTreatedBy());
            currentUser.setCost(patient.getCost());
            session.merge(currentUser);
            System.out.println("updated Successfully....");

            tx.commit();
        }
    }

}
