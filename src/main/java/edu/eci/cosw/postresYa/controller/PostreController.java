/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.stub.Stub;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

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
    public List<Postre> getPostre() {
        return stub.getPostres();
    }
    
    @RequestMapping(value="/{code}", method = RequestMethod.GET)
    public boolean isPostre(@RequestBody code){
        
    }
    
    @RequestMapping (method = RequestMethod.POST)
    public void postPostre(@RequestBody Postre postre) {
        stub.addPostre(postre);
    }
    
    
}
