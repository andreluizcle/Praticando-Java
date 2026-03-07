import java.util.Scanner;

public class Exercicio12 {
    public static void main(String[] args) {
        //Receber
        Scanner scanner = new Scanner(System.in);
        System.out.print("bool: ");
        boolean bool = scanner.nextBoolean();
        System.out.print("int: ");
        int inteiro = scanner.nextInt();
        System.out.print("float: ");
        float flutuanteSimples = scanner.nextFloat();
        System.out.print("double: ");
        double flutuanteDuplo = scanner.nextDouble();
        System.out.print("char: ");
        char caracter = scanner.next().charAt(0);
        System.out.print("byte: ");
        byte sequenciaByte = scanner.nextByte();
        System.out.print("short: ");
        short numeroPequeno = scanner.nextShort();
        System.out.print("long: ");
        long numeroLongo = scanner.nextLong();
        System.out.print("String: ");
        String palavra = scanner.next();

        System.out.println("-------------------");
        //Imprimir
        System.out.println("bool: " + bool);
        System.out.println("int: " + inteiro);
        System.out.println("float: " + flutuanteSimples);
        System.out.println("double: " + flutuanteDuplo);
        System.out.println("char: " + caracter);
        System.out.println("byte: " + sequenciaByte);
        System.out.println("short: " + numeroPequeno);
        System.out.println("long: " + numeroLongo);
        System.out.println("String: " + palavra);
    }
}
