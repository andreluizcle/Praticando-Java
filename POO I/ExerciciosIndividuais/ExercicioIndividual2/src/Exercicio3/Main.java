package Exercicio3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Ponto2D> pontos = new ArrayList<>();

        System.out.print("Quantos pontos deseja cadastrar? ");
        int quantidade = scanner.nextInt();

        for (int i = 1; i <= quantidade; i++) {
            System.out.printf("Ponto %d - x: ", i);
            double x = scanner.nextDouble();
            System.out.printf("Ponto %d - y: ", i);
            double y = scanner.nextDouble();
            pontos.add(new Ponto2D(x, y));
        }

        System.out.println("\n--- Pontos inseridos ---");
        for (Ponto2D p : pontos) {
            System.out.println(p);
        }

        Collections.sort(pontos);

        System.out.println("\n--- Pontos ordenados por x ---");
        for (Ponto2D p : pontos) {
            System.out.println(p);
        }

        scanner.close();
    }
}
