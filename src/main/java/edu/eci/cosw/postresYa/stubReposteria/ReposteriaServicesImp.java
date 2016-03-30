/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.persistence.ReposteriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duvan
 */

//@Service
public class ReposteriaServicesImp implements StubReposteriaI{
     @Autowired 
    ReposteriaRepository reposteriaRepository;

    @Override
    public List<Reposteria> getReposterias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarReposteria(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean login(String nit, String pass) {
    /*  Reposteria r=reposteriaRepository.findOne(nit);
        
        
        if (r==null){
            return false;
        }
        return true;        
    }*/return true;
    }
}
