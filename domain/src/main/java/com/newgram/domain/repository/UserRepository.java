package com.newgram.domain.repository;

import com.newgram.domain.entity.UserEntity;

import java.util.List;

import io.reactivex.Flowable;

public interface UserRepository {
    Flowable<UserEntity> getUser();

    Flowable<List<UserEntity>> getRanking();
}
