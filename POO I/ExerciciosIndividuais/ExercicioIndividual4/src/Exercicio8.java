import java.util.HashSet;
import java.util.NoSuchElementException;

class Cidade {
    private String nome;
    private String estado;
    private int populacao;

    public Cidade(String nome, String estado, int populacao) {
        this.nome       = nome;
        this.estado     = estado;
        this.populacao  = populacao;
    }

    public String getNome()    { return nome; }
    public String getEstado()  { return estado; }
    public int getPopulacao()  { return populacao; }

    // equals e hashCode baseados em nome + estado (identidade única da cidade)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cidade)) return false;
        Cidade outra = (Cidade) obj;
        return this.nome.equalsIgnoreCase(outra.nome)
                && this.estado.equalsIgnoreCase(outra.estado);
    }

    @Override
    public int hashCode() {
        return 31 * nome.toLowerCase().hashCode()
                + estado.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return String.format("Cidade{nome='%s', estado='%s', pop=%,d}", nome, estado, populacao);
    }
}

class Mapa {
    private HashSet<Cidade> cidades;

    public Mapa() {
        this.cidades = new HashSet<>();
    }

    // ── Inserção ─────────────────────────────────────────────────────

    public void inserir(Cidade c) {
        try {
            if (c == null) throw new IllegalArgumentException("Cidade não pode ser nula.");
            boolean inserida = cidades.add(c);
            if (!inserida)
                throw new IllegalStateException(
                        "Cidade duplicada: '" + c.getNome() + " - " + c.getEstado() + "' já existe.");
            System.out.println("  ADD  ✔ " + c);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            System.out.println("  ADD  ✘ IllegalStateException: " + ex.getMessage());
        }
    }

    // ── Remoção ──────────────────────────────────────────────────────

    public void removerPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome inválido para remoção.");

            Cidade encontrada = buscarInternamente(nome);
            if (encontrada == null)
                throw new NoSuchElementException("Cidade '" + nome + "' não encontrada.");

            cidades.remove(encontrada);
            System.out.println("  REM  ✔ Removida: " + encontrada);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  REM  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    // ── Buscas ───────────────────────────────────────────────────────

    public void buscarPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome de busca inválido.");

            Cidade encontrada = buscarInternamente(nome);
            if (encontrada == null)
                throw new NoSuchElementException("Cidade '" + nome + "' não encontrada.");

            System.out.println("  FIND ✔ " + encontrada);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIND ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void verificarContem(Cidade c) {
        try {
            if (c == null) throw new IllegalArgumentException("Cidade não pode ser nula.");
            boolean contem = cidades.contains(c);
            System.out.println("  CONTAINS ✔ " + c.getNome() + ": " + contem);
        } catch (IllegalArgumentException ex) {
            System.out.println("  CONTAINS ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    // ── Helper interno ────────────────────────────────────────────────

    private Cidade buscarInternamente(String nome) {
        for (Cidade c : cidades) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    // ── Listagem ─────────────────────────────────────────────────────

    public void listar() {
        if (cidades.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + cidades.size() + " cidades) — ordem não garantida:");
        for (Cidade c : cidades) {
            System.out.println("    • " + c);
        }
    }

    // acessor para uso no main
    public boolean isEmpty() { return cidades.isEmpty(); }
    public int size()        { return cidades.size(); }
}

public class Exercicio8 {
    public static void main(String[] args) {

        Mapa mapa = new Mapa();

        // ── Teste 1: inserções válidas ───────────────────────────────
        System.out.println("=== Teste 1: Inserções Válidas ===");
        mapa.inserir(new Cidade("São Paulo",       "SP", 12_325_232));
        mapa.inserir(new Cidade("Rio de Janeiro",  "RJ", 6_747_815));
        mapa.inserir(new Cidade("Belo Horizonte",  "MG", 2_521_564));
        mapa.inserir(new Cidade("Curitiba",        "PR", 1_948_626));
        mapa.inserir(new Cidade("Fortaleza",       "CE", 2_703_391));
        mapa.listar();

        // ── Teste 2: inserção nula (exceção) ─────────────────────────
        System.out.println("\n=== Teste 2: Inserção Nula (exceção) ===");
        mapa.inserir(null);

        // ── Teste 3: inserção duplicada (exceção) ────────────────────
        System.out.println("\n=== Teste 3: Inserção Duplicada (exceção) ===");
        mapa.inserir(new Cidade("São Paulo", "SP", 99_999));  // mesmo nome+estado → duplicata
        mapa.inserir(new Cidade("curitiba",  "pr", 00_000));  // case-insensitive → duplicata

        // ── Teste 4: cidade com mesmo nome, estado diferente ─────────
        System.out.println("\n=== Teste 4: Mesmo Nome, Estado Diferente (permitido) ===");
        mapa.inserir(new Cidade("São Paulo", "MG", 41_000));  // cidade diferente!
        mapa.listar();

        // ── Teste 5: busca por nome ───────────────────────────────────
        System.out.println("\n=== Teste 5: Busca por Nome ===");
        mapa.buscarPorNome("Fortaleza");
        mapa.buscarPorNome("belo horizonte");  // case-insensitive

        // ── Teste 6: busca inexistente (exceção) ─────────────────────
        System.out.println("\n=== Teste 6: Busca Inexistente (exceção) ===");
        mapa.buscarPorNome("Manaus");
        mapa.buscarPorNome("");

        // ── Teste 7: verificar contains ───────────────────────────────
        System.out.println("\n=== Teste 7: Verificar contains() ===");
        mapa.verificarContem(new Cidade("Curitiba",      "PR", 0)); // deve achar (equals ignora pop)
        mapa.verificarContem(new Cidade("Porto Alegre",  "RS", 0)); // não existe
        mapa.verificarContem(null);

        // ── Teste 8: remoções válidas ────────────────────────────────
        System.out.println("\n=== Teste 8: Remoções Válidas ===");
        mapa.removerPorNome("Curitiba");
        mapa.removerPorNome("Rio de Janeiro");
        mapa.listar();

        // ── Teste 9: remoções inválidas (exceção) ────────────────────
        System.out.println("\n=== Teste 9: Remoções Inválidas (exceção) ===");
        mapa.removerPorNome("Curitiba");  // já removida
        mapa.removerPorNome("");
        mapa.removerPorNome(null);

        // ── Teste 10: esvaziando com loop ─────────────────────────────
        System.out.println("\n=== Teste 10: Esvaziando com Loop ===");
        for (String nome : new String[]{"São Paulo", "Belo Horizonte",
                "Fortaleza", "São Paulo"}) {
            mapa.removerPorNome(nome);
        }
        mapa.listar();

        // ── Teste 11: operações em HashSet vazio (exceção) ───────────
        System.out.println("\n=== Teste 11: Operações em HashSet Vazio (exceção) ===");
        mapa.buscarPorNome("Qualquer");
        mapa.removerPorNome("Qualquer");
        System.out.println("  Tamanho final: " + mapa.size() + " | Vazio: " + mapa.isEmpty());
    }
}

