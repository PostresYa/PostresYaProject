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
public class Confirmacion {
    private String message;

   

    public Confirmacion(String message) {
        this.message = message;
    }
     public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
