/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author duvan
 */


public class Postre implements java.io.Serializable{
  
    private PostreId id;
    private String name;
    private int price;
    private String description;
   


    /**
     * Constructor inicial de postre
     */
    public Postre(){
        
    }
    
   /**
    * Constructor con parametros de postre
    * @param code //Codigo de identificacion para el postre
    * @param name //Nombre para el postre
    * @param price //Precio del postre
    * @param description //Descripcion y especificaciones del postre
    */
    public Postre(PostreId id,String name,int price,String description){
        
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        
    }
    
    /**
     * Busca el valor del código del postre
     * @return 
     */
    public PostreId getId() {
        return id;
    }

    /**
     * Cambia el valor del código del postre
     * @param code String
     */
    public void setId(PostreId id) {
        this.id=id;
    }
    
    /**
     * Busca el valor del nombre del postre
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Cambia el valor del nombre del postre
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Busca el valor del precio del postre
     * @return price int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Cambia el valor del precio del postre
     * @param price int
     */
    public void setPrice(int price) {
        this.price = price;
    }
    
    /**
     * Busca la descripción del postre
     * @return descripcion String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Cambia la descripción del postre
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
}