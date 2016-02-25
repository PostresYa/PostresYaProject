/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;
import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.stub.Stub;
import java.io.IOException;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author 2095499
 */
@RestController
@RequestMapping(value="/postres")
public class PostreController {
    
    
    @Autowired
    Stub stub;
    public PostreController(){

    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Set<Postre> getPostre() {
        

        return stub.getPostres();
    }
    
 
    
    @RequestMapping (method = RequestMethod.POST)
    public void postPostre(@RequestBody Postre postre) throws PostreException {
        stub.addPostre(postre);
    }
    
     @RequestMapping (value="/change", method = RequestMethod.POST)
    public void changePostre(@RequestBody Postre postre) throws PostreException {
        stub.changePostre(postre);
    }
    
        
    @RequestMapping(value="/{code}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPostrePicture(@PathVariable String code){
        
      
        try{
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(stub.getPostrePicture(code)));
        }catch(Exception e){
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
    
    
}
