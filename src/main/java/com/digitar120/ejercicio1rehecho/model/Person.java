package com.digitar120.ejercicio1rehecho.model;

import jakarta.persistence.*;

@Entity
public class Person {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "PERSON_ID") Integer id;
    private @Column(name = "PERSON_NAME") String name;
    private @ManyToOne @JoinColumn(name="BRANCH_ID") Branch branch;

    public Person(Integer id, String name, Branch branch) {
        this.id = id;
        this.name = name;
        this.branch = branch;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch=" + branch +
                '}';
    }
}
