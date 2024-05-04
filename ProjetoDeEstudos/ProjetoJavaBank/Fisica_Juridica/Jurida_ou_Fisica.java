package Fisica_Juridica;

abstract public class Jurida_ou_Fisica {

    public boolean isValidId(String ids){

        System.out.println(ids);

        return ids.equals("1365") || ids.equals("2479");

    }

    public String getId(String id){

        String ids = String.valueOf(id.substring(0, 4));

        System.out.println(ids);

        if(isValidId(ids)){

            if(ids.equals("1365")){
                System.out.println("Fisica");
                return ids;
            }

            System.out.println("Jurídica");
            return ids;

        }

        return "";

    }

    public String info(){
        return "Você não é pessoa física ou jurídica";
    }

}
