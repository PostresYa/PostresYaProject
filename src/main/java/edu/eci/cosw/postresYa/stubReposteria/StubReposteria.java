/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

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
    
 

    @Override
    public Reposteria getReposteriaByNit(String nit) throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveReposteria(Reposteria reposteris) throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Reposteria> getAllReposterias() throws PostreException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
