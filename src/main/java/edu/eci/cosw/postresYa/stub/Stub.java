/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;

import java.io.InputStream;
import java.util.List;


/**
 *
 * @author 2095499
 */
public interface Stub {
    List<Postre> getPostres(String nit) throws PostreException;
    Postre getPostre(String nit,String code) throws PostreException;
    void addPostre(Postre postre,String nit) throws PostreException;
    void changePostre(Postre postre,String nit) throws PostreException;
  

    public InputStream getPostrePicture(String code) throws PostreException;
    
    
}
