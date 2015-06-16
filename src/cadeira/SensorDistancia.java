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
public class SensorDistancia extends Sensor{
    
    public SensorDistancia(Usuario usuario){
        super(usuario);
    }

    @Override
    public void run() { 
        while (run) {
            valor=  getValor();
            
            if(valor < 10){
                alerta = true;
                msgAlerta = "Obstáculo detectado";
            }else {
                alerta = false;
                msgAlerta = "";
            } 
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
    
    
     @Override
    public float getValor() {
        
        /*
            parte usada para randomizar valores cardíacos
        */
        if (simulacao) {
            int[] valores = new int[1000];
            for (int i = 0; i < 999; i++) {
                valores[i] = RandomUtil.randInt(2, 500);
            } 
            return valores[RandomUtil.randInt(0, 999)];
        } 
        return valor;
    }
    
}
