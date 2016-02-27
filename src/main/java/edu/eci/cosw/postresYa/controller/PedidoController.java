/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.stubPedido.StubPed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author WilmerOrlandoCortezConde
 */

@RestController
@RequestMapping(value="/pedidos")
public class PedidoController {
    
    @Autowired
    StubPed pedido;
    
    public PedidoController(){
        
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Pedido> getPedidos() throws PostreException{
        return pedido.getPedidos();
    }
    
    @RequestMapping(value="/change", method=RequestMethod.POST)
     public void changeStatePedido(@RequestBody String codigo) throws PostreException {
         System.out.println(codigo);
        pedido.changeStatePedido(codigo);
    }

    
}
