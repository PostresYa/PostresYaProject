/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

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
    private InputStream image;//la foto no se sabe
    public Postre(){
        
    }
    public Postre(String code,String name,int price,String description,InputStream image){
        this.code=code;
        this.name=name;
        this.price=price;
        this.description=description;
        this.image=image;
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

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
    
    
}
