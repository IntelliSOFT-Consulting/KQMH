package com.kqmh.app.kqmh.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.request.JsonRequest;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.Utils.UrlConstants;

import org.json.JSONObject;

/**
 * Created by ekirapa on 5/22/18 .
 */

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    private void login(final String encoded) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, UrlConstants.LOGIN_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }
}
