/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.repositories;


import edu.eci.cosw.postresYa.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author 2095499
 */
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    @Query("select DISTINCT p from Pedido as p inner join p.postres as postreC inner join postreC.postreCantId as pCId where pCId.reposteriaNit= :nit")
    List<Pedido> getPedidosByNit(@Param(value = "nit")String nit);
    
}