/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duvan
 */

//@Service
public class ServicesReposteria implements StubReposteriaI{

    @Autowired
    ReposteriaRepository reposteriaRepository;
    
    @Override
    public List<Reposteria> getReposterias() {
        
     // return reposteriaRepository.getAllReposterias();
       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    

    @Override
    public void modificarReposteria(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
