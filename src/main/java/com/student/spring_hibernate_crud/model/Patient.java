package com.student.spring_hibernate_crud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int pid;

    @Column
    private String pname;
    @Column
    private LocalDateTime dischargedAt;
    @Column
    private LocalDateTime admittedAt;
    @Column
    private String treatedBy;
    @Column
    private long cost;

    public Patient(String pname, LocalDateTime dischargedAt, LocalDateTime admittedAt, String treatedBy, long cost) {
        this.pname = pname;
        this.dischargedAt = dischargedAt;
        this.admittedAt = admittedAt;
        this.treatedBy = treatedBy;
        this.cost = cost;
    }

    public Patient() {
    }
}
