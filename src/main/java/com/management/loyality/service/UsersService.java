package com.management.loyality.service;


import com.management.loyality.domain.Users;

import java.util.List;

public interface UsersService {
    public String getAll();
    public String insertUser( String lastname,  String firstname,  String address,  String email,  String phonenumber,  String password,  int gender,  String profil ) throws  Exception;

    public String getSpecificUser(String email, String password, List<Users> userList, String toTakeOff, String remplacement) throws Exception;

}
