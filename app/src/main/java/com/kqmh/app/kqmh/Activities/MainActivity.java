package com.kqmh.app.kqmh.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.widget.TextView;
import com.kqmh.app.kqmh.R;
import com.kqmh.app.kqmh.Adapters.BottomBarAdapter;
import com.kqmh.app.kqmh.Widgets.FragViewPager;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomBarAdapter adapter;
    private boolean tabNotification1 = false;
    private boolean tabNotification2 = false;
    private boolean tabNotification3 = false;
    private FragViewPager viewPager;
    private int currentPosition = 0;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager.setPagingEnabled(false);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);


    }

    private void setupViewPager() {
        adapter = new BottomBarAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        currentPosition = 0;
    }

    private void closeProgressbar() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        setupViewPager();
    }
}
