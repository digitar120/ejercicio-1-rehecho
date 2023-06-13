package com.digitar120.ejercicio1rehecho.controller;

import com.digitar120.ejercicio1rehecho.exception.RegisterNotFoundException;
import com.digitar120.ejercicio1rehecho.model.Register;
import com.digitar120.ejercicio1rehecho.repository.IRegisterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisterController {

    private final IRegisterRepository repository;

    RegisterController (IRegisterRepository repository){
        this.repository = repository;
    }



    // Peticiones GET
    //GET para todos los registros
    @GetMapping("/registers")
    List<Register> all() {
        return repository.findAll();
    }

    // GET para un registro específico
    @GetMapping("/registers/{id}")
    Register one(@PathVariable Integer id) {
        return repository.findById(id).orElseThrow( () -> new RegisterNotFoundException(id));
    }

    // GET para todos los registros asociados a una persona
    @GetMapping("/registers/by-person-id/{person_id}")
    List<Register> all(@PathVariable Integer person_id){
        return repository.findByPersonId(person_id);
    }


    // Peticiones POST
    // POST para insertar un registro
    @PostMapping("/registers/")
    Register newRegister(@RequestBody Register new_register){
        return repository.save(new_register);
    }


    // Peticiones PUT
    // PUT para editar un registro
    @PutMapping("/registers/{id}")
    Register editRegister(@PathVariable Integer id, @RequestBody Register edited_register){
        return repository.findById(id)
                .map(register -> {
                    register.setText(edited_register.getText());
                    return repository.save(edited_register);
                })
                .orElseThrow( () -> new RegisterNotFoundException(id));

    }


    // Peticiones DELETE
    // DELETE para remover un registro
    @DeleteMapping("/registers/{id}")
    void removeRegister(@PathVariable Integer id){
        repository.deleteById(id);
    }


}
