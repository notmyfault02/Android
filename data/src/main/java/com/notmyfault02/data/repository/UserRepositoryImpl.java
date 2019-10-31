package com.notmyfault02.data.repository;

import com.newgram.domain.entity.UserEntity;
import com.newgram.domain.repository.UserRepository;
import com.notmyfault02.data.mapper.UserEntityMapper;
import com.notmyfault02.data.source.UserDataSource;

import java.util.List;

import io.reactivex.Flowable;

public class UserRepositoryImpl implements UserRepository {

    private UserDataSource dataSource;

    @Override
    public Flowable<UserEntity> getUser() {
        return dataSource.getUser().map(data -> UserEntityMapper.mapToEntity(data));
    }

    @Override
    public Flowable<List<UserEntity>> getRanking() {
        return null;
    }
}
