import java.util.Scanner;

public class Exercicio15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o numero referente a tabuada que deseja: ");
        int numTabuada = scanner.nextInt();
        for(int i=1; i<=10;i++){
            System.out.println(numTabuada+"x"+i+"="+(numTabuada*i));
        }
    }
}
