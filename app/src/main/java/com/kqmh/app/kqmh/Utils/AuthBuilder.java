package com.kqmh.app.kqmh.Utils;


public class AuthBuilder {
    private static String username;
    private static  String password;

    public AuthBuilder(String username, String password) {
        AuthBuilder.username = username;
        AuthBuilder.password = password;
    }

    public static String buildAuthParams() {
        return username;
    }
}
