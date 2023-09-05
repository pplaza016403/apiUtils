/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

import static com.api.utils.ApiTemplate.GSON;
import com.api.utils.model.TWebService;
import com.api.utils.model.WUsuario;
import java.util.HashMap;
import java.util.Map;
import java.util.Base64;

/**
 *
 * @author edisson.tapia
 */
public class UsuariosApi extends ApiTemplate {

    public UsuariosApi(WebServiceResolver resolver) {
        this.resolver = resolver;
    }

    public WUsuario findUsuario(java.lang.String usuId) throws Exception {
        GenericResponse<String> requestJson = new GenericResponse<>();
        TWebService ws = resolver.getWebService("BUSCAR_USUARIO_WEB");
        Map<String, String> params = new HashMap<>();
        param(params, "usuId", usuId);
        if (!params.isEmpty()) {
            requestJson.setObject(UtilsApi.GSON.toJson(params));
        }
        GenericResponse responseJson = consumirApiRest(ws, null, params);
        System.out.println(UtilsApi.GSON.toJson(responseJson));
        validateResponse(responseJson, MenusApi.class.getName());
        String decodedString = new String(Base64.getDecoder().decode(responseJson.getObject().toString()));
        return responseJson.getObject() == null ? null : GSON.fromJson(decodedString, WUsuario.class);
    }
}
