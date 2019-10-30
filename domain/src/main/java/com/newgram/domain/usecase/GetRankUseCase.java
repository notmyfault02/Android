package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.UserEntity;
import com.newgram.domain.repository.UserRepository;

import java.util.List;

import io.reactivex.Flowable;

public class GetRankUseCase extends UseCase<Object, List<UserEntity>> {

    private UserRepository repository;

    public GetRankUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<List<UserEntity>> createSingle(Object data) {
        return repository.getRanking();
    }

    private Flowable<List<UserEntity>> getRanking() {
        return createSingle(new Object());
    }
}
