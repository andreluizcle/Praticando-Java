package Exercicio1;
// Main.java
public class Main {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("Alice", 30);
        Pessoa pessoa2 = new Pessoa("Bruno", 25);

        System.out.println("=== Dados das Pessoas ===");
        System.out.println("Nome: " + pessoa1.getNome() + " | Idade: " + pessoa1.getIdade());
        System.out.println("Nome: " + pessoa2.getNome() + " | Idade: " + pessoa2.getIdade());

        System.out.println("\n=== Uso como DTO ===");
        exibirPessoa(pessoa1);
        exibirPessoa(pessoa2);
    }

    // Metodo auxiliar que recebe um DTO Pessoa e exibe seus dados
    public static void exibirPessoa(Pessoa p) {
        System.out.println("Pessoa{nome='" + p.getNome() + "', idade=" + p.getIdade() + "}");
    }
}
