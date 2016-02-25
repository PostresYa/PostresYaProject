/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.Exceptions;

import edu.eci.cosw.postresYa.stub.StubPostre;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author duvan
 */
public class PostreException extends Exception{
    public final static String postreException="Postre 404"; 
    public PostreException(String message){
        super(message);
    }
    
    
}
