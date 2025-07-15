package com.ali.db.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ali.db.dto.DtoHome;
import com.ali.db.dto.DtoRoom;
import com.ali.db.entites.Home;
import com.ali.db.entites.Room;
import com.ali.db.exception.BaseException;
import com.ali.db.exception.ErrorMessage;
import com.ali.db.exception.MessegaType;
import com.ali.db.repository.HomeRepository;
import com.ali.db.services.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        Optional<Home> optional = homeRepository.findById(id);
        if (optional.isEmpty()) {
           throw new BaseException(new ErrorMessage(MessegaType.NO_RECORD_EXITS, id.toString()));
        }

        DtoHome dtoHome = new DtoHome();
        BeanUtils.copyProperties(optional.get(), dtoHome);
        List<Room> dbRooms = optional.get().getRoom();
        if (dbRooms != null && !dbRooms.isEmpty()) {
            for (Room room : dbRooms) {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            }
        }
        return dtoHome;

    }

}
