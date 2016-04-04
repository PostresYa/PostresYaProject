/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    private Set<Postre> postres= new HashSet<>(0);
    private String coverageRange; //no sabemos como tratar el rango
    private Usuario usuario;

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
     */
    public Reposteria(String nit,String name,String coverageRange,Usuario usuario){
        this.nit=nit;
        this.name=name;
        this.coverageRange=coverageRange;
        //postres=new ArrayList<Postre>();
        this.usuario=usuario;
    }
    
    /**
     * Busca el nit de la repostería 
     * @return int Nit de la reposteria
     */
    
    @Id
    @Column(name = "nit", unique = true, nullable = false)
	
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
    
    //@Column(name = "name", unique = true, nullable = false)

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
    /*@OneToMany(cascade = CascadeType.ALL)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Reposteria_nit")
    public Set<Postre> getPostres() {
        return postres;
    }
    public void setPostre(Set<Postre> postres) {
        this.postres=postres;
    }*/

    /**
     * Agrega un nuevo postre al catálogo de la repostería
     * @param postre 
     */
    /*public void addPostres(Postre postre) {
        postres.add(postre);
    }*/
    
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
    
    @OneToOne()
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name="Usuario_username",unique = true, nullable = false)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 
    
}
