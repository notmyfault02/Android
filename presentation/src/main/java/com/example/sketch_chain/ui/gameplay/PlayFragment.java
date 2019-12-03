package com.example.sketch_chain.ui.gameplay;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.sketch_chain.R;
import com.example.sketch_chain.entity.Message;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PlayFragment extends Fragment {

    public FrameLayout frameLayout;
    private DrawView drawView;
    public AutoDrawView autoDrawView;
    private TextView explainTv;
    private TextView roundTv;

    private static int TIME = 60;
    private static int ROUND = 3;

    private int timerCount = TIME;
    private int roundCount = 1;

    ArrayList<Point> points = new ArrayList<>();

    class Point {
        float x;
        float y;
        boolean check;
        int color;

        public Point(float x, float y, boolean check, int color) {
            this.x = x;
            this.y = y;
            this.check = check;
            this.color = color;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_play, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        explainTv = getActivity().findViewById(R.id.play_explain_tv);
        roundTv = getActivity().findViewById(R.id.play_round_tv);

        drawView = new DrawView(getContext());
        autoDrawView = ((InGameActivity)getActivity()).view;
        start();
        frameLayout = (FrameLayout) getView().findViewById(R.id.play_draw_frame);

        if (((InGameActivity) getActivity()).prefHelper.getName().equals(((InGameActivity) getActivity()).roomInfo.getLeaderName())) {
            frameLayout.addView(drawView);
            explainTv.setText(getString(R.string.play_explain));
            //roundTv.setText("1");
            WordDialogFragment wordDialogFragment = WordDialogFragment.getInstance();
            wordDialogFragment.show(getFragmentManager(), WordDialogFragment.TAG_EVENT_DIALOG);
        }
        else {
            frameLayout.addView(autoDrawView);
            explainTv.setText(getString(R.string.answer_explain));
            //roundTv.setText("1");
        }

    }

    private void start() {
        JSONObject userMessage = new JSONObject();
        try {
            userMessage.put("chatRoomId", ((InGameActivity) getActivity()).getIntent().getStringExtra("roomName"));
            userMessage.put("type", "START");
            userMessage.put("writer", ((InGameActivity) getActivity()).prefHelper.getName());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ((InGameActivity) getActivity()).mWebSocketClient.send(userMessage.toString());
    }

    public void selectTurn(Message message) {
        frameLayout.removeAllViews();
        if(message.getWriter().equals(((InGameActivity)getContext()).prefHelper.getName())) {
            frameLayout.removeAllViews();
            frameLayout.addView(drawView);
            explainTv.setText(getString(R.string.play_explain));
//            roundTv.setText(roundCount);
//            roundCount++;
            WordDialogFragment wordDialogFragment = WordDialogFragment.getInstance();
            wordDialogFragment.show(getFragmentManager(), WordDialogFragment.TAG_EVENT_DIALOG);
            explainTv.setText("그림을 그려주세요");
        }else {
            frameLayout.removeAllViews();
            frameLayout.addView(autoDrawView);
            explainTv.setText(getString(R.string.answer_explain));
        }

//        if(roundCount > ROUND) {
//            getActivity().finish();
//        }
    }


}
