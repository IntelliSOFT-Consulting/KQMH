package com.kqmh.app.kqmh.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.android.volley.request.JsonRequest;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.SessionManager;
import com.kqmh.app.kqmh.Utils.UrlConstants;
import com.kqmh.app.kqmh.Utils.VolleySingleton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity {
    private EditText email, password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Logging in...");
        progressDialog.setCancelable(false);

    }

    private boolean check() {
        if (email.getText().toString().isEmpty()) {
            email.setError(getString(R.string.error_email_required));
            return false;
        } else if (password.getText().toString().isEmpty()) {
            password.setError(getString(R.string.error_password_required));
            return false;
        }
        return true;
    }

    private void login(final String encoded) {
        progressDialog.show();
        final SessionManager sessionManager = new SessionManager(getBaseContext());
        JSONObject jsonObject = new JSONObject();

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, UrlConstants.LOGIN_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response.has("success")) {
                    finishLogin();
                } else {
                    closeProgressbar();
                    Toast.makeText(Login.this, "Cannot Log in at this time", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                closeProgressbar();
                if (error instanceof AuthFailureError) {
                    Toast.makeText(Login.this, "Wrong email and password combination", Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(Login.this, "Cannot Log in at this time", Toast.LENGTH_SHORT).show();

            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                headers.put("Authorization", "Bearer " + sessionManager.getKeyBearerToken());
                return headers;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }


    public void Submit(View view) {
        if (check()) {
            login(email.getText().toString());
        }
    }

    private void finishLogin() {
        closeProgressbar();
        new SessionManager(getBaseContext()).setLoggedIn(true);
        Intent intent = new Intent(getBaseContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void closeProgressbar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }
}
