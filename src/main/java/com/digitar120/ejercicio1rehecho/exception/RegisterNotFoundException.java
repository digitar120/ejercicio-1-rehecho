package com.digitar120.ejercicio1rehecho.exception;

public class RegisterNotFoundException extends RuntimeException{
    public RegisterNotFoundException (Integer id) {
        super ("No se encontró el registro N° " + id);
    }
}
