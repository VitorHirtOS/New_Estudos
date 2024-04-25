package Bank;

public class ContaBancaria {
    
    private int saldo;
    private int limite;

    public void Depostio(int valor){
        this.saldo += valor;
    }

    public void Pagar(int valor){

        if(valor > this.saldo){
         
            System.out.println("Valor do saldo é menor");

        }else{

            this.saldo -= valor;
           
        }

    }

    private void SetLimite(){

        if(this.saldo >= 1000 && this.saldo <= 4000){
            this.limite = Limite.BASICO.BASICO();
        } else if (this.saldo > 4000 && this.saldo <= 9000) {
            this.limite = Limite.PREMIUM.PREMIUM();
        }else{
            this.limite = Limite.PREMIUM.START_PREMIUM();
        }

    }

    public int GetLimite(){
        SetLimite();
        return this.limite;
    }

    public void SaldoSalario(int salario){
        this.saldo += salario;
    }

    public int GetSaldo(){
        return this.saldo;
    }

    public ContaBancaria(){

    }

}