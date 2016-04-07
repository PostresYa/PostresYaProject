/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author duvan
 */

@Service
public class ServicesPostre implements Stub{

    @Autowired
    PostreRepository postreRepository;
    @Override
    public List<Postre> getPostres(String nit) throws PostreException {
        return postreRepository.getPostresReposteria(nit);
    }

    @Override
    public void addPostre(Postre postre,String nit) throws PostreException {
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
        
           }

    @Override
    public void changePostre(Postre postre,String nit) throws PostreException {
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
     
    }

   
    @Override
    public InputStream getPostrePicture(String code) throws PostreException {
        try {
            return new FileInputStream("src/main/resources/static/app/images/Postre1.png");
        } catch (FileNotFoundException ex) {
            return null;
            //Logger.getLogger(ServicesPostre.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    @Override
    public Postre getPostre(String nit, String code) throws PostreException {
       Postre p=postreRepository.findOne(new PostreId(code,nit));
        if(p==null){
            p=new Postre();
        }
        return p;
    }
    
}
