/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author duvan
 */
public class Reposteria {
    private int nit;
    private String name;
    private List<Postre> postres;
    private String coverageRange; //no sabemos como tratar el rango
    
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
    public Reposteria(int nit,String name,String coverageRange){
        this.nit=nit;
        this.name=name;
        this.coverageRange=coverageRange;
        postres=new ArrayList<Postre>();
    }
    
    /**
     * Busca el nit de la repostería 
     * @return int Nit de la reposteria
     */
    public int getNit() {
        return nit;
    }
    
    /**
     * Cambia el valor del nit de la repostería
     * @param nit 
     */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /**
     * Busca el nombre de la repostería
     * @return name
     */
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
    public List<Postre> getPostres() {
        return postres;
    }

    /**
     * Agrega un nuevo postre al catálogo de la repostería
     * @param postre 
     */
    public void addPostres(Postre postre) {
        postres.add(postre);
    }
    
    /**
     * Busca el rango de cobertura de la repostería
     * @return 
     */
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
 
    
}
