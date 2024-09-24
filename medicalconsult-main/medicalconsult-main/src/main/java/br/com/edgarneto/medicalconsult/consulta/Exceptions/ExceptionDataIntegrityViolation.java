package br.com.edgarneto.medicalconsult.consulta.Exceptions;

public class ExceptionDataIntegrityViolation extends RuntimeException{
    public ExceptionDataIntegrityViolation(String message) {
        super(message);
    }
}