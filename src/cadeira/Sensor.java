/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira;

import cadeira.util.Log;

/**
 *
 * @author charles
 */
abstract class Sensor extends Thread {  
    
    protected float valor;
    protected boolean simulacao = true;
    
    public boolean alerta = false;
    public String msgAlerta = "";
    protected boolean run = true;
    
    protected Usuario usuario;

    public Sensor(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void run() {
        if (alerta) {
            Log.log("Sensor", msgAlerta + "[valor:"+valor+"]");
        }
    } 
     
    public void finish(){
        run = false;
    }
 
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public boolean isSimulacao() {
        return simulacao;
    }

    public void setSimulacao(boolean simulacao) {
        this.simulacao = simulacao;
    }
    
}
