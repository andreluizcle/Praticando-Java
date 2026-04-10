package Exercicio10;

import java.util.Random;

public class Palpiteiro {

    public static Palpite[] deUmPalpite() {
        Random random = new Random();
        Palpite[] palpites = new Palpite[14];
        Palpite[] valores = Palpite.values();

        for (int i = 0; i < 14; i++) {
            palpites[i] = valores[random.nextInt(valores.length)];
        }

        return palpites;
    }
}
