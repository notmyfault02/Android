package com.example.sketch_chain.ui.showroom;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.annotation.NonNull;

import com.newgram.domain.usecase.GetRoomListUseCase;

public class ShowRoomViewModel extends AndroidViewModel {
    private GetRoomListUseCase getRoomListUseCase;

    public ShowRoomViewModel(@NonNull Application application) {
        super(application);
    }

    public void setGetRoomListUseCase(GetRoomListUseCase getRoomListUseCase) {
        this.getRoomListUseCase = getRoomListUseCase;
    }
}
