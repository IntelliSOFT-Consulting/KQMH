package com.kqmh.app.kqmh.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.Adapters.BottomBarAdapter;
import com.kqmh.app.kqmh.Widgets.FragViewPager;


public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}
