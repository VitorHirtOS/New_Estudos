package Main.Menu;
import Main.Somando.Somando;

import java.util.Scanner;


public class Menu {

    public void menu(){

        Scanner sc = new Scanner(System.in);
        boolean opcao = true;
        Somando somando = new Somando();

        while(opcao){

            System.out.print("Qual a sua operação? [1] - [2] ");
            String acao = sc.nextLine();

            switch (acao){
                case "1":
                    System.out.println("Somar");
                    somando.somar();
                    break;
                case "2":
                    System.out.println(somando.getValor());
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }



    }

}
