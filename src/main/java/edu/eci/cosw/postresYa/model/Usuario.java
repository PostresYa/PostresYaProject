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
    public Usuario(String username,String password){
        this.username=username;
        this.password=password;
    }
    @Id
    @Column(name = "username", unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
  
}
