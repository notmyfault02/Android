package com.notmyfault02.data.repository;

import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;
import com.notmyfault02.data.entity.RoomData;
import com.notmyfault02.data.mapper.RoomEntityMapper;
import com.notmyfault02.data.source.RoomDataSource;

import java.util.ArrayList;

import io.reactivex.Flowable;
import retrofit2.Response;

public class RoomRepositoryImpl implements RoomRepository {

    private RoomDataSource dataSource;

    @Override
    public Flowable<ArrayList<RoomEntity>> getRoomList() {

        return dataSource.getRoomList().map(roomData -> {
            ArrayList<RoomEntity> roomDataList = new ArrayList<RoomEntity>();
            for(RoomData data: roomData) {
                roomDataList.add(RoomEntityMapper.mapToEntity(data));
            }
            return roomDataList;
            }
        );
    }

    @Override
    public Flowable<RoomEntity> inGame() {
        return null;
    }

    @Override
    public Flowable<Response<Object>> makeRoom(RoomEntity data) {
        return null;
        //return dataSource.makeRoom().map(data -> RoomEntityMapper.mapToEntity(data));
    }

    @Override
    public Flowable<RoomEntity> getSearchRoom(String query) {
        return dataSource.getSearchRoom(query).map(data -> RoomEntityMapper.mapToEntity(data));
    }
}
