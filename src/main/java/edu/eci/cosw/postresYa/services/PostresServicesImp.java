/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.services;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Cliente;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreCant;
import edu.eci.cosw.postresYa.model.PostreCantId;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.repositories.ClienteRepository;
import edu.eci.cosw.postresYa.repositories.PedidoRepository;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2096844
 */

@Service
public class PostresServicesImp implements PostresYaServices{
     
    @Autowired
    PostreRepository postreRepository;
    
    @Autowired
    ReposteriaRepository reposteriaRepository;
        
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    PedidoRepository pedidoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;
    /**
     * obtiene postres con base al nit
     * @param nit
     * @return
     * @throws PostreException 
     */
    @Override
    public List<Postre> getPostres(String nit) throws PostreException {
        return postreRepository.getPostresReposteria(nit);
    }

    /**
     * agrega un postres
     * @param postre
     * @param nit
     * @throws PostreException 
     */
    @Override
    public void addPostre(Postre postre,String nit) throws PostreException {
        
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
        
    }

    /**
     * cambia un postre
     * @param postre
     * @param nit
     * @throws PostreException 
     */
    @Override
    public void changePostre(Postre postre,String nit) throws PostreException {
        postre.getId().setReposteriaNit(nit);
        postreRepository.save(postre);
     
    }


    /**
     * obtiene postre
     * @param nit
     * @param code
     * @return
     * @throws PostreException 
     */
    @Override
    public Postre getPostre(String nit, String code) throws PostreException {
       Postre p=postreRepository.findOne(new PostreId(code,nit));
        if(p==null){
            p=new Postre();
        }
        return p;
    }
    
    /**
     * obtiene reposteria por nit
     * @param nit
     * @return
     * @throws PostreException 
     */
    @Override
    public Reposteria getReposteriaByNit(String nit) throws PostreException{
         return reposteriaRepository.findOne(nit);
    }

    /**
     * guarda la reposteria creada
     * @param reposteria
     * @throws PostreException 
     */
    @Override
    public void saveReposteria(Reposteria reposteria) throws PostreException {
 
        userRepository.save(reposteria.getUsuario());
        reposteriaRepository.save(reposteria);
    }

    /**
     * obtiene todas las reposterias
     * @return
     * @throws PostreException 
     */
    @Override
    public List<Reposteria> getAllReposterias() throws PostreException {
       return reposteriaRepository.findAll();
          }

    @Override
    public List<Pedido> getPedidosByNit(String nit) throws PostreException {
        List <PostreCant> postres = new ArrayList<>();        
        //Postres de prueba
        Postre p = postreRepository.findOne(new PostreId("flan1", "r1"));
        postres.add(new PostreCant(new PostreCantId(p.getId().getCode(),p.getId().getReposteriaNit()), p, 4));
        //Pedido pedido = new Pedido(postres, nit, new Date(), nit, 0, clienteRepository.getClienteByCedula(1014238039));
   
        
        
         
        return pedidoRepository.getPedidosByNit(nit);
        
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }



    @Override
    public void cambiarEstadoPedido(int code) throws PostreException {
        Pedido p = pedidoRepository.findOne(code);
        p.setEstado("Enviado");
        pedidoRepository.save(p);
    }

    @Override
    public void addPedido(Pedido p) throws PostreException {
        pedidoRepository.save(p);
    }
    
    @Override
    public Cliente getClienteByCedula(Integer cedula)throws PostreException{        
        return clienteRepository.getClienteByCedula(cedula);
    }
    
    @Override
    public Cliente getClienteByUsername(String username) throws PostreException{
         return  clienteRepository.getClienteByUsername(username);
    }
    
}
