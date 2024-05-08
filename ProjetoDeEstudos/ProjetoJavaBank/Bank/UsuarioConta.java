package Bank;

public class UsuarioConta extends Transferencia {

    private String nome;
    private int idade;

    public String getNome(){
        return nome;
    }

    public int getIdade(){
        return idade;
    }

    @Override
    public void msg(UsuarioConta usuario01, UsuarioConta usuario02){
        System.out.println("Não foi possível realizar a ação de: " + usuario01.getNome() + " Para " + usuario02.getNome());
    }

    public UsuarioConta(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

}
