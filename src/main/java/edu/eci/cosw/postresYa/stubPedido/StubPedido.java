/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stubPedido;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreCant;
import edu.eci.cosw.postresYa.model.PostreCantId;
import edu.eci.cosw.postresYa.model.PostreId;
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
        List <PostreCant> postres = new ArrayList<>();
        
     
        //Postres de prueba
        Postre p1 = new Postre(new PostreId("postre1","r1"), "MORA", 9000,"con leche");
        Postre p = new Postre(new PostreId("postre2","r1"), "LECHE", 15000,"asada");
         Postre p3 = new Postre(new PostreId("postre4","r1"), "MARACUYA", 7000,"asada");
        postres.add(new PostreCant(new PostreCantId("postre1", "r1", 1),p1, 1));
        postres.add(new PostreCant(new PostreCantId("postre2", "r1", 1),p, 3));
        postres.add(new PostreCant(new PostreCantId("postre4", "r1", 1),p3, 2));
      
        
        Date d=new Date("2016/03/11");
       
        //Adicion de los postres de prueba a la lista de los pedidos
        Pedido aux = new Pedido(postres, "Cll 8 #77-14" , d,"en espera",68000);
        pedidos.add(aux);
        Postre p2 = new Postre(new PostreId("postre3","r1"), "Arequipe", 18000,"con fresas");
        List <PostreCant> postres2 = new ArrayList<>();
       
        postres2.add(new PostreCant(new PostreCantId("postre3", "r1", 1),p2, 2));
        d=new Date("2016/03/10");
        //segundo pedido
        aux = new Pedido(postres2, "Calle 222 #25-32" , d,"en espera",36000);
       
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
    public void changeStatePedido(int codigo) throws PostreException {
       
        int pos=-1; 
        for (int i=0;i<pedidos.size();i++){
                
             if (pedidos.get(i).getCodigo() == codigo){
               
                 pos=i;
             }
         }
        if (pos==-1){
             throw new PostreException(PostreException.pedidoException);
        }else{
            pedidos.get(pos).setEstado("Enviado");
        }
    }
    
}
