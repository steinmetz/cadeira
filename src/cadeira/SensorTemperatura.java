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
public class SensorTemperatura extends Sensor{

    @Override
    public void run() { 
        while (run) {
            valor=  getValor();
            if(valor < 36){
                alerta = true;
                msgAlerta = "Temperatura corporal abaixo do limite";
            } else if(valor > 38){
                alerta = true;
                msgAlerta = "Temperatura corporal acima do limite";
            } else {
                alerta = false;
                msgAlerta = "Temperatura corporal OK";
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    
    
     @Override
    public float getValor() {
         
        if (simulacao) {
            int[] valores = new int[1000];
            for (int i = 0; i < 880; i++) {
                valores[i] = RandomUtil.randInt(36, 38);
            }
            for (int i = 879; i < 930; i++) {
                valores[i] = RandomUtil.randInt(39, 40);
            }
            for (int i = 929; i < 1000; i++) {
                valores[i] = RandomUtil.randInt(20, 35);
            }
            return valores[RandomUtil.randInt(0, 999)];
        } 
        return valor;
    }
    
}
