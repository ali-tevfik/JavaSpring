package com.ali.db.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoAdress;
import com.ali.db.dto.DtoCustomer;
import com.ali.db.entites.Adress;
import com.ali.db.exception.BaseException;
import com.ali.db.exception.ErrorMessage;
import com.ali.db.exception.MessegaType;
import com.ali.db.repository.AdressRepository;
import com.ali.db.services.IAdressService;

@Service
public class AdressServiceImpl implements IAdressService {

    @Autowired
    private AdressRepository adressRepository;

    @Override
    public DtoAdress findAdressById(Long id) {
        Optional<Adress> optional = adressRepository.findById(id);

        if (optional.isEmpty()){
            throw new BaseException(new ErrorMessage(MessegaType.NO_RECORD_EXITS, id.toString()));
        }
        Adress adress = optional.get();
        DtoAdress dtoAdress = new DtoAdress();
        BeanUtils.copyProperties(adress, dtoAdress);
        DtoCustomer dtoCustomer = new DtoCustomer();
        dtoCustomer.setId(adress.getId());
        dtoCustomer.setName(adress.getCustomer().getName());
        dtoAdress.setDtoCustomer(dtoCustomer);
        return dtoAdress;

    }

}
