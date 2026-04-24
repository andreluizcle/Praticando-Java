import java.util.ArrayList;

// Interface
interface Arquivo {
    void abrir();
}

// Arquivo do tipo documento de texto
class DocumentoTexto implements Arquivo {
    private String nome;

    public DocumentoTexto(String nome) {
        this.nome = nome;
    }

    @Override
    public void abrir() {
        System.out.println("Arquivo foi aberto | DocumentoTexto: " + nome);
    }
}

// Arquivo do tipo planilha
class Planilha implements Arquivo {
    private String nome;

    public Planilha(String nome) {
        this.nome = nome;
    }

    @Override
    public void abrir() {
        System.out.println("Arquivo foi aberto | Planilha: " + nome);
    }
}

// Arquivo do tipo apresentacao
class Apresentacao implements Arquivo {
    private String nome;

    public Apresentacao(String nome) {
        this.nome = nome;
    }

    @Override
    public void abrir() {
        System.out.println("Arquivo foi aberto | Apresentacao: " + nome);
    }
}

// Main
public class Exercicio6 {

    public static void main(String[] args) {

        ArrayList<Arquivo> arquivos = new ArrayList<>();

        arquivos.add(new DocumentoTexto("relatorio_anual.txt"));
        arquivos.add(new Planilha("orcamento_2025.xlsx"));
        arquivos.add(new Apresentacao("pitch_investidores.pptx"));
        arquivos.add(new DocumentoTexto("contrato_servico.txt"));
        arquivos.add(new Apresentacao("treinamento_equipe.pptx"));
        arquivos.add(new Planilha("controle_estoque.xlsx"));

        System.out.println("Abrindo arquivos...\n");

        // Polimorfismo: o tipo exato de cada arquivo nao precisa ser conhecido
        for (Arquivo a : arquivos) {
            a.abrir();
        }

        System.out.println("\nTodos os arquivos foram abertos.");
    }
}
