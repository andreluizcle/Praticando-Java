import java.util.LinkedList;
import java.util.NoSuchElementException;

class Medicamento {
    private String nome;
    private String principioAtivo;
    private double preco;

    public Medicamento(String nome, String principioAtivo, double preco) {
        this.nome           = nome;
        this.principioAtivo = principioAtivo;
        this.preco          = preco;
    }

    public String getNome()            { return nome; }
    public String getPrincipioAtivo()  { return principioAtivo; }
    public double getPreco()           { return preco; }

    @Override
    public String toString() {
        return String.format("Medicamento{nome='%s', principio='%s', preco=R$%.2f}",
                nome, principioAtivo, preco);
    }
}

class Farmacia {
    private LinkedList<Medicamento> estoque;

    public Farmacia() {
        this.estoque = new LinkedList<>();
    }

    // ── Inserções ────────────────────────────────────────────────────

    public void inserirNoFim(Medicamento m) {
        try {
            if (m == null) throw new IllegalArgumentException("Medicamento não pode ser nulo.");
            estoque.addLast(m);
            System.out.println("  ADD_LAST  ✔ " + m);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD_LAST  ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void inserirNoInicio(Medicamento m) {
        try {
            if (m == null) throw new IllegalArgumentException("Medicamento não pode ser nulo.");
            estoque.addFirst(m);
            System.out.println("  ADD_FIRST ✔ " + m);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD_FIRST ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void inserirNaPosicao(int indice, Medicamento m) {
        try {
            if (m == null) throw new IllegalArgumentException("Medicamento não pode ser nulo.");
            estoque.add(indice, m);
            System.out.println("  ADD[" + indice + "]     ✔ " + m);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + estoque.size() + ")");
        }
    }

    // ── Remoções ─────────────────────────────────────────────────────

    public void removerPrimeiro() {
        try {
            Medicamento removido = estoque.removeFirst();
            System.out.println("  REM_FIRST ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_FIRST ✘ NoSuchElementException: estoque vazio!");
        }
    }

    public void removerUltimo() {
        try {
            Medicamento removido = estoque.removeLast();
            System.out.println("  REM_LAST  ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_LAST  ✘ NoSuchElementException: estoque vazio!");
        }
    }

    public void removerPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome inválido.");

            Medicamento encontrado = buscarInternamente(nome);
            if (encontrado == null)
                throw new NoSuchElementException("Medicamento '" + nome + "' não encontrado.");

            estoque.remove(encontrado);
            System.out.println("  REM_NOME  ✔ Removido: " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM_NOME  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_NOME  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void removerPorIndice(int indice) {
        try {
            Medicamento removido = estoque.remove(indice);
            System.out.println("  REM[" + indice + "]     ✔ Removido: " + removido);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  REM[" + indice + "]     ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + estoque.size() + ")");
        }
    }

    // ── Buscas ───────────────────────────────────────────────────────

    public void buscarPrimeiro() {
        try {
            System.out.println("  FIRST     ✔ " + estoque.getFirst());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIRST     ✘ NoSuchElementException: estoque vazio!");
        }
    }

    public void buscarUltimo() {
        try {
            System.out.println("  LAST      ✔ " + estoque.getLast());
        } catch (NoSuchElementException ex) {
            System.out.println("  LAST      ✘ NoSuchElementException: estoque vazio!");
        }
    }

    public void buscarPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome de busca inválido.");

            Medicamento encontrado = buscarInternamente(nome);
            if (encontrado == null)
                throw new NoSuchElementException("Medicamento '" + nome + "' não encontrado.");

            System.out.println("  FIND_NOME ✔ " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND_NOME ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIND_NOME ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void buscarPorIndice(int indice) {
        try {
            System.out.println("  GET[" + indice + "]      ✔ " + estoque.get(indice));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  GET[" + indice + "]      ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + estoque.size() + ")");
        }
    }

    // ── Helper interno ────────────────────────────────────────────────

    private Medicamento buscarInternamente(String nome) {
        for (Medicamento m : estoque) {
            if (m.getNome().equalsIgnoreCase(nome)) return m;
        }
        return null;
    }

    // ── Listagem ─────────────────────────────────────────────────────

    public void listar() {
        if (estoque.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + estoque.size() + " medicamentos):");
        for (int i = 0; i < estoque.size(); i++) {
            System.out.printf("    [%d] %s%n", i, estoque.get(i));
        }
    }

    public boolean isEmpty() { return estoque.isEmpty(); }
}

public class Exercicio9 {
    public static void main(String[] args) {

        Farmacia farmacia = new Farmacia();

        // ── Teste 1: inserções no fim ────────────────────────────────
        System.out.println("=== Teste 1: Inserção no Fim (addLast) ===");
        farmacia.inserirNoFim(new Medicamento("Dipirona",    "Metamizol",      2.50));
        farmacia.inserirNoFim(new Medicamento("Amoxicilina", "Amoxicilina",   18.90));
        farmacia.inserirNoFim(new Medicamento("Ibuprofeno",  "Ibuprofeno",     9.80));
        farmacia.inserirNoFim(new Medicamento("Omeprazol",   "Omeprazol",     12.40));
        farmacia.inserirNoFim(new Medicamento("Paracetamol", "Paracetamol",    4.70));
        farmacia.listar();

        // ── Teste 2: inserção no início ──────────────────────────────
        System.out.println("\n=== Teste 2: Inserção no Início (addFirst) ===");
        farmacia.inserirNoInicio(new Medicamento("Azitromicina", "Azitromicina", 32.00));
        farmacia.listar();

        // ── Teste 3: inserção em posição específica ──────────────────
        System.out.println("\n=== Teste 3: Inserção em Posição Específica ===");
        farmacia.inserirNaPosicao(3, new Medicamento("Losartana", "Losartana Potássica", 22.00));
        farmacia.listar();

        // ── Teste 4: inserções inválidas (exceção) ───────────────────
        System.out.println("\n=== Teste 4: Inserções Inválidas (exceção) ===");
        farmacia.inserirNoFim(null);
        farmacia.inserirNoInicio(null);
        farmacia.inserirNaPosicao(99, new Medicamento("Ghost", "N/A", 0));
        farmacia.inserirNaPosicao(-1, new Medicamento("Ghost", "N/A", 0));

        // ── Teste 5: busca primeiro e último ─────────────────────────
        System.out.println("\n=== Teste 5: Primeiro e Último ===");
        farmacia.buscarPrimeiro();
        farmacia.buscarUltimo();

        // ── Teste 6: busca por nome ───────────────────────────────────
        System.out.println("\n=== Teste 6: Busca por Nome ===");
        farmacia.buscarPorNome("Omeprazol");
        farmacia.buscarPorNome("dipirona");   // case-insensitive

        // ── Teste 7: busca nome inexistente (exceção) ────────────────
        System.out.println("\n=== Teste 7: Busca Inexistente (exceção) ===");
        farmacia.buscarPorNome("Ritalina");
        farmacia.buscarPorNome("");

        // ── Teste 8: busca por índice ─────────────────────────────────
        System.out.println("\n=== Teste 8: Busca por Índice ===");
        farmacia.buscarPorIndice(0);
        farmacia.buscarPorIndice(6);

        // ── Teste 9: busca índice inválido (exceção) ─────────────────
        System.out.println("\n=== Teste 9: Índice Inválido (exceção) ===");
        farmacia.buscarPorIndice(-1);
        farmacia.buscarPorIndice(100);

        // ── Teste 10: remoções ────────────────────────────────────────
        System.out.println("\n=== Teste 10: Remoções ===");
        farmacia.removerPrimeiro();
        farmacia.removerUltimo();
        farmacia.removerPorNome("Ibuprofeno");
        farmacia.removerPorIndice(0);
        farmacia.listar();

        // ── Teste 11: remoções inválidas (exceção) ────────────────────
        System.out.println("\n=== Teste 11: Remoções Inválidas (exceção) ===");
        farmacia.removerPorNome("Ibuprofeno");  // já removido
        farmacia.removerPorIndice(50);
        farmacia.removerPorNome("");

        // ── Teste 12: esvaziando com loop ─────────────────────────────
        System.out.println("\n=== Teste 12: Esvaziando com Loop ===");
        while (!farmacia.isEmpty()) {
            farmacia.removerPrimeiro();
        }
        farmacia.listar();

        // ── Teste 13: operações em lista vazia (exceção) ──────────────
        System.out.println("\n=== Teste 13: Operações em Lista Vazia (exceção) ===");
        farmacia.buscarPrimeiro();
        farmacia.buscarUltimo();
        farmacia.removerPrimeiro();
        farmacia.removerUltimo();
    }
}
