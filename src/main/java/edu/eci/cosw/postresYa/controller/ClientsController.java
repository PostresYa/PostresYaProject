/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Cliente;
import edu.eci.cosw.postresYa.services.PostresYaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duvan
 */
@RestController
@RequestMapping(value="/cliente")
public class ClientsController {
    
    @Autowired
    PostresYaServices cliente;
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public Cliente getClienteByUsername(@PathVariable String username)throws PostreException{
        return cliente.getClienteByUsername(username);
    }
}
