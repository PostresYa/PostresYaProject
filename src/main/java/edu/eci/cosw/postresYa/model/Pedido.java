/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author diegorodriguecruz
 */
public class Pedido {
    
    
    private List <Postre> postres;
    private Date fecha;
    private String direccion; // Posibilidad de un objeto
    private String codigo;
    private String estado;
    private int precio;

    public int getPrecio() {
        return precio;
    }
    
    public Pedido(){
    
    }
    
    public Pedido(List <Postre> postres, String direccion, String codigo, Date fecha){
        
        this.postres = postres;
        this.fecha = fecha;
        this.direccion = direccion;
        this.codigo=codigo;
        this.estado="en espera";
        this.precio=updatePrice(postres);
        System.out.println(fecha.toString());
        
        
    }
    
     private int updatePrice(List<Postre> postres) {
         int tempPrice=0;
         for(Postre p:postres){
             tempPrice+=p.getPrice();
         }
         return tempPrice;
     
     }
    

    public List<Postre> getPostres() {
        return postres;
    }

    public String getFecha() {
        
        return fecha.toLocaleString();
    }


    public String getDireccion() {
        return direccion;
    }

    public String getCodigo() {
        return codigo;
    }
    public void setEstado(){
        this.estado="Enviado";
    }
    public String getEstado(){
        return estado;
    }


   
    
}

