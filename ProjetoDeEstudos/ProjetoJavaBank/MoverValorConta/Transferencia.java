package MoverValorConta;

import Bank.ContaBancaria;
import Bank.Usuario;

abstract public class Transferencia implements IMoverValor {

    private int saldo01;
    private int saldo02;

    public int moverValor(ContaBancaria usuario1, ContaBancaria usuario2, int valor, String escolha) {

        this.saldo01 = usuario1.GetSaldo();
        this.saldo02 = usuario2.GetSaldo();

        if(valor > saldo01 || valor > saldo02){
            System.out.println("O valor de transferência não é possível por causa do saldo abaixo!!! " + Protocol.WARNING);
            return 0;
        }

        if(escolha.equals("1")){
            usuario1.Pagar(saldo01 -= valor);
            int transferencia = saldo02 + valor;
            usuario2.Depostio(transferencia);
            System.out.println("Tudo certo " + Protocol.SUCCESS);
            return transferencia;
        }else if(escolha.equals("2")){
            usuario2.Pagar(saldo02 -= valor);
            int transferencia = saldo01 + valor;
            usuario1.Depostio(transferencia);
            System.out.println("Tudo certo " + Protocol.SUCCESS);
            return transferencia;
        }

        System.out.println("Algo errado em sua operação!!! " + Protocol.DANGER);

        return 0;
    }

}