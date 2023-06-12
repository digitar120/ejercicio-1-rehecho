package com.digitar120.ejercicio1rehecho.exception;

public class PersonNotFoundException extends RuntimeException{
    public PersonNotFoundException (Integer id){
        super ("No se encontró a la persona N° " + id);
    }
}
