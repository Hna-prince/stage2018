package com.management.loyality.service;

import com.management.loyality.domain.Adminst;

import java.util.List;

public interface AdminstService {
    public String getAllAdmin();
    public String insertAdmin(  String companyname, String description, String registredaddress,String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil ) throws  Exception;
    public String insertAdminSeller( String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil,  String companyname, String idPlace ) throws  Exception;
    public String getAdmin(String email, String password) throws Exception;

}
