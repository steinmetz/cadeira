package cadeira;

import cadeira.util.Log;
import java.text.DecimalFormat;

/**
 *
 * @author charles
 */
public class Cadeira {

    private SensorTemperatura sTemperatura;
    private SensorBatCardiacos sBatCardiacos;
    private SensorDistancia sDistancia;
    private InterfaceUsuario interfaceUsr;
    private Motor motorD;
    private Motor motorE;
    private Bateria bateria;
    private Camera camera;
    private Usuario usuario;

    private boolean ligado = false;
    private String tag = "Cadeira";
    private Ponto posicao;

    public static void main(String[] args) {

        boolean rodando = true;
        Cadeira cadeira = new Cadeira();
        cadeira.showMenu();
        while (rodando) {
            String comando = cadeira.interfaceUsr.lerComandoUsr();
            if (!comando.toLowerCase().equals("ligar") && !cadeira.ligado) {
                continue;
            }
            switch (comando.toLowerCase()) {
                case "ligar":
                    if (!cadeira.ligado) {
                        cadeira.ligar();
                    }
                    break;
                case "desligar":
                    cadeira.desligar();
                    break;
                case "frente":
                    cadeira.andarFrente();
                    break;
                case "tras":
                    cadeira.andarTras();
                    break;
                case "direita":
                    cadeira.andarDireita();
                    break;
                case "esquerda":
                    cadeira.andarEsquerda();
                    break;
                case "sair":
                    System.out.println("Saindo...");
                    rodando = false;
                    break;
                default:
                    System.err.println("Comando inválido!");
                    cadeira.showMenu();
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Comandos válidos são:");
        System.out.println("'ligar'     para ligar");
        System.out.println("'desligar'  para desligar");
        System.out.println("'sair'      para sair");
        System.out.println("'frente'    para andar para frente");
        System.out.println("'tras'      para andar para tras");
        System.out.println("'direita'   para andar para direita");
        System.out.println("'esquerda'  para andar para esquerda");
    }

    public void showStatus() {
        System.out.println(bateria.toString());
    }

    public Cadeira() {
        interfaceUsr = new InterfaceUsuario();
        motorD = new Motor("Motor D");
        motorE = new Motor("Motor E");
        bateria = new Bateria(100);
        camera = new Camera();
        posicao = new Ponto();
    }
    
    public void ligar() {
        if (usuario != null) { 
            ligado = true;
            Log.log(tag, "Cadeira ligada");
            bateria.setConsumindo(ligado);
            bateria.setConsumo((float) 0.01);
            sTemperatura = new SensorTemperatura(usuario);
            sBatCardiacos = new SensorBatCardiacos(usuario);
            sDistancia = new SensorDistancia(usuario);
            sTemperatura.start();
            sDistancia.start();
            sBatCardiacos.start();
        } else {
            System.out.println("Não existe usuário na cadeira.");            
        }
    }

    public void criarUsuario(){
        usuario = new Usuario();
        usuario.criarUsuario();
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public void desligar() {
        ligado = false;
        Log.log(tag, "Cadeira desligada");
        bateria.setConsumindo(ligado);
        sTemperatura.finish();
        sDistancia.finish();
        sBatCardiacos.finish();
    }

    public void andarFrente() {
        Log.log(tag, "Andar para Frente");
        motorD.frente();
        motorE.frente();
        bateria.descarregando((float) 0.5);
        posicao.incrementarX(5);
    }

    public void andarTras() {
        Log.log(tag, "Andar para Tras");
        motorD.tras();
        motorE.tras();
        bateria.descarregando((float) 0.5);
        posicao.incrementarX(-5);
    }

    public void andarDireita() {
        Log.log(tag, "Virar Direita");
        motorE.frente();
        motorD.tras();
        bateria.descarregando((float) 0.5);
    }

    public void andarEsquerda() {
        Log.log(tag, "Virar Esquerda");
        motorD.frente();
        motorE.tras();
        bateria.descarregando((float) 0.5);
    }

    public SensorTemperatura getsTemperatura() {
        return sTemperatura;
    }

    public void setsTemperatura(SensorTemperatura sTemperatura) {
        this.sTemperatura = sTemperatura;
    }

    public SensorBatCardiacos getsBatCardiacos() {
        return sBatCardiacos;
    }

    public void setsBatCardiacos(SensorBatCardiacos sBatCardiacos) {
        this.sBatCardiacos = sBatCardiacos;
    }

    public SensorDistancia getsDistancia() {
        return sDistancia;
    }

    public void setsDistancia(SensorDistancia sDistancia) {
        this.sDistancia = sDistancia;
    }

    public InterfaceUsuario getInterfaceUsr() {
        return interfaceUsr;
    }

    public void setInterfaceUsr(InterfaceUsuario interfaceUsr) {
        this.interfaceUsr = interfaceUsr;
    }

    public Motor getMotorD() {
        return motorD;
    }

    public void setMotorD(Motor motorD) {
        this.motorD = motorD;
    }

    public Motor getMotorE() {
        return motorE;
    }

    public void setMotorE(Motor motorE) {
        this.motorE = motorE;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public void setBateria(Bateria bateria) {
        this.bateria = bateria;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public boolean isLigado() {
        return ligado;
    }

    public void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Ponto getPosicao() {
        return posicao;
    }

    public void setPosicao(Ponto posicao) {
        this.posicao = posicao;
    }

}
