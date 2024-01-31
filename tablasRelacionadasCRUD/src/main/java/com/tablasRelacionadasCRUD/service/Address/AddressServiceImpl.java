package com.tablasRelacionadasCRUD.service.Address;

import com.tablasRelacionadasCRUD.entity.Address;
import com.tablasRelacionadasCRUD.repository.AdressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    AdressRepository adressRepository;
    @Override
    public Address createAddress(Address address) {
        return adressRepository.save(address);
    }
}
