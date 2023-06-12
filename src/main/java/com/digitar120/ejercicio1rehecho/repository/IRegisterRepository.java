package com.digitar120.ejercicio1rehecho.repository;

import com.digitar120.ejercicio1rehecho.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegisterRepository extends JpaRepository<Register, Integer> {
    
}
