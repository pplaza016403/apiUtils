/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api.lazy;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 *
 * @author edisson.tapia
 */
public class LazySortMeta implements Serializable {

    @SerializedName("sortField")
    private String sortField;
    @SerializedName("sortOrder")
    private String sortOrder;
    @SerializedName("sortFunction")
    private String sortFunction;
    @SerializedName("priority")
    private int priority = 0;

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSortFunction() {
        return sortFunction;
    }

    public void setSortFunction(String sortFunction) {
        this.sortFunction = sortFunction;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
