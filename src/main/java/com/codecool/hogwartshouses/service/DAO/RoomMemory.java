package com.codecool.hogwartshouses.service.DAO;

import com.codecool.hogwartshouses.model.RoomModel;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class RoomMemory implements RoomDAO {

    private Set<RoomModel> roomModels;

    public RoomMemory(Set<RoomModel> roomModels) {
        this.roomModels = roomModels;
    }
}
