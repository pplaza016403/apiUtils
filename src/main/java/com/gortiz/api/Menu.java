/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public class Menu {

    private int menId;
    private String nombre;
    private String descripcion;
    private String url;
    private String urlAdicional;
    private int orden;
    private String icono;
    private List<Menu> hijos = new ArrayList<>();

    public int getMenId() {
        return menId;
    }

    public void setMenId(int menId) {
        this.menId = menId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public List<Menu> getHijos() {
        return hijos;
    }

    public void setHijos(List<Menu> hijos) {
        this.hijos = hijos;
    }

    public String getUrlAdicional() {
        return urlAdicional;
    }

    public void setUrlAdicional(String urlAdicional) {
        this.urlAdicional = urlAdicional;
    }

}
