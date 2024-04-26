package Bank;

import Bank.Exception.ExceptionContaBancaria;
import Cartao.Exception.ExcpetionCartao;

import java.io.IOException;

public class Main{
    
    public static void main(String[] args) throws ExcpetionCartao, ExceptionContaBancaria, IOException {
        Menu menu = new Menu();
        menu.menu();
    }

}