/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

/**
 *
 * @author Edisson Tapia
 */
public class GoApiException extends Exception {

    private String server;
    private String titulo;
    private String mensaje;
    private Throwable causa;

    public GoApiException(String titulo, String mensaje, Exception ex) {
        super(ex);
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.causa = ex;
    }

    public GoApiException(Exception ex) {
        super(ex);
        this.titulo = ex.getMessage();
        this.mensaje = (ex.getCause() != null ? ex.getCause().getMessage() : "Error") + " <br>"
                + ex.getMessage();
        for (StackTraceElement fila : ex.getStackTrace()) {
            this.mensaje += "\n" + fila;
        }
        this.causa = ex;
    }

    public GoApiException(String mensaje) {
        this.titulo = "Error";
        this.mensaje = mensaje;
    }

    public GoApiException(String titulo, String mensaje) {
        super(mensaje);
        this.titulo = titulo;
        this.mensaje = mensaje;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Throwable getCausa() {
        return causa;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

}
