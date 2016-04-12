/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author duvan
 */
@Entity
@Table(name="Usuario")
public class Usuario implements java.io.Serializable {
    private String username;
    private String password;
    public Usuario(){
        
    }
    
    /**
     * constructor de usuario
     * @param username
     * @param password 
     */
    public Usuario(String username,String password){
        this.username=username;
        this.password=password;
    }
    
    /**
     * obtiene el usuario
     * @return username
     */
    @Id
    @Column(name = "username", nullable = false)
    public String getUsername() {
        return username;
    }

    /**
     * asigna usuario
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * obtiene contraseña
     * @return 
     */
    @Column(name="password", nullable = false)
    public String getPassword() {
        return password;
    }

    /**
     * asigna contraseña
     * @param password 
     */
    public void setPassword(String password) {
        this.password = password;
    }
  
}
