/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author duvan
 */

@Entity
@Table(name="Cliente")
public class Cliente implements Serializable {
    private int cedula;
    private BigInteger cuenta;
    private Usuario usuario;
    private String nombre;
    
    private String tipoTarjeta;

  
    /**
     * constructor vacio
     */
    public Cliente(){
        
    }
    /**
     * constructor cliente
     * @param cedula
     * @param cuenta
     * @param usuario
     * @param nombre 

     * @param tipoTarjeta 
     */
    public Cliente(int cedula,BigInteger cuenta,Usuario usuario,String nombre,String tipoTarjeta){
        this.cedula=cedula;
        this.cuenta=cuenta;
        this.usuario=usuario;
        this.nombre=nombre;
      
        this.tipoTarjeta=tipoTarjeta;
                
    }
    
    /**
     * cedula del cliente
     * @return 
     */
     @Id
    @Column(name = "cedula", nullable = false)
    public int getCedula() {
        return cedula;
    }
    
    

    /**
     * cedula del cliente
     * @param cedula 
     */
    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    /**
     * cuenta del cliente
     * @return 
     */
      @Column(name = "cuenta", nullable = false)
    public BigInteger getCuenta() {
        return cuenta;
    }

    /**
     * cambiar cuenta
     * @param cuenta 
     */
    public void setCuenta(BigInteger cuenta) {
        this.cuenta = cuenta;
    }
/**
 * usuario del cliente
 * @return 
 */
     @ManyToOne()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Usuario_username", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * cambiar usuario
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * nombre del cliente
     * @return 
     */
      @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return nombre;
    }

    /**
     * cambiar nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    /**
     * trae tarjeta
     * @return 
     */
     @Column(name = "tipoTarjeta", nullable = false)
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }
  

    
    
}
