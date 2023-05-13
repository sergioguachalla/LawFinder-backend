package com.lawfinder.backend.bl;

import com.lawfinder.backend.Entitity.AddressEntity;
import com.lawfinder.backend.dao.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBl {

    private final AddressRepository addressRepository;

    public AddressBl(AddressRepository addressRepository){
        this.addressRepository = addressRepository;
    }

    public AddressEntity saveAddress(AddressEntity addressEntity){
        return addressRepository.save(addressEntity);
    }

    public List<AddressEntity> findAll(){
        return addressRepository.findAll();
    }


}
