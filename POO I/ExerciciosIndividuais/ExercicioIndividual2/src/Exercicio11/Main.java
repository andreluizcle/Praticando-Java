package Exercicio11;

public class Main {
    public static void main(String[] args) {
        BilheteLoteria bilhete = Palpiteiro.deUmPalpite();

        System.out.println("Bilhete de loteria gerado:");
        for (int i = 0; i < 14; i++) {
            System.out.println("Jogo " + (i + 1) + ": " + bilhete.getPalpite(i));
        }
    }
}
