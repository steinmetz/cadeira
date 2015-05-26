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
public class Motor {
    private float velocidade;
    private float torque;
    
    private String tag;

    public Motor(String tag) {
        this.tag = tag;
    }
    
    public void frente(){
        Log.log(tag, "Andando para frente");
    }
    public void tras(){
        Log.log(tag, "Andando para tras");
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    public float getTorque() {
        return torque;
    }

    public void setTorque(float torque) {
        this.torque = torque;
    }
    
    
    
}
