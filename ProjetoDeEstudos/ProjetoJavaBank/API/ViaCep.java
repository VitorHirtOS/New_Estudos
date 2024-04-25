package API;

import API.Exception.ExcpetionCep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ViaCep {

    private String cepBR;

    public void cep(){

        try{

            URL url = new URL("https://viacep.com.br/ws/" + this.cepBR + "/json");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;

            StringBuilder response = new StringBuilder();

            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine + "\n");
            }

            reader.close();

            System.out.println(response.toString());

            conn.disconnect();

            throw new ExcpetionCep("O cep informado não é valido. Ex: 00000-000 / xxxxx-xxx ");

        }catch (Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }


    }

    public ViaCep(String cepBR){
        this.cepBR = cepBR;
    }

}
