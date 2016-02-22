/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.awt.Image;
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
    private Image image;//la foto no se sabe
    public Postre(){
        
    }
    public Postre(String code,String name,int price,String description){
        this.code=code;
        this.name=name;
        this.price=price;
        this.description=description;
        
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    
    
}
