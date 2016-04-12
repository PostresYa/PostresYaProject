/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;



/**
 *
 * @author duvan
 */

@Entity
@Table (name = "Postre")

public class Postre implements java.io.Serializable{
  
    private PostreId id;
    private String name;
    private int price;
    private String description;
    
    private Blob image;
   


    /**
     * Constructor inicial de postre
     */
    public Postre(){
        
    }
    
   /**
    * Constructor con parametros de postre
     * @param id
    * @param name Nombre para el postre
    * @param price Precio del postre
    * @param description Descripcion y especificaciones del postre
    */
    public Postre(PostreId id,String name,int price,String description){
        
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        
    }
    
    /**
     * Constructor de postre postre con valores iniciales e imagenes de los postres
     * @param id
     * @param name
     * @param price
     * @param description
     * @param image 
     */
       public Postre(PostreId id,String name,int price,String description,Blob image){
        
        this.id=id;
        this.name=name;
        this.price=price;
        this.description=description;
        this.image=image;
        
    }
    
    /**
     * Busca el valor del código del postre
     * @return el id del postre
     */
    @EmbeddedId
    public PostreId getId() {
        return id;
    }

    /**
     * Cambia el valor del código del postre
     * @param id del postre
     */
    public void setId(PostreId id) {
        this.id=id;
    }
    
    /**
     * Busca el valor del nombre del postre
     * @return name
     */
  @Column(name = "nombre" )
    public String getName() {
        return name;
    }

    /**
     * Cambia el valor del nombre del postre
     * @param name el nuevo nombre del postre
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Busca el valor del precio del postre
     * @return price int
     */
    @Column(name = "precio")
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
    @Column(name = "descripcion")
    public String getDescription() {
        return description;
    }

    /**
     * Cambia la descripción del postre
     * @param description del postre
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Cambia imagen asignada para el postre
     * @param nImage del postre
     */
    public void setImage(Blob nImage ){
        this.image = nImage;
    }
            
    /**
     * 
     * @return imagen del postre
     */
    @JsonIgnore
    @Column(name = "imagen")
    public Blob getImage(){
        return  this.image;
    }
}