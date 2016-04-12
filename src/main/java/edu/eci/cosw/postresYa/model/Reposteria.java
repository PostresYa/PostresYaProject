     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;



import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author duvan
 */

@Entity
@Table(name="Reposteria")
public class Reposteria implements java.io.Serializable  {
    private String nit;
    private String name;
   private List<Postre> postres= new ArrayList<Postre>();
    private String coverageRange; //no sabemos como tratar el rango
    private Usuario usuario;
    private String direccion;

    /**
     * Constructor sin parametros de la reposteria
     */
    public Reposteria(){
        
    }
    
    /**
     * Constructor con parametros para la reposteria
     * @param nit //NIT de identificacion de la reposteria
     * @param name // Nombre de la reposteria
     * @param coverageRange // Rando de cobertura de la reposteria
     * @param postres

     */
    public Reposteria(String nit,String name,String coverageRange,List<Postre> postres,Usuario usuario,String direccion){
        this.nit=nit;
        this.name=name;
        this.coverageRange=coverageRange;
        //postres=new ArrayList<Postre>();
        this.postres=postres;
        this.usuario=usuario;
        this.direccion=direccion;
    }
 
    /**
     * Busca el nit de la repostería 
     * @return int Nit de la reposteria
     */
    
    @Id
    @Column(name = "nit", nullable = false)
    public String getNit() {
        return nit;
    }
    
    /**
     * Cambia el valor del nit de la repostería
     * @param nit 
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Busca el nombre de la repostería
     * @return name
     */
    
    @Column(name = "nombre", nullable = false)

    public String getName() {
        return name;
    }

    /**
     * Cambia el valor del nombre de la repostería
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Busca el catálogo de postres de la repostería
     * @return 
     */
    @OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Reposteria_nit")
    public List<Postre> getPostres() {
        return postres;
    }
    
    /**
     * Asigna un postre en la lista de postres
     * @param postres 
     */
    public void setPostres(List<Postre> postres) {
        this.postres=postres;
    }

    
    /**
     * Busca el rango de cobertura de la repostería
     * @return 
     */
    
    @Column(name = "rango_cobertura",  nullable = false)
    public String getCoverageRange() {
        return coverageRange;
    }

    /**
     * Cambia el valor del rango de cobertura de la repostería
     * @param coverageRange 
     */
    public void setCoverageRange(String coverageRange) {
        this.coverageRange = coverageRange;
    }
    
    /**
     * obtiene el usuario
     * @return 
     */
    @ManyToOne()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "Usuario_username", nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * asigna un usuario a los usuarios ya creados
     * @param usuario 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    @Column(name = "direccion",  nullable = false)
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
