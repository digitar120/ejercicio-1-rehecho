package com.digitar120.ejercicio1rehecho.model;

import jakarta.persistence.*;

@Entity
public class Register {
       private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "REGISTER_ID") Integer id;
       private @Column (name = "REGISTER_TEXT") String text;
       private @ManyToOne @JoinColumn(name = "PERSON_ID") Person person;

    public Register(Integer id, String text, Person person) {
        this.id = id;
        this.text = text;
        this.person = person;
    }

    public Register() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", person=" + person +
                '}';
    }
}
