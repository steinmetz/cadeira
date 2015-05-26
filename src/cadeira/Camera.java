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
public class Camera {
    
    private boolean ligado = false;
    private String tag;
    
    public void ligar(){
        ligado = true;
        Log.log(tag, "Camera Ligada");
    }
    
    public void desligar(){
        ligado = false;
        Log.log(tag, "Camera Desligada");
    }
    
    public boolean estahLigado(){
        return ligado;
    }
    
    public Object getVideo(){
        return null;
    }
    
}
