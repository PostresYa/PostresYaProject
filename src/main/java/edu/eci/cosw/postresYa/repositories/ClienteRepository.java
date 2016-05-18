/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.repositories;

import edu.eci.cosw.postresYa.model.Cliente;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author giovanny
 */
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    //from Usuario u where u.username= :user and u.password= :pass"
    
    @Query("from Cliente cl where cl.cedula=:cedula ")
    Cliente getClienteByCedula(@Param(value = "cedula")Integer cedula);
    
 
    //@Query(" from Cliente c where c.usuario =: username")
    @Query("select c from Cliente as c inner join c.usuario as u where u.username=:username")
    Cliente getClienteByUsername(@Param(value = "username") String username);
    
    
}
