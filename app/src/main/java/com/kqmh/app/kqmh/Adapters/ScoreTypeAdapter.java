package com.kqmh.app.kqmh.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.kqmh.app.kqmh.Models.ScoreTypeOptions;

import java.util.ArrayList;
import java.util.List;

public class ScoreTypeAdapter extends ArrayAdapter<ScoreTypeOptions>{
    private Context context;
    private List<ScoreTypeOptions> scoreOptions = new ArrayList<>();

    public ScoreTypeAdapter(@NonNull Context context, int resource, List<ScoreTypeOptions> ScoreTypeOptions) {
        super(context, resource);
        this.scoreOptions = ScoreTypeOptions;
    }

    @Override
    public int getCount() {
        return scoreOptions.size();
    }

    @Override
    public ScoreTypeOptions getItem(int position) {
        return scoreOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        CheckedTextView label = (CheckedTextView) super.getView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(scoreOptions.get(position).getDisplayName());

        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,@NonNull ViewGroup parent) {
        TextView label = (TextView) super.getDropDownView(position, convertView, parent);
        label.setTextColor(Color.BLACK);
        label.setText(scoreOptions.get(position).getDisplayName());

        return label;
    }
}