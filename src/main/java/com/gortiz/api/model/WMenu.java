/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public class WMenu {

    private int menId;
    private String nombre;
    private String descripcion;
    private String url;
    private String icono;
    private int estado;
    private String tipo;
    private String aplicacion;
    private String usuarioCrea;
    private Date fechaCrea;
    private int orden;
    private String urlAdicional;
    private String subsistema;
    private WMenu wMenu;
    private List<WMenu> listWMenu = new ArrayList<>();
    private List<WMenuConexion> listWMenuConexion = new ArrayList<>();

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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAplicacion() {
        return aplicacion;
    }

    public void setAplicacion(String aplicacion) {
        this.aplicacion = aplicacion;
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

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public String getUrlAdicional() {
        return urlAdicional;
    }

    public void setUrlAdicional(String urlAdicional) {
        this.urlAdicional = urlAdicional;
    }

    public String getSubsistema() {
        return subsistema;
    }

    public void setSubsistema(String subsistema) {
        this.subsistema = subsistema;
    }

    public WMenu getwMenu() {
        return wMenu;
    }

    public void setwMenu(WMenu wMenu) {
        this.wMenu = wMenu;
    }

    public List<WMenu> getListWMenu() {
        return listWMenu;
    }

    public void setListWMenu(List<WMenu> listWMenu) {
        this.listWMenu = listWMenu;
    }

    public List<WMenuConexion> getListWMenuConexion() {
        return listWMenuConexion;
    }

    public void setListWMenuConexion(List<WMenuConexion> listWMenuConexion) {
        this.listWMenuConexion = listWMenuConexion;
    }

}
