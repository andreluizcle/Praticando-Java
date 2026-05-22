class Motor {
    private int potencia;

    public Motor(int potencia) {
        this.potencia = potencia;
    }

    public int getPotencia() {
        return potencia;
    }

    @Override
    public String toString() {
        return "Motor{potencia=" + potencia + " cv}";
    }
}

class Carro {
    private String modelo;
    private Motor motor;

    public Carro(String modelo, Motor motor) {
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    @Override
    public String toString() {
        return "Carro{modelo='" + modelo + "', " + motor + "}";
    }
}

public class Exercicio1 {
    public static void main(String[] args) {

        Motor motor1 = new Motor(100);
        Motor motor2 = new Motor(150);
        Motor motor3 = new Motor(200);

        Carro carro1 = new Carro("Sedan Básico", motor1);
        Carro carro2 = new Carro("SUV Médio",    motor2);
        Carro carro3 = new Carro("Esportivo",    motor3);

        System.out.println("=== Frota de Carros ===");
        System.out.println(carro1);
        System.out.println(carro2);
        System.out.println(carro3);

        System.out.println("\n=== Detalhes ===");
        for (Carro c : new Carro[]{carro1, carro2, carro3}) {
            System.out.printf("Modelo: %-15s | Potência: %d cv%n",
                    c.getModelo(), c.getMotor().getPotencia());
        }
    }
}

