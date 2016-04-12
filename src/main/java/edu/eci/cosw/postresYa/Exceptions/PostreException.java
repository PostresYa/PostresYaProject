/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.Exceptions;


/**
 * Define las excepciones que se pueden presentar en el API
 * de PostresYa
 * @author duvan
 * 
 */
public class PostreException extends Exception{
    public final static String postreException="Postre 404"; 
    public final static String pedidoException="Pedido 404"; 
    public PostreException(String message){
        super(message);
    }
    
    
}
