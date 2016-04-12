/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.repositories;
import edu.eci.cosw.postresYa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author duvan
 */
public interface UserRepository extends JpaRepository<Usuario, String> {
     @Query("from Usuario u where u.username= :user and u.password= :pass")
     Usuario Login(@Param(value = "user")String user,@Param(value = "pass")String password);
}
