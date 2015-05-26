/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charles
 */
public class Bateria {
    
    private float carga;
    //distância que a cadeira percorre por unidade de carga.
    private float ditanciaPorUniCarga = 1;
    
    private boolean consumindo = false;
    private float consumo = (float) 0.1;
    
    public Bateria(float carga){
        setCarga(carga);
    }
    
    private void setCarga(float carga){
        if(carga > -1){
            this.carga = carga;
        }
    }
    
    public void descarregando(float qtd){
        carga -= qtd;    
    }
    public void carregando(){
        carga++;
    }
    public float getCarga(){
        return carga;
    }
    public float getDistanciaCarga(){
        return carga * ditanciaPorUniCarga;
    }
    
    private void consumoBateria(){
        Runnable run = new Runnable() {
            @Override
            public void run() {
                while(consumindo){
                    try {
                        descarregando(consumo);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Cadeira.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread t = new Thread(run);
        t.start();
    }

    public boolean isConsumindo() {
        return consumindo;
    }

    public void setConsumindo(boolean consumindo) {
        this.consumindo = consumindo;
        consumoBateria();
    }  
    
    public void setConsumo(float consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return "Bateria " + carga + '%';
    }
    
    
    
    
}
