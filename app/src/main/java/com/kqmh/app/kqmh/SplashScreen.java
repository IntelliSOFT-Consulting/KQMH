package com.kqmh.app.kqmh;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.kqmh.app.kqmh.Activities.MainActivity;
import com.kqmh.app.kqmh.Activities.WelcomeActivity;
import com.kqmh.app.kqmh.Utils.UrlConstants;
import com.kqmh.app.kqmh.Utils.VolleySingleton;
import com.kqmh.app.kqmh.Utils.AppConstants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Date;

/**
 * Created by ekirapa on 4/17/18.
 * Splashscreen class
 */

public class SplashScreen extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        progressBar = findViewById(R.id.progressbar);
        try {
            getToken();
        } catch (JSONException e) {
            e.printStackTrace();
            finishSplash();
        }
    }

    private void getToken() throws JSONException {
        final SessionManager sessionManager = new SessionManager(getBaseContext());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username", AppConstants.AUTH_EMAIL);
        jsonObject.put("client_id", AppConstants.CLIENT_ID);
        jsonObject.put("password", AppConstants.AUTH_PASSWORD);
        jsonObject.put("client_secret", AppConstants.CLIENT_SECRET);
        jsonObject.put("grant_type", AppConstants.GRANT_TYPE);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, UrlConstants.TOKEN_URL, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response.has("access_token")) {
                    try {
                        String token = response.getString("access_token");
                        sessionManager.setKeyBearerToken(token);
                        Log.d("token", token);
                        String refreshToken = response.getString("refresh_token");
                        sessionManager.setKeyRefreshToken(refreshToken);
                        sessionManager.setDateTokenRefreshed(new Date().toString());


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    finishSplash();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                finishSplash();
            }
        });
        VolleySingleton.getInstance(getBaseContext()).addToRequestQueue(jsonObjectRequest);
    }

    private void finishSplash() {
        if (progressBar != null) progressBar.setVisibility(View.GONE);
        if (new SessionManager(getBaseContext()).iisLoggedIn()) {
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else {
            Intent intent = new Intent(getBaseContext(), WelcomeActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                    | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }
}
