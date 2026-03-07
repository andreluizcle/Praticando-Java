import java.util.Scanner;

public class Exercicio13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro numero: ");
        int num1 = scanner.nextInt();
        System.out.print("Digite o segundo numero: ");
        int num2 = scanner.nextInt();
        System.out.print("Digite o codigo de operação aritmetica: ");
        String operacao = scanner.next();

        System.out.print("Resultado: ");
        switch (operacao){
            case "+" -> System.out.print(num1+num2);
            case "-" -> System.out.print(num1-num2);
            case "*" -> System.out.print(num1*num2);
            case "/" -> {
                if(num2 == 0){
                    System.out.print("Divisão por 0!");
                } else {
                    System.out.print(num1/num2);
                }
            }
        }
    }
}
