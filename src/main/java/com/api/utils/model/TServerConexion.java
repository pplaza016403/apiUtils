/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ETAPIA
 */
public class TServerConexion implements java.io.Serializable {

    @SerializedName("serCodigo")
    private int serCodigo;
    @SerializedName("serDescripcion")
    private String serDescripcion;
    @SerializedName("serUrl")
    private String serUrl;
    @SerializedName("serEstado")
    private Integer serEstado;
    @SerializedName("usuarioCrea")
    private String usuarioCrea;
    @SerializedName("fechaCrea")
    private Date fechaCrea;
    @SerializedName("ipCrea")
    private String ipCrea;
    @SerializedName("usuarioModifica")
    private String usuarioModifica;
    @SerializedName("fechaModifica")
    private Date fechaModifica;
    @SerializedName("ipModifica")
    private String ipModifica;
    @SerializedName("listTWebService")
    private List<TWebService> listTWebService = new ArrayList<>();

    public int getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(int serCodigo) {
        this.serCodigo = serCodigo;
    }

    public String getSerDescripcion() {
        return serDescripcion;
    }

    public void setSerDescripcion(String serDescripcion) {
        this.serDescripcion = serDescripcion;
    }

    public String getSerUrl() {
        return serUrl;
    }

    public void setSerUrl(String serUrl) {
        this.serUrl = serUrl;
    }

    public Integer getSerEstado() {
        return serEstado;
    }

    public void setSerEstado(Integer serEstado) {
        this.serEstado = serEstado;
    }

    public String getUsuarioCrea() {
        return usuarioCrea;
    }

    public void setUsuarioCrea(String usuarioCrea) {
        this.usuarioCrea = usuarioCrea;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public String getIpCrea() {
        return ipCrea;
    }

    public void setIpCrea(String ipCrea) {
        this.ipCrea = ipCrea;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getIpModifica() {
        return ipModifica;
    }

    public void setIpModifica(String ipModifica) {
        this.ipModifica = ipModifica;
    }

    public List<TWebService> getListTWebService() {
        return listTWebService;
    }

    public void setListTWebService(List<TWebService> listTWebService) {
        this.listTWebService = listTWebService;
    }

}
