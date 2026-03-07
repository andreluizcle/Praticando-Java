import java.util.Scanner;

public class Exercicio16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro numero: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo numero: ");
        double num2 = scanner.nextDouble();

        System.out.print("Maior if-else: ");
        if(num1>num2){
            System.out.println(num1);
        } else if(num2>num1){
            System.out.println(num2);
        } else{
            System.out.println("São iguais");
        }
        System.out.print("Maior ternario: ");
        System.out.print(num1>num2?num1:num2);
    }
}
