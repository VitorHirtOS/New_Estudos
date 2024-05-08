package Poupanca;

import java.util.Scanner;

public class Test extends Poupanca {

    private int valor;
    private boolean isValid = true;

    public void menuTest(){

        Scanner scanner = new Scanner(System.in);
        // Verificando o armazenamento dinamicamente incorreto
        while(isValid){
            System.out.println("Armazenar valor [V] - [VC] ");

            String opcao = scanner.nextLine().toUpperCase();

            if(opcao.equals("V")){

                System.out.println("Coloque o valor de armazenamento: ");
                valor = scanner.nextInt();
                TestValor(valor);

            } else if (opcao.equals("VC")) {
                System.out.println("Valor: " + returnValor());
            }else if (opcao.equals("S")){
                isValid = false;
            }

        }

    }

}
