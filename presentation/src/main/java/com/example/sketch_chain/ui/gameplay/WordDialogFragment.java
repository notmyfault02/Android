package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.sketch_chain.R;
import com.notmyfault02.data.local.PrefHelper;

import org.json.JSONException;
import org.json.JSONObject;

public class WordDialogFragment extends DialogFragment implements View.OnClickListener {
    private Button wordBtn;
    private EditText wordEt;

    private PrefHelper prefHelper;

    public static final String TAG_EVENT_DIALOG = "dialog_event";

    public static WordDialogFragment getInstance() {
        WordDialogFragment instance = new WordDialogFragment();
        return instance;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_word, container);
        Button btn = (Button) v.findViewById(R.id.word_confirm_btn);
        wordEt = (EditText) v.findViewById(R.id.word_et);
        prefHelper = PrefHelper.getInstance();
        btn.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        JSONObject word = new JSONObject();
        String whatWord = wordEt.getText().toString();
        try {
            word.put("chatRoomId", ((InGameActivity)getContext()).roomInfo.getTitle());
            word.put("type", "WORD");
            word.put("message", whatWord);
            word.put("writer", prefHelper.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((InGameActivity)getContext()).mWebSocketClient.send(word.toString());
        dismiss();
    }
}