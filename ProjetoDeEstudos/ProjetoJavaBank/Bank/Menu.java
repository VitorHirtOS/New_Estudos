package Bank;

import API.ViaCep;
import Bank.Exception.ExceptionContaBancaria;
import Cartao.Cartao;
import Bank.Exception.ExceptionMenu;
import Cartao.Exception.ExcpetionCartao;
import Fisica_Juridica.Pessoa;
import Poupanca.Poupanca;
import Poupanca.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Poupanca {
    
    private boolean isValid = false;
    private boolean isValidSalario = true;
    private String nome;
    private int idade;
    private int deposito;
    private ContaBancaria contaBancaria;
    private Usuario usuario;
    private Cartao cartao;
    private String cep;
    private int depostio;
    private int pagar;
    private int senha;
    private int valorMovimentacao;
    private Transferencia transferenciaDeValor;

    public void menu() throws ExcpetionCartao, IOException, ExceptionContaBancaria {

        contaBancaria = new ContaBancaria();
        cartao = new Cartao();
        transferenciaDeValor = new Transferencia();

        while(!isValid){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual a sua operação: [SA] - [C] - [D] - [P] - [U] - [B] - [V] - [ID] - [SP] - [DP] - [VP] - [TR] - [.]");
            String acao = scanner.nextLine().toUpperCase();

            switch (acao) {
                case "SA":

                        try{

                            if(this.idade > 18 && this.nome != null){
                                System.out.println("Valor do salário: ");
                                int salario = scanner.nextInt();
                                scanner.nextLine();
                                contaBancaria.SaldoSalario(salario);
                                contaBancaria.GetLimite();
                                isValidSalario = false;
                                break;
                            }

                            throw new ExceptionMenu("Problemas relacionados ao seu salário, pode haver entraves envolvendo o seus dados\nUse a opção de criar conta [U]\n" +
                                    String.format("OBS: Você deve forncer uma idade acima de 18, e, o seu nome para que seja valido a criação. Sua idade: %d.\n " +
                                            "Seu nome: %s", this.idade, this.nome));

                        }catch (ExceptionMenu | ExceptionContaBancaria ex){
                            System.out.println("Error: " + ex.getMessage());
                        }

                        break;

                case "C":

                    try{

                        if(!isValidSalario){

                            System.out.println("Saldo da sua conta está: " + contaBancaria.GetSaldo());
                            break;
                        }

                        throw new ExceptionMenu("Problemas ao verifcar saldo: Você forneceu o seus dados de forma correta.\n" +
                                String.format("OBS: Você deve forncer uma idade acima de 18, e, o seu nome para que seja valido a criação. Sua idade: %d.\n " +
                                        "Seu nome: %s", this.idade, this.nome));

                    }catch (ExceptionMenu ex){
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;
                case "D":

                    try{

                        if(!isValidSalario){
                            System.out.print("Valor para depositar: ");
                            depostio = scanner.nextInt();
                            scanner.nextLine();
                            contaBancaria.Deposito(depostio);
                            break;
                        }

                        throw new ExceptionMenu("Problemas ao fazer depósito: Você forneceu o seus dados de forma correta.\n" +
                                String.format("OBS: Você deve forncer uma idade acima de 18, e, o seu nome para que seja valido a criação. Sua idade: %d.\n " +
                                        "Seu nome: %s", this.idade, this.nome));

                    }catch (ExceptionMenu ex){
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;
                case "P":

                    try{

                        if(!isValidSalario){
                            System.out.println("Valor a pagar: ");
                            pagar = scanner.nextInt();
                            contaBancaria.Pagar(pagar);
                            break;
                        }

                        throw new ExceptionMenu("Problemas ao fazer depósito: Você forneceu o seus dados de forma correta.\n" +
                                String.format("OBS: Você deve forncer uma idade acima de 18, e, o seu nome para que seja valido a criação. Sua idade: %d.\n " +
                                        "Seu nome: %s", this.idade, this.nome));

                    }catch (ExceptionMenu ex){
                        System.out.println("Error: " + ex.getMessage());
                    }

                    break;
                case "U":

                    System.out.print("Seu nome: ");
                    String nome = scanner.nextLine();

                    while(nome.isEmpty()){

                        System.out.println(String.format("Você não forneceu uma nome válido: '%s'", nome));

                        System.out.print("Valide o seu nome: ou 's' para sair: ");
                        nome = scanner.nextLine();

                        if(nome.toUpperCase().equals("S")){
                            nome = null;
                            break;
                        } else if (nome.isEmpty()) {
                            System.err.println("O seu nome não é válido!!! ");
                        }

                        System.out.println("O seu nome é válido!!! ");
                    }

                    if(nome == null){
                       System.err.println("O seu usuário não foi criado");
                       break;
                    }

                    this.nome = nome;

                    System.out.print("Sua idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine();

                    if(idade < 18){

                        boolean isValidIdade = false;

                        while(!isValidIdade){

                            System.out.print("Valide a sua idade: ou '1' para sair: ");
                            idade = scanner.nextInt();

                            if(idade == 1){
                                idade = 1;
                                break;
                            }

                            System.err.println("O seu usuário não foi criado!!! ");

                        }

                    }


                    if(idade == 1){
                        System.err.println("O seu usuário não foi criado");
                        break;
                    }

                    this.idade = idade;

                    System.out.print("Crie uma senha: ");
                    String senha = scanner.nextLine();

                    while(senha != null){

                        System.out.print("Valide a sua senha: ou 's' para sair: ");
                        String senhaIsValid = scanner.nextLine();

                        if(senhaIsValid.toUpperCase().equals("S")){
                            senha = null;
                            break;
                        }else if(senhaIsValid.equals(senha)){
                            System.out.println("Senha é válida ");
                            break;
                        }

                        System.err.println("Senhas não seu iguais!!! \n");

                    }

                    if(senha == null){
                        System.err.println("O seu usuário não foi criado!!! ");
                        break;
                    }

                    usuario = new Usuario(nome, idade, senha);

                    break;
                case "B":

                    if(!isValidSalario){
                        ArrayList<String> lista = new ArrayList<String>();

                        lista.add("-------- Bank --------");
                        lista.add("Nome: " + usuario.getNome());
                        lista.add("Idade: " + String.valueOf(usuario.getIdade()));
                        lista.add("CVC: " + usuario.getCVC());
                        lista.add("Número do cartão: " + usuario.getNumeroCard());
                        lista.add("Data vencimento do cartão: " + usuario.getDataVencimento());
                        lista.add("Limite: " + String.valueOf(contaBancaria.GetLimite()));
                        lista.add("Saldo: " + String.valueOf(contaBancaria.GetSaldo()));
                        lista.add("Senha: " + usuario.getSenha());
                        lista.add("-------- End --------");

                        cartao.criadoArquivo(lista);
                        break;
                    }

                    System.out.println("Você não criou uma conta ainda!!!\nUse a opção de criar conta [U]");
                    break;
                case "V":

                    System.out.print("O seu código postal: ");
                    cep = scanner.nextLine();

                    if(this.cep != null){
                        System.err.println("Não foi possível validar o CEP: " + this.cep);
                        break;
                    }

                    ViaCep viaCep = new ViaCep(cep);
                    viaCep.cep();

                    break;
                case "ID":

                    Pessoa pessoa = new Pessoa();
                    pessoa.Status();

                    break;
                case "SP":

                    System.out.print("Qual o valor do saque: ");
                    int saqueDeposito  = scanner.nextInt();

                    sacarPoupanca(saqueDeposito);

                    break;
                case "DP":

                    System.out.print("Qual o valor do depósito: ");
                    deposito  = scanner.nextInt();

                    if(deposito > 1){
                        depositoPoupanca(deposito);
                    }

                    break;
                case "TR":

                    if(this.nome != null){

                        Conta contaVitor = new Conta(contaBancaria.GetSaldo(), usuario.getNome(), usuario.getIdade()); // getSaldo aqui!!!
                        UsuarioConta conta01 = new UsuarioConta(usuario.getNome(), usuario.getIdade());

                        System.out.println("Nome do recebedor: ");
                        String nome02 = scanner.nextLine();
                        System.out.println("Idade do recebedor: ");
                        int idade02 = scanner.nextInt();
                        scanner.nextLine();

                        UsuarioConta conta02 = new UsuarioConta(nome02, idade02);

                        System.out.println("Valor repassado: ");
                        this.valorMovimentacao = scanner.nextInt();
                        contaBancaria.Pagar(this.valorMovimentacao);
                        boolean verificacao = contaVitor.isValidSaldo(this.valorMovimentacao); // Valor da transferência

                        if(verificacao){
                            Conta contaMaria = new Conta(this.valorMovimentacao, nome02, idade02);
                            transferenciaDeValor.transferenciaDeValor(conta02, contaMaria);
                            transferenciaDeValor.transferenciaDeValor(conta01, contaVitor);
                            transferenciaDeValor.msg(conta01, conta02);
                        }else{
                            transferenciaDeValor.transferenciaDeValor(conta01, contaVitor);
                            conta01.msg(conta01, conta02);
                        }

                        break;

                    }

                    System.out.println("Não foi possível fazer esta operação. Portanto crie uma conta [U] e depois [SA]");

                    break;
                case "VP":
                    System.out.println("Valor da poupança: " + getDepositoPoupanca());
                    break;
                case "T":

                    Test test = new Test();
                    test.menuTest();
                    break;
                default:
                    System.out.println("Saindo do sistema!!!");
                    isValid = true;
                    break;
            }

        }

    }

}
