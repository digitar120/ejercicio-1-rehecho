package com.digitar120.ejercicio1rehecho.repository;

import com.digitar120.ejercicio1rehecho.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByBranchId(Integer id);
}
