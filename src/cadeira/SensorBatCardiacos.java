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
 
    @Override
    public float getValor() {
        
        /*
            parte usada para randomizar valores cardíacos
        */
        if (simulacao) {
            int[] valores = new int[100];
            for (int i = 0; i < 80; i++) {
                valores[i] = 37;
            }
            for (int i = 79; i < 90; i++) {
                valores[i] = 37;
            }
            for (int i = 89; i < 100; i++) {
                valores[i] = 40;
            }
            return valores[RandomUtil.randInt(0, 100)];
        } 
        return valor;
    }

   
    
    
    
}
