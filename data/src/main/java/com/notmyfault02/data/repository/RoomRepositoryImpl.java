package com.notmyfault02.data.repository;

import com.newgram.domain.entity.RoomEntity;
import com.newgram.domain.repository.RoomRepository;
import com.notmyfault02.data.mapper.RoomEntityMapper;
import com.notmyfault02.data.source.RoomDataSource;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.Response;

public class RoomRepositoryImpl implements RoomRepository {

    private RoomDataSource dataSource;
    private RoomEntityMapper mapper = new RoomEntityMapper();

    @Override
    public Flowable<List<RoomEntity>> getRoomList() {
        return null;
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
