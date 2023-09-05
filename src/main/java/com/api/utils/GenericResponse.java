/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class GenericResponse<T> implements Serializable {

//	private static final Logger log = LoggerFactory.getLogger(GenericResponse.class);
    private static final long serialVersionUID = -3380247771926557748L;
    @SerializedName("token")
    private Integer token;
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("object")
    private T object;
    @SerializedName("rowCount")
    private int rowCount;

    public Integer getStatus() {
        if (status == null) {
            status = ParametersApi.SUCCESSFUL.value();
        }
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void setStatusException(ParametersApi status, Exception e) {
        this.status = status.value();
        if (message == null) {
            //TODO mejorar procesamiento de exception
            this.message = e == null ? "Error" : e.getLocalizedMessage();
            e.printStackTrace();
        }
    }

    public String getMessage() {
        if (message == null && status != null) {
            message = ParametersApi.resolve(status).getReasonPhrase();

        }
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Integer getToken() {
        return token;
    }

    public void setToken(Integer token) {
        this.token = token;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    @Override
    public String toString() {
        return "GenericResponse{" + "status=" + status + ", message=" + message + ", object=" + object + '}';
    }

}
