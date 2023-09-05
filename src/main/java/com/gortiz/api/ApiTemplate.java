package com.gortiz.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.gortiz.api.model.TWebService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Map;
import okhttp3.MediaType;
import org.apache.commons.net.util.Base64;

/**
 *
 * @author edisson
 */
public class ApiTemplate {

    protected WebServiceResolver resolver = null;

    protected static final int REST_TIMEOUT = 90;
    protected final DecimalFormat gsonNumberPattern = new DecimalFormat("############0.##########");
    protected final SimpleDateFormat gsonDatePattern = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final Gson GSON;
    protected final MediaType json = MediaType.get("application/json; charset=utf-8");

    public static final String UTF_DEFAULT = "utf-8";
    public static final String RESP_POST = "POST";
    public static final String RESP_GET = "GET";
    public static final String RESP_PUT = "PUT";

    public static final String TIPOAUTENTICACION = "Basic";

    public static final String PERSONA_RELACIONADA = "BP01";

    public static final String ERROR_CONEXION_WS = "Conexion WS no definida a SAP ";
    public static final String ERROR_CONSUMIR_WS = "Error al consumir WS ";

    public static final String TIPOCONTENIDO = "Content-type";
    public static final String XAUTORIZACIONX = "Authorization";
//    protected final OkHttpClient client = new OkHttpClient();

    static {
        GSON = UtilsApi.GSON;
//        Gson gsonAux = new GsonBuilder()
//                .registerTypeHierarchyAdapter(byte[].class, new ByteArraySerializer())
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .create();
//        // Get the date adapter
//        TypeAdapter<Date> dateTypeAdapter = gsonAux.getAdapter(Date.class);
//        // Ensure the DateTypeAdapter is null safe
//        TypeAdapter<Date> safeDateTypeAdapter = dateTypeAdapter.nullSafe();
//        // Build the definitive safe Gson instance
//        GSON = new GsonBuilder()
//                .registerTypeHierarchyAdapter(byte[].class, new ByteArraySerializer())
//                .setDateFormat("yyyy-MM-dd HH:mm:ss")
//                .registerTypeAdapter(Date.class, safeDateTypeAdapter)
//                .create();
    }

    /**
     * Consumir Web Service de API de GO. Método genérico para consumir WS REST
     * de diferentes tipos GET, POST, DELETE y PUT
     *
     * @param ws Web service a consumir, Null en caso de querer consumir directo
     * desde las otras variables
     * @param postDataJSON
     * @param urlDataParams Map de PathVariable o RequestParam. Se indentifica
     * cada uno por el caracter usado "{" para PathVariable caso contrario
     * RequestParam
     * @return
     * @throws java.io.UnsupportedEncodingException
     * @throws MalformedURLException
     * @throws IOException
     * @throws URISyntaxException
     */
    //TODO implementar GoException
    public GenericResponse consumirApiRest(TWebService ws, String postDataJSON, Map<String, String> urlDataParams) throws Exception {
        GenericResponse<String> respuestaWs = validaWsService(ws);
        if (respuestaWs.getStatus() != ParametersApi.SUCCESSFUL.value()) {
            return respuestaWs;
        }
        String pathUrl = ws.getSerCodigo().getSerUrl().concat(ws.getWsUrl());
        String metodo = ws.getWsMetodo();
        String contentType = ws.getWsContenytType() == null || ws.getWsContenytType().trim().isEmpty() ? "application/json" : ws.getWsContenytType();
        //Construye url con parametros de hashMap
        pathUrl = construyeUrlPathRequestVariable(urlDataParams, pathUrl);
        URL url1 = new URL(pathUrl);
        URI uri = new URI(
                url1.getProtocol(),
                url1.getUserInfo(),
                url1.getHost(),
                url1.getPort(),
                url1.getPath(),
                url1.getQuery(),
                url1.getRef());
        URL url = new URL(uri.toASCIIString());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod(metodo);
        connection.setRequestProperty(TIPOCONTENIDO, contentType);
        connection.setRequestProperty("Accept", "application/json");
        //Basic autentication
        if (ws.getWsUsuario() != null && !ws.getWsUsuario().trim().isEmpty()) {
            String authString = ws.getWsUsuario() + ":" + ws.getWsClave();
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            String tipoAutenticacion = TIPOAUTENTICACION.concat(" ").concat(authStringEnc);
            connection.setRequestProperty(XAUTORIZACIONX, tipoAutenticacion);
        }
        //parametros
        if (ws.getWsConnectTimeout() != null) {
            connection.setConnectTimeout(ws.getWsConnectTimeout().intValue());
        } else {
            connection.setConnectTimeout(10000);
        }
        if (ws.getWsReadTimeout() != null) {
            connection.setReadTimeout(ws.getWsReadTimeout().intValue());
        } else {
            //se configura un timeout por defecto para la lectura ya que existen problemas al no responder
            connection.setReadTimeout(30000);
        }
        if (metodo.equalsIgnoreCase(RESP_POST)) {
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postDataJSON.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
                os.flush();
            }
        } else if (metodo.equalsIgnoreCase(RESP_GET)) {
            connection.connect();
        } else {
            respuestaWs.setMessage("NO SE HA DEFINIDO EL TIPO DE WS");
            respuestaWs.setStatus(ParametersApi.SERVER_ERROR.value());
            return respuestaWs;
        }
        // Verificar conexion
        boolean responseStatus = connection.getResponseCode() == HttpURLConnection.HTTP_OK;//404,502
        String rawString = null;
        GenericResponse<String> resultado = null;
        if (!responseStatus) {
            respuestaWs.setMessage("Conexion no establecida. Mensaje: " + connection.getResponseMessage() + ". CODE: " + connection.getResponseCode());
            respuestaWs.setStatus(ParametersApi.SERVER_ERROR.value());
            return respuestaWs;
        } else {//Captura la respuesta del WS
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                rawString = response.toString();
                resultado = GSON.fromJson(rawString, new TypeToken<GenericResponse<String>>() {
                }.getType());
            }
        }
        if (resultado.getStatus() == null) {
            //significa que no pudo parsear
            resultado.setStatus(1);
            resultado.setMessage("Respuesta obtenida, revise mensaje");
            resultado.setObject(rawString);
        }
