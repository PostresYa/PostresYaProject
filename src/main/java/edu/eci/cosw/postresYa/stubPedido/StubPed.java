/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubPedido;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;
import java.util.List;

/**
 *
 * @author Diego Alejandro Rodriguez Cruz
 */
public interface StubPed {
    
    List <Pedido> getPedidos() throws PostreException;

    public void changeStatePedido(String codigo) throws PostreException;
}
