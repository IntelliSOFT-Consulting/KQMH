package com.kqmh.app.kqmh.Forms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Spinner;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.kqmh.app.kqmh.Models.KeyValue;
import com.kqmh.app.kqmh.R;

import java.util.ArrayList;


public class Dimensions_List extends AppCompatActivity {
    private Spinner spinner_dim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_dimensions_list);

        spinner_dim = findViewById(R.id.spinner_dim);

        spinnerData_dim(spinner_dim,"1");
    }

    public void spinnerData_dim(Spinner spinner, final String choice) {
        final ArrayList<KeyValue> keyvalue = new ArrayList<>();

        // adding each child node to HashMap key => value
        keyvalue.add(new KeyValue(0, "Select"));
        keyvalue.add(new KeyValue(1, "Dim1: Leadership"));
        keyvalue.add(new KeyValue(2, "Dim2: HRM"));
        keyvalue.add(new KeyValue(3, "Dim3: Guidelines"));
        keyvalue.add(new KeyValue(4, "Dim4: Infrastructure"));
        keyvalue.add(new KeyValue(5, "Dim5: Supplies Management"));
        keyvalue.add(new KeyValue(6, "Dim6: Equipment Management"));
        keyvalue.add(new KeyValue(7, "Dim7: Transport Management"));
        keyvalue.add(new KeyValue(8, "Dim8: Referral System"));
        keyvalue.add(new KeyValue(9, "Dim9: HMIS"));
        keyvalue.add(new KeyValue(10, "Dim10: Financial Management"));
        keyvalue.add(new KeyValue(11, "Dim11: Services"));
        keyvalue.add(new KeyValue(12, "Dim12: Results"));


        //fill data in spinner
        ArrayAdapter<KeyValue> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, keyvalue);
        spinner.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        //occupationSpinner.setSelection(adapter.getPosition(keyvalue.get(2)));//Optional to set the selected item.

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        break;
                    case 1:
                        Intent intentDimension1 = new Intent(getBaseContext(), Dimension1.class);
                        intentDimension1.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentDimension1);
                            break;
                    case 2:
                        Intent intentDimension2 = new Intent(getBaseContext(), Dimension2.class);
                        intentDimension2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentDimension2);
                        break;
                    case 3:
                        Intent intentDimension3 = new Intent(getBaseContext(), Dimension3.class);
                        intentDimension3.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
                                | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intentDimension3);
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

}