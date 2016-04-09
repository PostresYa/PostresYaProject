package edu.eci.cosw.postresYa;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostresYaMain.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class PostresYaTest {

      
        
        
        
        /*
        @Autowired
        ReposteriaRepository repositoryReposteria;
        
        
        @Autowired
        PostreRepository repositoryPostre;
        
        @Autowired
        UserRepository userRepository;
      
        @Test
        public void testGet() throws PostreException{
            Usuario u= new Usuario("duvan", "123");
            userRepository.save(u);
             Postre p= new Postre(new PostreId("p1", "r1"), "name1", 10000, "descirpcion1");
            List<Postre> postres= new ArrayList<Postre>();
            postres.add(p);
                  
             
           // Reposteria r= new Reposteria("r1", "marica", "asd", postres, u);
            //repositoryReposteria.save(r);
            //System.out.println(servicesReposteria.getReposteriaByNit("r1").getUsuario().getUsername()+"   sdfsdfsdfsd");       
                    
            
           
           repositoryPostre.save(p);
            Postre comparacion= servicesPostre.getPostre(p.getId().getCode(), p.getId().getReposteriaNit());
            Assert.assertEquals(comparacion.getId().getCode(),repositoryPostre.findOne(new PostreId(p.getId().getCode(), p.getId().getReposteriaNit())).getId().getCode());
                 
            
            Paciente p = new Paciente(new PacienteId(2095499, "cc"), "Duvan", new Date());
            Set<Consulta> consultas = new HashSet<>();
            consultas.add(new Consulta(new Date(), "resumen prueba"));
            p.setConsultas(consultas);
            pr.save(p);
            
            Paciente comparacion=services.getPatient(2095499, "cc");
            boolean test = p.getId().equals(comparacion.getId());
            pr.delete(pr.getOne(new PacienteId(2095499,"cc")));
            Assert.assertTrue(test);

          
          
        }*/

}
