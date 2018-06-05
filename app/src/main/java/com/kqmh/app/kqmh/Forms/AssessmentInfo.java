package com.kqmh.app.kqmh.Forms;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.SessionManager;
import com.kqmh.app.kqmh.models.KeyValue;

import java.util.ArrayList;

public class AssessmentInfo extends AppCompatActivity {

    private Spinner spinner_orgUnit;
    private Spinner spinner_assessType;
    private Spinner spinner_period;
    private Spinner spinner_facilityLevel;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_assessmentinfo);

        spinner_orgUnit = findViewById(R.id.spinner_orgUnit);
        spinner_assessType = findViewById(R.id.spinner_assessType);
        spinner_period = findViewById(R.id.spinner_period);
        spinner_facilityLevel = findViewById(R.id.spinner_facilityLevel);

        spinnerData(spinner_orgUnit,"1");
        spinnerData(spinner_assessType,"1");
        spinnerData(spinner_period,"1");
        spinnerData(spinner_facilityLevel,"1");


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

    }


    public void spinnerData(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "a"));
        keyvalue.add(new KeyValue(2, "b"));
        keyvalue.add(new KeyValue(3, "c"));
        keyvalue.add(new KeyValue(4, "d"));


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
        Intent intent = new Intent(getBaseContext(), Dimensions.class);
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