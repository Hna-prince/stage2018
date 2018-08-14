package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Adminst;
import com.management.loyality.domain.Company;
import com.management.loyality.domain.Users;
import com.management.loyality.repository.AdminstRepository;
import com.management.loyality.repository.CompanyRepository;
import com.management.loyality.utilitaires.Utilitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImplementation  implements  AdminstService{

    AdminstRepository repository;
    UsersService userservice;
    CompanyRepository companyrepository;

    @Autowired
    public AdminServiceImplementation( AdminstRepository adminstRepository, UsersService userService, CompanyRepository companyRepository){
        this.repository= adminstRepository;
        this.userservice=userService;
        this.companyrepository =  companyRepository;
    }

    @Override
    public String getAllAdmin() {
        String result ;
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<Adminst> listAdminst=repository.findAll();
            String adminList = mapper.writeValueAsString(listAdminst);
            result= "{\"status\":0, \"adminstlist\": "+adminList+" }";

        }
        catch (Exception e){
            result = e.getMessage();
        }

        return result;
    }

    @Override
    @Transactional
    public String insertAdmin( String companyname, String description, String registredaddress,String lastname, String firstname, String address, String email, String phonenumber, String password, int gender, String profil) throws Exception {
        try {
            Company oneCompany= new Company(companyname,description,registredaddress);
            companyrepository.saveAndFlush(oneCompany);
            Adminst oneUser = new Adminst(lastname, firstname, address, email, phonenumber, Utilitaire.sha1(password), gender, profil, 20, oneCompany.getIdcompany());
            repository.save(oneUser);
            String response = "{'status':0, 'description' : ' le compte administrateur est créé'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String insertAdminSeller(String lastname, String firstname, String address, String email, String phonenumber, String password, int gender, String profil, String companyname, String idPlace) throws Exception {
        try {
            Adminst oneUser = new Adminst(lastname, firstname, address, email, phonenumber, Utilitaire.sha1(password), gender, profil, 30, companyname, idPlace);
            repository.save(oneUser);
            String response = "{'status':0, 'description' : ' le compte seller  est créé'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String  getAdmin(String email, String password) throws Exception{

        try {


            List<Adminst> adminList = repository.findAdminByEmailPassword(email, password);

            String toTakeOff = ",\"password\":\".*\",\"creationdate";
            String newString =",\"creationdate";

            List<Users> userList=new ArrayList<Users>();
            for (Adminst oneAdmin: adminList) {
                userList.add( oneAdmin);
            }

            return  userservice.getSpecificUser(email,password,userList, toTakeOff, newString);

        }
        catch (Exception e){
            throw e;
        }
    }


}
