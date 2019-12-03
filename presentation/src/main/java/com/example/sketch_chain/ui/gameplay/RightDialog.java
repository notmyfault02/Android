package com.example.sketch_chain.ui.gameplay;

import android.app.Dialog;
import android.content.Context;
import android.widget.ImageView;

import com.example.sketch_chain.R;

public class RightDialog extends Dialog{
    ImageView img;
    public RightDialog(Context context){
        super(context);
        setContentView(R.layout.dialog_right);

    }
}
