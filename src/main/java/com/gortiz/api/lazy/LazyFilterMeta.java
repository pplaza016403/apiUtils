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
public class LazyFilterMeta implements Serializable {

    @SerializedName("column")
    private String column;
    @SerializedName("filterByValueExpression")
    private String filterByValueExpression;

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public String getFilterByValueExpression() {
        return filterByValueExpression;
    }

    public void setFilterByValueExpression(String filterByValueExpression) {
        this.filterByValueExpression = filterByValueExpression;
    }

}
