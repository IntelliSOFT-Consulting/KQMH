package com.kqmh.app.kqmh.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.request.JsonRequest;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.Utils.UrlConstants;

import org.json.JSONObject;


public class Login extends AppCompatActivity {
    private EditText email, password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button submit = findViewById(R.id.bt_login);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check()) {
                    login(null);
                }
            }
        });
    }

    private boolean check() {
        if (email.getText().toString().isEmpty()) {
            email.setError(getString(R.string.error_email_required));
            return false;
        } else if (email.getText().toString().isEmpty()) {
            password.setError(getString(R.string.error_password_required));
            return false;
        }
        return true;
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
