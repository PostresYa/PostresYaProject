/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.stub;

import edu.eci.cosw.postresYa.model.Postre;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import org.springframework.stereotype.Service;

/**
 *
 * @author 2095499
 */
@Service
public class StubPostre implements Stub{
    private List<Postre> postres= new ArrayList<>();
    
    public StubPostre() throws IOException{
        postres.add(new Postre("p1", "prueba", 15000, "4 porciones, rico"));
    }

    @Override
    public List<Postre> getPostres() {
        return postres;
    }

    @Override
    public void addPostre(Postre postre) {
        postres.add(postre);
    }
    
}
