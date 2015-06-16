/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeira.jframes;

import cadeira.Bateria;
import cadeira.Cadeira;
import cadeira.SensorBatCardiacos;
import java.awt.Color;
import java.awt.Label;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

/**
 *
 * @author charles
 */
public class Monitoramento extends Thread{
    
    Cadeira cadeira;
    JProgressBar progress;
    Label lblBatCard, lblBatCardLim, lblTempCorp, lblTempCorpLim,lblStatusBat;
    JSlider sldDistanciaRec;
    boolean monitorando = true;
    
    DecimalFormat df = new DecimalFormat("##.00");

     

    public Monitoramento(Cadeira cadeira, JProgressBar progress, Label lblBatCard, Label lblBatCardLim, Label lblTempCorp, Label lblTempCorpLim, Label lblStatusBat, JSlider sldDistanciaRec) {
        this.cadeira = cadeira;
        this.progress = progress;
        this.lblBatCard = lblBatCard;
        this.lblBatCardLim = lblBatCardLim;
        this.lblTempCorp = lblTempCorp;
        this.lblTempCorpLim = lblTempCorpLim;
        this.lblStatusBat = lblStatusBat;
        this.sldDistanciaRec = sldDistanciaRec;
        progress.setMaximum(100);
        progress.setMinimum(0);
        progress.setStringPainted(true);
        progress.setForeground(Color.blue);
        sldDistanciaRec.setMaximum(200);
        sldDistanciaRec.setMinimum(0);
    }
    

    @Override
    public void run() {
        int valor;
        while (monitorando) {            
            valor = (int)(cadeira.getBateria().getCarga());
            progress.setValue(valor);
            progress.setString(df.format(cadeira.getBateria().getCarga())+"%");
            if(cadeira.getBateria().getDistanciaCarga() <= sldDistanciaRec.getValue()){
                lblStatusBat.setText("Bateria Fraca \n[ Autonomia:"+cadeira.getBateria().getDistanciaCarga()+" P.Recarga:"+sldDistanciaRec.getValue());
            }else {
                lblStatusBat.setText("");
            }
            lblBatCard.setText(cadeira.getsBatCardiacos().getValor()+"");
            lblTempCorp.setText(cadeira.getsTemperatura().getValor()+"");
            if (cadeira.getsBatCardiacos().alerta) {
                lblBatCard.setForeground(Color.RED);
            }else{
                lblBatCard.setForeground(Color.BLACK);
            }
            if (cadeira.getsTemperatura().alerta) {
                lblTempCorp.setForeground(Color.RED);
            }else{
                lblTempCorp.setForeground(Color.BLACK);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Monitoramento.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Setando carga:"+valor);
        }                
    }
    public void pararMonitoramento(){
        monitorando = false;
    }
    
}
