package Exercicio2;

public class ContaBancaria {
    private String titular;
    private String numeroConta;
    private double saldo;

    public ContaBancaria(String titular, String numeroConta, double saldo) {
        this.titular = titular;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        saldo += valor;
        System.out.printf("Depósito de R$ %.2f realizado. Novo saldo: R$ %.2f%n", valor, saldo);
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        if (valor > saldo) {
            System.out.println("Saldo insuficiente.");
            return;
        }
        saldo -= valor;
        System.out.printf("Saque de R$ %.2f realizado. Novo saldo: R$ %.2f%n", valor, saldo);
    }

    public void verificarSaldo() {
        System.out.printf("Saldo atual: R$ %.2f%n", saldo);
    }

    public String getTitular()    { return titular; }
    public String getNumeroConta() { return numeroConta; }
    public double getSaldo()       { return saldo; }
}
