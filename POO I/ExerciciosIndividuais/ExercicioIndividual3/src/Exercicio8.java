import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class BasketballPlayer implements Comparable<BasketballPlayer> {
    private String playerName;
    private double playerHeight;

    public BasketballPlayer(String playerName, double playerHeight) {
        this.playerName = playerName;
        this.playerHeight = playerHeight;
    }

    public String getPlayerName() { return playerName; }
    public double getPlayerHeight() { return playerHeight; }

    // Ordena por altura em ordem crescente
    @Override
    public int compareTo(BasketballPlayer outro) {
        return Double.compare(this.playerHeight, outro.playerHeight);
    }

    @Override
    public String toString() {
        return String.format("%-25s %.2f m", playerName, playerHeight);
    }
}

// Main
public class Exercicio8 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<BasketballPlayer> jogadores = new ArrayList<>();

        System.out.println("Cadastro de jogadores de basquete");
        System.out.println("Informe os dados de 20 jogadores:\n");

        for (int i = 1; i <= 20; i++) {
            System.out.print("Jogador " + i + " - Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Jogador " + i + " - Altura (ex: 1.98): ");
            double altura = Double.parseDouble(scanner.nextLine());

            jogadores.add(new BasketballPlayer(nome, altura));
            System.out.println();
        }

        // Collections.sort usa o compareTo definido na classe
        Collections.sort(jogadores);

        System.out.println("========================================");
        System.out.println(" Jogadores ordenados por estatura");
        System.out.println("========================================");
        System.out.printf("%-4s %-25s %s%n", "Pos", "Nome", "Altura");
        System.out.println("----------------------------------------");

        for (int i = 0; i < jogadores.size(); i++) {
            System.out.printf("%-4d %s%n", i + 1, jogadores.get(i));
        }

        System.out.println("========================================");

        scanner.close();
    }
}