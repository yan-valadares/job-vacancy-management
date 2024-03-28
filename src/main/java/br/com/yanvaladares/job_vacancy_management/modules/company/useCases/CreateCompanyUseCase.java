package br.com.yanvaladares.job_vacancy_management.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.yanvaladares.job_vacancy_management.exceptions.CompanyAlreadyExists;
import br.com.yanvaladares.job_vacancy_management.modules.company.entities.CompanyEntity;
import br.com.yanvaladares.job_vacancy_management.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

    @Autowired
    CompanyRepository companyRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public CompanyEntity execute(CompanyEntity companyEntity){
        companyRepository
            .findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail())
            .ifPresent((company) -> {
                throw new CompanyAlreadyExists();
            });

            var password = passwordEncoder.encode(companyEntity.getPassword());
            companyEntity.setPassword(password);

        return this.companyRepository.save(companyEntity);
    }
}
