/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubPedido;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Diego Alejandro Rodriguez Cruz
 */

@Service
public class StubPedido implements StubPed{
    
    private List<Pedido> pedidos = new ArrayList<>();

    /**
     * El constructor del StubPedido instancia un nuevo objeto pedido
     * almacenando en memoria
     */
    public StubPedido(){
        List <Postre> postres = new ArrayList<>();
        Postre p1 = new Postre("1", "MORA", 100,"description MORA");
        Postre p = new Postre("2", "LECHE", 20,"description leche");
        postres.add(p);
        postres.add(p1);
        Date d=new Date("2016/03/20");
        Pedido aux = new Pedido(postres, "direccion" , "pedido1", d);
        pedidos.add(aux);
        p = new Postre("p3", "pedido 2", 250,"description leche");
        postres.add(p);
        d=new Date("2016/03/10");
        aux = new Pedido(postres, "direccion" , "pedisadfksdfhsdkj", d);
        pedidos.add(aux);
    }
    
    /**
     * Conjunto de pedidos
     * @return pedidos
     */
    @Override
    public List<Pedido> getPedidos() {
    
        return pedidos;
        
    }

    /**
     * Cambia con base al codido del pedido el estado
     * @param codigo
     * @throws PostreException 
     */
    @Override
    public void changeStatePedido(String codigo) throws PostreException {
       
        int pos=-1; 
        for (int i=0;i<pedidos.size();i++){
                
             if (pedidos.get(i).getCodigo().equals(codigo)){
               
                 pos=i;
             }
         }
        if (pos==-1){
             throw new PostreException(PostreException.pedidoException);
        }else{
            pedidos.get(pos).setEstado();
        }
    }
    
}
