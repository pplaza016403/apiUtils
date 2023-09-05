/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils.model;

/**
 *
 * @author edisson.tapia
 */
public class WUsuarioMenu {

    private int umId;
    private String usuId;
    private int nivelAcceso;
    private WMenuConexion wMenuConexion;

    public int getUmId() {
        return umId;
    }

    public void setUmId(int umId) {
        this.umId = umId;
    }

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public int getNivelAcceso() {
        return nivelAcceso;
    }

    public void setNivelAcceso(int nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    public WMenuConexion getwMenuConexion() {
        return wMenuConexion;
    }

    public void setwMenuConexion(WMenuConexion wMenuConexion) {
        this.wMenuConexion = wMenuConexion;
    }

}
