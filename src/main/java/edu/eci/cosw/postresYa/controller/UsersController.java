/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import java.security.Principal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {  
    
    
    /**
     * Busca si el usuario tiene autorización en la aplicación
     * @param user usuario
     * @return user usuario 
     */
    @RequestMapping("/app/user")
    public Principal user(Principal user) {
        
       
        return user;
    }           
}