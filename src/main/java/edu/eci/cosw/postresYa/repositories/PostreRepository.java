package edu.eci.cosw.postresYa.repositories;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author duvan
 */
public interface PostreRepository extends JpaRepository<Postre, PostreId> {
    @Query("from Postre p where p.id.reposteriaNit = :nit")
    List<Postre> getPostresReposteria(@Param(value = "nit")String nit);
}