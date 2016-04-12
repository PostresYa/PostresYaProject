/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.controller;
import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.services.PostresYaServices;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.rowset.serial.SerialBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author 2095499
 */
@RestController
@RequestMapping(value="/postres")
public class PostreController {
    
    
    @Autowired
    PostresYaServices stub;
    /**
     * Constructor del controlador de postres
     */
    public PostreController(){

    }
   
    /**
     * busca la lista de postres en el stub
     * @param nit
     * @return un conjunto con los postres, en caso de que no tenga ningun postre devolvera un conjunto vacio
     * @throws edu.eci.cosw.postresYa.Exceptions.PostreException
     */
    @RequestMapping(value="/{nit}",method = RequestMethod.GET)
    public List<Postre> getPostres(@PathVariable String nit) throws PostreException {
        
        return stub.getPostres(nit);
    }
    
    /**
     * busca en la lista de postres en el stub con su codigo correspondiente de producto
     * @param nit
     * @param code
     * @return un conjunto de postres con base a un codigo de postres
     * @throws edu.eci.cosw.postresYa.Exceptions.PostreException 
     */
    @RequestMapping(value="/{nit}/{code}",method = RequestMethod.GET)
    public Postre getPostre(@PathVariable String nit,@PathVariable String code) throws PostreException {
       
        return stub.getPostre(nit,code);
    }
   
    
    /**
     * Añade un postre nuevo (el código de este no esta utilizado) a la lista de postres del stub
     * @param nit
     * @param postre
     * @throws PostreException 
     */
    @RequestMapping (value="/{nit}",method = RequestMethod.POST)
    public void postPostre(@PathVariable String nit,@RequestBody Postre postre) throws PostreException { 
        System.out.println(nit+"-----postre------"+postre.getName());
        stub.addPostre(postre,nit);
    }
    
  
    /**
     * los datos de un postre ya existente en la lista de postres del stub
     * @param postre que se va a cambiar
     * @throws PostreException 
     */
     @RequestMapping (value="/{nit}/change", method = RequestMethod.POST)
    public void changePostre(@PathVariable String nit,@RequestBody Postre postre) throws PostreException {
         
        stub.changePostre(postre,nit);
    }
    
    
    
    /**
     * Busca la imagen a un postre asociado por medio de un código dado
     * @param code
     * @return ResponseEntity 
     */
    @RequestMapping(value="{nit}/{code}/picture", method = RequestMethod.GET)
    public ResponseEntity<InputStreamResource> getPostrePicture(@PathVariable String nit,@PathVariable String code){
        System.out.println(nit+"---------------------------------------"+code);
         try {            
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType("image/png"))
                    .body(new InputStreamResource(stub.getPostre(nit, code).getImage().getBinaryStream()));
        } catch (PostreException ex) {
            Logger.getLogger(PostreController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        } catch (SQLException ex) {
            Logger.getLogger(PostreController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
       
         
    }
    
    @RequestMapping(
    value = "/uploadImage",
    method = RequestMethod.POST
    )
    
    
    public ResponseEntity uploadFile(MultipartHttpServletRequest request,@RequestParam(name = "codigo") String codigo,@RequestParam(name = "nit") String nit) {
        System.out.println("-------------"+nit+"-----------"+codigo);
        try {
            Iterator<String> itr = request.getFileNames();

                while (itr.hasNext()) {
                    String uploadedFile = itr.next();
                    MultipartFile file = request.getFile(uploadedFile);
                   
                    Postre p=stub.getPostre(nit,codigo);
                    System.out.println("postre-----"+p.getName());
                    p.setImage(new SerialBlob(StreamUtils.copyToByteArray(file.getInputStream())));
                    System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");                          

                    //-->> GUARDAR EL DESPACHO A TRAVÉS DEL SERVICIO CREADO
                    stub.changePostre(p, nit);

            }
        }
        catch (Exception e) {
            return new ResponseEntity<>("{}", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>("{}", HttpStatus.OK);
    }
    
    
}
