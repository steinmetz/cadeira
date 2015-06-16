package cadeira;

import java.util.Scanner;

/**
 *
 * @author charles
 */
public class Usuario {

    private String nome;
    private float temperaturaMax;
    private float temperaturaMin;
    private float batimentosMax;
    private float batimentosMin;
    private String tipoUsuario;

    //pegar esses valores para validar os sensores.
    public Usuario() {

    }

    public Usuario(String nome, float temperaturaMax, float temperaturaMin, float batimentosMax, float batimentosMin, String tipoUsuario) {
        this.nome = nome;
        this.temperaturaMax = temperaturaMax;
        this.temperaturaMin = temperaturaMin;
        this.batimentosMax = batimentosMax;
        this.batimentosMin = batimentosMin;
        this.tipoUsuario = tipoUsuario;
    }

    public void criarUsuario() {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Insira o nome do usuário:");
        setNome(leitor.next());
        /*
         System.out.println("Insira valor máximo da Temperatura Corporal:");
         setTemperaturaMax(Float.parseFloat(leitor.next().trim()));
         System.out.println("Insira valor mínimo da Temperatura Corporal:");
         setTemperaturaMin(Float.parseFloat(leitor.next().trim()));
         System.out.println("Insira o máximo de batimentos cardíacos:");
         setBatimentosMax(Float.parseFloat(leitor.next().trim()));
         System.out.println("Insira o mínimo de batimentos cardíacos:");
         setBatimentosMin(Float.parseFloat(leitor.next().trim()));
         */
        System.out.println("Insira o tipo de usuário [crianca, adulto, idoso]:");
        setTipoUsuario(leitor.next().trim());

    }
    
    public String getLimBatCard(){
        return "["+getBatimentosMin()+" - "+getBatimentosMax() +"]";
    }

    public String getLimTempCorp(){
        return "["+getTemperaturaMin()+" - "+getTemperaturaMax() +"]";
    }
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
        switch (tipoUsuario) {
            case "crianca":
                setTemperaturaMax((float) 38);
                setTemperaturaMin((float) 36.5);
                setBatimentosMax((float) 110);
                setBatimentosMin((float) 80);
                break;
            case "adulto":
                setTemperaturaMax((float) 38.5);
                setTemperaturaMin((float) 36);
                setBatimentosMax((float) 100);
                setBatimentosMin((float) 80);
                break;
            case "idoso":
                setTemperaturaMax((float) 38.5);
                setTemperaturaMin((float) 36.5);
                setBatimentosMax((float) 95);
                setBatimentosMin((float) 85);
                break;
            default:
                setTemperaturaMax((float) 38.5);
                setTemperaturaMin((float) 36.5);
                setBatimentosMax((float) 95);
                setBatimentosMin((float) 80);
                break;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getTemperaturaMax() {
        return temperaturaMax;
    }

    public void setTemperaturaMax(float temperaturaMax) {
        this.temperaturaMax = temperaturaMax;
    }

    public float getTemperaturaMin() {
        return temperaturaMin;
    }

    public void setTemperaturaMin(float temperaturaMin) {
        this.temperaturaMin = temperaturaMin;
    }

    public float getBatimentosMax() {
        return batimentosMax;
    }

    public void setBatimentosMax(float batimentosMax) {
        this.batimentosMax = batimentosMax;
    }

    public float getBatimentosMin() {
        return batimentosMin;
    }

    public void setBatimentosMin(float batimentosMin) {
        this.batimentosMin = batimentosMin;
    }

}
