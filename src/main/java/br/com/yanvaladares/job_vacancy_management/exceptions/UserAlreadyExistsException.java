package br.com.yanvaladares.job_vacancy_management.exceptions;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(){
        super("Usuário já existe.");
    }
}
