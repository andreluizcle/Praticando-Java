package Exercicio12;

public class Main {
    public static void main(String[] args) {
        System.out.println("População inicial: " + SerAutoContante.getPopulacao());

        SerAutoContante s1 = new SerAutoContante("Alice");
        System.out.println("Criado: " + s1.getNome() + " | ID: " + s1.getId() + " | População: " + SerAutoContante.getPopulacao());

        SerAutoContante s2 = new SerAutoContante("Bob");
        System.out.println("Criado: " + s2.getNome() + " | ID: " + s2.getId() + " | População: " + SerAutoContante.getPopulacao());

        SerAutoContante s3 = new SerAutoContante("Carlos");
        System.out.println("Criado: " + s3.getNome() + " | ID: " + s3.getId() + " | População: " + SerAutoContante.getPopulacao());

        SerAutoContante s4 = new SerAutoContante("Diana");
        System.out.println("Criado: " + s4.getNome() + " | ID: " + s4.getId() + " | População: " + SerAutoContante.getPopulacao());

        System.out.println("\nPopulação final: " + SerAutoContante.getPopulacao());
    }
}
