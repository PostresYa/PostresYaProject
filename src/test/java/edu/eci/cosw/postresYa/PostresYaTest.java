package edu.eci.cosw.postresYa;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.INVIMA.StubINVIMA;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import edu.eci.cosw.postresYa.services.PostresYaServices;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostresYaMain.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class PostresYaTest {

        @Autowired
        PostresYaServices services;
        
        @Autowired
        ReposteriaRepository reposteriaRepository;
        
        @Autowired
        PostreRepository postreRepository;
        
        @Autowired
        UserRepository userRepository;
        @Autowired
        StubINVIMA INVIMA;
        
        @Test
        public void nitInvalidoTest(){
            Assert.assertFalse(INVIMA.validarINVIMA("nit1").isRegistrado());
        }
        
         @Test
        public void nitValidoTest(){
            Assert.assertTrue(INVIMA.validarINVIMA("r1").isRegistrado());
        }
        
        @Test
        public void ReposteriaRegistradaTest(){
            Usuario u=new Usuario("r1", "pass1");
            Reposteria r=new Reposteria("r1", "prueba", "norte", new ArrayList<Postre>(), u, "centro");
            userRepository.save(u);
            reposteriaRepository.save(r);
            try {
                Reposteria r2=services.getReposteriaByNit("r1");
                boolean test=r.getNit().equals(r2.getNit());
               reposteriaRepository.delete("r1");
               userRepository.delete("r1");
                Assert.assertTrue(test);
            } catch (PostreException ex) {
                Assert.fail();
            }
            
        }
        
        @Test
        public void ReposteriaNoRegistradaTest() throws PostreException{
            Reposteria r= services.getReposteriaByNit("noregistrada");
            Assert.assertNull(r);
        }
        
        @Test
        public void NingunaReposteriaTest() throws PostreException{
            List<Reposteria> reposterias=services.getAllReposterias();
            Assert.assertEquals(reposterias.size(),0);
        }
        
        @Test
        public void DosReposteriasTest() throws PostreException{
            Usuario u=new Usuario("r1", "pass1");
            Reposteria r=new Reposteria("r1", "prueba", "norte", new ArrayList<Postre>(), u, "centro");
            Usuario u1=new Usuario("r2", "pass2");
            Reposteria r2=new Reposteria("r2", "prueba2", "norte2", new ArrayList<Postre>(), u1, "centro");
            
            userRepository.save(u);
            reposteriaRepository.save(r);
            userRepository.save(u1);
            reposteriaRepository.save(r2);
            
            List<Reposteria> reposterias=services.getAllReposterias();
            boolean test=(reposterias.size()==2);
            reposteriaRepository.delete("r1");
            userRepository.delete("r1");
            reposteriaRepository.delete("r2");
            userRepository.delete("r2");
            Assert.assertTrue(test);
        }
        
      // Pruebas registro de postres
        //@Test
        

}

