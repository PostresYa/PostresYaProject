/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.stubReposteria.StubReposteriaI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Wilmer Orlando Cortez Conde
 */

@RestController
@RequestMapping(value="/reposterias")
public class ReposteriaController {
    
    @Autowired
    StubReposteriaI reposteria;
    
    public ReposteriaController(){
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Reposteria> getTodasReposterias(){
        return reposteria.getReposterias();
    }
    
    @RequestMapping(value="/nit", method = RequestMethod.GET)
    public Reposteria getReposteria(int nit){
        List <Reposteria> aux = reposteria.getReposterias();
        for(Reposteria a: aux){
            if(a.getNit() == nit){
                return a;
            }
        }
        return null;
    }
}
