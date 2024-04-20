public class ContaBancaria {
    
    private int saldo = 0;

    public void Depostio(int valor){
        this.saldo += valor;
    }

    public int GetSaldo(){
        return this.saldo;
    }

    public void Pagar(int valor){

        if(valor > this.saldo){
         
            System.out.println("Valor do saldo é menor");

        }else{
            this.saldo -= valor;
           
        }

    }

    public void SaldoSalario(int salario){
        this.saldo += salario;
    }

    public ContaBancaria(){

    }

}
