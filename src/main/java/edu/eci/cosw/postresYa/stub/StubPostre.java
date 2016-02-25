/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import java.io.BufferedInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import java.net.MalformedURLException;
import java.util.Iterator;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

/**
 *
 * @author 2095499
 */
@Service
public class StubPostre implements Stub{
   // private List<Postre> postres= new ArrayList<>();

    
    private static LinkedHashSet<Postre> postres;
    private static LinkedHashMap<String, Postre> postresMap;
    private static LinkedHashMap<String, String> postresImages;
    
    public StubPostre() throws PostreException {
        postres= new LinkedHashSet<>();
        postresMap= new LinkedHashMap<>();
        postresImages= new LinkedHashMap<>();
        Postre prueba=new Postre("p1", "prueba", 15000, "4 porciones, rico");
        postres.add(prueba);
        postresMap.put(prueba.getCode(), prueba);
        postresImages.put(prueba.getCode(),"src/main/resources/static/app/images/Postre1.png");
    }
    @Override
    public Set<Postre> getPostres() {
        return postres;
    }

    @Override
    public void addPostre(Postre postre) throws PostreException{
       
        postres.add(postre);
        postresMap.put(postre.getCode(), postre);
        postresImages.put(postre.getCode(),"src/main/resources/static/app/images/PostreNuevo.png");
    }

    @Override
    public Postre getPostreByCode(String code) throws PostreException{
        
        return postresMap.get(code);
    }

    @Override
    public InputStream getPostrePicture(String code) throws PostreException {
        
        
        try {
            return new BufferedInputStream(
                    new FileInputStream(postresImages.get(code)));
            //return postresImages.get(code).openStream();
        } catch (FileNotFoundException ex) {
            
            throw new PostreException(PostreException.postreException);
           
        }
        
       
    }

    @Override
    public void changePostre(Postre postre) throws PostreException {
        
        Postre postreDelete=null;
        Iterator<Postre> iterator= postres.iterator();
        for(int i=0;i<postres.size();i++){
            if(iterator.hasNext()){
                Postre postretemp=iterator.next();
                if (postretemp.getCode().equals(postre.getCode())){
                  postreDelete=postretemp;
                }
            }
        }
       
        postres.remove(postreDelete);
        postres.add(postre);
        changeReference(postre);
        
    }
    
    private void changeReference(Postre postre){
        postresMap.get(postre.getCode()).setName(postre.getName());
        postresMap.get(postre.getCode()).setDescription(postre.getDescription());
        postresMap.get(postre.getCode()).setPrice(postre.getPrice());
        
    }
    
}
