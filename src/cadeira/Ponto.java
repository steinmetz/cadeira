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
public class Ponto {
    private float x;
    private float y;
    
    public Ponto(){
        this.x = 0;
        this.y = 0;
    }
    
    public Ponto(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public void incrementarX(int valor){
        x+=valor;
    }
    public void incrementarY(int valor){
        y+=valor;
    }
    
}