//        Logger.getLogger(ApiTemplate.class.getName()).log(Level.INFO, "resultado {0}", resultado.toString());
        return resultado;
    }

    /**
     * Consumir Web Service de API de GO. Método genérico para consumir WS REST
     * de diferentes tipos GET, POST, DELETE y PUT
     *
     * @param ws Web service a consumir, Null en caso de querer consumir directo
     * desde las otras variables
     * @param postDataJSON
     * @param urlDataParams Map de PathVariable o RequestParam. Se indentifica
     * cada uno por el caracter usado "{" para PathVariable caso contrario
     * RequestParam
     * @return
     * @throws java.io.UnsupportedEncodingException
     * @throws MalformedURLException
     * @throws org.json.JSONException
     * @throws IOException
     * @throws URISyntaxException
     */
    //TODO implementar GoException
    public String consumirApiRestRaw(TWebService ws, String postDataJSON, Map<String, String> urlDataParams) throws Exception {
        GenericResponse respuestaWs = validaWsService(ws);
        if (respuestaWs.getStatus() != ParametersApi.SUCCESSFUL.value()) {
            return null;
        }
        String pathUrl = ws.getSerCodigo().getSerUrl().concat(ws.getWsUrl());
        String metodo = ws.getWsMetodo();
        String contentType = ws.getWsContenytType() == null || ws.getWsContenytType().trim().isEmpty() ? "application/json" : ws.getWsContenytType();

        //Construye url con parametros de hashMap
        pathUrl = construyeUrlPathRequestVariable(urlDataParams, pathUrl);
        URL url1 = new URL(pathUrl);
        URI uri = new URI(
                url1.getProtocol(),
                url1.getUserInfo(),
                url1.getHost(),
                url1.getPort(),
                url1.getPath(),
                url1.getQuery(),
                url1.getRef());
        URL url = new URL(uri.toASCIIString());

//        Logger.getLogger(ApiTemplate.class.getName()).log(Level.INFO, "CONEXION A: {0}", pathUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setRequestMethod(metodo);
        connection.setRequestProperty(TIPOCONTENIDO, contentType);
        connection.setRequestProperty("Accept", "application/json");

        //Basic autentication
        if (ws.getWsUsuario() != null && !ws.getWsUsuario().trim().isEmpty()) {
            String authString = ws.getWsUsuario() + ":" + ws.getWsClave();
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            String tipoAutenticacion = TIPOAUTENTICACION.concat(" ").concat(authStringEnc);
            connection.setRequestProperty(XAUTORIZACIONX, tipoAutenticacion);
        }

        //parametros
        if (ws.getWsConnectTimeout() != null) {
            connection.setConnectTimeout(ws.getWsConnectTimeout().intValue());
        } else {
            connection.setConnectTimeout(10000);
        }
        if (ws.getWsReadTimeout() != null) {
            connection.setReadTimeout(ws.getWsReadTimeout().intValue());
        } else {
            //se configura un timeout por defecto para la lectura ya que existen problemas al no responder
            connection.setReadTimeout(30000);
        }

        if (metodo.equalsIgnoreCase(RESP_POST)) {
            connection.setDoOutput(true);
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = postDataJSON.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
                os.flush();
            }
        } else if (metodo.equalsIgnoreCase(RESP_GET)) {
            connection.connect();
        } else {
            respuestaWs.setMessage("NO SE HA DEFINIDO EL TIPO DE WS");
            respuestaWs.setStatus(ParametersApi.SERVER_ERROR.value());
            return null;
        }
        // Verificar conexion
        boolean responseStatus = connection.getResponseCode() == HttpURLConnection.HTTP_OK;//404,502
        String rawString = null;
        if (!responseStatus) {
            respuestaWs.setMessage("Conexion no establecida. Mensaje: " + connection.getResponseMessage() + ". CODE: " + connection.getResponseCode());
            respuestaWs.setStatus(ParametersApi.SERVER_ERROR.value());
            return null;
        } else {//Captura la respuesta del WS
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                rawString = response.toString();
            }
        }
