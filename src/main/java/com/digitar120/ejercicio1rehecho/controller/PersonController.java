package com.digitar120.ejercicio1rehecho.controller;

import com.digitar120.ejercicio1rehecho.exception.PersonNotFoundException;
import com.digitar120.ejercicio1rehecho.model.Person;
import com.digitar120.ejercicio1rehecho.repository.IPersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    // ATRIBUTOS
    private final IPersonRepository repo;

    // CONSTRUCTORES
    PersonController(IPersonRepository repo) {
        this.repo = repo;
    }

    // PETICIONES GET
    // GET para todas las personas registradas
    @GetMapping("/persons")
            List<Person> all() {
        return repo.findAll();
    }

    // GET para persona con Id específico
    @GetMapping("/persons/{id]")
    Person one(@PathVariable Integer id){
        return repo.findById(id).orElseThrow( () -> new PersonNotFoundException(id));
    }

    // GET para todas las personas asociadas a una sucursal, según ID de persona
    @GetMapping("/persons/by-branch-id/{branch_id}")
    List<Person> all(@PathVariable Integer id){
        return repo.findByBranchId(id);
    }



    // PETICIONES POST
    // POST para agregar un registro
    @PostMapping("/persons")
    Person newPerson(@RequestBody Person new_person){
        return repo.save(new_person);
    }

    // PUT para editar un registro
    @PutMapping("/persons/{id}")
    Person editPerson(@RequestBody Person new_person, @PathVariable Integer id){
        return repo.findById(id)
                .map( person -> {
                    person.setName(new_person.getName());
                    return repo.save(person);
                })
                .orElseThrow(() -> new PersonNotFoundException(id));
    }



    // PETICIONES DELETE
    // DELETE para remover un registro
    @DeleteMapping("/persons/{person_id}")
    void removePerson(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
