package Exercicio7;

public class Main {
    public static void main(String[] args) {
        Carro carro1 = new Carro(100);
        Carro carro2 = new Carro(200);
        Carro carro3 = new Carro(150);

        System.out.println("Carro 1 - Potência do motor: " + carro1.getMotor().getPotencia() + " cv");
        System.out.println("Carro 2 - Potência do motor: " + carro2.getMotor().getPotencia() + " cv");
        System.out.println("Carro 3 - Potência do motor: " + carro3.getMotor().getPotencia() + " cv");
    }
}
