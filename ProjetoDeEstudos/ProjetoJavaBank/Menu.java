import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    
    private boolean isValid = false;
    private boolean isValidSalario = true;
    private int isValidIdade;
    private String nome;
    private int idade;

    public void menu(){

        ContaBancaria contaBancaria = new ContaBancaria();

        while(!isValid){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual a sua operação: [SA] - [C] - [D] - [P] - [U] - [I] - [.]");
            String acao = scanner.nextLine().toUpperCase();

            switch (acao) {
                case "SA":

                    if(isValidSalario){
                        if(isValidIdade > 18){
                            System.out.println("Valor do salário: ");
                            int salario = scanner.nextInt();
                            scanner.nextLine();
                            contaBancaria.SaldoSalario(salario);
                            contaBancaria.GetLimite();
                            isValidSalario = false;
                            break;
                        }
                        System.out.println("Você é menor de idade ou não criou a conta");
                        break;
                    }

                    System.out.println("Esta operação não está mais dispoível");

                    break;
                case "C":

                    if(!isValidSalario){
                        System.out.println("Saldo da conta: " + contaBancaria.GetSaldo());
                        break;
                    }

                    System.out.println("A conta não foi criada ainda!!!");

                    break;
                case "D":

                    if(!isValidSalario){
                        System.out.print("Valor para depositar: ");
                        int depostio = scanner.nextInt();
                        scanner.nextLine();
                        contaBancaria.Depostio(depostio);
                        break;
                    }

                    System.out.println("A conta não foi criada ainda!!!");

                    break;
                case "P":

                    if(!isValidSalario){
                        System.out.println("Valor a pagar");
                        int pagar = scanner.nextInt();
                        contaBancaria.Pagar(pagar);
                        break;
                    }

                    System.out.println("A conta não foi criada ainda!!!");

                    break;
                case "U":

                    System.out.print("Seu nome: ");
                    nome = scanner.nextLine();

                    System.out.print("Sua idade: ");
                    idade = scanner.nextInt();
                    scanner.nextLine();

                    isValidIdade = idade;

                    if(isValidIdade > 18){
                        Usuario usuario = new Usuario(nome, idade);

                        ArrayList<String> info = new ArrayList<>();

                        info = usuario.informacaoUsuario();

                        info.add(String.valueOf(contaBancaria.GetSaldo()));

                        for(String i : info){
                            System.out.println(i);
                        }

                        break;
                    }

                    System.out.println("Você é menor de idade!!!");

                    break;
                case "I":

                    if(!isValidSalario){
                        System.out.println("Informação do usuário");

                        Usuario lista = new Usuario(nome, idade);

                        ArrayList<String> list = new ArrayList<>();

                        list = lista.informacaoUsuario();

                        list.add("Saldo da conta: " + String.valueOf(contaBancaria.GetSaldo()));
                        list.add("Limite da conta: " + String.valueOf(contaBancaria.GetLimite()));

                        for(String i : list){
                            System.out.println(i);
                        }

                        break;
                    }

                    System.out.println("A conta não foi criada ainda!!!");

                    break;
                default:
                    System.out.println("Saindo do sistema!!!");
                    isValid = true;
                    break;
            }

        }

    }

}
