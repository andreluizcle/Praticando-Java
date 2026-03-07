import java.util.Scanner;

public class Exercicio14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double soma = 0;
        int quantidade = 0;
        double valorAtual = 0;
        while(valorAtual != -1) {
            quantidade++;
            soma += valorAtual;
            System.out.print("Digite um numero (-1 para parar): ");
            valorAtual = scanner.nextDouble();
        }
        quantidade--;
        System.out.println("Media: " + (soma/quantidade));
    }
}
