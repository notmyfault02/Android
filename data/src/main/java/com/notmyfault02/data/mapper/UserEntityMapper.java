package com.notmyfault02.data.mapper;

import com.newgram.domain.entity.UserEntity;
import com.notmyfault02.data.entity.UserData;

public class UserEntityMapper {

    public static UserEntity mapToEntity(UserData data) {
        UserEntity entity = new UserEntity();
        entity.setName(data.getName());
        entity.setUrl(data.getUrl());
        entity.setLevel(data.getLevel());
        entity.setCoin(data.getCoin());
        entity.setExp(data.getExp());

        return entity;
    }
}
