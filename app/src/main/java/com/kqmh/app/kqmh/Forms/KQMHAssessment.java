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

public class KQMHAssessment extends AppCompatActivity {

    private Spinner spinner_scores;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_kqmhassessment);

        spinner_scores = findViewById(R.id.spinner_scores);

        spinnerData(spinner_scores,"1");

        Button nextStd = findViewById(R.id.btn_next);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("loading form...");
        progressDialog.setCancelable(false);
        nextStd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

    }

    public void spinnerData(Spinner spinner, final String choice) {
        ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(1, "Select"));
        keyvalue.add(new KeyValue(2, "yes"));
        keyvalue.add(new KeyValue(3, "no"));
        keyvalue.add(new KeyValue(4, "partial"));
        keyvalue.add(new KeyValue(5, "N/A"));

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