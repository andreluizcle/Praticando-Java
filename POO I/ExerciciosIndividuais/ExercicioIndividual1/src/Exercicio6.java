public class Exercicio6 {
    public static void main(String[] args) {
        int i = 0;
        while (i <= 99) {
            String faixa = ((i >= 18) && (i<=24))?" - Dentro da Faixa":" - fora da Faixa";
            String multiplo3 = (i%3 == 0)?" - multiplo de 3":" - Não é multiplo de 3";
            String paridade = (i%2 == 0)?" - Par":" - Impar";
            System.out.println(i + faixa + multiplo3 + paridade);
            i++;
        }
    }
}
