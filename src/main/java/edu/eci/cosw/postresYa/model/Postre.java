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

/**
 *
 * @author duvan
 */
public class Postre {
    private String code;
    private String name;
    private int price;
    private String description;
   


    
    public Postre(){
        
    }
    public Postre(String code,String name,int price,String description){
        this.code=code;
        this.name=name;
        this.price=price;
        this.description=description;
  
        
    }
    
    
    
        
     /*
    *Busca el valor del código del postre
    *@Return String code
    */
    public String getCode() {
        return code;
    }

     /*
    *Cambia el valor del código del postre
    *@Params String code
    *@Return void
    */
    public void setCode(String code) {
        this.code = code;
    }
     /*
    *Busca el valor del nombre del postre
    *@Return String name
    */
    public String getName() {
        return name;
    }

       /*
    *Cambia el valor del nombre del postre
    *@Params String name
    *@Return void
    */
    public void setName(String name) {
        this.name = name;
    }
     /*
    *Busca el valor del precio del postre
    *@Return int price
    */
    public int getPrice() {
        return price;
    }

       /*
    *Cambia el valor del precio del postre
    *@Params int price
    *@Return void
    */
    public void setPrice(int price) {
        this.price = price;
    }
    
     /*
    *Busca la descripción del postre
    *@Return String description
    */
    public String getDescription() {
        return description;
    }

    
       /*
    *Cambia la descripción del postre
    *@Params String description
    *@Return void
    */
    public void setDescription(String description) {
        this.description = description;
    }


    
    
}
