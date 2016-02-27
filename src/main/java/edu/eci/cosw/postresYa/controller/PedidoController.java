/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.stubPedido.StubPed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Pedido> getPedidos() {
        return pedido.getPedidos();
    }
  
    @RequestMapping(value="/postres", method = RequestMethod.GET)
    public List<Postre> getPostresPedido(int codPedido) {
        List<Pedido>aux =pedido.getPedidos();
        
        for(Pedido p : aux){
            if(p.getCodigo() == codPedido){
                List<Postre> postres = p.getPostres();
                return postres;
            }
                
        }
        return null;
    }
    
}
