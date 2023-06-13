package com.digitar120.ejercicio1rehecho.controller;

import com.digitar120.ejercicio1rehecho.exception.BranchNotFoundException;
import com.digitar120.ejercicio1rehecho.model.Branch;
import com.digitar120.ejercicio1rehecho.repository.IBranchRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BranchController {
    // ATRIBUTOS
    private final IBranchRepository repo;

    // CONSTRUCTORES
    BranchController(IBranchRepository repo) {
        this.repo = repo;
    }

    // METODOS
    // PETICIONES GET
    // GET para todas las sucursales
    @GetMapping("/branches")
    List<Branch> one(){
        return repo.findAll();
    }

    // GET para una sucursal según ID
    @GetMapping("/branches/{branch_id}")
    Branch one(@PathVariable Integer branch_id){
        return repo.findById(branch_id).orElseThrow( () -> new BranchNotFoundException(branch_id));
    }


    // PETICIONES POST
    // POST para una nueva sucursal
    @PostMapping("/branches")
    Branch newBranch(@RequestBody Branch new_branch){
        return repo.save(new_branch);
    }


    // PETICIONES PUT
    // PUT para editar una sucursal
    @PutMapping("/branches/{branch_id}")
    Branch editBranch(@RequestBody Branch new_branch, @PathVariable Integer branch_id){
        return repo.findById(branch_id)
                .map( branch -> {
                    branch.setName(new_branch.getName());
                    return repo.save(branch);
                })
                .orElseThrow( () -> new BranchNotFoundException(branch_id));
    }


    // PETICINOES DELETE
    // DELETE para remover una sucursal
    @DeleteMapping("/branches/{branch_id}")
    void removeBranch(@PathVariable Integer branch_id){
        repo.deleteById(branch_id);
    }

}