//        Logger.getLogger(ApiTemplate.class.getName()).log(Level.INFO, "resultado {0}", resultado.toString());
        return rawString;
    }

    /**
     * Valida datos ingresados en WS service
     *
     * @param ws
     * @return
     */
    private GenericResponse validaWsService(TWebService ws) {
        GenericResponse<String> respuestaWs = new GenericResponse();
        if (ws == null) {
            respuestaWs.setMessage("Configuracion de ws no realizada");
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else if (ws.getSerCodigo() == null) {
            respuestaWs.setMessage("No esta definido la Ip del servidor");
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else if (ws.getSerCodigo().getSerUrl() == null) {
            respuestaWs.setMessage("No esta definido URL de Servidor");
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else if (ws.getWsTipo() == null) {
            respuestaWs.setMessage("TIPO DE WS NO DEFINIDO");
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else if (!ws.getWsTipo().equalsIgnoreCase("REST")) {
            respuestaWs.setMessage("Metodo no habilitado para sericios " + ws.getWsTipo());
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else if (ws.getWsEstado() == ParametersApi.ANULADO.value()) {
            respuestaWs.setMessage("Sericio web no habilitado.");
            respuestaWs.setStatus(ParametersApi.PROCESS_NOT_COMPLETED.value());
            return respuestaWs;
        } else {
            respuestaWs.setStatus(ParametersApi.SUCCESSFUL.value());
            return respuestaWs;
        }
    }

    /**
     * En caso de ser una URL tipo @PathVariable se construye la URL a partir de
     * hashMap y se elimina para que no se considere en el RequestParam caso
     * contrario se considera como @RequestParam
     * <p>
     * Ejm: ../pedido/{empresa}/{oferta} -> ../pedidos/20/2000012
     * </p>
     * Construye URL de tipo parametros a partir del HashMap Ej:
     * ../pedido/empresa=20?oferta=2000012
     *
     * @param urlDataParams
     * @param pathUrl
     * @return
     * @throws java.io.UnsupportedEncodingException
     */
    protected String construyeUrlPathRequestVariable(Map<String, String> urlDataParams, String pathUrl) throws UnsupportedEncodingException {
        String respPathUrl = pathUrl;
        if (urlDataParams != null && !urlDataParams.isEmpty()) {
            if (pathUrl.contains("{") && pathUrl.contains("}")) {
                for (Map.Entry<String, String> entry : urlDataParams.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    String valuePath = "{".concat(key).concat("}");
                    pathUrl = pathUrl.replace(valuePath, value);
                    urlDataParams.remove(key);
                }
            }

            /**
             * Construye URL de tipo parametros a partir del HashMap Ej:
             * ../pedido/empresa=20?oferta=2000012
             */
            if (pathUrl.endsWith("?")) {
                pathUrl = pathUrl.concat(getPostDataString(urlDataParams));
            } else {
                pathUrl = pathUrl.concat("?").concat(getPostDataString(urlDataParams));
            }

            respPathUrl = pathUrl;
        }
        return respPathUrl;
    }

    /**
     * Genera la URL con los @RequestParam desde el HashMap
     *
     * @param params
     * @return
     * @throws UnsupportedEncodingException
     */
    protected String getPostDataString(Map<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), UTF_DEFAULT));
            result.append("=");
            result.append(entry.getValue() == null ? "" : entry.getValue());
        }
        return result.toString();
    }

//    protected JsonResponse post(String resource, JsonRequest request, int timeout) throws GoException {
//        return post(resource, request, true, timeout);
//    }
//
//    protected JsonResponse post(String resource, JsonRequest request, boolean token, int timeout) throws GoException {
//        RequestBody body = RequestBody.create(json, GSON.toJson(request));
////        System.out.println("Main.apiCaja = " + Main._urlWScaja.replace("caja/caja?wsdl", "rs"));
////        System.out.println("resource = " + resource);
////        System.out.println("request = " + GSON.toJson(request));
////        Request.Builder builder = new Request.Builder().url("http://appcinaquito1.gerardoortiz.com:8080/rs" + resource).method("POST", body);
//        Request.Builder builder = new Request.Builder().url("http://localhost:8080/rs" + resource).method("POST", body);
////        if (token) {
//////            if (Main.lastApiDate.before(new Date())) {
//////                Main.generarToken();
//////            }
//////            builder.addHeader("Authorization", "Bearer " + Main.token);
////        }
//        Request req = builder.build();
//
//        try {
//            OkHttpClient client = new OkHttpClient.Builder()
//                    .connectTimeout(10, TimeUnit.SECONDS)
//                    .writeTimeout(10, TimeUnit.SECONDS)
//                    .readTimeout(timeout, TimeUnit.SECONDS)
//                    .build();
//            Response response = client.newCall(req).execute();
//            if (response.code() >= 200 && response.code() < 300) {
//                String cad = response.body().string();
//                return GSON.fromJson(cad, JsonResponse.class);
//            } else {
//                throw new GoException("Error " + response.code() + ", " + response.message() + "<br/>Revisar método [" + resource + "]", request);
//            }
//        } catch (Exception e) {
//            if (e instanceof GoException) {
//                throw (GoException) e;
//            }
//            if ("timeout".equalsIgnoreCase(e.getMessage())) {
//                throw new GoException("TIMEOUT al conectarse al recurso<br/>Revisar método [" + resource + "]", request);
//            } else {
//                throw new GoException(e.getMessage() + "<br/>Revisar método [" + resource + "]", request);
//            }
//        }
//    }
    protected void validateResponse(GenericResponse resp, String clase) throws GoApiException {
        validateResponse(null, null, resp, clase);
    }

    protected void validateResponse(String ws, String url, GenericResponse resp, String clase) throws GoApiException {
        if (resp == null) {
            StringBuilder buil = new StringBuilder("No se obtuvo respuesta " + (ws == null ? "" : ws));
            if (clase != null && !clase.trim().isEmpty()) {
                buil.append(" [").append(clase.trim()).append("]").toString();
            }
            throw new GoApiException(buil.toString());
        }
        if (resp.getStatus() == null) {
//            Main.generarToken();
            throw new GoApiException("Excepcion Generica " + (ws == null ? "" : ws));
        }
        if (resp.getStatus() == ParametersApi.EXCEPCION_CONTROLADA.value()) {
            throw new GoApiException("Excepcion Controlada ", resp.getMessage());
        } else if (resp.getStatus() != ParametersApi.SUCCESSFUL.value()) {
            StringBuilder buil = new StringBuilder();
            buil.append(resp.getMessage());
            if (clase != null && !clase.trim().isEmpty()) {
                buil.append(clase.trim());
            }
            throw new GoApiException("Error", buil.toString());
        }
    }

    protected void param(Map params, String id, Object obj) {
        if (obj != null && params != null) {
            params.put(id, obj);
        }
    }

    protected void param(Map params, Class clase, String id, Object obj) {
        if (obj != null && params != null) {
            params.put(id, GSON.toJson(obj, clase));
        }
    }

    protected void paramByteArray(Map params, String id, byte[] array) {
        if (array == null) {
            return;
        }
        params.put(id, new String(Base64.encodeBase64(array)));
    }

}
