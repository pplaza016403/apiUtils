/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

/**
 * Mensajes de respuesta GO CORP. Tabla origen JDBA T_STATUS_RESPONSE
 *
 * @author christian
 *
 */
public enum ParametersApi {

    SERVER_ERROR(0, "Error en el servidor"),
    SUCCESSFUL(1, "Exito"),
    EMPTY_RECORD(2, "Sin registros que mostrar"),
    PROCESS_NOT_COMPLETED(3, "Tarea o proceso no completada"),
    EXCEPCION_CONTROLADA(4, "Excepción Controlada"),
    ANULADO(9, "Registro anulado");

    private final int value;

    private final String reasonPhrase;

    ParametersApi(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public int value() {
        return this.value;
    }

    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    /**
     * Return a string representation of this status code.
     */
    @Override
    public String toString() {
        return this.value + " " + name();
    }

    public static ParametersApi valueOf(int statusCode) {
        ParametersApi status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        }
        return status;
    }

    public static ParametersApi resolve(int statusCode) {
        for (ParametersApi status : values()) {
            if (status.value == statusCode) {
                return status;
            }
        }
        return null;
    }

}
