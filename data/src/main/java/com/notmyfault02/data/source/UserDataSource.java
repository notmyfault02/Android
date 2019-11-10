package com.notmyfault02.data.source;

import com.notmyfault02.data.entity.UserData;

import java.util.List;

import io.reactivex.Flowable;

public interface UserDataSource {

    public Flowable<UserData> getUser();

    public Flowable<List<UserData>> getRanking();
}
