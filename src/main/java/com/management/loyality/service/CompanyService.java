package com.management.loyality.service;

public interface CompanyService {

    public String findCompanyById(String idCompany) throws  Exception;
    public String insertCompany(String companyname, String description, String registeredaddress) throws Exception;

}
