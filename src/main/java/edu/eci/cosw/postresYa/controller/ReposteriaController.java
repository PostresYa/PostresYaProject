/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.INVIMA.StubINVIMA;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.StatusRegistroInvima;
import edu.eci.cosw.postresYa.stubReposteria.StubReposteriaI;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wilmer Orlando Cortez Conde
 */

@RestController
@RequestMapping(value="/reposterias")
public class ReposteriaController {
    
    @Autowired
    StubReposteriaI reposteria;
    
    @Autowired
    StubINVIMA stubINVIMA;
    public ReposteriaController(){
        
    }
    
    @RequestMapping(value="/registroinvima/{nit}",method = RequestMethod.GET)
    public StatusRegistroInvima validarINVIMA(@PathVariable String nit){
       
        
        return  stubINVIMA.validarINVIMA(nit);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Reposteria> getTodasReposterias(){
        return reposteria.getReposterias();
    }
    
    @RequestMapping(value="/nit", method = RequestMethod.GET)
    public Reposteria getReposteria(String nit){
        List <Reposteria> aux = reposteria.getReposterias();
        for(Reposteria a: aux){
            if(a.getNit().equals(nit)){
                return a;
            }
        }
        return null;
    }
}
