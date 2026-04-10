package Exercicio4;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Clean Code", "Robert C. Martin", 89.90);
        System.out.println("Criado:    " + livro);

        livro.setTitulo("The Pragmatic Programmer");
        livro.setAutor("Andrew Hunt");
        livro.setPreco(120.00);
        System.out.println("Atualizado: " + livro);

        livro.setPreco(-50.00);
        System.out.println("Após preço inválido (-50): " + livro);

        livro.setPreco(0);
        System.out.println("Após preço zero (válido):  " + livro);
    }
}
