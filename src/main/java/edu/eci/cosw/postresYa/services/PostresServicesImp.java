/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.services;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Cliente;
import edu.eci.cosw.postresYa.model.Confirmacion;
import edu.eci.cosw.postresYa.model.Pago;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreCant;
import edu.eci.cosw.postresYa.model.PostreCantId;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.StatusRegistroInvima;
import edu.eci.cosw.postresYa.repositories.ClienteRepository;
import edu.eci.cosw.postresYa.repositories.PedidoRepository;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.lang.Integer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.xml.ws.http.HTTPException;
import org.springframework.web.client.HttpClientErrorException;

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
    public Confirmacion addPedido(Pedido p) throws PostreException {
        Confirmacion confirmacion;
        Pago pago= new Pago(""+p.getCliente().getCuenta(), "123", p.getCliente().getTipoTarjeta(), p.getCliente().getNombre(), "234567893434-bancolombia", "pago pedido postresYa a"+p.getPostres().get(0).getPostreCantId().getReposteriaNit(), p.getPrecio());
        
        RestTemplate rt = new RestTemplate();
        
        try{
        String responseType= rt.postForObject("http://paymentsgateway.herokuapp.com/rest/payments", pago,String.class);
        confirmacion=new Confirmacion(responseType);
        System.out.println("este es el codigo de confirmacion"+responseType);
        List<PostreCant> postres=p.getPostres();
        
        //Date date= new Date();
        //DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //System.out.println("Hora y fecha: "+hourdateFormat.format(date));
        //p.setFecha(new Date(hourdateFormat.format(date)));
        p.setPostres(new ArrayList<PostreCant>());
        
        pedidoRepository.save(p);
        for(int i=0;i<postres.size();i++){
            postres.get(i).getPostreCantId().setIdPedido(p.getCodigo());
        }
        p.setPostres(postres);
        pedidoRepository.save(p);
        }catch(HTTPException e){
            System.out.println("este es el codigo del error"+ e.getStatusCode());
            confirmacion= new Confirmacion(""+e.getStatusCode());
        }
        return confirmacion;
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
