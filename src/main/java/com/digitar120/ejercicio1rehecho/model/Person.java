package com.digitar120.ejercicio1rehecho.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Person {
    private @Id @GeneratedValue @Column(name = "PERSON_ID") Integer id;
    private @Column(name = "PERSON_NAME") String name;
    private
}
