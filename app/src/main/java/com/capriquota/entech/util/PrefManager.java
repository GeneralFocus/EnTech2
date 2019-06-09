package com.capriquota.entech.util;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "entech";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String ACCESS_TOKEN = "access_token";

    private static final String REFRESH_TOKEN = "refresh_token";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    //Shared Preference for Token
    public void saveAccessToken(String token) {
        editor.putString(ACCESS_TOKEN, token).commit();
    }

    public String getAccessToken() {
        return pref.getString(ACCESS_TOKEN, null);
    }

    //Shared Preference for Refresh Token
    public void saveRefreshToken(String token) {
        editor.putString(REFRESH_TOKEN, token).commit();
    }

    public String getRefreshToken() {
        return pref.getString(REFRESH_TOKEN, null);
    }
}
