import java.util.Random;

public class Exercicio7 {
    public static void main(String[] args) {
        Random aleatorio = new Random();
        int num;
        for(int j=1;j<=512;j++){
            num = aleatorio.nextInt(1025);
            String faixa = ((num >= 0) && (num<=13))?" - Dentro da Faixa":" - fora da Faixa";
            String multiplo3 = (num%11 == 0)?" - multiplo de 11":" - Não é multiplo de 11";
            String paridade = (num%2 == 0)?" - Par":" - Impar";
            System.out.println(j + ":" + num + faixa + multiplo3 + paridade);
        }
    }
}
