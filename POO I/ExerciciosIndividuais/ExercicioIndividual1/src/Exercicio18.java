import java.util.Scanner;

public class Exercicio18 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] palavras = new String[128];
        int i = 0;
        while (i<128){
            System.out.print("Digite uma palavra ('fim' para parar): ");
            palavras[i] = scanner.nextLine();
            if(palavras[i].endsWith("fim")){
                break;
            }
            i++;
        }
        for(int j = i; j>=0; j--){
            System.out.println(palavras[j]);
        }
    }
}
