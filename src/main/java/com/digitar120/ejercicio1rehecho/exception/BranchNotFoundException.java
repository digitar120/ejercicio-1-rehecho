package com.digitar120.ejercicio1rehecho.exception;

public class BranchNotFoundException extends RuntimeException{
    public BranchNotFoundException(Integer id){
        super("No se encontró la sucursal N° " + id);
    }
}
