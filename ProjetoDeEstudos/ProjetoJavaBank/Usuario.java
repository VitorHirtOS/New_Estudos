import java.util.ArrayList;
import java.util.Random;

public class Usuario {

    private String nome;
    private int idade;
    private String CVC;
    private String numeroCard = "";
    private String saldo = "0";
    private String dataVencimento;

    private void cartaoConfig(){

        Random gerador = new Random();

        int CVC = gerador.nextInt(100, 999);
        this.CVC = String.valueOf(CVC);

        for(int i = 0; i < 4; i++){
            int numeroCard = gerador.nextInt(1000, 9999);
            this.numeroCard += numeroCard;
            if(i < 3){
                this.numeroCard += ".";
            }
        }

        int dataVencimento = gerador.nextInt(1, 28);
        this.dataVencimento = String.valueOf(dataVencimento) + "/30";

    }

    public ArrayList<String> informacaoUsuario(){
        ArrayList<String> informacoes = new ArrayList<>();

        cartaoConfig();

        informacoes.add(nome);
        informacoes.add(String.valueOf(idade));
        informacoes.add(CVC);
        informacoes.add(numeroCard);
        informacoes.add(saldo);
        informacoes.add(dataVencimento);

        return informacoes;
    }
    
    public void setIdade(int valor){
        this.idade = valor;
    }

    public int getIdade(){
        return this.idade;
    }

    public String getName(){
        return this.nome;
    }

    public Usuario(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

}
