package MoverValorConta;

import java.util.Scanner;
import Bank.Usuario;
import Bank.ContaBancaria;

public class MenuTransferencia extends Transferencia {

    private String nome;
    private int idade;
    private String senha;
    private int salario;
    private int deposito;

    public void menu(){

        Scanner scanner = new Scanner(System.in);

        Usuario usuario = new Usuario(this.nome, this.idade, this.senha);
        ContaBancaria contaBancaria = new ContaBancaria();
        contaBancaria.SaldoSalario(this.salario);
        contaBancaria.Deposito(this.deposito);

        Conta contaVitor = new Conta(contaBancaria.GetSaldo(), usuario.getNome(), usuario.getIdade()); // getSaldo aqui!!!
        UsuarioConta conta01 = new UsuarioConta(usuario.getNome(), usuario.getIdade());

        System.out.println("Nome do recebedor: ");
        String nome02 = scanner.nextLine();
        System.out.println("Idade do recebedor: ");
        int idade02 = scanner.nextInt();
        scanner.nextLine();

        UsuarioConta conta02 = new UsuarioConta(nome02, idade02);

        System.out.println("Valor repassado: ");
        int valor = scanner.nextInt();
        boolean verificacao = contaVitor.isValidSaldo(valor); // Valor da transferência

        if(verificacao){
            Conta contaMaria = new Conta(valor, nome02, idade02);
            transferenciaDeValor(conta02, contaMaria);
            transferenciaDeValor(conta01, contaVitor);
            msg(conta01, conta02);
        }else{
            transferenciaDeValor(conta01, contaVitor);
            conta01.msg(conta01, conta02);
        }
    }

    public MenuTransferencia(String nome, int idade, String senha, int salario, int deposito){
        this.nome = nome;
        this.idade = idade;
        this.senha = senha;
        this.salario = salario;
        this.deposito = deposito;
    }

}
