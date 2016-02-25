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
    
}
