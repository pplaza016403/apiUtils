/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.utils;

import com.api.utils.model.TWebService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edisson.tapia
 * @param <T>
 */
public class MultiWs<T extends Object> {

    private List<TWebService> webServices = new ArrayList<>();
    private List<GoApiException> errores = new ArrayList<>();
    private int timeout = 30000;

    public MultiWs() {
    }

    public MultiWs(int timeout) {
        this.timeout = timeout;
    }

    public T process(TWebService ws) throws Exception {
        return null;
    }

    public List<T> execute() {
        List<T> resultado = new ArrayList<>();
        List<Thread> hilos = new ArrayList<>();
        for (final TWebService ws : webServices) {
            Thread hilo = new Thread() {
                @Override
                public void run() {
                    try {
                        T res = process(ws);
                        synchronized (resultado) {
                            resultado.add(res);
                        }
                    } catch (Exception e) {
                        GoApiException error = new GoApiException(e);
                        errores.add(error);
                    }
                }
            };
            hilos.add(hilo);
        }
        for (Thread hilo : hilos) {
            hilo.start();
        }
        for (Thread hilo : hilos) {
            try {
                hilo.join(timeout);
            } catch (Exception e) {
                GoApiException error = new GoApiException(e);
                errores.add(error);
            }
        }
        return resultado;
    }

    public List<TWebService> getWebServices() {
        return webServices;
    }

    public void setWebServices(List<TWebService> webServices) {
        this.webServices = webServices;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public List<GoApiException> getErrores() {
        return errores;
    }

    public void setErrores(List<GoApiException> errores) {
        this.errores = errores;
    }

}
