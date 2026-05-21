package com.student.spring_hibernate_crud.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pid")
    private int pid;

    @Column(name = "pname",length = 80,unique = true,nullable = false)
    private String pname;

    @Column(name = "dischargedAt")
    private LocalDateTime dischargedAt;

    @Column(name = "admittedAt")
    private LocalDateTime admittedAt;

    @Column(name = "treatedBy")
    private String treatedBy;

    @Column(name = "cost")
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
