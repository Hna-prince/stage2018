package com.management.loyality.service;

import org.springframework.transaction.annotation.Transactional;

public interface PlaceService {
    public String insertPlace(String idAdmin, String address, String nameplace)throws  Exception;
    public String getList(String idAdmin) throws Exception;
    public String updatePlace(String idplace, String address, String nameplace) throws  Exception;
}
