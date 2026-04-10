package Exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Titular da conta: ");
        String titular = scanner.nextLine();

        System.out.print("Número da conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Saldo inicial: R$ ");
        double saldoInicial = scanner.nextDouble();

        ContaBancaria conta = new ContaBancaria(titular, numeroConta, saldoInicial);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n=== Banco IntelliJ ===");
            System.out.println("Titular: " + conta.getTitular() + " | Conta: " + conta.getNumeroConta());
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Verificar saldo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Valor para depositar: R$ ");
                    conta.depositar(scanner.nextDouble());
                    break;
                case 2:
                    System.out.print("Valor para sacar: R$ ");
                    conta.sacar(scanner.nextDouble());
                    break;
                case 3:
                    conta.verificarSaldo();
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}