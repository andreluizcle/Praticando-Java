package Exercicio10;

public class Main {
    public static void main(String[] args) {
        Palpite[] palpites = Palpiteiro.deUmPalpite();

        System.out.println("Palpite para a loteria:");
        for (int i = 0; i < palpites.length; i++) {
            System.out.println("Jogo " + (i + 1) + ": " + palpites[i]);
        }
    }
}
