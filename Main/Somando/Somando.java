package Main.Somando;

import java.util.Scanner;

public class Somando {

    private int valor;

    public void somar(){

        boolean opcao = true;

        while(opcao){

            Scanner sc = new Scanner(System.in);

            System.out.print("Valores de soma: ou [1] ");
            int x = sc.nextInt();
            sc.nextLine();

            System.out.println("Valores da soma: " + valor);

            valor += x;

            if(x == 1){
                opcao = false;
            }



        }
    }


    public int getValor(){
        return valor;
    }

}