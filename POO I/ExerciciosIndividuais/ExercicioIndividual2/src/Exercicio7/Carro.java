package Exercicio7;

public class Carro {
    private Motor motor;

    public Carro(int potenciaMotor) {
        this.motor = new Motor(potenciaMotor);
    }

    public Motor getMotor() {
        return motor;
    }
}
