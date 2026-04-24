import java.util.ArrayList;

//  CLASSE BASE
abstract class SerVivo {
    private String nome;

    public SerVivo(String nome) {
        this.nome = nome;
    }

    protected String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public abstract void imprimirIdentidade();
}

//  NÍVEL 1 — filhos diretos de SerVivo
class Ameba extends SerVivo {
    public Ameba(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Ameba"); }
}

abstract class Ave extends SerVivo {
    public Ave(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Ave"); }
}

abstract class Mamifero extends SerVivo {
    public Mamifero(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Mamifero"); }
}

abstract class Planta extends SerVivo {
    public Planta(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Planta"); }
}

//  NÍVEL 2 — filhos de Ave

class BeijaFlor extends Ave {
    public BeijaFlor(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("BeijaFlor"); }
}

abstract class BemTeVi extends Ave {
    public BemTeVi(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("BemTeVi"); }
}

class Gaviao extends Ave {
    public Gaviao(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Gaviao"); }
}

//  NÍVEL 2 — filhos de Mamifero
abstract class Caes extends Mamifero {
    public Caes(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Caes"); }
}

abstract class Felinos extends Mamifero {
    public Felinos(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Felinos"); }
}

//  NÍVEL 2 — filhos de Planta

class Angiosperma extends Planta {
    public Angiosperma(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Angiosperma"); }
}

//  NÍVEL 3 — filhos de Caes

class PastorAlemao extends Caes {
    public PastorAlemao(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("PastorAlemao"); }
}

class Labrador extends Caes {
    public Labrador(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Labrador"); }
}

//  NÍVEL 3 — filhos de Felinos

class Leao extends Felinos {
    public Leao(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Leao"); }
}

class Tigre extends Felinos {
    public Tigre(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("Tigre"); }
}

//  NÍVEL 3 — filhos de BemTeVi

class BemTeViListrado extends BemTeVi {
    public BemTeViListrado(String nome) { super(nome); }

    @Override
    public void imprimirIdentidade() { System.out.println("BemTeViListrado"); }
}

public class Exercicio1 {

    public static void main(String[] args) {

        ArrayList<SerVivo> seres = new ArrayList<>();

        seres.add(new Ameba("Ameba-1"));
        seres.add(new BeijaFlor("BeijaFlor-1"));
        seres.add(new BemTeViListrado("BemTeViListrado-1"));
        seres.add(new Gaviao("Gaviao-1"));
        seres.add(new PastorAlemao("PastorAlemao-1"));
        seres.add(new Labrador("Labrador-1"));
        seres.add(new Leao("Leao-1"));
        seres.add(new Tigre("Tigre-1"));
        seres.add(new Angiosperma("Angiosperma-1"));

        System.out.println("=== Nome e Identidade de cada SerVivo ===\n");

        for (SerVivo ser : seres) {
            System.out.print("Nome: " + ser.getNome() + " | Identidade: ");
            ser.imprimirIdentidade();
        }
    }
}
