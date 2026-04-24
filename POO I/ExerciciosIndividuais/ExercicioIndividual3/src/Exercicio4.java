import java.util.ArrayList;

// Interface
interface Comando {
    void executar();
}

// Comando: ligar a luz
class ComandoLigarLuz implements Comando {
    @Override
    public void executar() {
        System.out.println("Luz ligada.");
    }
}

// Comando: desligar a luz
class ComandoDesligarLuz implements Comando {
    @Override
    public void executar() {
        System.out.println("Luz desligada.");
    }
}

// Comando: ligar o ventilador
class ComandoLigarVentilador implements Comando {
    @Override
    public void executar() {
        System.out.println("Ventilador ligado.");
    }
}

// Comando: desligar o ventilador
class ComandoDesligarVentilador implements Comando {
    @Override
    public void executar() {
        System.out.println("Ventilador desligado.");
    }
}

// Comando: ligar o ar-condicionado
class ComandoLigarArCondicionado implements Comando {
    @Override
    public void executar() {
        System.out.println("Ar-condicionado ligado.");
    }
}

// Comando: desligar o ar-condicionado
class ComandoDesligarArCondicionado implements Comando {
    @Override
    public void executar() {
        System.out.println("Ar-condicionado desligado.");
    }
}

// Classe controladora — não conhece o tipo exato de cada comando
class Controlador {
    private ArrayList<Comando> fila = new ArrayList<>();

    public void adicionarComando(Comando comando) {
        fila.add(comando);
    }

    public void executarTodos() {
        System.out.println("Executando comandos...\n");
        for (Comando c : fila) {
            c.executar();
        }
        System.out.println("\nTodos os comandos executados.");
    }
}

// Main
public class Exercicio4 {

    public static void main(String[] args) {

        Controlador controlador = new Controlador();

        controlador.adicionarComando(new ComandoLigarLuz());
        controlador.adicionarComando(new ComandoLigarVentilador());
        controlador.adicionarComando(new ComandoLigarArCondicionado());
        controlador.adicionarComando(new ComandoDesligarVentilador());
        controlador.adicionarComando(new ComandoDesligarLuz());
        controlador.adicionarComando(new ComandoDesligarArCondicionado());

        // Polimorfismo: o controlador executa sem conhecer o tipo exato
        controlador.executarTodos();
    }
}
