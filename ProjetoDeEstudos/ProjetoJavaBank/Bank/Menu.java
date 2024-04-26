package Bank;

import API.ViaCep;
import Bank.Exception.ExceptionContaBancaria;
import Cartao.Cartao;
import Bank.Exception.ExceptionMenu;
import Cartao.Exception.ExcpetionCartao;
import Fisica_Juridica.Pessoa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu extends Cartao {
    
    private boolean isValid = false;
    private boolean isValidSalario = true;
    private String nome;
    private int idade;
    public ArrayList<String> lista;
    private ContaBancaria contaBancaria;
    private Usuario usuario;
    private String cep;
    private int depostio;
    private int pagar;
    private String senha;
    private String senhaIsValid;
    private String id;

    public void menu() throws ExcpetionCartao, IOException, ExceptionContaBancaria {

        contaBancaria = new ContaBancaria();
        usuario = new Usuario(nome, idade, senha);
        Menu criadoCartao = new Menu();

        while(!isValid){

            Scanner scanner = new Scanner(System.in);

            System.out.println("Qual a sua operação: [SA] - [C] - [D] - [P] - [U] - [B] - [V] - [ID] - [.]");
            String acao = scanner.nextLine().toUpperCase();

            switch (acao) {
                case "SA":

                    if(isValidSalario){

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
                    }

                    System.out.println("Esta operação não está mais disponível");

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
                            contaBancaria.Depostio(depostio);
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
                    nome = scanner.nextLine();
                    while(nome == null){

                        System.out.println(String.format("Você não forneceu uma nome válido: '%s'", this.nome));

                        System.out.print("Valide o seu nome: ou 's' para sair: ");
                        nome = scanner.nextLine();

                        if(nome.toUpperCase().equals("S")){
                            nome = null;
                            break;
                        }

                        System.err.println("O seu nome não é válido!!! ");

                    }

                    if(this.nome != null){
                        System.err.println("O seu usuário não foi criado");
                       break;
                    }

                    usuario.setNome(nome);

                    System.out.print("Sua idade: ");
                    idade = scanner.nextInt();
                    scanner.nextLine();

                    while(this.idade < 18){

                        System.out.print("Valide a sua idade: ou '1' para sair: ");

                        idade = scanner.nextInt();

                        if(idade == 1){
                            idade = 1;
                            break;
                        }

                        System.err.println("O seu usuário não foi criado!!! ");

                    }

                    if(this.idade != 1){
                        System.err.println("O seu usuário não foi criado");
                        break;
                    }

                    usuario.setIdade(idade);

                    System.out.print("Crie uma senha: ");
                    senha = scanner.nextLine();

                    while(senha != null){

                        System.out.print("Valide a sua senha: ou 's' para sair: ");
                        senhaIsValid = scanner.nextLine();

                        if(senhaIsValid.toUpperCase().equals("S")){
                            senha = null;
                            break;
                        }else if(senhaIsValid.equals(senha)){
                            System.out.println("Senha é válida ");
                            break;
                        }

                        System.err.println("Senhas não seu iguais!!! ");

                    }

                    if(senha != null){
                        System.err.println("O seu usuário não foi criado!!! ");
                        break;
                    }

                    break;
                case "B":

                    if(!isValidSalario){
                        ArrayList<String> lista = new ArrayList<String>();

                        lista.add("Idade: " + String.valueOf(usuario.getIdade()));
                        lista.add("CVC: " + usuario.getCVC());
                        lista.add("Nome: " + usuario.getNome());
                        lista.add("Número do cartão: " + usuario.getNumeroCard());
                        lista.add("Data vencimento do cartão: " + usuario.getDataVencimento());
                        lista.add("Limite: " + String.valueOf(contaBancaria.GetLimite()));
                        lista.add("Saldo: " + String.valueOf(contaBancaria.GetSaldo()));
                        lista.add("Senha: " + usuario.getSenha());

                        criadoCartao.criadoArquivo(lista);
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

                    System.out.print("Pessoa física ou Jurídica? número: ");
                    id = scanner.nextLine();

                    Pessoa pessoa = new Pessoa(id);
                    pessoa.Status();

                default:
                    System.out.println("Saindo do sistema!!!");
                    isValid = true;
                    break;
            }

        }

    }

}
