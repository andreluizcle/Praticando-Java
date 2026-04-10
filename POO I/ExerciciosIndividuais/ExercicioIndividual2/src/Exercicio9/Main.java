package Exercicio9;

public class Main {
    public static void main(String[] args) {
        int[] palpite = Palpiteiro.deUmPalpite();

        System.out.println("Palpite para a loteria:");
        for (int i = 0; i < palpite.length; i++) {
            String resultado;
            if (palpite[i] == 1) resultado = "Coluna 1";
            else if (palpite[i] == 2) resultado = "Coluna 2";
            else resultado = "Empate";

            System.out.println("Jogo " + (i + 1) + ": " + resultado + " (" + palpite[i] + ")");
        }
    }
}
