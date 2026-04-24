import java.util.ArrayList;


//  Interface
interface Animal {
    void emitirSom();
    void mover();
    String getNome();
}

//  Classes que implementam a interface

class Cachorro implements Animal {
    private String nome;

    public Cachorro(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public void emitirSom() {
        System.out.println(nome + " faz: Au au!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " corre com as quatro patas.");
    }
}

class Passaro implements Animal {
    private String nome;

    public Passaro(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public void emitirSom() {
        System.out.println(nome + " faz: Piu piu!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " voa com as asas.");
    }
}

class Sapo implements Animal {
    private String nome;

    public Sapo(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public void emitirSom() {
        System.out.println(nome + " faz: Croac croac!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " pula de folha em folha.");
    }
}

class Cobra implements Animal {
    private String nome;

    public Cobra(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public void emitirSom() {
        System.out.println(nome + " faz: Sssss!");
    }

    @Override
    public void mover() {
        System.out.println(nome + " rasteja pelo chao.");
    }
}

class Golfinho implements Animal {
    private String nome;

    public Golfinho(String nome) {
        this.nome = nome;
    }

    @Override
    public String getNome() { return nome; }

    @Override
    public void emitirSom() {
        System.out.println(nome + " faz: Eeeee! (cliques e assobios)");
    }

    @Override
    public void mover() {
        System.out.println(nome + " nada com a nadadeira.");
    }
}

//  Main
public class Exercicio2 {

    public static void main(String[] args) {

        // Coleção polimórfica: o tipo declarado é a interface
        ArrayList<Animal> animais = new ArrayList<>();

        animais.add(new Cachorro("Rex"));
        animais.add(new Passaro("Tweety"));
        animais.add(new Sapo("Kermit"));
        animais.add(new Cobra("Naja"));
        animais.add(new Golfinho("Flipper"));

        System.out.println("=== Ações dos animais (polimorfismo via interface) ===\n");

        for (Animal a : animais) {
            System.out.println("--- " + a.getNome() + " ---");
            a.emitirSom();
            a.mover();
            System.out.println();
        }
    }
}
