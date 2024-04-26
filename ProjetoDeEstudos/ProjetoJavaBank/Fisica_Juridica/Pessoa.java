package Fisica_Juridica;

public class Pessoa extends Jurida_ou_Fisica {

    public void Status(){

        String id = getId();

        if(id.equals("1365")){
            Fisica fisica = new Fisica(id);
            fisica.info();
        } else if (id.equals("2479")) {
            Juridica juridica = new Juridica(id);
            juridica.info();
        }

        info();

    }

    public Pessoa(String id){
        super(id);
    }

}
