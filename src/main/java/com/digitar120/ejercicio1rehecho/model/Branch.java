package com.digitar120.ejercicio1rehecho.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Branch {

    private @Id @GeneratedValue @Column(name = "BRANCH_ID") Integer id;
    private @Column(name = "BRANCH_NAME") String name;

    public Branch(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Branch() {
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

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
