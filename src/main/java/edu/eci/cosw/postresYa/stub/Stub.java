/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.model.Postre;
import java.util.List;

/**
 *
 * @author 2095499
 */
public interface Stub {
    List<Postre> getPostres();
    void addPostre(Postre postre);
}
