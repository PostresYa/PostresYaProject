/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubPedido;

import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author diegorodriguecruz
 */

@Service
public class StubPedido {
    
    private List <Pedido> pedidos = new ArrayList<>();
    
    public StubPedido(){
        List <Postre> postres = new ArrayList<>();
        Postre p = new Postre("2","name",0,"description");
        postres.add(p);
        Pedido aux = new Pedido();//Implementar
        pedidos.add(aux);
    }
    
  //  @Override
    public List<Pedido> getPedidos(){
        return pedidos;
    }
}