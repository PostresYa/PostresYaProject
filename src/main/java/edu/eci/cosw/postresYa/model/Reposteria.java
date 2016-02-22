/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.model;

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

    public void setPostres(List<Postre> postres) {
        this.postres = postres;
    }

    public String getCoverageRange() {
        return coverageRange;
    }

    public void setCoverageRange(String coverageRange) {
        this.coverageRange = coverageRange;
    }
 
    
}
