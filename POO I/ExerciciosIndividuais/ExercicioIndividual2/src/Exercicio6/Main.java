package Exercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CofreCriogenico cofre = new CofreCriogenico();

        System.out.println("=== Cofre Criogênico ===");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n" + cofre);
            System.out.println("1 - Abrir porta (sem alterar carga)");
            System.out.println("2 - Abrir porta (alterar carga)");
            System.out.println("3 - Fechar porta");
            System.out.println("4 - Manter frio (-0,5 °C)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    cofre.abrePorta();
                    System.out.println("Porta aberta. Temperatura subiu 3,0 °C.");
                }
                case 2 -> {
                    System.out.print("Nova carga ('vazio' para esvaziar): ");
                    String novaCarga = scanner.nextLine();
                    try {
                        cofre.abrePorta(novaCarga);
                        System.out.println("Porta aberta. Carga alterada para '" + novaCarga + "'.");
                    } catch (IllegalStateException e) {
                        System.out.println("ERRO: " + e.getMessage());
                    }
                }
                case 3 -> {
                    cofre.fechaPorta();
                    System.out.println("Porta fechada.");
                }
                case 4 -> {
                    cofre.mantemFrio();
                    System.out.println("Temperatura reduzida em 0,5 °C.");
                }
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
