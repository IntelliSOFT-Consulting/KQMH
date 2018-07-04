package com.kqmh.app.kqmh.Models;

import com.kqmh.app.kqmh.AppDatabase;
import com.kqmh.app.kqmh.Forms.Dimension1;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = AppDatabase.class, name = "scoreOptions")
    public class ScoreTypeOptions extends BaseModel {
        public ScoreTypeOptions(Dimension1 dimension1, int simple_spinner_dropdown_item, List<ScoreTypeOptions> categoryScores) {

        }

        @Column
        @PrimaryKey
        private String id;

        @Column
        private String displayName;


        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        public String getName() {
            return this.displayName;
        }
    }
