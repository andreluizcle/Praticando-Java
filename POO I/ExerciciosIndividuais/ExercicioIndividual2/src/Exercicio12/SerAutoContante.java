package Exercicio12;

public class SerAutoContante {
    private int id;
    private String nome;
    private static int populacao = 0;

    public SerAutoContante(String nome) {
        this.populacao++;
        this.id = populacao;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public static int getPopulacao() {
        return populacao;
    }
}
