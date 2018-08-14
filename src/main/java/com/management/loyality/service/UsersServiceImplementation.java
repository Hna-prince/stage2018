package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Adminst;
import com.management.loyality.domain.Users;
import com.management.loyality.repository.AdminstRepository;
import com.management.loyality.repository.UsersRepository;
import com.management.loyality.utilitaires.Utilitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImplementation implements UsersService {


    UsersRepository repository;



    @Autowired
    public UsersServiceImplementation(UsersRepository userRepository){
        this.repository         =userRepository;

    }


    public String  getAll(){
        String result ;
        try{
        ObjectMapper mapper = new ObjectMapper();
        List<Users> listUser=repository.findAll();
         result = mapper.writeValueAsString(listUser);

        }
        catch (Exception e){
            result = e.getMessage();
        }

        return result;
    }


    public String insertUser( String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil )throws  Exception{

        try {
            Users oneUser = new Users(lastname, firstname, address, email, phonenumber, Utilitaire.sha1(password), gender, profil,0);
            repository.save(oneUser);
            String response = "{'status':0, 'description' : ' insertion executé avec succès'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String getSpecificUser(String email, String password,List<Users> userList, String toTakeOff, String remplacement) throws Exception {
        String result ;
        try {


            if(userList.size() == 0)
                return "{\"status\":1, \"user\": {}}";
            else if(!userList.get(0).getEmail().equals(email))
                return "{\"status\":2, \"user\": {}}";
            else if(!userList.get(0).getPassword().equals(password))
                return "{\"status\":3, \"user\": {}}";

            ObjectMapper mapper = new ObjectMapper();
            result              = mapper.writeValueAsString(userList.get(0));



            return "{\"status\":0, \"user\": "+result.replaceAll(toTakeOff, remplacement)+"}";
            //return result;
        }
        catch (Exception e){
            throw e;
        }
    }


}
