package Kotlin

public class App {

    fun menu(){

        println("------- Menu -------")
        println("------- End -------")

        val opcao:Int = 1;

        val acao = when (opcao){
            1 -> {
                "x está fora dos intervalos especificados"
            }else -> {
                "x está fora dos intervalos especificados"
            }
        }

        println("A acão é: ${acao}")

    }


}