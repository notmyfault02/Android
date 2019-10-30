package com.newgram.domain.usecase;

import com.newgram.domain.base.UseCase;
import com.newgram.domain.entity.UserEntity;
import com.newgram.domain.repository.UserRepository;

import io.reactivex.Flowable;

public class GetUserUseCase extends UseCase<Object, UserEntity> {

    private UserRepository repository;

    public GetUserUseCase(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flowable<UserEntity> createSingle(Object data) {
        return repository.getUser();
    }

    private Flowable<UserEntity> getUser() {
        return createSingle(new Object());
    }
}
