package com.kqmh.app.kqmh.Utils;

import android.util.Base64;
import android.util.Log;

import java.util.Arrays;


public class AuthBuilder {
    private static String username;
    private static String password;


    public AuthBuilder(String username, String password) {
        AuthBuilder.username = username;
        AuthBuilder.password = password;
    }

    public static String encode( String username, String password ) throws Exception
    {
        String encodeValue = username + ":" + password;
        String auth = "Basic " + Base64.encode(encodeValue.getBytes(), Base64.NO_WRAP);

        Log.d("encoded", auth);
        return  auth ;
    }


}
