/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import org.springframework.boot.orm.jpa.EntityScan;


/**
 *
 * @author Diego Alejandro Rodriguez Cruz
 */
//@Entity
//@Table(name = "Pedido")
public class Pedido {
    
    /**
     * Declaracion de variables
     */
    private List <PostreCant> postres;


    private Date fecha;
    private String direccion; // Posibilidad de un objeto
    private String codigo;
    private String estado;
    private int precio;

    /**
     * Constructor inicial de pedido
     */
    public Pedido(){
    
    }
    
    /**
     * Constructor con parametro de un pedido
     * @param postres // Lista de los postres que se solicitdan y su cantidad
     * @param direccion //Direccion a la cual se solicito un postre
     * @param codigo //Codigo del pedido para tener en cuenta las modificaciones que se necesiten
     * @param fecha //Fecha de pedido en la que se realizo, para dar mayor prioridad a la mas antigua
     */
    public Pedido(List <PostreCant> postres, String direccion, String codigo, Date fecha){
        
        this.postres = postres;
        this.fecha = fecha;
        this.direccion = direccion;
        this.codigo=codigo;
        this.estado="en espera";
        this.precio=updatePrice(postres);
      
        
        
    }
        
    /**
     * Metodo que retorna el precio del pedido
     * @return 
     */
    public int getPrecio() {
        return precio;
    }
    
    /**
     * Actualiza el precio del pedido solicitado, y añade la cantidad solicitada de cada postre
     * @param postres
     * @return 
     */
     private int updatePrice(List<PostreCant> postres) {
         int tempPrice=0;

         for(PostreCant p:postres){

//cantTemp=postresCant.get(p.getCode());
             tempPrice+=(p.getPostre().getPrice())*p.getCant();
         }
         return tempPrice;
     
     }
    
     /**
      * Se obtiene la lista de postres solicitados, con sus cantitades
      * @return 
      */
    public List<PostreCant> getPostres() {
        return postres;
    }

    /**
     * Se obtiene la fecha de solicitud del pedido
     * @return 
     */
    public String getFecha() {
        
        return fecha.toLocaleString();
    }
    
  

    /**
     * Se obtiene la direccion a donde se requiere entregar el postre
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Codigo de pedido, para realizar las modificaciones necesarias para este
     * @return obtiene codigo del pedido
     */
    public String getCodigo() {
        return codigo;
    }
    
    /**
     * Maneja el estado del pedido
     */
    public void setEstado(){
        this.estado="Enviado";
    }
    
    /**
     * Obtiene el estado del pedido
     * @return estado del pedido
     */
    public String getEstado(){
        return estado;
    }


   
    
}

