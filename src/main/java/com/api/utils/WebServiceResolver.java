/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

import com.api.utils.model.TWebService;
import java.util.List;

/**
 *
 * @author edisson.tapia
 */
public interface WebServiceResolver {

    public TWebService getWebService(String nombre);

    public List<TWebService> listWebService(String nombre);
}
