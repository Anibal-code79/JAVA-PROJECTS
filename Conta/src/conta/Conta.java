package conta;
/**
 * CLASSE QUE REPRESENTA UMA CONTA BANCARIA SIMPLES 
 * @author anibal
 * @version 1.0
 */
public class Conta {
    private String nome;
    private double saldo;
    
    public Conta(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }
   
    public void depositar(double valor) {
        saldo = saldo + valor;
        System.out.println("Depósito realizado.");
    }
        
    public void levantar(double valor) {
        if (valor <= saldo) {
            saldo = saldo - valor;
            System.out.println("Levantamento realizado.");
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

   public double getSaldo() {
        return saldo;
    }
    
    public static void main(String[] args) {
       Conta conta = new Conta("Anibal", 5000);
        conta.depositar(1000);
        conta.levantar(2000);
        System.out.println("Saldo Final: " + conta.getSaldo());
    }   
}
