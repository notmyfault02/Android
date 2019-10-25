package com.notmyfault02.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelperImpl implements PrefHelper {

    private Context context;

    public PrefHelperImpl(Context context) {
        this.context = context;
    }

    static String PREF_NAME = "com.example.sketch_chain";
    static String TOKEN = "ACCESS_TOKEN";

    private SharedPreferences pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);

    @Override
    public String getToken() {
        return pref.getString("TOKEN", "");
    }

    @Override
    public void setToken(String token) {
        pref.edit().putString(TOKEN, token).apply();
    }

    @Override
    public void deleteToken() {
        pref.edit().remove(TOKEN).apply();
    }
}
