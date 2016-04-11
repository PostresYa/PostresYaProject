/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.INVIMA.StubINVIMA;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.StatusRegistroInvima;
import edu.eci.cosw.postresYa.services.PostresYaServices;
import edu.eci.cosw.postresYa.stubReposteria.StubReposteriaI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    PostresYaServices stubReposteria;
    
    @Autowired
    StubINVIMA stubINVIMA;
    public ReposteriaController(){
        
    }
     
    @RequestMapping(method = RequestMethod.GET)
    public List<Reposteria> getAllReposterias() {
       
        
        try {
            return  stubReposteria.getAllReposterias();
        } catch (PostreException ex) {
            return new ArrayList<Reposteria>();
        }
    }
    @RequestMapping(value="/registroinvima/{nit}",method = RequestMethod.GET)
    public StatusRegistroInvima validarINVIMA(@PathVariable String nit){
       
        
        return  stubINVIMA.validarINVIMA(nit);
    }
    
  /*  @RequestMapping(method = RequestMethod.GET)
    public List<Reposteria> getTodasReposterias(){
        return reposteria.getReposterias();
    }*/
    
    @RequestMapping(value="/{nit}", method = RequestMethod.GET)
    public Reposteria getReposteria(@PathVariable String nit){
      
        try {
            return stubReposteria.getReposteriaByNit(nit);
        } catch (PostreException ex) {
           // Logger.getLogger(ReposteriaController.class.getName()).log(Level.SEVERE, null, ex);
            return new Reposteria();
        }
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public void saveReposteria(@RequestBody Reposteria reposteria){
        //System.out.println("entro"+ reposteria.getNit()+"   "+ reposteria.getUsuario().getPassword());
        try {
            stubReposteria.saveReposteria(reposteria);
        } catch (PostreException ex) {
            Logger.getLogger(ReposteriaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
     
     
}
