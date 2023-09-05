/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gortiz.api.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public class WUsuario implements Serializable {

    private String usuId;
    private String codCliente;
    private Integer sucursal;
    private String cedula;
    private String nombre;
    private Date lastLogin;
    private String estado;
    private Date fecCrea;
    private String usuaCrea;
    private String pass;
    private int resetPass;
    private String correo;
    private Integer agente;
    private Integer almuerzo;
    private List<WUsuarioMenu> listWUsuarioMenu = new ArrayList<>();

    public String getUsuId() {
        return usuId;
    }

    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public Integer getSucursal() {
        return sucursal;
    }

    public void setSucursal(Integer sucursal) {
        this.sucursal = sucursal;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecCrea() {
        return fecCrea;
    }

    public void setFecCrea(Date fecCrea) {
        this.fecCrea = fecCrea;
    }

    public String getUsuaCrea() {
        return usuaCrea;
    }

    public void setUsuaCrea(String usuaCrea) {
        this.usuaCrea = usuaCrea;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getResetPass() {
        return resetPass;
    }

    public void setResetPass(int resetPass) {
        this.resetPass = resetPass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Integer getAgente() {
        return agente;
    }

    public void setAgente(Integer agente) {
        this.agente = agente;
    }

    public Integer getAlmuerzo() {
        return almuerzo;
    }

    public void setAlmuerzo(Integer almuerzo) {
        this.almuerzo = almuerzo;
    }

    public List<WUsuarioMenu> getListWUsuarioMenu() {
        return listWUsuarioMenu;
    }

    public void setListWUsuarioMenu(List<WUsuarioMenu> listWUsuarioMenu) {
        this.listWUsuarioMenu = listWUsuarioMenu;
    }

}
