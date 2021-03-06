package edu.eci.cosw.postresYa.repositories;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
/**
 *
 * @author duvan
 */
public interface PostreRepository extends JpaRepository<Postre, PostreId> {
    @Query("from Postre as p where p.id.reposteriaNit = :nit")
    List<Postre> getPostresReposteria(@Param(value = "nit")String nit);
}