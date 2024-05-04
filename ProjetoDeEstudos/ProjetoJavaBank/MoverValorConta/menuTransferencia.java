package MoverValorConta;

import Bank.ContaBancaria;

import java.util.Scanner;

public class menuTransferencia extends Transferencia {

    public void menuTransferencia() {

        ContaBancaria usuario01 = new ContaBancaria();
        ContaBancaria usuario02 = new ContaBancaria();

        Scanner sc = new Scanner(System.in);

        System.out.println("Valor de transferência: ");
        int valor = sc.nextInt();
        System.out.println("Digite o nome do conta: ");
        String escolha = sc.nextLine();

        moverValor(usuario01, usuario02, valor, escolha);

    }

}
