package com.example.sketch_chain.ui;

import android.app.Application;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketApplication extends Application {

    private Socket socket;
    {
        try {
            socket = IO.socket("https://");
        }catch (URISyntaxException e) {
            //throw new RuntimeException(e);
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
