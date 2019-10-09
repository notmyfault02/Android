package com.newgram.domain.repository;

import com.newgram.domain.entity.RoomEntity;

import java.util.List;

public interface RoomRepository {
    List<RoomEntity> getRoomList();
    
}
