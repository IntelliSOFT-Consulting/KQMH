package com.kqmh.app.kqmh.Forms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.JsonObjectRequest;
import com.google.gson.Gson;
import com.kqmh.app.kqmh.Models.AssesmentCombo;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.SessionManager;
import com.kqmh.app.kqmh.Utils.AuthBuilder;
import com.kqmh.app.kqmh.Utils.UrlConstants;
import com.kqmh.app.kqmh.Utils.VolleySingleton;
import com.kqmh.app.kqmh.Models.KeyValue;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assessment_Info extends AppCompatActivity {

    private Spinner spinner_orgUnit;
    private Spinner spinner_assessType;
    private Spinner spinner_period;
    private Spinner spinner_facilityLevel;
    private ProgressDialog progressDialog;
    List<AssesmentCombo> categoryOptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_assessment_info);
        CookieManager cookieManager = new CookieManager();
        CookieHandler.setDefault(cookieManager);
        spinner_orgUnit = findViewById(R.id.spinner_orgUnit);
        spinner_assessType = findViewById(R.id.spinner_assessmentType);
        spinner_period = findViewById(R.id.spinner_period);
        spinner_facilityLevel = findViewById(R.id.spinner_facilityLevel);

        spinnerData_orgUnit(spinner_orgUnit, "1");

        spinnerData_period(spinner_period, "1");
        spinnerData_facilityLevel(spinner_facilityLevel, "1");


        Button dataEntry = findViewById(R.id.bt_dataEntry);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("loading form...");
        progressDialog.setCancelable(false);
        dataEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });
        SessionManager sessionManager = new SessionManager(getBaseContext());
        try {
            getAssessmentType(AuthBuilder.encode(sessionManager.getUserName(), sessionManager.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void spinnerData_orgUnit(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "Bondo District Hospital"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if (choice.matches("1")) {
                    //occupation = value.getId();
                } else if (choice.matches("2")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void spinnerData_assessType(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();
        List<AssesmentCombo> assesmentComboList = SQLite.select().from(AssesmentCombo.class).queryList();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "Self Assessment"));
        keyvalue.add(new KeyValue(2, "External Assessment"));
        keyvalue.add(new KeyValue(3, "CHMT Assessment"));


        //fill data in spinner
        ArrayAdapter<AssesmentCombo> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, assesmentComboList);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if (choice.matches("1")) {
                    //occupation = value.getId();
                } else if (choice.matches("2")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void spinnerData_period(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "April - June 2018"));
        keyvalue.add(new KeyValue(2, "January - March 2018"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if (choice.matches("1")) {
                    //occupation = value.getId();
                } else if (choice.matches("2")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void spinnerData_facilityLevel(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "level 6"));
        keyvalue.add(new KeyValue(2, "level 5"));
        keyvalue.add(new KeyValue(3, "level 4 with dialysis"));
        keyvalue.add(new KeyValue(4, "level 4"));
        keyvalue.add(new KeyValue(5, "level 3"));
        keyvalue.add(new KeyValue(6, "level 2"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                KeyValue value = (KeyValue) parent.getSelectedItem();
                if (choice.matches("1")) {
                    //occupation = value.getId();
                } else if (choice.matches("2")) {
                    //occupation = value.getId();
                }
                //updateValues();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void submit() {
        closeProgressbar();
        new SessionManager(getBaseContext()).setLoggedIn(true);
        Intent intent = new Intent(getBaseContext(), Dimensions_List.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void closeProgressbar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private void getAssessmentType(final String encoded) {
        Log.d("Auth", encoded);
        progressDialog.show();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, UrlConstants.ASSESSMENT_TYPE_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d("assessment type", response.toString());
                try {
                    JSONArray jsonArray = response.getJSONArray("categoryOptionCombos");
                    Gson gson = new Gson();
                    for (int i = 0; i < jsonArray.length(); i++) {
                        AssesmentCombo combo = gson.fromJson(jsonArray.getJSONObject(i).toString(), AssesmentCombo.class);
                        FlowManager.getModelAdapter(AssesmentCombo.class).save(combo);
                    }
                    closeProgressbar();
                    spinnerData_assessType(spinner_assessType, "1");
                } catch (JSONException e) {
                    e.printStackTrace();
                    closeProgressbar();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                closeProgressbar();
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> headers = new HashMap<>();
                //headers.put("Content-Type","application/json");
                Log.d("Encoded", encoded);
                headers.put("Authorization", encoded);
                return headers;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(jsonObjectRequest);
    }
}