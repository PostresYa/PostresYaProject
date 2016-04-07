/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.cosw.postresYa.INVIMA;

import edu.eci.cosw.postresYa.model.StatusRegistroInvima;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

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
    
   
    @Override
    public StatusRegistroInvima validarINVIMA(String nit) {
        System.out.println(nitINVALIDOS.size());
        StatusRegistroInvima status=new StatusRegistroInvima(true);
        for(String nitInvalido:nitINVALIDOS){
            if(nitInvalido.equals(nit)){
                status.setRegistrado(false);
            }
        }
     
        return status;
    }
    
}
