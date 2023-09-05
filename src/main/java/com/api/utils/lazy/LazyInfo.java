/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils.lazy;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author edisson.tapia
 */
public class LazyInfo implements Serializable {

    @SerializedName("count")
    private boolean count = false;
    @SerializedName("pagesize")
    private int pagesize;
    @SerializedName("first")
    private int first;
    @SerializedName("sortBy")
    private Map<String, LazySortMeta> sortBy = new HashMap<>();
    @SerializedName("filterBy")
    private Map<String, LazyFilterMeta> filterBy = new HashMap<>();

    
    public static LazyInfo count(){
        LazyInfo obj = new LazyInfo();
        obj.setCount(true);
        return obj;
    }
    public boolean isCount() {
        return count;
    }

    public void setCount(boolean count) {
        this.count = count;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public Map<String, LazySortMeta> getSortBy() {
        return sortBy;
    }

    public void setSortBy(Map<String, LazySortMeta> sortBy) {
        this.sortBy = sortBy;
    }

    public Map<String, LazyFilterMeta> getFilterBy() {
        return filterBy;
    }

    public void setFilterBy(Map<String, LazyFilterMeta> filterBy) {
        this.filterBy = filterBy;
    }

}
