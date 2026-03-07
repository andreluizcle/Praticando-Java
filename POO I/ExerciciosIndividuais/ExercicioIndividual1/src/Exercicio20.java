import java.util.Scanner;

public class Exercicio20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha seu prato: ");
        System.out.println("1-Salada");
        System.out.println("2-Arroz e Feijao");
        System.out.println("3-Espaguete ao sugo");
        System.out.println("4-Frango frito com farofa");
        System.out.println("5-Bisteca grelhada");
        System.out.println("6-Peixe ensopado");
        int opcao = scanner.nextInt();
        switch (opcao) {
            case 1 -> System.out.println("Salada");
            case 2 -> System.out.println("Arroz e feijão");
            case 3 -> System.out.println("Espaguete ao sugo");
            case 4 -> System.out.println("Frango frito com farofa");
            case 5 -> System.out.println("Bisteca grelhada");
            case 6 -> System.out.println("Peixe ensopado");
            default -> System.out.println("Prato indisponível");
        }
    }
}
