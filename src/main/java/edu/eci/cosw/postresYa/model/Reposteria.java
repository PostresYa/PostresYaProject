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
    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Postre> getPostres() {
        return postres;
    }

    public void addPostres(Postre postre) {
        postres.add(postre);
    }
    public String getCoverageRange() {
        return coverageRange;
    }

    public void setCoverageRange(String coverageRange) {
        this.coverageRange = coverageRange;
    }
 
    
}
