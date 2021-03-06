/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Diego
 */

@Entity
@Table(name="PedidoPostreCantidad")
public class PostreCant {
    
     private PostreCantId postreCantId;

     private Postre postre;
     private int cant;
     
     
     public PostreCant(){
         
     }
     
    /**
     * Crea un postre solicitado con su cantidad
     * @param postreCantId id del postre
     * @param postre solicitado
     * @param cant la cantidad solicitada
     */ 
    public PostreCant(PostreCantId postreCantId,Postre postre,int cant){
        this.postre=postre;
        this.cant=cant;
        this.postreCantId=postreCantId;
    }
    /**
     * devuelve el postre solicitado
     * @return postre
     */
    
    @ManyToOne
    @Fetch(FetchMode.JOIN)
     @JoinColumns(
             {@JoinColumn(name = "Postre_codigo_postre" , nullable = false,insertable = false,updatable = false), 
              @JoinColumn(name = "Postre_Reposteria_nit", nullable = false,insertable = false,updatable = false)})  

    public Postre getPostre() {
        return postre;
    }
    /**
     * devuelve la cantidad del postre
     * @return cant
     */
    
    @Column(name="cantidad",nullable = false)
    public int getCant() {
        return cant;
    }
    
    /**
     * retorna la cantidad de postres
     * @return cantidad de postres
     */
    @EmbeddedId
     public PostreCantId getPostreCantId() {
        return postreCantId;
    }

     /**
      * cambia la cantidad de postre
      * @param postreCantId 
      */
    public void setPostreCantId(PostreCantId postreCantId) {
        this.postreCantId = postreCantId;
    }
    
    /**
     * cambia el postre
     * @param postre el postre solicitado
     */
    public void setPostre(Postre postre) {
        this.postre = postre;
    }

    /**
     * Asigna la cantidad de postre
     * @param cant la nueva cantidad solicitada
     */
    public void setCant(int cant) {
        this.cant = cant;
    }
   
}
