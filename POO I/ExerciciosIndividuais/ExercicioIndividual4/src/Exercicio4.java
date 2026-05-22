import java.util.Stack;
import java.util.EmptyStackException;

class Elemento {
    private int valor;

    // Construtor default
    public Elemento() {
        this.valor = 0;
    }

    // Construtor com parâmetro
    public Elemento(int valor) {
        this.valor = valor;
    }

    public int getValor() { return valor; }

    @Override
    public String toString() {
        return "Elemento{valor=" + valor + "}";
    }
}

public class Exercicio4 {

    static Stack<Elemento> pilha = new Stack<>();

    // Empilha com tratamento de erro
    static void empilhar(Elemento e) {
        try {
            pilha.push(e);
            System.out.println("  PUSH ✔ " + e + " | Topo: " + pilha.peek());
        } catch (Exception ex) {
            System.out.println("  PUSH ✘ Erro inesperado: " + ex.getMessage());
        }
    }

    // Desempilha com tratamento de EmptyStackException
    static void desempilhar() {
        try {
            Elemento removido = pilha.pop();
            System.out.println("  POP  ✔ Removido: " + removido
                    + (pilha.isEmpty() ? " | Pilha vazia" : " | Novo topo: " + pilha.peek()));
        } catch (EmptyStackException ex) {
            System.out.println("  POP  ✘ EmptyStackException: pilha está vazia!");
        }
    }

    // Espiar o topo com tratamento de erro
    static void espiarTopo() {
        try {
            System.out.println("  PEEK ✔ Topo atual: " + pilha.peek());
        } catch (EmptyStackException ex) {
            System.out.println("  PEEK ✘ EmptyStackException: pilha está vazia!");
        }
    }

    // Exibe estado atual da pilha
    static void exibirPilha() {
        System.out.println("  PILHA (base → topo): " + pilha);
        System.out.println("  Tamanho: " + pilha.size() + " | Vazia: " + pilha.isEmpty());
    }

    public static void main(String[] args) {

        // ── Teste 1: construtor default ──────────────────────────────
        System.out.println("=== Teste 1: Construtor Default ===");
        Elemento padrao = new Elemento();
        System.out.println("  Elemento default: " + padrao);

        // ── Teste 2: empilhando elementos ────────────────────────────
        System.out.println("\n=== Teste 2: Empilhando Elementos ===");
        empilhar(new Elemento(10));
        empilhar(new Elemento(20));
        empilhar(new Elemento(30));
        empilhar(new Elemento(40));
        empilhar(new Elemento(50));
        exibirPilha();

        // ── Teste 3: espiando o topo ─────────────────────────────────
        System.out.println("\n=== Teste 3: Espiando o Topo (peek) ===");
        espiarTopo();

        // ── Teste 4: desempilhando todos ─────────────────────────────
        System.out.println("\n=== Teste 4: Desempilhando Todos ===");
        desempilhar();
        desempilhar();
        desempilhar();
        desempilhar();
        desempilhar();
        exibirPilha();

        // ── Teste 5: erro — pop em pilha vazia ───────────────────────
        System.out.println("\n=== Teste 5: POP em Pilha Vazia (exceção) ===");
        desempilhar(); // deve lançar EmptyStackException

        // ── Teste 6: erro — peek em pilha vazia ──────────────────────
        System.out.println("\n=== Teste 6: PEEK em Pilha Vazia (exceção) ===");
        espiarTopo(); // deve lançar EmptyStackException

        // ── Teste 7: misturando push/pop intercalados ─────────────────
        System.out.println("\n=== Teste 7: Operações Intercaladas ===");
        empilhar(new Elemento(100));
        empilhar(new Elemento(200));
        desempilhar();
        empilhar(new Elemento(300));
        empilhar(new Elemento(400));
        desempilhar();
        desempilhar();
        exibirPilha();

        // ── Teste 8: esvaziando com loop automático ───────────────────
        System.out.println("\n=== Teste 8: Esvaziando com Loop ===");
        empilhar(new Elemento(1));
        empilhar(new Elemento(2));
        empilhar(new Elemento(3));
        System.out.println("  Antes: " + pilha);
        while (!pilha.isEmpty()) {
            desempilhar();
        }
        System.out.println("  Pilha esvaziada com sucesso!");

        // ── Teste 9: elemento default na pilha ───────────────────────
        System.out.println("\n=== Teste 9: Empilhando Elemento Default ===");
        empilhar(new Elemento()); // valor = 0
        espiarTopo();
        desempilhar();
    }
}
