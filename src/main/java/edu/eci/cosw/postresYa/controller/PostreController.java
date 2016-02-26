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
    /*
    *busca la lista de postres en el stub
    *@return Set<Postre>, en caso de que no tenga ningun postre devolvera un set vacio
    */
    @RequestMapping(method = RequestMethod.GET)
    public Set<Postre> getPostre() {
        

        return stub.getPostres();
    }
    
 
     /*
    *Añade un postre nuevo (el código de este no esta utilizado) a la lista de postres del stub
    *@Params Postre postre
    *@return void
    */
    @RequestMapping (method = RequestMethod.POST)
    public void postPostre(@RequestBody Postre postre) throws PostreException {
        stub.addPostre(postre);
    }
    
     /*
    *Cambia los datos de un postre ya existente en la lista de postres del stub
    *@Params Postre postre
    *@return void
    */
     @RequestMapping (value="/change", method = RequestMethod.POST)
    public void changePostre(@RequestBody Postre postre) throws PostreException {
        stub.changePostre(postre);
    }
    
     /*
    *Busca la imagen a un postre asociado por medio de un código dado, y la devuleve en una conexión abierta para hacer más rapido el programa
    *en caso de que no la encuentre devuleve un HttpStatus.NOT_FOUND
    *@Params String code
    *@return ResponseEntity<InputStreamResource>
    */    
    @RequestMapping(value="/{code}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPostrePicture(@PathVariable String code){
        
      
        try{
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("image/jpg")).body(new InputStreamResource(stub.getPostrePicture(code)));
        }catch(Exception e){
            
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }
    
    
}
