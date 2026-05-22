import java.util.ArrayList;

class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo         = titulo;
        this.autor          = autor;
        this.anoPublicacao  = anoPublicacao;
    }

    public String getTitulo()       { return titulo; }
    public String getAutor()        { return autor; }
    public int getAnoPublicacao()   { return anoPublicacao; }

    @Override
    public String toString() {
        return String.format("Livro{titulo='%s', autor='%s', ano=%d}",
                titulo, autor, anoPublicacao);
    }
}

class Biblioteca {
    private String nome;
    private ArrayList<Livro> livros;

    public Biblioteca(String nome) {
        this.nome   = nome;
        this.livros = new ArrayList<>();
    }

    // Adiciona um livro ao acervo
    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("✔ Livro adicionado: " + livro.getTitulo());
    }

    // Remove um livro pelo título
    public void removerLivro(String titulo) {
        Livro encontrado = null;
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                encontrado = l;
                break;
            }
        }
        if (encontrado != null) {
            livros.remove(encontrado);
            System.out.println("✔ Livro removido: " + titulo);
        } else {
            System.out.println("✘ Livro não encontrado: " + titulo);
        }
    }

    // Lista todos os livros do acervo
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }
        System.out.println("\n📚 Acervo da biblioteca '" + nome + "' (" + livros.size() + " livros):");
        System.out.println("-".repeat(55));
        for (int i = 0; i < livros.size(); i++) {
            System.out.printf("  %d. %s%n", i + 1, livros.get(i));
        }
        System.out.println("-".repeat(55));
    }

    // Busca livro por título
    public Livro buscarPorTitulo(String titulo) {
        for (Livro l : livros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) return l;
        }
        return null;
    }

    public String getNome()         { return nome; }
    public int getTotalLivros()     { return livros.size(); }
}

public class Exercicio3 {
    public static void main(String[] args) {

        // Criando a biblioteca
        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");

        // Criando livros
        Livro l1 = new Livro("Dom Casmurro",              "Machado de Assis",  1899);
        Livro l2 = new Livro("O Cortiço",                 "Aluísio Azevedo",   1890);
        Livro l3 = new Livro("Grande Sertão: Veredas",    "Guimarães Rosa",    1956);
        Livro l4 = new Livro("A Hora da Estrela",         "Clarice Lispector", 1977);
        Livro l5 = new Livro("Memórias Póstumas",         "Machado de Assis",  1881);

        // Adicionando livros
        System.out.println("=== Adicionando Livros ===");
        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3);
        biblioteca.adicionarLivro(l4);
        biblioteca.adicionarLivro(l5);

        // Listando acervo completo
        biblioteca.listarLivros();

        // Removendo um livro existente
        System.out.println("\n=== Removendo Livro ===");
        biblioteca.removerLivro("O Cortiço");

        // Tentando remover livro inexistente
        biblioteca.removerLivro("Harry Potter");

        // Listando após remoção
        biblioteca.listarLivros();

        // Buscando um livro
        System.out.println("\n=== Busca por Título ===");
        Livro encontrado = biblioteca.buscarPorTitulo("A Hora da Estrela");
        if (encontrado != null) {
            System.out.println("Livro encontrado: " + encontrado);
        }

        // Resumo final
        System.out.println("\n=== Resumo Final ===");
        System.out.printf("Biblioteca: '%s' | Total de livros: %d%n",
                biblioteca.getNome(), biblioteca.getTotalLivros());
    }
}

