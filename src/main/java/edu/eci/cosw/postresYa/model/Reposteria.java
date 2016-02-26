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
    
    public Reposteria(){
        
    }
    public Reposteria(int nit,String name,String coverageRange){
        this.nit=nit;
        this.name=name;
        this.coverageRange=coverageRange;
        postres=new ArrayList<Postre>();
    }
    
    
         /*
    *Busca el nit de la repostería 
    *@Return int nit
    */ 
    public int getNit() {
        return nit;
    }
    
       /*
    *Cambia el valor del nit de la repostería
    *@Params int nit
    *@Return void
    */
    public void setNit(int nit) {
        this.nit = nit;
    }

    /*
    *Busca el nombre de la repostería
    *@Return String name
    */
    public String getName() {
        return name;
    }

       /*
    *Cambia el valor del nombre de la repostería
    *@Params String name
    *@Return void
    */
    public void setName(String name) {
        this.name = name;
    }

  
           /*
    *Busca el catálogo de postres de la repostería
    *@Return List<Postres> postres
    */ 
    public List<Postre> getPostres() {
        return postres;
    }

       /*
    *Agrega un nuevo postre al catálogo de la repostería
    *@Params Postre postre
    *@Return void
    */
    public void addPostres(Postre postre) {
        postres.add(postre);
    }
    
           /*
    *Busca el rango de cobertura de la repostería 
    *@Return String coverageRange
    */ 
    public String getCoverageRange() {
        return coverageRange;
    }

       /*
    *Cambia el valor del rango de cobertura de la repostería
    *@Params  String coverageRange
    *@Return void
    */
    public void setCoverageRange(String coverageRange) {
        this.coverageRange = coverageRange;
    }
 
    
}
