package br.com.yanvaladares.job_vacancy_management.exceptions;

public class CompanyAlreadyExists extends RuntimeException{

    public CompanyAlreadyExists(){
        super("Empresa já existe.");
    }
}
