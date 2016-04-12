/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.services;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2096844
 */

@Service
public class PostresServicesImp implements PostresYaServices{
     
    @Autowired
    PostreRepository postreRepository;
    
    @Autowired
    ReposteriaRepository reposteriaRepository;
        
    @Autowired
    UserRepository userRepository;
    
    /**
     * obtiene postres con base al nit
     * @param nit
     * @return
     * @throws PostreException 
     */
    @Override
    public List<Postre> getPostres(String nit) throws PostreException {
        return postreRepository.getPostresReposteria(nit);
    }

    /**
     * agrega un postres
     * @param postre
     * @param nit
     * @throws PostreException 
     */
    @Override
    public void addPostre(Postre postre,String nit) throws PostreException {
        
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
        
    }

    /**
     * cambia un postre
     * @param postre
     * @param nit
     * @throws PostreException 
     */
    @Override
    public void changePostre(Postre postre,String nit) throws PostreException {
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
     
    }

   /**
    * obiene la imagen de un postre
    * @param code
    * @return
    * @throws PostreException 
    */
    @Override
    public InputStream getPostrePicture(String code) throws PostreException {
        try {
            return new FileInputStream("src/main/resources/static/app/images/Postre1.png");
        } catch (FileNotFoundException ex) {
            return null;
            //Logger.getLogger(ServicesPostre.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    /**
     * obtiene postre
     * @param nit
     * @param code
     * @return
     * @throws PostreException 
     */
    @Override
    public Postre getPostre(String nit, String code) throws PostreException {
       Postre p=postreRepository.findOne(new PostreId(code,nit));
        if(p==null){
            p=new Postre();
        }
        return p;
    }
    
    /**
     * obtiene reposteria por nit
     * @param nit
     * @return
     * @throws PostreException 
     */
    @Override
    public Reposteria getReposteriaByNit(String nit) throws PostreException{
         return reposteriaRepository.findOne(nit);
    }

    /**
     * guarda la reposteria creada
     * @param reposteria
     * @throws PostreException 
     */
    @Override
    public void saveReposteria(Reposteria reposteria) throws PostreException {
 
        userRepository.save(reposteria.getUsuario());
        reposteriaRepository.save(reposteria);
    }

    /**
     * obtiene todas las reposterias
     * @return
     * @throws PostreException 
     */
    @Override
    public List<Reposteria> getAllReposterias() throws PostreException {
       return reposteriaRepository.findAll();
          }
    
}
