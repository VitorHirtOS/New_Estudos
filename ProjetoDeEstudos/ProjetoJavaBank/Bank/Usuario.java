package Bank;

import Bank.Exception.ExceptionUsuario;

import java.util.ArrayList;
import java.util.Random;

public class Usuario {

    private String nome;
    private int idade;
    private String CVC;
    private String numeroCard = "";
    private String dataVencimento;
    private final String senha;

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

    public String getNome() {
        return nome;
    }

    public String getCVC(){
        return this.CVC;
    }

    public String getNumeroCard(){
        return this.numeroCard;
    }

    public String getDataVencimento(){
        return this.dataVencimento;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdade(){
        return idade;
    }

    public Usuario(String nome, int idade, String senha){
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        cartaoConfig();
    }

}
