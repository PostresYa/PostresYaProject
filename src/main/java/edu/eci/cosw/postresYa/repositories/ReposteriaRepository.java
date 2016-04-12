/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.repositories;
import edu.eci.cosw.postresYa.model.Reposteria;
import org.springframework.data.jpa.repository.JpaRepository;




/**
 *
 * @author duvan
 */
public interface ReposteriaRepository extends JpaRepository<Reposteria, String> {
    
}
