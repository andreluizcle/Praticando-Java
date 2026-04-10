package Exercicio11;

import Exercicio10.Palpite;

public class BilheteLoteria {
    private Palpite[] palpites;

    public BilheteLoteria(Palpite[] palpites) {
        this.palpites = new Palpite[14];
        for (int i = 0; i < 14; i++) {
            this.palpites[i] = palpites[i];
        }
    }

    public Palpite[] getPalpites() {
        return palpites;
    }

    public void setPalpites(Palpite[] palpites) {
        this.palpites = palpites;
    }

    public Palpite getPalpite(int index) {
        return palpites[index];
    }

    public void setPalpite(int index, Palpite palpite) {
        palpites[index] = palpite;
    }
}
