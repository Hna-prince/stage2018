package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Company;
import com.management.loyality.repository.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImplementation implements CompanyService {

    CompanyRepository repository;
     public CompanyServiceImplementation(CompanyRepository companyrepository){
         this.repository = companyrepository;
     }
    @Override
    public String findCompanyById(String idCompany) throws Exception {
        try {
             Company oneCompany= repository.findById(idCompany).get();
            ObjectMapper mapper = new ObjectMapper();
            String result              = mapper.writeValueAsString(repository);
            return "{\"status\":0, \"company\": "+result+" }";

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public String insertCompany(String companyname, String description, String registeredaddress) throws Exception {
        try {
            Company oneCompany=new Company(companyname,description,registeredaddress);
            repository.save(oneCompany);
            String response = "{'status':0, 'description' : ' la compagnie a été crée avec succes'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }
}
