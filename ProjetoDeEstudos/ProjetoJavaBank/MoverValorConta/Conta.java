package MoverValorConta;

public class Conta extends UsuarioConta implements IValorConta {

    private int valor;

    public int getValor(){
        return valor;
    }

    @Override
    public boolean isValidSaldo(int valor){

        if(getIdade() < 18){
            System.out.println("Você é menor de idade para realizar esta operação!!! " + Protocol.WARNING);
            return false;
        }else if(getValor() < valor){
            System.out.println("Saldo insuficiente!!! " + Protocol.DANGER);
            return false;
        }

        System.out.println("Transferência tudo certo!!! " + Protocol.SUCCESS);
        this.valor -= valor;

        return true;
    }

    public Conta(int valor, String nome, int idade){
        super(nome, idade);
        this.valor = valor;
    }

}
