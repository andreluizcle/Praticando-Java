import java.util.Scanner;

public class Exercicio17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro numero: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double num2 = scanner.nextDouble();

        System.out.println(Math.max(num1, num2));
    }
}
