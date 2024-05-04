package Cartao;

import Cartao.Exception.ExcpetionCartao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cartao {

    public void criadoArquivo(ArrayList<String> lista) throws ExcpetionCartao, IOException {

        File arquivo = new File("Backup.txt");

        if (!arquivo.exists()) {

            FileWriter fw = new FileWriter(arquivo);

            if(lista != null){
                for(String info : lista){
                    if(info != null){
                        fw.write(info + "\n");
                    }
                }
                fw.close();

            }
        }else{
            throw new ExcpetionCartao("Não foi possível criar o seu cartão ");
        }

    }
}
