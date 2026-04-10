package Exercicio8;

public class Potencia {

    public static double calcula(int base, int expoente) {
        System.out.println("Método invocado: calcula(int base, int expoente)");
        return Math.pow(base, expoente);
    }

    public static double calcula(int base, double expoente) {
        System.out.println("Método invocado: calcula(int base, double expoente)");
        return Math.pow(base, expoente);
    }

    public static double calcula(double base, double expoente) {
        System.out.println("Método invocado: calcula(double base, double expoente)");
        return Math.pow(base, expoente);
    }
}