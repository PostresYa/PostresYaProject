/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author duvan
 */
@Embeddable
public class PostreCantId implements java.io.Serializable {
    private String codigoPostre;

    
    private String reposteriaNit;
    private int idPedido;
    
    public PostreCantId(){
        
    }
    
    /**
     * constructor de PostreCantId
     * @param codigoPostre
     * @param reposteriaNit
     * @param idPedido 
     */
    public PostreCantId(String codigoPostre,String reposteriaNit,int idPedido){
        this.codigoPostre=codigoPostre;
        this.reposteriaNit=reposteriaNit;
        this.idPedido=idPedido;
    }
    
    /**
     * obtiene el codigo del postre
     * @return 
     */
    @Column(name="Postre_codigo_postre",nullable = false)
    public String getCodigoPostre() {
        return codigoPostre;
    }

    /**
     * cambia el codigo del postre
     * @param codigoPostre 
     */
    public void setCodigoPostre(String codigoPostre) {
        this.codigoPostre = codigoPostre;
    }
    
    /**
     * obtiene el nit de la reposteria
     * @return 
     */
    @Column(name="Postre_Reposteria_nit",nullable = false)
    public String getReposteriaNit() {
        return reposteriaNit;
    }

    /**
     * asigna el nit a la reposteria
     * @param reposteriaNit 
     */
    public void setReposteriaNit(String reposteriaNit) {
        this.reposteriaNit = reposteriaNit;
    }
    
    /**
     * obtiene el id asociado al postre
     * @return 
     */
     @Column(name="Pedido_id_pedido",nullable = false)
    public int getIdPedido() {
        return idPedido;
    }

    /**
     * cambia el id del pedido
     * @param idPedido 
     */
    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
