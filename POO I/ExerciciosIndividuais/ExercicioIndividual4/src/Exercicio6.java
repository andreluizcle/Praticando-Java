import java.util.LinkedList;
import java.util.NoSuchElementException;

class Aluno {
    private String nome;
    private int matricula;
    private double nota;

    public Aluno(String nome, int matricula, double nota) {
        this.nome      = nome;
        this.matricula = matricula;
        this.nota      = nota;
    }

    public String getNome()    { return nome; }
    public int getMatricula()  { return matricula; }
    public double getNota()    { return nota; }

    @Override
    public String toString() {
        return String.format("Aluno{nome='%s', matricula=%d, nota=%.1f}", nome, matricula, nota);
    }
}

class Turma {
    private LinkedList<Aluno> alunos;

    public Turma() {
        this.alunos = new LinkedList<>();
    }

    // ── Inserções ────────────────────────────────────────────────────

    public void inserirNoFim(Aluno a) {
        try {
            if (a == null) throw new IllegalArgumentException("Aluno não pode ser nulo.");
            alunos.addLast(a);
            System.out.println("  ADD_LAST  ✔ " + a);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD_LAST  ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void inserirNoInicio(Aluno a) {
        try {
            if (a == null) throw new IllegalArgumentException("Aluno não pode ser nulo.");
            alunos.addFirst(a);
            System.out.println("  ADD_FIRST ✔ " + a);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD_FIRST ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void inserirNaPosicao(int indice, Aluno a) {
        try {
            if (a == null) throw new IllegalArgumentException("Aluno não pode ser nulo.");
            alunos.add(indice, a);
            System.out.println("  ADD[" + indice + "]     ✔ " + a);
        } catch (IllegalArgumentException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  ADD[" + indice + "]     ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + alunos.size() + ")");
        }
    }

    // ── Remoções ─────────────────────────────────────────────────────

    public void removerPrimeiro() {
        try {
            Aluno removido = alunos.removeFirst();
            System.out.println("  REM_FIRST ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_FIRST ✘ NoSuchElementException: lista vazia!");
        }
    }

    public void removerUltimo() {
        try {
            Aluno removido = alunos.removeLast();
            System.out.println("  REM_LAST  ✔ Removido: " + removido);
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_LAST  ✘ NoSuchElementException: lista vazia!");
        }
    }

    public void removerPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome inválido.");

            Aluno encontrado = null;
            for (Aluno a : alunos) {
                if (a.getNome().equalsIgnoreCase(nome)) {
                    encontrado = a;
                    break;
                }
            }
            if (encontrado == null)
                throw new NoSuchElementException("Aluno '" + nome + "' não encontrado.");

            alunos.remove(encontrado);
            System.out.println("  REM_NOME  ✔ Removido: " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM_NOME  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  REM_NOME  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void removerPorIndice(int indice) {
        try {
            Aluno removido = alunos.remove(indice);
            System.out.println("  REM[" + indice + "]     ✔ Removido: " + removido);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  REM[" + indice + "]     ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + alunos.size() + ")");
        }
    }

    // ── Buscas ───────────────────────────────────────────────────────

    public void buscarPrimeiro() {
        try {
            System.out.println("  PEEK_FIRST ✔ " + alunos.getFirst());
        } catch (NoSuchElementException ex) {
            System.out.println("  PEEK_FIRST ✘ NoSuchElementException: lista vazia!");
        }
    }

    public void buscarUltimo() {
        try {
            System.out.println("  PEEK_LAST  ✔ " + alunos.getLast());
        } catch (NoSuchElementException ex) {
            System.out.println("  PEEK_LAST  ✘ NoSuchElementException: lista vazia!");
        }
    }

    public void buscarPorNome(String nome) {
        try {
            if (nome == null || nome.isBlank())
                throw new IllegalArgumentException("Nome de busca inválido.");

            Aluno encontrado = null;
            for (Aluno a : alunos) {
                if (a.getNome().equalsIgnoreCase(nome)) {
                    encontrado = a;
                    break;
                }
            }
            if (encontrado == null)
                throw new NoSuchElementException("Aluno '" + nome + "' não encontrado.");

            System.out.println("  FIND_NOME  ✔ " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND_NOME  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIND_NOME  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void buscarPorIndice(int indice) {
        try {
            System.out.println("  GET[" + indice + "]      ✔ " + alunos.get(indice));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("  GET[" + indice + "]      ✘ IndexOutOfBoundsException: índice "
                    + indice + " inválido (tamanho=" + alunos.size() + ")");
        }
    }

    // ── Listagem ─────────────────────────────────────────────────────

    public void listar() {
        if (alunos.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + alunos.size() + " alunos):");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.printf("    [%d] %s%n", i, alunos.get(i));
        }
    }

    public int getTotalAlunos() { return alunos.size(); }
}

public class Exercicio6 {
    public static void main(String[] args) {

        Turma turma = new Turma();

        // ── Teste 1: inserções no fim ────────────────────────────────
        System.out.println("=== Teste 1: Inserção no Fim (addLast) ===");
        turma.inserirNoFim(new Aluno("Ana",     1001, 9.5));
        turma.inserirNoFim(new Aluno("Bruno",   1002, 7.0));
        turma.inserirNoFim(new Aluno("Carlos",  1003, 8.3));
        turma.inserirNoFim(new Aluno("Diana",   1004, 6.5));
        turma.listar();

        // ── Teste 2: inserção no início ──────────────────────────────
        System.out.println("\n=== Teste 2: Inserção no Início (addFirst) ===");
        turma.inserirNoInicio(new Aluno("Eduardo", 1000, 10.0));
        turma.listar();

        // ── Teste 3: inserção em posição específica ──────────────────
        System.out.println("\n=== Teste 3: Inserção em Posição Específica ===");
        turma.inserirNaPosicao(2, new Aluno("Fernanda", 1005, 8.8));
        turma.listar();

        // ── Teste 4: inserção nula (exceção) ─────────────────────────
        System.out.println("\n=== Teste 4: Inserção Nula (exceção) ===");
        turma.inserirNoFim(null);
        turma.inserirNoInicio(null);
        turma.inserirNaPosicao(0, null);

        // ── Teste 5: inserção em índice inválido (exceção) ───────────
        System.out.println("\n=== Teste 5: Inserção Índice Inválido (exceção) ===");
        turma.inserirNaPosicao(99, new Aluno("Ghost", 9999, 0.0));

        // ── Teste 6: busca por nome ───────────────────────────────────
        System.out.println("\n=== Teste 6: Busca por Nome ===");
        turma.buscarPorNome("Diana");
        turma.buscarPorNome("eduardo");   // case-insensitive

        // ── Teste 7: busca por nome inexistente (exceção) ────────────
        System.out.println("\n=== Teste 7: Busca Nome Inexistente (exceção) ===");
        turma.buscarPorNome("Zé Ninguém");
        turma.buscarPorNome("");

        // ── Teste 8: busca por índice ────────────────────────────────
        System.out.println("\n=== Teste 8: Busca por Índice ===");
        turma.buscarPorIndice(0);
        turma.buscarPorIndice(5);

        // ── Teste 9: busca índice inválido (exceção) ─────────────────
        System.out.println("\n=== Teste 9: Busca Índice Inválido (exceção) ===");
        turma.buscarPorIndice(-1);
        turma.buscarPorIndice(100);

        // ── Teste 10: peek primeiro e último ─────────────────────────
        System.out.println("\n=== Teste 10: Peek Primeiro e Último ===");
        turma.buscarPrimeiro();
        turma.buscarUltimo();

        // ── Teste 11: remoções ────────────────────────────────────────
        System.out.println("\n=== Teste 11: Remoções ===");
        turma.removerPrimeiro();
        turma.removerUltimo();
        turma.removerPorNome("Carlos");
        turma.removerPorIndice(0);
        turma.listar();

        // ── Teste 12: remoção inválida (exceção) ─────────────────────
        System.out.println("\n=== Teste 12: Remoções Inválidas (exceção) ===");
        turma.removerPorNome("Fantasma");
        turma.removerPorIndice(99);

        // ── Teste 13: esvaziando com loop ─────────────────────────────
        System.out.println("\n=== Teste 13: Esvaziando com Loop ===");
        while (turma.getTotalAlunos() > 0) {
            turma.removerPrimeiro();
        }
        turma.listar();

        // ── Teste 14: peek e remoção em lista vazia (exceção) ────────
        System.out.println("\n=== Teste 14: Operações em Lista Vazia (exceção) ===");
        turma.buscarPrimeiro();
        turma.buscarUltimo();
        turma.removerPrimeiro();
        turma.removerUltimo();
    }
}
