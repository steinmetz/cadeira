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
