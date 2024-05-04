package Fisica_Juridica;

import java.util.Scanner;

public class Pessoa extends Jurida_ou_Fisica  {


    public void Status(){

        Scanner sc = new Scanner(System.in);

        try{

            System.out.print("Pessoa física ou Jurídica? número: ");
            String id = sc.nextLine();
            String ids = getId(id);

            if(ids.equals("1365")){
                Fisica fisica = new Fisica();
                System.out.println(fisica.info());
            } else if (ids.equals("2479")) {
                Juridica juridica = new Juridica();
                System.out.println(juridica.info());
            }

            System.out.println(info());
        }catch (Exception ex){
            System.out.println("Error sistema: " + ex.getMessage());
        }


    }

    public Pessoa(){

    }

}
