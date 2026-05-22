import java.util.ArrayList;

class Produto {
    private String nome;
    private double preco;
    private int estoque;

    public Produto(String nome, double preco, int estoque) {
        this.nome    = nome;
        this.preco   = preco;
        this.estoque = estoque;
    }

    public String getNome()    { return nome; }
    public double getPreco()   { return preco; }
    public int getEstoque()    { return estoque; }

    @Override
    public String toString() {
        return String.format("Produto{nome='%s', preco=R$%.2f, estoque=%d}", nome, preco, estoque);
    }
}

class Estoque {
    private ArrayList<Produto> produtos;

    public Estoque() {
        this.produtos = new ArrayList<>();
    }

    // ── Inserção ────────────────────────────────────────────────────
    public void inserir(Produto p) {
        try {
            if (p == null) throw new IllegalArgumentException("Produto não pode ser nulo.");
            produtos.add(p);
            System.out.println("  ADD  ✔ " + p);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD  ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    // ── Remoção por nome ─────────────────────────────────────────────
    public void removerPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome inválido para remoção.");

            Produto encontrado = null;
            for (Produto p : produtos) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    encontrado = p;
                    break;
                }
            }
            if (encontrado == null)
                throw new IllegalArgumentException("Produto '" + nome + "' não encontrado.");

            produtos.remove(encontrado);
            System.out.println("  REM  ✔ Removido: " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM  ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    // ── Remoção por índice ───────────────────────────────────────────
    public void removerPorIndice(int indice) {
        try {
            Produto removido = produtos.remove(indice);
            System.out.println("  REM  ✔ Índice " + indice + ": " + removido);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  REM  ✘ IndexOutOfBoundsException: índice " + indice
                    + " inválido (tamanho=" + produtos.size() + ")");
        }
    }

    // ── Busca por nome ───────────────────────────────────────────────
    public void buscarPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome de busca inválido.");

            Produto encontrado = null;
            for (Produto p : produtos) {
                if (p.getNome().equalsIgnoreCase(nome)) {
                    encontrado = p;
                    break;
                }
            }
            if (encontrado == null)
                throw new IllegalArgumentException("Produto '" + nome + "' não encontrado.");

            System.out.println("  FIND ✔ " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    // ── Busca por índice ─────────────────────────────────────────────
    public void buscarPorIndice(int indice) {
        try {
            Produto p = produtos.get(indice);
            System.out.println("  GET  ✔ Índice " + indice + ": " + p);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  GET  ✘ IndexOutOfBoundsException: índice " + indice
                    + " inválido (tamanho=" + produtos.size() + ")");
        }
    }

    // ── Listagem completa ────────────────────────────────────────────
    public void listar() {
        if (produtos.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + produtos.size() + " produtos):");
        for (int i = 0; i < produtos.size(); i++) {
            System.out.printf("    [%d] %s%n", i, produtos.get(i));
        }
    }

    public int getTotalProdutos() { return produtos.size(); }
}

public class Exercicio5 {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        // ── Teste 1: inserções válidas ───────────────────────────────
        System.out.println("=== Teste 1: Inserções Válidas ===");
        estoque.inserir(new Produto("Notebook",    3500.00, 10));
        estoque.inserir(new Produto("Mouse",         89.90,  50));
        estoque.inserir(new Produto("Teclado",      149.90,  30));
        estoque.inserir(new Produto("Monitor",     1299.00,  15));
        estoque.inserir(new Produto("Headset",      259.00,  20));
        estoque.listar();

        // ── Teste 2: inserção nula (exceção) ─────────────────────────
        System.out.println("\n=== Teste 2: Inserção Nula (exceção) ===");
        estoque.inserir(null);

        // ── Teste 3: busca por nome válido ───────────────────────────
        System.out.println("\n=== Teste 3: Busca por Nome ===");
        estoque.buscarPorNome("Monitor");
        estoque.buscarPorNome("mouse");   // case-insensitive

        // ── Teste 4: busca por nome inexistente (exceção) ────────────
        System.out.println("\n=== Teste 4: Busca Nome Inexistente (exceção) ===");
        estoque.buscarPorNome("Impressora");
        estoque.buscarPorNome("");        // nome em branco

        // ── Teste 5: busca por índice válido ─────────────────────────
        System.out.println("\n=== Teste 5: Busca por Índice ===");
        estoque.buscarPorIndice(0);
        estoque.buscarPorIndice(4);

        // ── Teste 6: busca por índice inválido (exceção) ─────────────
        System.out.println("\n=== Teste 6: Busca Índice Inválido (exceção) ===");
        estoque.buscarPorIndice(99);
        estoque.buscarPorIndice(-1);

        // ── Teste 7: remoção por nome ────────────────────────────────
        System.out.println("\n=== Teste 7: Remoção por Nome ===");
        estoque.removerPorNome("Teclado");
        estoque.removerPorNome("Notebook");
        estoque.listar();

        // ── Teste 8: remoção por nome inexistente (exceção) ──────────
        System.out.println("\n=== Teste 8: Remoção Nome Inexistente (exceção) ===");
        estoque.removerPorNome("Notebook"); // já removido

        // ── Teste 9: remoção por índice válido ───────────────────────
        System.out.println("\n=== Teste 9: Remoção por Índice ===");
        estoque.removerPorIndice(0);
        estoque.listar();

        // ── Teste 10: remoção por índice inválido (exceção) ──────────
        System.out.println("\n=== Teste 10: Remoção Índice Inválido (exceção) ===");
        estoque.removerPorIndice(50);

        // ── Teste 11: esvaziando com loop ────────────────────────────
        System.out.println("\n=== Teste 11: Removendo Tudo com Loop ===");
        estoque.inserir(new Produto("Webcam", 199.00, 8));
        estoque.inserir(new Produto("Caixinha", 89.00, 5));
        estoque.inserir(new Produto("Pendrive", 49.00, 15));
        System.out.println("  Antes:");
        estoque.listar();
        while (estoque.getTotalProdutos() > 0) {
            estoque.removerPorIndice(0);
        }
        estoque.listar();
        // remove restantes manualmente até lista vazia
        estoque.removerPorIndice(0);
        estoque.removerPorIndice(0);
        estoque.listar();
    }
}