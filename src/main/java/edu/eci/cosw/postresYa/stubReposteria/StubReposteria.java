/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.Exceptions.PostreException;

import edu.eci.cosw.postresYa.model.Reposteria;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Familia CC
 */
//@Service
public class StubReposteria implements StubReposteriaI {
    
    List <Reposteria> reposterias = new ArrayList<>();
    
    public StubReposteria(){
        //Reposteria r1 = new Reposteria("1", "Reposteria 1", "Zona Norte",new ArrayList<Postre>(),new Usuario("r1", "pass1")); 
        //Postre p = new Postre (new PostreId("1","r1"), "Tres leches", 5000,"vaso grande");
       // r1.addPostres(p);
        //reposterias.add(r1);
    }
    
 
    /**
     * obtiene reposteria por el nit
     * @param nit
     * @return
     * @throws PostreException 
     */
    @Override
    public Reposteria getReposteriaByNit(String nit) throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * guarda la reposteria
     * @param reposteris
     * @throws PostreException 
     */
    @Override
    public void saveReposteria(Reposteria reposteris) throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * obtiene todas las reposterias
     * @return
     * @throws PostreException 
     */
    @Override
    public List<Reposteria> getAllReposterias() throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
