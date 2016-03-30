/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.Reposteria;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Familia CC
 */
@Service
public class StubReposteria implements StubReposteriaI {
    
    List <Reposteria> reposterias = new ArrayList<>();
    
    public StubReposteria(){
        Reposteria r1 = new Reposteria(1, "Reposteria 1", "Zona Norte"); 
        Postre p = new Postre ("1", "Tres leches", 5000,"vaso grande");
        r1.addPostres(p);
        reposterias.add(r1);
    }
    
    @Override
    public List<Reposteria> getReposterias() {
        return reposterias;
    }

    @Override
    public void modificarReposteria(int codigo) {
        
    }
    
}
