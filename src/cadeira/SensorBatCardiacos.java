/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira;

import cadeira.util.RandomUtil;

/**
 *
 * @author charles
 */
public class SensorBatCardiacos extends Sensor{
    
     public SensorBatCardiacos(Usuario usuario){
        super(usuario);
    }

 
    @Override
    public void run() { 
        while (run) {
            valor=  getValor(); 
            
            if(valor < usuario.getBatimentosMin()){
                alerta = true;
                msgAlerta = "Batimentos abaixo do limite";
            } else if(valor > usuario.getBatimentosMax()){
                alerta = true;
                msgAlerta = "Batimentos acima do limite";
            } else {
                alerta = false;
                msgAlerta = "Batimentos cardíacos OK";
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
            super.run();
        }
    }
    
    
    @Override
    public float getValor() {
        
        /*
            parte usada para randomizar valores cardíacos
        */
        if (simulacao) {
            int[] valores = new int[1000];
            for (int i = 0; i < 880; i++) {
                valores[i] = RandomUtil.randInt(60, 90);
            }
            for (int i = 879; i < 930; i++) {
                valores[i] = RandomUtil.randInt(40, 59);
            }
            for (int i = 929; i < 1000; i++) {
                valores[i] = RandomUtil.randInt(91, 120);
            }
            return valores[RandomUtil.randInt(0, 999)];
        } 
        return valor;
    }

   
    
    
    
}
