package com.example.sketch_chain.ui;

import android.util.Log;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketApplication {
    private Socket socket;
    {
        try {
            socket = IO.socket("https://");
        }catch (URISyntaxException e) {
            Log.e("socket uri", e.getLocalizedMessage());
        }
    }

    public Socket getSocket() {
        return socket;
    }

}
