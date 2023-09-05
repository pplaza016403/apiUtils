/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.api.utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author edisson.tapia
 */
public class ApiMessage implements Serializable {

    private BigDecimal costo;
    private BigDecimal decimal10;
    private BigDecimal decimal1;
    private BigDecimal decimal2;
    private BigDecimal decimal3;
    private BigDecimal decimal4;
    private BigDecimal decimal5;
    private BigDecimal decimal6;
    private BigDecimal decimal7;
    private BigDecimal decimal8;
    private BigDecimal decimal9;
    private BigDecimal embalaje;
    private BigDecimal factor;
    private BigDecimal precio;
    private BigDecimal rentaMd;
    private BigDecimal rentaMu;
    private BigDecimal total;
    private BigDecimal iva;
    private BigDecimal ice;
    private BigDecimal descuentoPorc;
    private BigDecimal descuento;
    private BigDecimal baseIva;
    private BigDecimal baseExe;
    private BigDecimal baseCero;
    private Date fecha;
    private Date fechaCrea;
    private Date fechaFin;
    private Date fechaInicio;
    private Date fechaModifica;
    private Integer bodega1;
    private Integer bodega2;
    private Integer bodega;
    private Integer empresa;
    private Integer entero10;
    private Integer entero1;
    private Integer entero2;
    private Integer entero3;
    private Integer entero4;
    private Integer entero5;
    private Integer entero6;
    private Integer entero7;
    private Integer entero8;
    private Integer entero9;
    private Integer estadoInt;
    private String almacen;
    private String barra;
    private String bp;
    private String centro;
    private String codigo;
    private String correo;
    private String descripcion;
    private String direccion;
    private String estadoTxt;
    private String material;
    private String nombre;
    private String observaciones;
    private String presentacion;
    private String sociedad;
    private String telefono;
    private String texto10;
    private String texto1;
    private String texto2;
    private String texto3;
    private String texto4;
    private String texto5;
    private String texto6;
    private String texto7;
    private String texto8;
    private String texto9;
    private String tipo;
    private String tipoArt;
    private String tipoBp;
    private String tipoCli;
    private String unidad;
    private String usuario;
    private String ip;
    private String hostname;
    private String referencia;
    private String documento;
    private String unidadPedido;
    private String unidadCompra;
    private BigDecimal unidadPedidoCant;
    private BigDecimal unidadCompraCant;
    private BigDecimal ultimoPedidoCosto;
    private BigDecimal ultimoPedidoCant;
    private Date ultimoPedidoFecha;

    private String rowKey = UUID.randomUUID().toString();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarra() {
        return barra;
    }

