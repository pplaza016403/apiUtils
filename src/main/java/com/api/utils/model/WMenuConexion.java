/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public class WMenuConexion {

    private int mcId;
    private int cnxId;
    private int acceso;
    private WMenu wMenu;
    private List<WUsuarioMenu> listWUsuarioMenu = new ArrayList<WUsuarioMenu>();

    public int getMcId() {
        return mcId;
    }

    public void setMcId(int mcId) {
        this.mcId = mcId;
    }

    public int getCnxId() {
        return cnxId;
    }

    public void setCnxId(int cnxId) {
        this.cnxId = cnxId;
    }

    public int getAcceso() {
        return acceso;
    }

    public void setAcceso(int acceso) {
        this.acceso = acceso;
    }

    public WMenu getwMenu() {
        return wMenu;
    }

    public void setwMenu(WMenu wMenu) {
        this.wMenu = wMenu;
    }

    public List<WUsuarioMenu> getListWUsuarioMenu() {
        return listWUsuarioMenu;
    }

    public void setListWUsuarioMenu(List<WUsuarioMenu> listWUsuarioMenu) {
        this.listWUsuarioMenu = listWUsuarioMenu;
    }

}
