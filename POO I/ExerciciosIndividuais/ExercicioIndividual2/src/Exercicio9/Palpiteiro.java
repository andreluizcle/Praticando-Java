package Exercicio9;

import java.util.Random;

public class Palpiteiro {

    public static int[] deUmPalpite() {
        Random random = new Random();
        int[] palpite = new int[14];

        for (int i = 0; i < 14; i++) {
            palpite[i] = random.nextInt(3);
        }

        return palpite;
    }
}