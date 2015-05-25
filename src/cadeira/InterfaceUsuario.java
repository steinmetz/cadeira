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
public class InterfaceUsuario {
    
    private Joystick joystick;
    private Tela tela;

    public InterfaceUsuario() {
        joystick = new Joystick();
        tela = new Tela();
    }
        
    public String lerComandoUsr(){
        return joystick.lerComando();
    }
    
    public void exibirMensagemTela(String mensagem){
        tela.exibirMensagemTela(mensagem);
    }
    
}
