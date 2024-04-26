package Fisica_Juridica;

abstract public class Jurida_ou_Fisica implements Ids {

    private final String id;
    private String ids;

    public boolean isValidId(){

        this.ids = String.valueOf(id.substring(0, 3));

        return this.ids.equals("1365") || this.ids.equals("2479");

    }

    public String getId(){

        if(isValidId()){

            if(this.ids.equals("1365")){
                return ids;
            }

            return ids;

        }

        return null;

    }

    public String info(){
        return "Você não é pessoa física ou jurídica";
    }

    public Jurida_ou_Fisica(String id){
        this.id = id;
    }

}
