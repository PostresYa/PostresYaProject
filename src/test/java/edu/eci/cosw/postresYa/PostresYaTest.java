package edu.eci.cosw.postresYa;

import edu.eci.cosw.postresYa.Exceptions.PostreException;
import edu.eci.cosw.postresYa.INVIMA.StubINVIMA;
import edu.eci.cosw.postresYa.model.Cliente;
import edu.eci.cosw.postresYa.model.Pedido;
import edu.eci.cosw.postresYa.model.Postre;
import edu.eci.cosw.postresYa.model.PostreCant;
import edu.eci.cosw.postresYa.model.PostreCantId;
import edu.eci.cosw.postresYa.model.PostreId;
import edu.eci.cosw.postresYa.model.Reposteria;
import edu.eci.cosw.postresYa.model.Usuario;
import edu.eci.cosw.postresYa.repositories.ClienteRepository;
import edu.eci.cosw.postresYa.repositories.PedidoRepository;
import edu.eci.cosw.postresYa.repositories.PostreRepository;
import edu.eci.cosw.postresYa.repositories.ReposteriaRepository;
import edu.eci.cosw.postresYa.repositories.UserRepository;
import edu.eci.cosw.postresYa.services.PostresYaServices;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
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
        PedidoRepository pedidoRepository;
        
        @Autowired
        UserRepository userRepository;
        
        @Autowired
        ClienteRepository clientRepository;
        
        @Autowired
        StubINVIMA INVIMA;
        
        @Test
        public void nitInvalidoTest(){          
           Assert.assertEquals(INVIMA.validarINVIMA("604256769-9").getEstadoRegistro(), "Vencidos");
        }
        
         @Test
        public void nitValidoTest(){            
             Assert.assertEquals(INVIMA.validarINVIMA("124356789-1").getEstadoRegistro(), "Vigentes");
        }
        
        @Test
        public void ReposteriaRegistradaTest(){
            Usuario u=new Usuario("r1", "pass1","reposteria");
            Reposteria r=new Reposteria("r1", "prueba", "norte", new ArrayList<Postre>(), u, "centro",4.056,-74.342);
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
            Usuario u=new Usuario("r1", "pass1","reposteria");
            Reposteria r=new Reposteria("r1", "prueba", "norte", new ArrayList<Postre>(), u, "centro",4.056,-74.342);
            Usuario u1=new Usuario("r2", "pass2","reposteria");
            Reposteria r2=new Reposteria("r2", "prueba2", "norte2", new ArrayList<Postre>(), u1, "centro",4.056,-74.342);            
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
        @Test
        public void registroPostreOkTest() throws PostreException{
            Usuario u = new Usuario("us1", "password","reposteria");  
            Postre p = new Postre(new PostreId("code1", "us1"), "name", 0, "description");
            List<Postre> postres=new ArrayList<Postre>();
            postres.add(p);
            Reposteria r = new Reposteria("us1", "name", "coverageRange",postres, u, "direccion",4.056,-74.342);            
            //Assert.assertTrue(services.getPostres("us1").size() == 0);
            userRepository.save(u);
            reposteriaRepository.save(r);
            postreRepository.save(p);                    
            Assert.assertTrue(services.getPostres("us1").size() == 1);
            postreRepository.delete(p.getId());
            reposteriaRepository.delete("us1");
            userRepository.delete("us1");
            
          
          
        }
        
        @Test
        public void variosPostresEnReposteriaTest() throws PostreException{
            Usuario u = new Usuario("us1", "password","reposteria");   
            Reposteria r = new Reposteria("us1", "name", "coverageRange", new ArrayList<Postre>(), u, "direccion",4.056,-74.342);  
            userRepository.save(u);
            reposteriaRepository.save(r);
            Assert.assertTrue(services.getPostres("us1").size() == 0);            
            Postre p = new Postre(new PostreId("code1", "us1"), "name", 0, "description");
            postreRepository.save(p);

            //p = new Postre(new PostreId("codejkkkkk", "us1"), "name1", 1, "description1");              
            postreRepository.save(p);
     
            System.out.println("##############################");
            System.out.println(services.getPostres("us1").size());
                    
            Assert.assertTrue(services.getPostres("us1").size() == 1);
            
            postreRepository.deleteAll();
            reposteriaRepository.delete("us1");
            userRepository.delete("us1");
            
                    
            
            
  
        }
        
        @Test
        public void sinPostresGuardadosTest() throws PostreException{
            Usuario u = new Usuario("us1", "password","reposteria");   
            Reposteria r = new Reposteria("us1", "name", "coverageRange", new ArrayList<Postre>(), u, "direccion",4.056,-74.342);
            userRepository.save(u);
            reposteriaRepository.save(r);
            Assert.assertTrue(services.getPostres("us1").size() == 0);
            reposteriaRepository.delete(r.getNit());
            userRepository.delete(u.getUsername());
            
        }
        
        /*
        @Test
        public void postreConPrecioNegativoTest()throws PostreException{
            Usuario u = new Usuario("us1", "password");   
            Reposteria r = new Reposteria("us1", "name", "coverageRange", new ArrayList<Postre>(), u, "direccion");
            Postre p = new Postre(new PostreId("code1", "us1"), "name", -111, "description");            
            userRepository.save(u);
            reposteriaRepository.save(r);
            postreRepository.save(p);
            Assert.assertFalse(p.getPrice()<=0);
            postreRepository.delete(p.getId());
            reposteriaRepository.delete("us1");
            userRepository.delete("us1");
            
        }*/
        
        //pruebas consultar pedidos
        /*
        @Test
        public void pedidosNoExistenteTest() throws PostreException{
            List<Pedido> pedido= services.getPedidosByNit("r1");
            Assert.assertEquals(pedido.size(), 0);
        }*/
        
        @Test
         public void validarPedidosQueExistaTest() throws PostreException{
             
             Usuario u = new Usuario("us2", "password","cliente");   
           userRepository.save(u);
            Cliente cl= new Cliente(1022408185, new BigInteger("12344"), u, "duvan","AMEX");
            clientRepository.save(cl);
            Pedido pedido= new Pedido("direccion", new Date(16/02/02), "en espera", 0,cl);
            System.out.println("-------------------"+pedido.getCodigo()+"---------------------------------");
                    
            pedidoRepository.save(pedido);
            System.out.println("-------------------"+pedido.getCodigo()+"---------------------------------");
            
            Usuario u1 = new Usuario("us3", "password","reposteria");   
            Reposteria r = new Reposteria("us3", "name", "coverageRange", new ArrayList<Postre>(), u, "direccion",4.056,-74.342);  
            userRepository.save(u);
            reposteriaRepository.save(r);
            Postre p = new Postre(new PostreId("code12", "us3"), "name", 0, "description");
            postreRepository.save(p);
            
            ArrayList<PostreCant> pc= new ArrayList<>();
            pc.add(new PostreCant(new PostreCantId(p.getId().getCode(), p.getId().getReposteriaNit(), pedido.getCodigo()), p, 10000));
            pedido.setPostres(pc);
            pedidoRepository.save(pedido);
            
            
  /*
            Pedido pedido= new Pedido(new ArrayList<PostreCant>(), "direccion", new Date(16/02/02), "en espera", 0);
            pedidoRepository.save(pedido);
            Pedido pedido2=pedidoRepository.findOne(pedido.getCodigo());          
            boolean test= pedido2.getCodigo()==pedido.getCodigo();
            pedidoRepository.delete(pedido.getCodigo());
            Assert.assertTrue(test);
    */        
         }
         
          
  
         

}

