package com.management.loyality.service;

public interface CustomerService  {
        public String getAllCustomer();
        public String insertCustomer( String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil, String birthdate ) throws  Exception;
        public String getCustomer(String email, String password) throws Exception;
}
