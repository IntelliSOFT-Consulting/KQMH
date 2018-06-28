package com.kqmh.app.kqmh.Models;

import com.kqmh.app.kqmh.AppDatabase;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by ekirapa on 6/28/18 .
 */

@Table(database = AppDatabase.class, name = "assesmentOptions")
public class AssesmentCombo extends BaseModel {
    public AssesmentCombo() {

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
