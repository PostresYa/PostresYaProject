/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

/**
 *
 * @author duvan
 */
public class Pago {
    private String numeroTarjeta;
    private String codigoSeguridad;
    private String tipo;
    private String nombreCliente;
    private String cuentaDestino;
    private String descripcion;
    private int montoTransaccion;

    public Pago(String numeroTarjeta, String codigoSeguridad, String tipo, String nombreCliente, String cuentaDestino, String descripcion, int montoTransaccion) {
        this.numeroTarjeta = numeroTarjeta;
        this.codigoSeguridad = codigoSeguridad;
        this.tipo = tipo;
        this.nombreCliente = nombreCliente;
        this.cuentaDestino = cuentaDestino;
        this.descripcion = descripcion;
        this.montoTransaccion = montoTransaccion;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(String codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(String cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getMontoTransaccion() {
        return montoTransaccion;
    }

    public void setMontoTransaccion(int montoTransaccion) {
        this.montoTransaccion = montoTransaccion;
    }
    
    
    
    
}
