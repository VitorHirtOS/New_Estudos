package Poupanca;

import java.util.Scanner;

abstract public class Poupanca implements IPoupanca {

    private int depositoPoupanca;
    private int valor;

    @Override
    public void depositoPoupanca(int valor) {
        this.depositoPoupanca += valor;
    }

    @Override
    public void sacarPoupanca(int valor) {

        if(getDepositoPoupanca() < valor){
            System.out.println("Poupança insuficiente");
        }else{
            depositoPoupanca -= valor;
        }
    }

    public void TestValor(int valor){
        this.valor += valor;
    }

    public int returnValor(){
        return this.valor;
    }

    public int getDepositoPoupanca() {
        return this.depositoPoupanca;
    }

}
