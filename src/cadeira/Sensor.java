/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira;

/**
 *
 * @author charles
 */
abstract class Sensor {  
    
    protected float valor;
    protected boolean simulacao = true;
 
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
