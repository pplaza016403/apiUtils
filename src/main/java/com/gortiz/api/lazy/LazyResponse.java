/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api.lazy;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public class LazyResponse<T> {

    @SerializedName("rowCount")
    private int rowCount = 0;
    @SerializedName("data")
    private List<T> data;

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

}
