package Exercicio5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Temperatura> temperaturas = new ArrayList<>();

        System.out.println("Unidades disponíveis: (1) Kelvin  (2) Celsius  (3) Fahrenheit");
        System.out.print("Quantas temperaturas deseja cadastrar? ");
        int quantidade = scanner.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("\nTemperatura %d%n", i);
            System.out.print("Unidade (1/2/3): ");
            int unidade = scanner.nextInt();
            System.out.print("Valor: ");
            double valor = scanner.nextDouble();

            Temperatura t = new Temperatura(0);

            switch (unidade) {
                case 1 -> t.setKelvin(valor);
                case 2 -> t.setCelsius(valor);
                case 3 -> t.setFahrenheit(valor);
                default -> System.out.println("Unidade inválida, temperatura ignorada.");
            }

            // Verifica se o valor informado era abaixo do zero absoluto
            if (t.getKelvin() == 0 && valor != 0) {
                System.out.println("Valor abaixo do zero absoluto. Temperatura ignorada.");
            } else {
                temperaturas.add(t);
            }
        }

        System.out.println("\n=== Temperaturas cadastradas ===");
        System.out.printf("%-15s %-15s %-15s%n", "Kelvin", "Celsius", "Fahrenheit");
        System.out.println("-".repeat(45));
        for (Temperatura t : temperaturas) {
            System.out.printf("%-15s %-15s %-15s%n",
                    String.format("%.2f K", t.getKelvin()),
                    String.format("%.2f °C", t.getCelsius()),
                    String.format("%.2f °F", t.getFahrenheit()));
        }

        scanner.close();
    }
}
