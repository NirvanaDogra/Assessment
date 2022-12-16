package com.example.full_stack_assessment.Data.Grid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GridCall {
    @SerializedName("properties")
    @Expose
    private GridProperties gridProperties;

    public GridProperties getGridProperties() {
        return gridProperties;
    }

    public void setGridProperties(GridProperties gridProperties) {
        this.gridProperties = gridProperties;
    }
}
