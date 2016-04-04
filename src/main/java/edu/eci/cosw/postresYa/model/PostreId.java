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
public class PostreId implements java.io.Serializable{
    private String code;
    private String reposteriaNit;

    public PostreId(){
        
    }
    public PostreId(String code,String reposteriaNit){
        this.code=code;
        this.reposteriaNit=reposteriaNit;
    }
    @Column(name="codigo_postre",nullable = false,unique = true)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    @Column(name="Reposteria_nit",nullable = false,unique = true)
    
    public String getReposteriaNit() {
        return reposteriaNit;
    }

    public void setReposteriaNit(String reposteriaNit) {
        this.reposteriaNit = reposteriaNit;
    }
   
}
