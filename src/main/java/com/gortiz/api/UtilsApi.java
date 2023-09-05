package com.gortiz.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.TextField;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Ing Edisson Tapia
 */
public class UtilsApi {

    public static final SimpleDateFormat SDF_DATETIME_FULL = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat SDF_DATETIME = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final SimpleDateFormat SDF_TIME_FULL = new SimpleDateFormat("HH:mm:ss");
    public static final SimpleDateFormat SDF_TIME = new SimpleDateFormat("HH:mm");
    public static final SimpleDateFormat SDF_DATE = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat SDF_SRI_DATE = new SimpleDateFormat("dd/MM/yyyy");
    public static final DecimalFormat DF2 = new DecimalFormat("0.00");
    public static final DecimalFormat DF4 = new DecimalFormat("0.0000");
    public static final DecimalFormat DF_FULL = new DecimalFormat("0.##########################");
    public static final DecimalFormat DF00 = new DecimalFormat("00");
    public static final DecimalFormat DF000 = new DecimalFormat("000");

    public static final String GSON_TIME_PATTERN = "HH:mm:ss";
    public static final String GSON_DATE_PATTERN = "yyyy-MM-dd";
    public static final String GSON_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String GSON_NUMBER_PATTERN = "############0.##########";
    public static final Gson GSON
            = new GsonBuilder()
                    .registerTypeHierarchyAdapter(byte[].class, new ByteArraySerializer())
                    //                    .registerTypeHierarchyAdapter(Collection.class, new CollectionsSerializer())
                    .setDateFormat(GSON_DATETIME_PATTERN)
                    .setPrettyPrinting()
                    .create();

    public static String getMensajeExcepcion(Exception ex) {
        String aux = ex.getMessage();
        for (StackTraceElement fila : ex.getStackTrace()) {
            aux += "\n" + fila;
        }
        if (ex.getCause() != null) {
            aux += "\n***************************************************";
            for (StackTraceElement fila : ex.getCause().getStackTrace()) {
                aux += "\n" + fila;
            }
        }
        return aux + "\n";
    }

    public static Date addFechaField(int dias, int tipo) {
        return addFechaField(null, dias, tipo);
    }

    public static Date addFechaField(Date fecha, int dias, int tipo) {
        Calendar cal = Calendar.getInstance();
        fecha = encerarTime(fecha == null ? new Date() : fecha);
        cal.setTime(fecha);
        cal.add(tipo, dias);
        return cal.getTime();
    }

