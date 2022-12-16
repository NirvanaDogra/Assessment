package com.example.full_stack_assessment.Data.Grid;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GridProperties {
    @SerializedName("gridId")
    @Expose
    private String gridID;

    @SerializedName("gridX")
    @Expose
    private int gridX;

    @SerializedName("gridY")
    @Expose
    private int gridY;

    public String getGridID() {
        return gridID;
    }

    public void setGridID(String gridID) {
        this.gridID = gridID;
    }

    public int getGridX() {
        return gridX;
    }

    public void setGridX(int gridX) {
        this.gridX = gridX;
    }

    public int getGridY() {
        return gridY;
    }

    public void setGridY(int gridY) {
        this.gridY = gridY;
    }
}
