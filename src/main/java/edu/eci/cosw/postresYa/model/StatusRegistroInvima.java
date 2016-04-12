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
    private boolean registrado;

    /**
     * consulta el estado del registro INVIMA
     * @return 
     */
    public boolean isRegistrado() {
        return registrado;
    }

    /**
     * cambia el estado del registro INVIMA
     * @param registrado 
     */
    public void setRegistrado(boolean registrado) {
        this.registrado=registrado;
    }
    
    /**
     * Constructor vacio de registro INVIMA
     */
    public StatusRegistroInvima(){
       
    }
    
    /**
     * Estado del registro invima
     * @param registrado 
     */
    public StatusRegistroInvima(boolean registrado){
        this.registrado=registrado;
    }
}
