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
    public PostreCantId(String codigoPostre,String reposteriaNit,int idPedido){
        this.codigoPostre=codigoPostre;
        this.reposteriaNit=reposteriaNit;
        this.idPedido=idPedido;
    }
    @Column(name="Postre_codigo_postre",nullable = false)
    public String getCodigoPostre() {
        return codigoPostre;
    }

    public void setCodigoPostre(String codigoPostre) {
        this.codigoPostre = codigoPostre;
    }
    
    @Column(name="Postre_Reposteria_nit",nullable = false)
    public String getReposteriaNit() {
        return reposteriaNit;
    }

    public void setReposteriaNit(String reposteriaNit) {
        this.reposteriaNit = reposteriaNit;
    }
    
     @Column(name="Pedido_id_pedido",nullable = false)
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }
}
