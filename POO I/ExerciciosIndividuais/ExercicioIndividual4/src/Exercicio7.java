import java.util.Vector;
import java.util.NoSuchElementException;

class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome    = nome;
        this.cargo   = cargo;
        this.salario = salario;
    }

    public String getNome()    { return nome; }
    public String getCargo()   { return cargo; }
    public double getSalario() { return salario; }

    @Override
    public String toString() {
        return String.format("Funcionario{nome='%s', cargo='%s', salario=R$%.2f}",
                nome, cargo, salario);
    }
}

class Empresa {
    private Vector<Funcionario> funcionarios;

    public Empresa() {
        this.funcionarios = new Vector<>();
    }

    // ── Inserções ────────────────────────────────────────────────────

    public void inserirNoFim(Funcionario f) {
        try {
            if (f == null) throw new IllegalArgumentException("Funcionário não pode ser nulo.");
            funcionarios.addElement(f);          // método legado do Vector
            System.out.println("  ADD_END   ✔ " + f);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD_END   ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void inserirNaPosicao(int indice, Funcionario f) {
        try {
            if (f == null) throw new IllegalArgumentException("Funcionário não pode ser nulo.");
            funcionarios.insertElementAt(f, indice);   // método legado do Vector
            System.out.println("  ADD[" + indice + "]     ✔ " + f);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ ArrayIndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + funcionarios.size() + ")");
        }
    }

    // ── Remoções ─────────────────────────────────────────────────────

    public void removerPrimeiro() {
        try {
            if (funcionarios.isEmpty())
                throw new NoSuchElementException("Vector está vazio.");
            Funcionario removido = funcionarios.firstElement();
            funcionarios.removeElementAt(0);           // método legado do Vector
            System.out.println("  REM_FIRST ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_FIRST ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void removerUltimo() {
        try {
            if (funcionarios.isEmpty())
                throw new NoSuchElementException("Vector está vazio.");
            Funcionario removido = funcionarios.lastElement();
            funcionarios.removeElementAt(funcionarios.size() - 1);
            System.out.println("  REM_LAST  ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_LAST  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void removerPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome inválido.");

            Funcionario encontrado = null;
            for (Funcionario f : funcionarios) {
                if (f.getNome().equalsIgnoreCase(nome)) {
                    encontrado = f;
                    break;
                }
            }
            if (encontrado == null)
                throw new NoSuchElementException("Funcionário '" + nome + "' não encontrado.");

            funcionarios.removeElement(encontrado);    // método legado do Vector
            System.out.println("  REM_NOME  ✔ Removido: " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM_NOME  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_NOME  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void removerPorIndice(int indice) {
        try {
            funcionarios.removeElementAt(indice);      // método legado do Vector
            System.out.println("  REM[" + indice + "]     ✔ Índice " + indice + " removido.");
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("  REM[" + indice + "]     ✘ ArrayIndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + funcionarios.size() + ")");
        }
    }

    // ── Buscas ───────────────────────────────────────────────────────

    public void buscarPrimeiro() {
        try {
            System.out.println("  FIRST     ✔ " + funcionarios.firstElement());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIRST     ✘ NoSuchElementException: Vector está vazio!");
        }
    }

    public void buscarUltimo() {
        try {
            System.out.println("  LAST      ✔ " + funcionarios.lastElement());
        } catch (NoSuchElementException ex) {
            System.out.println("  LAST      ✘ NoSuchElementException: Vector está vazio!");
        }
    }

    public void buscarPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome de busca inválido.");

            Funcionario encontrado = null;
            for (Funcionario f : funcionarios) {
                if (f.getNome().equalsIgnoreCase(nome)) {
                    encontrado = f;
                    break;
                }
            }
            if (encontrado == null)
                throw new NoSuchElementException("Funcionário '" + nome + "' não encontrado.");

            System.out.println("  FIND_NOME ✔ " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND_NOME ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIND_NOME ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void buscarPorIndice(int indice) {
        try {
            Funcionario f = funcionarios.elementAt(indice);  // método legado do Vector
            System.out.println("  GET[" + indice + "]      ✔ " + f);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("  GET[" + indice + "]      ✘ ArrayIndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + funcionarios.size() + ")");
        }
    }

    // ── Capacidade (exclusivo do Vector) ─────────────────────────────

    public void infoCapacidade() {
        System.out.println("  CAPACIDADE: tamanho=" + funcionarios.size()
                + " | capacidade=" + funcionarios.capacity());
    }

    // ── Listagem ─────────────────────────────────────────────────────

    public void listar() {
        if (funcionarios.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + funcionarios.size() + " funcionários):");
        for (int i = 0; i < funcionarios.size(); i++) {
            System.out.printf("    [%d] %s%n", i, funcionarios.elementAt(i));
        }
    }

    public int getTotalFuncionarios() { return funcionarios.size(); }
}

public class Exercicio7 {
    public static void main(String[] args) {

        Empresa empresa = new Empresa();

        // ── Teste 1: inserções no fim ────────────────────────────────
        System.out.println("=== Teste 1: Inserção no Fim (addElement) ===");
        empresa.inserirNoFim(new Funcionario("Alice",   "Desenvolvedora", 8500.00));
        empresa.inserirNoFim(new Funcionario("Bruno",   "Designer",       6200.00));
        empresa.inserirNoFim(new Funcionario("Carla",   "Analista",       7100.00));
        empresa.inserirNoFim(new Funcionario("Daniel",  "Gerente",        9800.00));
        empresa.inserirNoFim(new Funcionario("Elisa",   "DBA",            7600.00));
        empresa.listar();

        // ── Teste 2: capacidade do Vector ────────────────────────────
        System.out.println("\n=== Teste 2: Capacidade do Vector ===");
        empresa.infoCapacidade();  // Vector cresce em blocos (padrão: capacidade inicial 10)

        // ── Teste 3: inserção em posição específica ──────────────────
        System.out.println("\n=== Teste 3: Inserção em Posição (insertElementAt) ===");
        empresa.inserirNaPosicao(2, new Funcionario("Fábio", "DevOps", 8900.00));
        empresa.listar();

        // ── Teste 4: inserções inválidas (exceção) ───────────────────
        System.out.println("\n=== Teste 4: Inserções Inválidas (exceção) ===");
        empresa.inserirNoFim(null);
        empresa.inserirNaPosicao(99, new Funcionario("Ghost", "N/A", 0));
        empresa.inserirNaPosicao(-1, new Funcionario("Ghost", "N/A", 0));

        // ── Teste 5: busca primeiro e último ─────────────────────────
        System.out.println("\n=== Teste 5: Primeiro e Último (firstElement / lastElement) ===");
        empresa.buscarPrimeiro();
        empresa.buscarUltimo();

        // ── Teste 6: busca por nome ───────────────────────────────────
        System.out.println("\n=== Teste 6: Busca por Nome ===");
        empresa.buscarPorNome("Carla");
        empresa.buscarPorNome("daniel");   // case-insensitive

        // ── Teste 7: busca nome inexistente (exceção) ────────────────
        System.out.println("\n=== Teste 7: Busca Nome Inexistente (exceção) ===");
        empresa.buscarPorNome("Zé Ninguém");
        empresa.buscarPorNome("");

        // ── Teste 8: busca por índice ─────────────────────────────────
        System.out.println("\n=== Teste 8: Busca por Índice (elementAt) ===");
        empresa.buscarPorIndice(0);
        empresa.buscarPorIndice(5);

        // ── Teste 9: busca índice inválido (exceção) ─────────────────
        System.out.println("\n=== Teste 9: Busca Índice Inválido (exceção) ===");
        empresa.buscarPorIndice(-1);
        empresa.buscarPorIndice(100);

        // ── Teste 10: remoções ────────────────────────────────────────
        System.out.println("\n=== Teste 10: Remoções ===");
        empresa.removerPrimeiro();
        empresa.removerUltimo();
        empresa.removerPorNome("Carla");
        empresa.removerPorIndice(0);
        empresa.listar();

        // ── Teste 11: remoções inválidas (exceção) ────────────────────
        System.out.println("\n=== Teste 11: Remoções Inválidas (exceção) ===");
        empresa.removerPorNome("Fantasma");
        empresa.removerPorIndice(50);
        empresa.removerPorNome("");

        // ── Teste 12: esvaziando com loop ─────────────────────────────
        System.out.println("\n=== Teste 12: Esvaziando com Loop ===");
        while (empresa.getTotalFuncionarios() > 0) {
            empresa.removerPrimeiro();
        }
        empresa.listar();
        empresa.infoCapacidade();

        // ── Teste 13: operações em Vector vazio (exceção) ─────────────
        System.out.println("\n=== Teste 13: Operações em Vector Vazio (exceção) ===");
        empresa.buscarPrimeiro();
        empresa.buscarUltimo();
        empresa.removerPrimeiro();
        empresa.removerUltimo();
    }
}
