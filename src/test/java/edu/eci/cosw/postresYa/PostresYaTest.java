package edu.eci.cosw.postresYa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = PostresYaMain.class)
@WebAppConfiguration
@ActiveProfiles("test")
public class PostresYaTest {

      
        
        @Test
        public void patientLoadTest(){
    
        }

}
