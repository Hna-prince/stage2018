package com.management.loyality.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.loyality.domain.Customer;
import com.management.loyality.domain.Users;
import com.management.loyality.repository.CustomerRepository;
import com.management.loyality.utilitaires.Utilitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImplementation implements  CustomerService{

    CustomerRepository repository;
    UsersService userservice;
    @Autowired
    public CustomerServiceImplementation(CustomerRepository customerRepository, UsersService userService){
        this.repository = customerRepository;
        this.userservice= userService;
    }


    @Override
    public String getAllCustomer() {
        String result ;
        try{
            ObjectMapper mapper = new ObjectMapper();
            List<Customer> listCustomer=repository.findAll();
            result = mapper.writeValueAsString(listCustomer);

        }
        catch (Exception e){
            result = e.getMessage();
        }

        return result;
    }

    @Override
    public String insertCustomer(String lastname, String firstname, String address, String email, String phonenumber, String password, int gender, String profil, String birthdate) throws Exception {
        try {
            Customer oneUser = new Customer(lastname, firstname, address, email, phonenumber, Utilitaire.sha1(password), gender, profil, 10, birthdate);
            repository.save(oneUser);
            String response = "{'status':0, 'description' : ' le compte client a été  créé'}";
            return response.replaceAll("'", "\"");
        }
        catch (Exception e){
            throw e;
        }
    }

    @Override
    public String getCustomer(String email, String password) throws   Exception{

        try {
           /* List<Customer> customer = repository.findByEmailPassword(email, password);

            if(customer.size() == 0)
                return "{\"status\":1, \"user\": {}}";
            else if(!customer.get(0).getEmail().equals(email))
                return "{\"status\":2, \"user\": {}}";
            else if(!customer.get(0).getPassword().equals(password))
                return "{\"status\":3, \"user\": {}}";

            ObjectMapper mapper = new ObjectMapper();
            result              = mapper.writeValueAsString(customer.get(0));

            String toTakeOff = ",\"password\":\".*\",\"creationdate";
            String newString =",\"creationdate";

            return "{\"status\":0, \"utilisateur\": "+result.replaceAll(toTakeOff, newString)+"}";
            //return result;*/

            List<Customer> customer = repository.findByEmailPassword(email, password);

            String toTakeOff = ",\"password\":\".*\",\"creationdate";
            String newString =",\"creationdate";

            List<Users> userList=new ArrayList<Users>();
            for (Customer oneCustomer: customer) {
                userList.add( oneCustomer);
            }

            return  userservice.getSpecificUser(email,password,userList, toTakeOff, newString);

        }
        catch (Exception e){
            throw e;
        }


    }
}
