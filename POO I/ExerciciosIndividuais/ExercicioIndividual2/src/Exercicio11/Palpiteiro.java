package Exercicio11;

import Exercicio10.Palpite;
import java.util.Random;

public class Palpiteiro {

    public static BilheteLoteria deUmPalpite() {
        Random random = new Random();
        Palpite[] valores = Palpite.values();
        Palpite[] palpites = new Palpite[14];

        for (int i = 0; i < 14; i++) {
            palpites[i] = valores[random.nextInt(valores.length)];
        }

        return new BilheteLoteria(palpites);
    }
}