    public void setBarra(String barra) {
        this.barra = barra;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTipoCli() {
        return tipoCli;
    }

    public void setTipoCli(String tipoCli) {
        this.tipoCli = tipoCli;
    }

    public String getTipoArt() {
        return tipoArt;
    }

    public void setTipoArt(String tipoArt) {
        this.tipoArt = tipoArt;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getDecimal1() {
        return decimal1;
    }

    public void setDecimal1(BigDecimal decimal1) {
        this.decimal1 = decimal1;
    }

    public BigDecimal getDecimal2() {
        return decimal2;
    }

    public void setDecimal2(BigDecimal decimal2) {
        this.decimal2 = decimal2;
    }

    public BigDecimal getDecimal3() {
        return decimal3;
    }

    public void setDecimal3(BigDecimal decimal3) {
        this.decimal3 = decimal3;
    }

    public BigDecimal getDecimal4() {
        return decimal4;
    }

    public void setDecimal4(BigDecimal decimal4) {
        this.decimal4 = decimal4;
    }

    public BigDecimal getDecimal5() {
        return decimal5;
    }

    public void setDecimal5(BigDecimal decimal5) {
        this.decimal5 = decimal5;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Integer getEstadoInt() {
        return estadoInt;
    }

    public void setEstadoInt(Integer estadoInt) {
        this.estadoInt = estadoInt;
    }

    public String getEstadoTxt() {
        return estadoTxt;
    }

    public void setEstadoTxt(String estadoTxt) {
        this.estadoTxt = estadoTxt;
    }

    public String getTexto1() {
        return texto1;
    }

    public void setTexto1(String texto1) {
        this.texto1 = texto1;
    }

    public String getTexto2() {
        return texto2;
    }

    public void setTexto2(String texto2) {
        this.texto2 = texto2;
    }

    public String getTexto3() {
        return texto3;
    }

    public void setTexto3(String texto3) {
        this.texto3 = texto3;
    }

    public String getTexto4() {
        return texto4;
    }

    public void setTexto4(String texto4) {
        this.texto4 = texto4;
    }

    public String getTexto5() {
        return texto5;
    }

    public void setTexto5(String texto5) {
        this.texto5 = texto5;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public BigDecimal getFactor() {
        return factor;
    }

    public void setFactor(BigDecimal factor) {
        this.factor = factor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getDecimal6() {
        return decimal6;
    }

    public void setDecimal6(BigDecimal decimal6) {
        this.decimal6 = decimal6;
    }

    public BigDecimal getDecimal7() {
        return decimal7;
    }

    public void setDecimal7(BigDecimal decimal7) {
        this.decimal7 = decimal7;
    }

    public BigDecimal getDecimal8() {
        return decimal8;
    }

    public void setDecimal8(BigDecimal decimal8) {
        this.decimal8 = decimal8;
    }

    public BigDecimal getDecimal9() {
        return decimal9;
    }

    public void setDecimal9(BigDecimal decimal9) {
        this.decimal9 = decimal9;
    }

    public BigDecimal getDecimal10() {
        return decimal10;
    }

    public void setDecimal10(BigDecimal decimal10) {
        this.decimal10 = decimal10;
    }

    public BigDecimal getRentaMd() {
        return rentaMd;
    }

    public void setRentaMd(BigDecimal rentaMd) {
        this.rentaMd = rentaMd;
    }

    public BigDecimal getRentaMu() {
        return rentaMu;
    }

    public void setRentaMu(BigDecimal rentaMu) {
        this.rentaMu = rentaMu;
    }

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public Integer getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Integer empresa) {
        this.empresa = empresa;
    }

    public String getSociedad() {
        return sociedad;
    }

    public void setSociedad(String sociedad) {
        this.sociedad = sociedad;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getAlmacen() {
        return almacen;
    }

    public void setAlmacen(String almacen) {
        this.almacen = almacen;
    }

    public Integer getBodega() {
        return bodega;
    }

    public void setBodega(Integer bodega) {
        this.bodega = bodega;
    }

    public BigDecimal getEmbalaje() {
        return embalaje;
    }

    public void setEmbalaje(BigDecimal embalaje) {
        this.embalaje = embalaje;
    }

    public Integer getBodega1() {
        return bodega1;
    }

    public void setBodega1(Integer bodega1) {
        this.bodega1 = bodega1;
    }

    public Integer getBodega2() {
        return bodega2;
    }

    public void setBodega2(Integer bodega2) {
        this.bodega2 = bodega2;
    }

    public Integer getEntero10() {
        return entero10;
    }

    public void setEntero10(Integer entero10) {
        this.entero10 = entero10;
    }

    public Integer getEntero1() {
        return entero1;
    }

    public void setEntero1(Integer entero1) {
        this.entero1 = entero1;
    }

    public Integer getEntero2() {
        return entero2;
    }

    public void setEntero2(Integer entero2) {
        this.entero2 = entero2;
    }

    public Integer getEntero3() {
        return entero3;
    }

    public void setEntero3(Integer entero3) {
        this.entero3 = entero3;
    }

    public Integer getEntero4() {
        return entero4;
    }

    public void setEntero4(Integer entero4) {
        this.entero4 = entero4;
    }

    public Integer getEntero5() {
        return entero5;
    }

    public void setEntero5(Integer entero5) {
        this.entero5 = entero5;
    }

    public Integer getEntero6() {
        return entero6;
    }

    public void setEntero6(Integer entero6) {
        this.entero6 = entero6;
    }

    public Integer getEntero7() {
        return entero7;
    }

    public void setEntero7(Integer entero7) {
        this.entero7 = entero7;
    }

    public Integer getEntero8() {
        return entero8;
    }

    public void setEntero8(Integer entero8) {
        this.entero8 = entero8;
    }

    public Integer getEntero9() {
        return entero9;
    }

    public void setEntero9(Integer entero9) {
        this.entero9 = entero9;
    }

    public String getBp() {
        return bp;
    }

    public void setBp(String bp) {
        this.bp = bp;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getTexto10() {
        return texto10;
    }

    public void setTexto10(String texto10) {
        this.texto10 = texto10;
    }

    public String getTexto6() {
        return texto6;
    }

    public void setTexto6(String texto6) {
        this.texto6 = texto6;
    }

    public String getTexto7() {
        return texto7;
    }

    public void setTexto7(String texto7) {
        this.texto7 = texto7;
    }

    public String getTexto8() {
        return texto8;
    }

    public void setTexto8(String texto8) {
        this.texto8 = texto8;
    }

    public String getTexto9() {
        return texto9;
    }

    public void setTexto9(String texto9) {
        this.texto9 = texto9;
    }

    public String getTipoBp() {
        return tipoBp;
    }

    public void setTipoBp(String tipoBp) {
        this.tipoBp = tipoBp;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIva() {
        return iva;
    }

    public void setIva(BigDecimal iva) {
        this.iva = iva;
    }

    public BigDecimal getIce() {
        return ice;
    }

    public void setIce(BigDecimal ice) {
        this.ice = ice;
    }

    public BigDecimal getDescuentoPorc() {
        return descuentoPorc;
    }

    public void setDescuentoPorc(BigDecimal descuentoPorc) {
        this.descuentoPorc = descuentoPorc;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getBaseIva() {
        return baseIva;
    }

    public void setBaseIva(BigDecimal baseIva) {
        this.baseIva = baseIva;
    }

    public BigDecimal getBaseExe() {
        return baseExe;
    }

    public void setBaseExe(BigDecimal baseExe) {
        this.baseExe = baseExe;
    }

    public BigDecimal getBaseCero() {
        return baseCero;
    }

    public void setBaseCero(BigDecimal baseCero) {
        this.baseCero = baseCero;
    }

    public String getUnidadPedido() {
        return unidadPedido;
    }

    public void setUnidadPedido(String unidadPedido) {
        this.unidadPedido = unidadPedido;
    }

    public String getUnidadCompra() {
        return unidadCompra;
    }

    public void setUnidadCompra(String unidadCompra) {
        this.unidadCompra = unidadCompra;
    }

    public BigDecimal getUnidadPedidoCant() {
        return unidadPedidoCant;
    }

    public void setUnidadPedidoCant(BigDecimal unidadPedidoCant) {
        this.unidadPedidoCant = unidadPedidoCant;
    }

    public BigDecimal getUnidadCompraCant() {
        return unidadCompraCant;
    }

    public void setUnidadCompraCant(BigDecimal unidadCompraCant) {
        this.unidadCompraCant = unidadCompraCant;
    }

    public BigDecimal getUltimoPedidoCosto() {
        return ultimoPedidoCosto;
    }

    public void setUltimoPedidoCosto(BigDecimal ultimoPedidoCosto) {
        this.ultimoPedidoCosto = ultimoPedidoCosto;
    }

    public BigDecimal getUltimoPedidoCant() {
        return ultimoPedidoCant;
    }

    public void setUltimoPedidoCant(BigDecimal ultimoPedidoCant) {
        this.ultimoPedidoCant = ultimoPedidoCant;
    }

    public Date getUltimoPedidoFecha() {
        return ultimoPedidoFecha;
    }

    public void setUltimoPedidoFecha(Date ultimoPedidoFecha) {
        this.ultimoPedidoFecha = ultimoPedidoFecha;
    }

}
