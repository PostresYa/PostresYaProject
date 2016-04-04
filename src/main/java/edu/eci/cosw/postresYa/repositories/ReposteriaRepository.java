/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.repositories;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author duvan
 */
public interface ReposteriaRepository {//extends JpaRepository<Reposteria, String> {
   // @Query("from Reposteria")
    //List<Reposteria> getAllReposterias();
}