    public static int getFechaField(Date fecha, int tipo) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal.get(tipo);
    }

    public static Date getFechaMeses(int cantidad) {
        return addFechaField(cantidad, Calendar.MONTH);
    }

    public static Date getFechaDias(int cantidad) {
        return addFechaField(cantidad, Calendar.DAY_OF_YEAR);
    }

    public static Date getFechaAnios(int cantidad) {
        return addFechaField(cantidad, Calendar.YEAR);
    }

    public static Date getFechaSemanas(int cantidad) {
        return addFechaField(cantidad, Calendar.WEEK_OF_YEAR);
    }

    public static Date encerarTime(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    public static String lpad(String cad, int max, char relleno) {
        int sobrante = cad.length() - max;
        if (sobrante > 0) {
            return cad.substring(sobrante);
        } else {
            for (int i = 0; i < -sobrante; i++) {
                cad = relleno + cad;
            }
            return cad;
        }
    }

    public static String rpad(String cad, int max, char relleno) {
        int sobrante = cad.length() - max;
        if (sobrante > 0) {
            return cad.substring(0, max);
        } else {
            for (int i = 0; i < -sobrante; i++) {
                cad = cad + relleno;
            }
            return cad;
        }
    }

    public static String df(Object obj, String pattern) {
        String cad = "0";
        if (obj instanceof Number) {
            cad = obj.toString();
        } else if (obj instanceof TextField) {
            cad = ((TextField) obj).getText();
        } else if (obj instanceof String) {
            cad = obj.toString();
        }
        BigDecimal val = new BigDecimal(cad);
        if (pattern.equals("0.00")) {
            return DF2.format(val);
        }
        if (pattern.equals("0.0000")) {
            return DF4.format(val);
        }
        if (pattern.equals("00")) {
            return DF00.format(val);
        }
        if (pattern.equals("000")) {
            return DF000.format(val);
        }
        DecimalFormat ptt = new DecimalFormat(pattern);
        return ptt.format(val);
    }

    public static void valida(boolean cuando, String titulo, String mensaje) throws GoApiException {
        if (cuando) {
            throw new GoApiException(titulo, mensaje);
        }
    }

    public static void valida(String txt, String titulo, String mensaje) throws GoApiException {
        valida(txt == null || txt.trim().isEmpty(), titulo, mensaje);
    }

    public static String randomString(int len) {
        byte[] array = new byte[len];
        new SecureRandom().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }

    /**
     * Genera un String aleatorio
     *
     * @param longitud
     * @return
     */
    public static String getRandomString(int longitud) {
        if (longitud > 32) {
            longitud = 32;
        }
        return UUID.randomUUID().toString().replace("-", "").substring(0, longitud).toUpperCase();
    }

    /**
     * Retorna el inicio del mes de la fecha indicada
     *
     * @param fecha si no se especifica fecha toma la fecha actual
     * @return
     */
    public static Date getInicioMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        fecha = fecha == null ? new Date() : fecha;
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        return UtilsApi.encerarTime(cal.getTime());
    }

    /**
     * Retorna el fin de mes de la fecha indicada
     *
     * @param fecha si no se especifica fecha toma la fecha actual
     * @return
     */
    public static Date getFinMes(Date fecha) {
        Calendar cal = Calendar.getInstance();
        fecha = fecha == null ? new Date() : fecha;
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return UtilsApi.encerarTime(cal.getTime());
    }

    public static Date getFinMesMasUno(Date fecha) {
        Calendar cal = Calendar.getInstance();
        fecha = fecha == null ? new Date() : fecha;
        cal.setTime(fecha);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.add(Calendar.MONTH, 1);
        return UtilsApi.encerarTime(cal.getTime());
    }

    /**
     *
     * @param _newbarra
     * @return EAN6,EAN8,EAN12,EAN13,EAN14 null en caso de no ser valido
     * @throws Exception
     */
    public static String pvalidaBarra(String _newbarra) {
        _newbarra = _newbarra == null ? "" : _newbarra;
        _newbarra = _newbarra.trim();
        if (!_newbarra.matches("\\d+")) {
            return null;
        }
        Integer ln_digito;
        Integer ln_size;
        Integer ln_suma;
        Integer ln_valor;
        Integer ln_digito_verificador;
        Integer ln_factor;
        Integer i;

        ln_size = _newbarra.length();
        ln_digito_verificador = Integer.parseInt(_newbarra.substring(ln_size - 1, ln_size));
        ln_factor = 3;
        ln_suma = 0;
        i = ln_size - 2;

        do {

            ln_digito = Integer.parseInt(_newbarra.substring(i, i + 1));
            ln_valor = ln_digito * ln_factor;
            ln_suma = ln_suma + ln_valor;

            if (ln_factor == 1) {
                ln_factor = 3;
            } else {
                ln_factor = 1;
            }

            i = i - 1;
        } while (i >= 0);

        ln_valor = 10 - (ln_suma % 10);

        if (ln_valor == 10) {
            ln_valor = 0;
        }

        if (Objects.equals(ln_digito_verificador, ln_valor)) {

            if (ln_size == 8) {
                return "EAN8";
            } else if (ln_size == 13) {
                return "EAN13";
            } else if (ln_size == 12) {
                return "EAN12";
            } else if (ln_size == 6) {
                return "EAN6";

            } else if (ln_size == 14) {
                return "EAN14";
            } else {

                return null;
            }
        } else {
            return null;
        }

    }

    public static String fixTildesHtml(String cad) {
        return cad
                .replace("á", "&aacute;")
                .replace("é", "&eacute;")
                .replace("í", "&iacute;")
                .replace("ó", "&oacute;")
                .replace("ú", "&uacute;")
                .replace("Á", "&Aacute;")
                .replace("É", "&Eacute;")
                .replace("Í", "&Iacute;")
                .replace("Ó", "&Oacute;")
                .replace("Ú", "&Uacute;")
                .replace("ñ", "&ntilde;")
                .replace("Ñ", "&Ntilde;");
    }

    /**
     * Busca el text dentro de los tags especificados
     *
     * @param text: Texto sobre el cual se busca
     * @param tagInicio: Tag inicial de busqueda
     * @param tagFin: Tag final de busqueda
     * @return
     */
    public static List<String> findAllTags(String text, String tagInicio, String tagFin) {
        final List<String> tagValues = new ArrayList<String>();
        final Matcher matcher = Pattern.compile(tagInicio + "(.+?)" + tagFin).matcher(text);
        while (matcher.find()) {
            tagValues.add(matcher.group(1));
        }
        return tagValues;
    }

    public static boolean validarEAN13(String cad) {
        if (cad == null) {
            return false;
        }
        cad = cad.trim();
        if (cad.isEmpty()) {
            return false;
        }
        if (cad.matches("\\d+")) {
            //solo digitos 
            if (cad.length() == 8) {
                cad = "00000" + cad;
            } else if (cad.length() != 13) {
                return false;
            }
            String verificador = cad.substring(12);
            String ean = cad.substring(0, 12);
            int pares = Integer.valueOf(ean.charAt(1) + "");
            pares += Integer.valueOf(ean.charAt(3) + "");
            pares += Integer.valueOf(ean.charAt(5) + "");
            pares += Integer.valueOf(ean.charAt(7) + "");
            pares += Integer.valueOf(ean.charAt(9) + "");
            pares += Integer.valueOf(ean.charAt(11) + "");
            pares *= 3;
            int impares = Integer.valueOf(ean.charAt(0) + "");
            impares += Integer.valueOf(ean.charAt(2) + "");
            impares += Integer.valueOf(ean.charAt(4) + "");
            impares += Integer.valueOf(ean.charAt(6) + "");
            impares += Integer.valueOf(ean.charAt(8) + "");
            impares += Integer.valueOf(ean.charAt(10) + "");
            int total = pares + impares;
            int residuo = total % 10;
            if (residuo != 0) {
                residuo = 10 - residuo;
            }
            int valida = Integer.valueOf(verificador);
            return valida == residuo;
        } else {
            return false;
        }
    }

    public static XMLGregorianCalendar getXMLDate(Date fecha) {
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            return DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar) cal);
        } catch (Exception e) {
            Logger.getLogger(UtilsApi.class.getName()).log(Level.SEVERE, "getXMLDate", e);
        }
        return null;
    }

    public static Date getDate(String xmlDate) {
        try {
            XMLGregorianCalendar cal = DatatypeFactory.newInstance().newXMLGregorianCalendar(xmlDate);
            return cal.toGregorianCalendar().getTime();
        } catch (Exception e) {
            Logger.getLogger(UtilsApi.class.getName()).log(Level.SEVERE, "getDate", e);
        }
        return null;
    }

    public static int getHoraAsInt(Date fecha) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        int res = cal.get(Calendar.HOUR_OF_DAY) * 10000;
        res += cal.get(Calendar.MINUTE) * 100;
        res += cal.get(Calendar.SECOND) * 1;
        return res;
    }

    public static String max(String cad, int max) {
        if (cad.length() > max) {
            return cad.substring(0, max);
        } else {
            return cad;
        }
    }

    public static String centerString(String cad, int max) {
        cad = cad.trim();
        int tam = cad.length();
        int esp = max - tam;
        String res = "";
        if (esp == 0) {
            res = cad;
        } else if (esp > 0) {
            int ini = new BigDecimal(Math.floor(esp / 2)).intValue();
            res = UtilsApi.lpad("", ini, ' ') + cad;
        } else {
            res = cad.substring(0, max);
        }
        return UtilsApi.rpad(res, max, ' ');
    }

    /**
     * Devuelve el número de dias laborables (sin domingos) entre dos fechas
     *
     * @param ini
     * @param fin
     * @return
     */
    public static int diasLS(Date ini, Date fin) {
        ini = UtilsApi.encerarTime(ini);
        fin = UtilsApi.encerarTime(fin);
        long diff = fin.getTime() - ini.getTime();
        int dias = new BigDecimal((((diff / 1000l) / 60l) / 60l) / 24l).intValue() + 1;
        Calendar cale = Calendar.getInstance();
        cale.setTime(ini);
        int diaSem = cale.get(Calendar.DAY_OF_WEEK) - 1;
        diaSem = diaSem == 0 ? 7 : diaSem;
        int ddAux = dias + (diaSem - 1);
        int dom = new BigDecimal(Math.floor(new BigDecimal(ddAux).doubleValue() / 7d)).intValue();
        return dias - dom;
    }

    public static boolean in(Integer valor, Integer... valores) {
        for (Integer val : valores) {
            if (valor == null) {
                if (val == null) {
                    return true;
                }
            } else {
                if (val != null && Integer.compare(val, valor) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void processException(Exception e) throws GoApiException {
        if (e instanceof GoApiException) {
            throw (GoApiException) e;
        } else {
            GoApiException ex = new GoApiException(e);
            throw ex;
        }
    }

    public static String siguienteCodigo(String codigo) {
        final String order = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        boolean sig = true;
        String resultado = "";
        for (int i = codigo.length() - 1; i >= 0; i--) {
            char c = codigo.toCharArray()[i];
            if (sig) {
                int idx = order.indexOf(c);
                if (idx < 0) {
                    //se trata de un error
                    return null;
                } else if (idx == order.length() - 1) {
                    resultado = order.charAt(0) + resultado;
                    sig = true;
                } else {
                    char n = order.charAt(idx + 1);
                    resultado = n + resultado;
                    sig = false;
                }
            } else {
                resultado = c + resultado;
            }
        }
        return resultado;
    }

    public static boolean filtroTxt(String txt) {
        return txt != null && !txt.trim().isEmpty();
    }

    public static boolean filtroLike(String txt) {
        txt = txt == null ? "" : txt;
        return txt.contains("%");
    }

    public static String objectToString(Object obj, String defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        return obj.toString();
    }

    public static Date objectToDate(Object obj, Date defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        return (Date) obj;
    }

    public static BigDecimal objectToBigDecimal(Object obj, int decimales, BigDecimal defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        return new BigDecimal(obj.toString()).setScale(decimales, RoundingMode.HALF_UP);
    }

//    public static void main(String[] args) {
//        System.out.println(siguienteCodigo("XZZABBA"));
//    }
    /**
     * Implementa comparacion de Strings con nullsafe
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean compareString(String str1, String str2) {
        if (str1 == null && str2 == null) {
            return true;
        }
        if (str1 != null && str2 == null) {
            return false;
        }
        if (str1 == null && str2 != null) {
            return false;
        }
        return str1.compareTo(str2) == 0;
    }
}
