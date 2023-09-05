/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api.model;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/**
 *
 * @author CFERNAND
 */
public class TWebService implements java.io.Serializable {

    @SerializedName("wsCodigo")
    private String wsCodigo;
    @SerializedName("fechaModifica")
    private Date fechaModifica;
    @SerializedName("ipModifica")
    private String ipModifica;
    @SerializedName("wsConnectTimeout")
    private Long wsConnectTimeout;
    @SerializedName("wsReadTimeout")
    private Long wsReadTimeout;
    @SerializedName("wsProyectoOrigen")
    private String wsProyectoOrigen;
    @SerializedName("wsDescripcion")
    private String wsDescripcion;
    @SerializedName("wsUrl")
    private String wsUrl;
    @SerializedName("wsContenytType")
    private String wsContenytType;
    @SerializedName("wsTipo")
    private String wsTipo;
    @SerializedName("wsMetodo")
    private String wsMetodo;
    @SerializedName("wsUsuario")
    private String wsUsuario;
    @SerializedName("wsClave")
    private String wsClave;
    @SerializedName("wsToken")
    private String wsToken;
    @SerializedName("wsEstado")
    private Integer wsEstado;
    @SerializedName("usuarioCrea")
    private String usuarioCrea;
    @SerializedName("fechaCrea")
    private Date fechaCrea;
    @SerializedName("ipCrea")
    private String ipCrea;
    @SerializedName("usuarioModifica")
    private String usuarioModifica;
    @SerializedName("serCodigo")
    private TServerConexion serCodigo;

    public String getWsCodigo() {
        return wsCodigo;
    }

    public void setWsCodigo(String wsCodigo) {
        this.wsCodigo = wsCodigo;
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

    public Long getWsConnectTimeout() {
        return wsConnectTimeout;
    }

    public void setWsConnectTimeout(Long wsConnectTimeout) {
        this.wsConnectTimeout = wsConnectTimeout;
    }

    public Long getWsReadTimeout() {
        return wsReadTimeout;
    }

    public void setWsReadTimeout(Long wsReadTimeout) {
        this.wsReadTimeout = wsReadTimeout;
    }

    public String getWsProyectoOrigen() {
        return wsProyectoOrigen;
    }

    public void setWsProyectoOrigen(String wsProyectoOrigen) {
        this.wsProyectoOrigen = wsProyectoOrigen;
    }

    public String getWsDescripcion() {
        return wsDescripcion;
    }

    public void setWsDescripcion(String wsDescripcion) {
        this.wsDescripcion = wsDescripcion;
    }

    public String getWsUrl() {
        return wsUrl;
    }

    public void setWsUrl(String wsUrl) {
        this.wsUrl = wsUrl;
    }

    public String getWsContenytType() {
        return wsContenytType;
    }

    public void setWsContenytType(String wsContenytType) {
        this.wsContenytType = wsContenytType;
    }

    public String getWsTipo() {
        return wsTipo;
    }

    public void setWsTipo(String wsTipo) {
        this.wsTipo = wsTipo;
    }

    public String getWsMetodo() {
        return wsMetodo;
    }

    public void setWsMetodo(String wsMetodo) {
        this.wsMetodo = wsMetodo;
    }

    public String getWsUsuario() {
        return wsUsuario;
    }

    public void setWsUsuario(String wsUsuario) {
        this.wsUsuario = wsUsuario;
    }

    public String getWsClave() {
        return wsClave;
    }

    public void setWsClave(String wsClave) {
        this.wsClave = wsClave;
    }

    public String getWsToken() {
        return wsToken;
    }

    public void setWsToken(String wsToken) {
        this.wsToken = wsToken;
    }

    public Integer getWsEstado() {
        return wsEstado;
    }

    public void setWsEstado(Integer wsEstado) {
        this.wsEstado = wsEstado;
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

    public TServerConexion getSerCodigo() {
        return serCodigo;
    }

    public void setSerCodigo(TServerConexion serCodigo) {
        this.serCodigo = serCodigo;
    }

}
