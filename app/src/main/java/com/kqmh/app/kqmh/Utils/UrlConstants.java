package com.kqmh.app.kqmh.Utils;


public class UrlConstants {
    private static final String IP = "https://kqmh.uonbi.ac.ke/";

    //Urls
    public static final String LOGIN_URL = IP + "api/me/user-account";
    public static final String TOKEN_URL = IP + "oauth/token";
    public static final String ORGANISATION_UNIT_URL = IP + "api/organisationUnits?page=[number]";
    public static final String ASSESSMENT_TYPE_URL = IP +  "api/categoryOptionCombos";


}
