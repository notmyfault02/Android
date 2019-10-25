package com.newgram.domain.base;

import io.reactivex.Flowable;

public abstract class UseCase<T, E> {
    public abstract Flowable<E> createSingle(T data);
}
