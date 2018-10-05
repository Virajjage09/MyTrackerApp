package com.codervj.mytrackerapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.codervj.mytrackerapp.constants.AppConstants;


public class MySharedPreference {

    private static MySharedPreference instance;
    private static SharedPreferences mySharedPreferences;

    public static final String EMAIL_ID = "email_id";


    private MySharedPreference(Context context) {
        mySharedPreferences = context.getSharedPreferences(AppConstants.MY_SHARED_PREFS, Context.MODE_PRIVATE);
    }


    public static MySharedPreference getInstance(Context context) {

        if (instance == null) {
            // Create the instance
            instance = new MySharedPreference(context);
            return instance;
        } else {
            return instance;
        }
    }

    public void storeString(String key, String value) {
        SharedPreferences.Editor edit = mySharedPreferences.edit();
        edit.putString(key, value);
        edit.apply();
    }

    public String getString(String key) {
        if (mySharedPreferences.contains(key)) {
            return mySharedPreferences.getString(key, null);
        } else {
            return "";
        }
    }


}
