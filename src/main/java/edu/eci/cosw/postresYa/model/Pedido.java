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
    
    
    private static final String[] listEstados= {"en espera","preparandose","enviado"};
    private List <Postre> postres = new ArrayList<>();
    private Date fecha;
    private String direccion; // Posibilidad de un objeto
    private int codigo;
    
    public Pedido(){
    
    }
    
    public Pedido(List <Postre> postres, String direccion, int codigo){
        
        this.postres = postres;
        this.fecha = new Date();
        this.direccion = direccion;
        this.codigo = codigo;
        
    
    }
    
    
    public static String[] getListEstados() {
        return listEstados;
    }
    

    public List<Postre> getPostres() {
        return postres;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
   
    
}

