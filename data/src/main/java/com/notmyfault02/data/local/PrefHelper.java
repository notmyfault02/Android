package com.notmyfault02.data.local;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefHelper {
    private static final String TAG = PrefHelper.class.getSimpleName();

    private static String PREF_NAME = "com.example.sketch_chain";
    private static String TOKEN = "ACCESS_TOKEN";
    private SharedPreferences sharePreference;

    private static PrefHelper prefHelper;
    public synchronized static PrefHelper getInstance(){
        if(prefHelper == null) {
            prefHelper = new PrefHelper();
        }
        return prefHelper;
    }

    public void init(Context context) {
        sharePreference = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public String getToken() {
        return sharePreference.getString(TOKEN, "");
    }

    public void setToken(String token) {
        SharedPreferences.Editor editor = sharePreference.edit();
        editor.putString(TOKEN, token).commit();
    }

    public void deleteToken() {
        sharePreference.edit().remove(TOKEN).apply();
        SharedPreferences.Editor editor = sharePreference.edit();
        editor.remove(TOKEN).commit();
    }
}
