package com.gortiz.api;

import static com.gortiz.api.ApiTemplate.GSON;
import com.gortiz.api.model.TWebService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author edisson.tapia
 */
public class MenusApi extends ApiTemplate {

    public MenusApi(WebServiceResolver resolver) {
        this.resolver = resolver;
    }

    public List<Menu> obtenerMenusUsuario(String usuario, String aplicacion) throws Exception {
        GenericResponse<String> requestJson = new GenericResponse<>();
        TWebService ws = resolver.getWebService("LISTAR MENU POR USUARIO");
        Map<String, String> params = new HashMap<>();
        param(params, "userId", usuario);
        param(params, "app", aplicacion);
        if (!params.isEmpty()) {
            requestJson.setObject(UtilsApi.GSON.toJson(params));
        }
        String responseJson = consumirApiRestRaw(ws, null, params);
        GenericResponse<List<Menu>> gr = responseJson == null ? null : GSON.fromJson(responseJson, new com.google.gson.reflect.TypeToken<GenericResponse<List<Menu>>>() {
        }.getType());
        return gr.getObject();
    }

    public List<Object[]> findMenuBasesAsignadas(String usuario, int menId) throws Exception {
        GenericResponse<String> requestJson = new GenericResponse<>();
        TWebService ws = resolver.getWebService("LISTAR MENU POR USUARIO");
        Map<String, String> params = new HashMap<>();
        param(params, "usuId", usuario);
        param(params, "menId", String.valueOf(menId));
        if (!params.isEmpty()) {
            requestJson.setObject(UtilsApi.GSON.toJson(params));
        }
        String responseJson = consumirApiRestRaw(ws, null, params);
        GenericResponse<List<Object[]>> gr = responseJson == null ? null : GSON.fromJson(responseJson, new com.google.gson.reflect.TypeToken<GenericResponse<List<Object[]>>>() {
        }.getType());
        return gr.getObject();
    }

}
