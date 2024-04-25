package Cartao;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

public class Cartao {

    public void criadoArquivo(ArrayList<String> lista) {

        File arquivo = new File("Backup.txt");

        try{
            FileWriter fw = new FileWriter(arquivo);

            if(lista != null){
                System.out.println("------ Cliente ------");
                for(String info : lista){
                    if(info != null){
                        fw.write(info + "\n");
                    }
                }
                System.out.println("-------- End --------");
                fw.close();
            }
        }catch (Exception ex){
            System.out.println("Erro na execução" + ex);
        }

    }
}
