package com.example.sketch_chain.di.module;

import com.newgram.domain.repository.RoomRepository;
import com.newgram.domain.usecase.GetRoomListUseCase;

import dagger.Module;
import dagger.Provides;

@Module
public class UseCaseModule {

    @Provides
    GetRoomListUseCase provideGetRoomListUseCase(RoomRepository roomRepository) {
        return new GetRoomListUseCase(roomRepository);
    }
}
