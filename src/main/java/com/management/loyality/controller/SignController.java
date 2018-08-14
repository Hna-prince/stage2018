package com.management.loyality.controller;

import com.management.loyality.service.AdminstService;
import com.management.loyality.service.CustomerService;
import com.management.loyality.utilitaires.Utilitaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.management.loyality.service.UsersService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@CrossOrigin(origins="*")
public class SignController {


    private UsersService usersService;
    private AdminstService adminstService;
    private CustomerService customerService;

    @Autowired
    public SignController(UsersService userService,  AdminstService adminService, CustomerService customersService){
        this.usersService       = userService;
        this.adminstService     = adminService;
        this.customerService    = customersService;
    }

    @RequestMapping("/login")
    String login(@RequestParam String email, @RequestParam String password){
         return usersService.getAll();
        /*return "{\n" +
                "  \"espèce\": \"Dog\",\n" +
                "  \"race\": \"Labrador Retriever\",\n" +
                "  \"couleur\": \"Yellow\",\n" +
                "  \"âge\": 6\n" +
                "}";*/
    }

    @RequestMapping("/signUp")
    String signUp(@RequestParam String lastname, @RequestParam String firstname, @RequestParam String address, @RequestParam String email, @RequestParam String phonenumber, @RequestParam String password, @RequestParam int gender, @RequestParam String profil){
        String result="";
        try {
            result= usersService.insertUser(lastname, firstname, address, email, phonenumber, password, gender, profil);
        }
        catch (Exception e){
            result="{'status':1, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/login/customer")
    String loginCustomer(@RequestParam String email, @RequestParam String password){
        String result="";
        try {
             result= customerService.getCustomer(email, password);

        }
        catch (Exception e){
            result="{'status':99, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/signUp/customer")
    String signUpCustomer(@RequestParam String lastname, @RequestParam String firstname, @RequestParam String address, @RequestParam String email, @RequestParam String phonenumber, @RequestParam String password, @RequestParam int gender, @RequestParam String profil, @RequestParam String birthdate ){
        String result="";
        try {
            result=customerService.insertCustomer(lastname, firstname, address, email, phonenumber, password, gender, profil,birthdate);
        }
        catch (Exception e){
            result="{'status':1, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/login/internal")
    String loginInternal(@RequestParam String email, @RequestParam String password){
        String result="";
        try {
            result= customerService.getCustomer(email, password);

        }
        catch (Exception e){
            result="{'status':1, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/userManagement/signUp/seller")
    String signUpInternal(@RequestParam String lastname, @RequestParam String firstname, @RequestParam String address, @RequestParam String email, @RequestParam String phonenumber, @RequestParam String password, @RequestParam int gender, @RequestParam String profil, @RequestParam String companyname, @RequestParam  String idplace ){
        String result="";
        try {
            result=adminstService.insertAdminSeller(lastname, firstname, address, email, phonenumber, password, gender, profil,companyname, idplace);
        }
        catch (Exception e){
            result="{'status':1, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }

    @RequestMapping("/userManagement/signUp/admin")
    String signUpAdmin(@RequestParam String companyname, @RequestParam String description, @RequestParam String registeredaddress,@RequestParam String lastname, @RequestParam String firstname, @RequestParam String address, @RequestParam String email, @RequestParam String phonenumber, @RequestParam String password, @RequestParam int gender, @RequestParam String profil ){
        String result="";
        try {
            result=adminstService.insertAdmin(companyname,description, registeredaddress, lastname, firstname, address, email, phonenumber, password, gender, profil);
        }
        catch (Exception e){
            result="{'status':1, 'description' : ' "+e.getMessage()+"'}";
        }
        finally {
            return result;
        }
    }




    /*@RequestMapping("/testValidEmail")
    String testValidEmail(@RequestParam String email){

         String REGEX_EMAIL_VALIDATION = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-zA-Z]{2,})$";
        Pattern ptr = Pattern.compile(REGEX_EMAIL_VALIDATION);
        Matcher matcher = ptr.matcher(email);
        return String.valueOf(matcher.matches()) ;
    }*/

    /*@RequestMapping("/testCryptage")
    String testSha1(@RequestParam String password){
       return Utilitaire.sha1(password);
    }*/

}
