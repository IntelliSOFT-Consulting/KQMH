package com.kqmh.app.kqmh.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.kqmh.app.kqmh.Models.AssessmentTypeCombo;

import java.util.ArrayList;
import java.util.List;


public class AssessmentTypeAdapter extends ArrayAdapter<AssessmentTypeCombo> {
    private Context context;
    private List<AssessmentTypeCombo> assessmentCombos = new ArrayList<>();

    public AssessmentTypeAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    public AssessmentTypeAdapter(@NonNull Context context, int resource, List<AssessmentTypeCombo> assessmentTypeCombos) {
        super(context, resource);
        this.assessmentCombos = assessmentTypeCombos;
    }

    @Override
    public int getCount() {
        return assessmentCombos.size();
    }

    @Override
    public AssessmentTypeCombo getItem(int position) {
        return assessmentCombos.get(position);
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
        label.setText(assessmentCombos.get(position).getDisplayName());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                @NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(assessmentCombos.get(position).getDisplayName());

        return label;
    }
}