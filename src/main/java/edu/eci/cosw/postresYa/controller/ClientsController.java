/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import javax.annotation.security.RolesAllowed;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author duvan
 */
@RestController
@RequestMapping(value="/cliente")
public class ClientsController {
    @RequestMapping(value="/check")
   @Secured({"cliente"})
    
    public ResponseEntity<?> check(){
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
