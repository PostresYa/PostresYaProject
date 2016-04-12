/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.services;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.Reposteria;
import java.io.InputStream;
import java.util.List;

/**
 *
 * @author 2096844
 */
public interface PostresYaServices {
     List<Postre> getPostres(String nit) throws PostreException;
    Postre getPostre(String nit,String code) throws PostreException;
    void addPostre(Postre postre,String nit) throws PostreException;
    void changePostre(Postre postre,String nit) throws PostreException;
     
      Reposteria getReposteriaByNit(String nit) throws PostreException;
    void saveReposteria(Reposteria reposteria) throws PostreException;
    List<Reposteria> getAllReposterias() throws PostreException;
    
     List<Pedido> getPedidosByNit(String nit) throws PostreException;
     void cambiarEstadoPedido(int code) throws PostreException;
}
