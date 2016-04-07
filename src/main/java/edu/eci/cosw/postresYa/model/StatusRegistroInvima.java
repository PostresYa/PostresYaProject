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

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado=registrado;
    }
    public StatusRegistroInvima(){
       
    }
    public StatusRegistroInvima(boolean registrado){
        this.registrado=registrado;
    }
}
