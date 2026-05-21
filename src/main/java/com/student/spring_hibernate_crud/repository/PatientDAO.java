package com.student.spring_hibernate_crud.repository;

import com.student.spring_hibernate_crud.model.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

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

            transaction.commit();
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        return newPatint;
    }

}
