/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubReposteria;

import edu.eci.cosw.postresYa.model.Reposteria;
import java.util.List;

/**
 *
 * @author Familia CC
 */
public interface StubReposteriaI {
    
    
    public List <Reposteria> getReposterias();
    public void modificarReposteria(int codigo);
}
