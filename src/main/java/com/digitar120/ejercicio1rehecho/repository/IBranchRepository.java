package com.digitar120.ejercicio1rehecho.repository;

import com.digitar120.ejercicio1rehecho.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchRepository extends JpaRepository<Branch, Integer> {
}
