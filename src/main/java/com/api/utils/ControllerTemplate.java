/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

//import com.gortiz.mayor.data.Utils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edisson
 */
public class ControllerTemplate {

    protected SimpleDateFormat patternDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    protected DecimalFormat patterNumber = new DecimalFormat("0.#");
    protected static final String OK = "OK";
    protected static final String ERROR = "ERROR";

//    protected void auditws(EntityManagerFactory emf, String clase, String metodo) {
//        if ("logWebService".equals(metodo)) {
//            return;
//        }
//        Session session = null;
//        Transaction transaction = null;
//        try {
//            session = emf.unwrap(SessionFactory.class).openSession();
//            transaction = session.beginTransaction();
////            String ip = fetchClientIpAddr();
////            new Auditoria().logWebService(session, 0, ip, "REST", clase + "/" + metodo, "N/A");
//            transaction.commit();
//        } catch (Exception e) {
//            try {
//                transaction.rollback();
//            } catch (Exception ex) {
//                logger.log(Level.SEVERE, "auditws()", ex);
//            }
//            logger.log(Level.SEVERE, "execute()", e);
//        } finally {
//            try {
//                session.close();
//            } catch (Exception e) {
//                logger.log(Level.SEVERE, "auditws()", e);
//            }
//        }
//    }
//    public String auth(String param) throws RestException {
//        String token = null;
//        if (param.startsWith("Bearer ")) {
//            token = param.substring(7);
//            JwtTokenUtil util = new JwtTokenUtil();
//            util.getUsernameFromToken(token);
//            //aqui debe de saltar una exception si no se puede parsear el token por errores
//            // o por token caducado
//            if (token.isEmpty()) {
//                throw new GoException("TOKEN VACIO");
//            }
//        }
//        return token;
//    }
//    protected String regenerateToken(String token) {
//        return JwtTokenUtil.regenerateToken(token);
//    }
    protected String evaluaString(String obj) {
        return obj == null ? null : obj;
    }

    protected Integer evaluaInteger(String obj) {
        try {
            return obj == null ? null : Integer.valueOf(obj);
        } catch (NumberFormatException e) {
            Logger.getLogger(ControllerTemplate.class.getName()).log(Level.SEVERE, "evaluaInteger", e);
            return null;
        }
    }

    protected Date evaluaDate(String obj) {
        try {
            return obj == null ? null : patternDate.parse(obj);
        } catch (ParseException e) {
            Logger.getLogger(ControllerTemplate.class.getName()).log(Level.SEVERE, "evaluaDate", e);
            return null;
        }
    }

    protected BigDecimal evaluaBigDecimal(String obj) {
        try {
            return obj == null ? null : new BigDecimal(obj);
        } catch (Exception e) {
            return null;
        }
    }

    protected boolean evaluaBool(String obj) {
        if (obj == null) {
            return false;
        }
        return obj.equalsIgnoreCase("true");
    }

    protected int evaluaInt(String obj) {
        try {
            return obj == null ? 0 : Integer.valueOf(obj);
        } catch (NumberFormatException e) {
            Logger.getLogger(ControllerTemplate.class.getName()).log(Level.SEVERE, "evaluaInt", e);
            return 0;
        }
    }

    protected long evaluaLong(String obj) {
        try {
            return obj == null ? 0l : Long.valueOf(obj);
        } catch (NumberFormatException e) {
            Logger.getLogger(ControllerTemplate.class.getName()).log(Level.SEVERE, "evaluaLong", e);
            return 0l;
        }
    }

    protected <T> T evaluaJson(Class<T> clase, String json) {
        if (json == null || clase == null) {
            return null;
        }
        return UtilsApi.GSON.fromJson(json, clase);
    }

    protected <T> List<T> evaluaJsonList(Type tipo, String json) {
        if (json == null || tipo == null) {
            return new ArrayList<>();
        }
        return UtilsApi.GSON.fromJson(json, tipo);
    }
}
