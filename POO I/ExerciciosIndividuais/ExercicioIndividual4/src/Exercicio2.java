import java.util.ArrayList;

class Comodo {
    private String nome;
    private double tamanho;
    private String materialDoPiso;

    public Comodo(String nome, double tamanho, String materialDoPiso) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.materialDoPiso = materialDoPiso;
    }

    public String getNome()            { return nome; }
    public double getTamanho()         { return tamanho; }
    public String getMaterialDoPiso()  { return materialDoPiso; }

    @Override
    public String toString() {
        return String.format("Comodo{nome='%s', tamanho=%.1f m², piso='%s'}",
                nome, tamanho, materialDoPiso);
    }
}

class Casa {
    private String endereco;
    private ArrayList<Comodo> comodos;

    public Casa(String endereco) {
        this.endereco = endereco;
        this.comodos  = new ArrayList<>();
    }

    public void adicionaComodo(Comodo comodo) {
        comodos.add(comodo);
    }

    public ArrayList<Comodo> getComodos() { return comodos; }
    public String getEndereco()           { return endereco; }

    public double calcularAreaTotal() {
        double total = 0;
        for (Comodo c : comodos) total += c.getTamanho();
        return total;
    }

    @Override
    public String toString() {
        return String.format("Casa{endereco='%s', totalComodos=%d, areaTotal=%.1f m²}",
                endereco, comodos.size(), calcularAreaTotal());
    }
}

public class Exercicio2 {
    public static void main(String[] args) {

        // Criando os cômodos
        Comodo sala    = new Comodo("Sala de Estar",  25.0, "Porcelanato");
        Comodo cozinha = new Comodo("Cozinha",        15.0, "Cerâmica");
        Comodo quarto1 = new Comodo("Quarto Principal", 20.0, "Madeira");
        Comodo quarto2 = new Comodo("Quarto de Hóspedes", 12.0, "Madeira");
        Comodo banheiro = new Comodo("Banheiro",       6.0, "Porcelanato");

        // Criando a casa e adicionando os cômodos
        Casa casa = new Casa("Rua das Flores, 123");
        casa.adicionaComodo(sala);
        casa.adicionaComodo(cozinha);
        casa.adicionaComodo(quarto1);
        casa.adicionaComodo(quarto2);
        casa.adicionaComodo(banheiro);

        // Exibindo resumo da casa
        System.out.println("=== Resumo da Casa ===");
        System.out.println(casa);

        // Listando todos os cômodos
        System.out.println("\n=== Cômodos ===");
        for (Comodo c : casa.getComodos()) {
            System.out.println(c);
        }

        // Adicionando um novo cômodo dinamicamente
        System.out.println("\n=== Adicionando Garagem ===");
        casa.adicionaComodo(new Comodo("Garagem", 18.0, "Concreto"));
        System.out.println(casa);
    }
}
