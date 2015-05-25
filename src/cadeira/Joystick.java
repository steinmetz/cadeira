/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira;

import java.util.Scanner;

/**
 *
 * @author charles
 */
public class Joystick {
    
    public String lerComando(){
        Scanner leitorTeclado = new Scanner(System.in);
        return leitorTeclado.next();
    }
    
}
