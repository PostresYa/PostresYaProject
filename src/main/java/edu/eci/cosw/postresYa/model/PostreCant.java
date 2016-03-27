/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

/**
 *
 * @author Diego
 */
public class PostreCant {
    private Postre postre;
     private int cant;
     
     
    /**
     * Crea un postre solicitado con su cantidad
     * @param postre
     * @param cant 
     */ 
    public PostreCant(Postre postre,int cant){
        this.postre=postre;
        this.cant=cant;
    }
    /**
     * devuelve el postre solicitado
     * @return postre
     */
    public Postre getPostre() {
        return postre;
    }
    /**
     * devuelve la cantidad del postre
     * @return cant
     */
    public int getCant() {
        return cant;
    }
   
}
