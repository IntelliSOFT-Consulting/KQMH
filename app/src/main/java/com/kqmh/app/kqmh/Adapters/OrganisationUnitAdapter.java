package com.kqmh.app.kqmh.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.kqmh.app.kqmh.Models.OrganisationUnit;


import java.util.ArrayList;
import java.util.List;


public class OrganisationUnitAdapter extends ArrayAdapter<OrganisationUnit> {
    private Context context;
    private List<OrganisationUnit> OrganisationUnit = new ArrayList<>();


    public OrganisationUnitAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public OrganisationUnitAdapter(@NonNull Context context, int resource, List<OrganisationUnit> OrganisationUnit) {
        super(context, resource);
        this.OrganisationUnit = OrganisationUnit;
    }

    @Override
    public int getCount() {
        return OrganisationUnit.size();
    }

    @Override
    public OrganisationUnit getItem(int position) {
        return OrganisationUnit.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
        CheckedTextView label = (CheckedTextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(OrganisationUnit.get(position).getDisplayName());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(OrganisationUnit.get(position).getDisplayName());

        return label;
    }

}
