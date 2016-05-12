/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

/**
 *
 * @author 2086906
 */



public class StatusRegistroInvima {
    private int expediente;
    private String nit;
    private String estadoRegistro;
    private String vencimiento;
    private String modalidad;
    
    public StatusRegistroInvima(){
    }
    
    public StatusRegistroInvima(int expediente, String nit, String estadoRegistro, String vencimiento, String modalidad){
        this.expediente = expediente;
        this.nit = nit;
        this.estadoRegistro = estadoRegistro;
        this.vencimiento = vencimiento;
        this.modalidad = modalidad;
    }
    public int getExpediente() {
        return expediente;
    }

    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(String estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
   
}
