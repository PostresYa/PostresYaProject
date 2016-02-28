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
    
    /**
     * El constructor del StubPostre instancia un nuevo objeto postre
     * y los almacena en memoria
     * @throws PostreException 
     */
    public StubPostre() throws PostreException {
        postres= new LinkedHashSet<>();
        postresMap= new LinkedHashMap<>();
        postresImages= new LinkedHashMap<>();
        Postre prueba=new Postre("p1", "prueba", 15000, "4 porciones, rico");
        postres.add(prueba);
        postresMap.put(prueba.getCode(), prueba);
        postresImages.put(prueba.getCode(),"src/main/resources/static/app/images/Postre1.png");
    }
    
    /**
     * 
     * @return un conjunto de postres
     */
    @Override
    public Set<Postre> getPostres() {
        return postres;
    }
   
    /**
     * Añade un postre al stub, en caso de que no se pueda registrar se envía una excepción (PostreException)
     * @param Postre postre 
     * @throws PostreException 
     */
    @Override
    public void addPostre(Postre postre) throws PostreException{
       
        postres.add(postre);
        postresMap.put(postre.getCode(), postre);
        postresImages.put(postre.getCode(),"src/main/resources/static/app/images/PostreNuevo.png");
    }

    /**
     * Busca un postre por medio del código asociado
     * @param code
     * @return
     * @throws PostreException si el postre a consultar no es encontrado
     */
    @Override
    public Postre getPostreByCode(String code) throws PostreException{
        
        return postresMap.get(code);
    }
   
    /**Busca la imagen de un postre por medio del código asociado
     * 
     * @param code
     * @return InputStream con la imagen del producto solicitado
     * @throws PostreException si el postre no se encuentra
     */
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
    
    /**
     * Busca un postre asociado a un código, para modificar sus valores
     * @param postre
     * @throws PostreException postre no encontrado
     */
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
    
    
    
    /**
     * Cambia la asociación de los hash, con un postre dado
     * @param postre 
     */
    private void changeReference(Postre postre){
        postresMap.get(postre.getCode()).setName(postre.getName());
        postresMap.get(postre.getCode()).setDescription(postre.getDescription());
        postresMap.get(postre.getCode()).setPrice(postre.getPrice());
        
    }
    
}
