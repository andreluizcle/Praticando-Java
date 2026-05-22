import java.util.HashMap;
import java.util.NoSuchElementException;

class Veiculo {
    private String modelo;
    private String marca;
    private int ano;

    public Veiculo(String modelo, String marca, int ano) {
        this.modelo = modelo;
        this.marca  = marca;
        this.ano    = ano;
    }

    public String getModelo() { return modelo; }
    public String getMarca()  { return marca; }
    public int getAno()       { return ano; }

    @Override
    public String toString() {
        return String.format("Veiculo{modelo='%s', marca='%s', ano=%d}", modelo, marca, ano);
    }
}

class Estacionamento {

    // Chave: placa | Valor: Veiculo
    private HashMap<String, Veiculo> vagas;

    public Estacionamento() {
        this.vagas = new HashMap<>();
    }

    // ── Inserção ─────────────────────────────────────────────────────

    public void inserir(String placa, Veiculo v) {
        try {
            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa inválida.");
            if (v == null)
                throw new IllegalArgumentException("Veículo não pode ser nulo.");
            if (vagas.containsKey(placa.toUpperCase()))
                throw new IllegalStateException("Placa '" + placa.toUpperCase() + "' já cadastrada.");

            vagas.put(placa.toUpperCase(), v);
            System.out.println("  PUT  ✔ [" + placa.toUpperCase() + "] → " + v);

        } catch (IllegalArgumentException ex) {
            System.out.println("  PUT  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (IllegalStateException ex) {
            System.out.println("  PUT  ✘ IllegalStateException: " + ex.getMessage());
        }
    }

    // ── Remoção ──────────────────────────────────────────────────────

    public void removerPorPlaca(String placa) {
        try {
            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa inválida.");

            Veiculo removido = vagas.remove(placa.toUpperCase());
            if (removido == null)
                throw new NoSuchElementException("Placa '" + placa.toUpperCase() + "' não encontrada.");

            System.out.println("  REM  ✔ [" + placa.toUpperCase() + "] → " + removido);

        } catch (IllegalArgumentException ex) {
            System.out.println("  REM  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  REM  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    // ── Buscas ───────────────────────────────────────────────────────

    public void buscarPorPlaca(String placa) {
        try {
            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa de busca inválida.");

            Veiculo encontrado = vagas.get(placa.toUpperCase());
            if (encontrado == null)
                throw new NoSuchElementException("Placa '" + placa.toUpperCase() + "' não encontrada.");

            System.out.println("  GET  ✔ [" + placa.toUpperCase() + "] → " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  GET  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  GET  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    public void verificarContem(String placa) {
        try {
            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa inválida.");
            boolean contem = vagas.containsKey(placa.toUpperCase());
            System.out.println("  CONTAINS ✔ [" + placa.toUpperCase() + "]: " + contem);
        } catch (IllegalArgumentException ex) {
            System.out.println("  CONTAINS ✘ IllegalArgumentException: " + ex.getMessage());
        }
    }

    public void buscarPorModelo(String modelo) {
        try {
            if (modelo == null || modelo.isBlank())
                throw new IllegalArgumentException("Modelo de busca inválido.");

            Veiculo encontrado = null;
            String placaEncontrada = null;

            for (HashMap.Entry<String, Veiculo> entry : vagas.entrySet()) {
                if (entry.getValue().getModelo().equalsIgnoreCase(modelo)) {
                    encontrado     = entry.getValue();
                    placaEncontrada = entry.getKey();
                    break;
                }
            }
            if (encontrado == null)
                throw new NoSuchElementException("Nenhum veículo com modelo '" + modelo + "'.");

            System.out.println("  FIND_MOD ✔ [" + placaEncontrada + "] → " + encontrado);

        } catch (IllegalArgumentException ex) {
            System.out.println("  FIND_MOD ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  FIND_MOD ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    // ── Atualização ──────────────────────────────────────────────────

    public void atualizar(String placa, Veiculo novoVeiculo) {
        try {
            if (placa == null || placa.isBlank())
                throw new IllegalArgumentException("Placa inválida.");
            if (novoVeiculo == null)
                throw new IllegalArgumentException("Novo veículo não pode ser nulo.");
            if (!vagas.containsKey(placa.toUpperCase()))
                throw new NoSuchElementException("Placa '" + placa.toUpperCase() + "' não encontrada.");

            vagas.replace(placa.toUpperCase(), novoVeiculo);
            System.out.println("  UPD  ✔ [" + placa.toUpperCase() + "] → " + novoVeiculo);

        } catch (IllegalArgumentException ex) {
            System.out.println("  UPD  ✘ IllegalArgumentException: " + ex.getMessage());
        } catch (NoSuchElementException ex) {
            System.out.println("  UPD  ✘ NoSuchElementException: " + ex.getMessage());
        }
    }

    // ── Listagem ─────────────────────────────────────────────────────

    public void listar() {
        if (vagas.isEmpty()) {
            System.out.println("  LISTA: (vazia)");
            return;
        }
        System.out.println("  LISTA (" + vagas.size() + " veículos) — ordem não garantida:");
        for (HashMap.Entry<String, Veiculo> entry : vagas.entrySet()) {
            System.out.println("    [" + entry.getKey() + "] → " + entry.getValue());
        }
    }

    public boolean isEmpty() { return vagas.isEmpty(); }
    public int size()        { return vagas.size(); }
}

public class Exercicio10 {
    public static void main(String[] args) {

        Estacionamento estacionamento = new Estacionamento();

        // ── Teste 1: inserções válidas ───────────────────────────────
        System.out.println("=== Teste 1: Inserções Válidas (put) ===");
        estacionamento.inserir("ABC1234", new Veiculo("Civic",   "Honda",      2021));
        estacionamento.inserir("DEF5678", new Veiculo("Corolla", "Toyota",     2020));
        estacionamento.inserir("GHI9012", new Veiculo("Onix",    "Chevrolet",  2022));
        estacionamento.inserir("JKL3456", new Veiculo("HB20",    "Hyundai",    2019));
        estacionamento.inserir("MNO7890", new Veiculo("Gol",     "Volkswagen", 2018));
        estacionamento.listar();

        // ── Teste 2: inserção duplicada (exceção) ────────────────────
        System.out.println("\n=== Teste 2: Inserção Duplicada (exceção) ===");
        estacionamento.inserir("ABC1234", new Veiculo("Fit", "Honda", 2023)); // placa já existe
        estacionamento.inserir("abc1234", new Veiculo("Fit", "Honda", 2023)); // case-insensitive

        // ── Teste 3: inserção inválida (exceção) ─────────────────────
        System.out.println("\n=== Teste 3: Inserção Inválida (exceção) ===");
        estacionamento.inserir("",    new Veiculo("X", "X", 2020));  // placa em branco
        estacionamento.inserir(null,  new Veiculo("X", "X", 2020));  // placa nula
        estacionamento.inserir("XYZ", null);                          // veículo nulo

        // ── Teste 4: busca por placa ──────────────────────────────────
        System.out.println("\n=== Teste 4: Busca por Placa (get) ===");
        estacionamento.buscarPorPlaca("DEF5678");
        estacionamento.buscarPorPlaca("ghi9012");   // case-insensitive

        // ── Teste 5: busca placa inexistente (exceção) ───────────────
        System.out.println("\n=== Teste 5: Busca Placa Inexistente (exceção) ===");
        estacionamento.buscarPorPlaca("ZZZ9999");
        estacionamento.buscarPorPlaca("");

        // ── Teste 6: verificar containsKey ────────────────────────────
        System.out.println("\n=== Teste 6: Verificar containsKey ===");
        estacionamento.verificarContem("JKL3456");   // existe
        estacionamento.verificarContem("ZZZ0000");   // não existe
        estacionamento.verificarContem("");           // inválida

        // ── Teste 7: busca por modelo (varredura entrySet) ────────────
        System.out.println("\n=== Teste 7: Busca por Modelo ===");
        estacionamento.buscarPorModelo("Onix");
        estacionamento.buscarPorModelo("gol");       // case-insensitive

        // ── Teste 8: busca modelo inexistente (exceção) ───────────────
        System.out.println("\n=== Teste 8: Busca Modelo Inexistente (exceção) ===");
        estacionamento.buscarPorModelo("Ferrari");
        estacionamento.buscarPorModelo("");

        // ── Teste 9: atualização ──────────────────────────────────────
        System.out.println("\n=== Teste 9: Atualização (replace) ===");
        estacionamento.atualizar("ABC1234", new Veiculo("Civic EX", "Honda", 2024));
        estacionamento.buscarPorPlaca("ABC1234");

        // ── Teste 10: atualização inválida (exceção) ──────────────────
        System.out.println("\n=== Teste 10: Atualização Inválida (exceção) ===");
        estacionamento.atualizar("ZZZ9999", new Veiculo("X", "X", 2020)); // placa inexistente
        estacionamento.atualizar("ABC1234", null);                         // veículo nulo

        // ── Teste 11: remoções válidas ────────────────────────────────
        System.out.println("\n=== Teste 11: Remoções Válidas (remove) ===");
        estacionamento.removerPorPlaca("ABC1234");
        estacionamento.removerPorPlaca("MNO7890");
        estacionamento.listar();

        // ── Teste 12: remoções inválidas (exceção) ────────────────────
        System.out.println("\n=== Teste 12: Remoções Inválidas (exceção) ===");
        estacionamento.removerPorPlaca("ABC1234");  // já removida
        estacionamento.removerPorPlaca("");
        estacionamento.removerPorPlaca(null);

        // ── Teste 13: esvaziando com loop ─────────────────────────────
        System.out.println("\n=== Teste 13: Esvaziando com Loop ===");
        for (String placa : new String[]{"DEF5678", "GHI9012", "JKL3456"}) {
            estacionamento.removerPorPlaca(placa);
        }
        estacionamento.listar();
        System.out.println("  Tamanho final: " + estacionamento.size()
                + " | Vazio: " + estacionamento.isEmpty());

        // ── Teste 14: operações em mapa vazio (exceção) ───────────────
        System.out.println("\n=== Teste 14: Operações em Mapa Vazio (exceção) ===");
        estacionamento.buscarPorPlaca("DEF5678");
        estacionamento.removerPorPlaca("DEF5678");
        estacionamento.buscarPorModelo("Civic");
    }
}

