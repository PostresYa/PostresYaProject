/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.INVIMA;

import edu.eci.cosw.postresYa.model.StatusRegistroInvima;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author 2086906
 */
@Service
public class StubINVIMAImp implements StubINVIMA{
    private List<String> nitINVALIDOS= new ArrayList<>();
    
    public StubINVIMAImp(){
        nitINVALIDOS.add("nit1");
        nitINVALIDOS.add("nit2");
        nitINVALIDOS.add("nit3");
        nitINVALIDOS.add("nit4");
        nitINVALIDOS.add("nit5");
        
    }
    
    /**
     * Estado del registro invima, valida si se realizo la validacion correctamente
     * @param nit nit de la reposteria
     * @return status true/false
     */
    @Override
    public StatusRegistroInvima validarINVIMA(String nit) {
        RestTemplate rt = new RestTemplate();
        Map<String, String> vars = new HashMap<String, String>();
        vars.put("nit", "nit");
        StatusRegistroInvima respuesta = rt.getForObject("https://damp-dusk-55729.herokuapp.com/rest/peticiones/invima/{nit}", StatusRegistroInvima.class, nit);
        return respuesta;
        
      
     
    }
    
}
