/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;

import edu.eci.cosw.postresYa.services.PostresYaServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
    PostresYaServices pedido;
    /**
     * Constructor vacio para el controlador de pedido
     */
    
    public PedidoController(){
        
    }
    
    /**
     * Metodo GET para obtener los pedidos
     * @param nit nit
     * @return Se entrega la lista de los valores realizados
     * @throws PostreException postreException
     */
    @RequestMapping(value="/{nit}",method = RequestMethod.GET)
    public List<Pedido> getPedidos(@PathVariable String nit) throws PostreException{
        return pedido.getPedidosByNit(nit);
    }
    
    /**
     * Metodo POST realizado para el cambio de estado de algun pedido
     * @param codigo //Codigo del pedido al cual se le desea cambiar el estado
     * @throws PostreException postreException
     */
    @RequestMapping(value="/change", method=RequestMethod.POST)
     public void changeStatePedido(@RequestBody int codigo) throws PostreException {
       pedido.cambiarEstadoPedido(codigo);
       // pedido.changeStatePedido(codigo);
    }
     
    @RequestMapping(method = RequestMethod.POST)
    public void addPedido(@RequestBody Pedido p)throws PostreException{
        pedido.addPedido(p);
    }

    
}
