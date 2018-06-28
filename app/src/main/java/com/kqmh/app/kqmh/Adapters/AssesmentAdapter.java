package com.kqmh.app.kqmh.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.kqmh.app.kqmh.Models.AssesmentCombo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ekirapa on 6/28/18 .
 */
public class AssesmentAdapter extends ArrayAdapter<AssesmentCombo> {
    private Context context;
    private List<AssesmentCombo> assesmentCombos = new ArrayList<>();

    public AssesmentAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public AssesmentAdapter(@NonNull Context context, int resource, List<AssesmentCombo> assesmentCombos) {
        super(context, resource);
        this.assesmentCombos = assesmentCombos;
    }

    @Override
    public int getCount() {
        return assesmentCombos.size();
    }

    @Override
    public AssesmentCombo getItem(int position) {
        return assesmentCombos.get(position);
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
        label.setText(assesmentCombos.get(position).getDisplayName());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(assesmentCombos.get(position).getDisplayName());

        return label;
    }
}