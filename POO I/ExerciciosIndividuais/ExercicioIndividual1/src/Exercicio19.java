import java.util.Arrays;
import java.util.Scanner;

public class Exercicio19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a quantidade de numeros que ira digitar: ");
        int quantidade = scanner.nextInt();
        double[] conjunto = new double[quantidade];
        for(int i = 0; i<conjunto.length; i++){
            System.out.print((i+1)+": ");
            conjunto[i] = scanner.nextDouble();
        }
        Arrays.sort(conjunto);
        double mediana;
        int n = conjunto.length;

        if (n % 2 == 0) {
            mediana = (conjunto[n/2 - 1] + conjunto[n/2]) / 2;
        } else {
            mediana = conjunto[n/2];
        }

        System.out.println("Mediana: " + mediana);
    }
}
