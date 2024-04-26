package Fisica_Juridica;

public class Juridica extends Jurida_ou_Fisica {

    private final String id;

    @Override
    public String info(){
        return "Você é uma empresa";
    }

    public Juridica(String id) {
        super(id);
        this.id = id;
    }

}
