package Bank;

public class Transferencia {

    public void transferenciaDeValor(UsuarioConta usuario, Conta conta){

        System.out.println("----- CONTA -----");
        System.out.println(usuario.getNome());
        System.out.println(usuario.getIdade());
        System.out.println(conta.getValor());
        System.out.println("------ END ------");

    }

    // Metodo único para usuário e conta bancária

    public void msg(UsuarioConta usuario01, UsuarioConta usuario02){
        System.out.println("A ação foi realizada com sucesso: " + usuario01.getNome() + " Para " + usuario02.getNome());
    }

}