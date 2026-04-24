import java.io.*;
import java.util.ArrayList;

// Classe Task serializavel para anotar tarefas diarias
class Task implements Serializable {
    private static final long serialVersionUID = 1L;

    private String date;
    private String time;
    private String description;

    public Task(String date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public String getDate()        { return date; }
    public String getTime()        { return time; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return String.format("[%s %s] %s", date, time, description);
    }
}

// Classe que gerencia a lista de tarefas
class TaskList {
    private ArrayList<Task> tarefas = new ArrayList<>();

    // Adiciona uma tarefa na lista
    public void adicionar(Task t) {
        tarefas.add(t);
        System.out.println("Tarefa adicionada: " + t);
    }

    // Lista todas as tarefas em memoria
    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
            return;
        }
        System.out.println("Tarefas na lista (" + tarefas.size() + "):");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + tarefas.get(i));
        }
    }

    // Grava a lista inteira em arquivo usando ObjectOutputStream
    public void gravarEmArquivo(String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(tarefas);
            System.out.println("Lista gravada em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao gravar arquivo: " + e.getMessage());
        }
    }

    // Recupera a lista de tarefas de arquivo usando ObjectInputStream
    @SuppressWarnings("unchecked")
    public void recuperarDeArquivo(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            tarefas = (ArrayList<Task>) ois.readObject();
            System.out.println("Lista recuperada de: " + caminho + " (" + tarefas.size() + " tarefas)");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar arquivo: " + e.getMessage());
        }
    }

    public int tamanho() { return tarefas.size(); }
}

// Main
public class Exercicio9 {

    public static void main(String[] args) {

        final String ARQUIVO = "tarefas.dat";

        // 1. Criar lista e adicionar tarefas
        System.out.println("=== Adicionando tarefas ===\n");
        TaskList lista = new TaskList();
        lista.adicionar(new Task("2025-04-24", "08:00", "Revisar relatorio trimestral"));
        lista.adicionar(new Task("2025-04-24", "09:30", "Reuniao com equipe de desenvolvimento"));
        lista.adicionar(new Task("2025-04-24", "12:00", "Almoco com cliente"));
        lista.adicionar(new Task("2025-04-24", "14:00", "Responder emails pendentes"));
        lista.adicionar(new Task("2025-04-24", "16:30", "Revisar pull requests no repositorio"));
        lista.adicionar(new Task("2025-04-25", "09:00", "Apresentacao de resultados para diretoria"));
        lista.adicionar(new Task("2025-04-25", "11:00", "Treinamento de seguranca da informacao"));
        lista.adicionar(new Task("2025-04-25", "15:00", "Planejamento da sprint da proxima semana"));

        // 2. Listar tarefas em memoria
        System.out.println("\n=== Listando tarefas em memoria ===\n");
        lista.listar();

        // 3. Gravar em arquivo (objetos serializados)
        System.out.println("\n=== Gravando em arquivo ===\n");
        lista.gravarEmArquivo(ARQUIVO);

        // 4. Criar nova lista vazia e recuperar do arquivo
        System.out.println("\n=== Recuperando do arquivo em nova lista ===\n");
        TaskList listaRecuperada = new TaskList();
        listaRecuperada.recuperarDeArquivo(ARQUIVO);

        // 5. Listar tarefas recuperadas
        System.out.println();
        listaRecuperada.listar();

        // 6. Examinar o arquivo gravado
        System.out.println("\n=== Examinando o arquivo gravado ===\n");
        File arquivo = new File(ARQUIVO);
        System.out.println("Nome do arquivo : " + arquivo.getName());
        System.out.println("Tamanho         : " + arquivo.length() + " bytes");
        System.out.println("Caminho absoluto: " + arquivo.getAbsolutePath());
        System.out.println("\nConteudo bruto (primeiros bytes em hexadecimal):");
        examinarBytesIniciais(ARQUIVO, 32);

        System.out.println("\nNota: o arquivo e binario (formato de serializacao Java).");
        System.out.println("Os bytes 'AC ED 00 05' sao a assinatura padrao de serializacao Java (magic number).");
    }

    // Exibe os primeiros N bytes do arquivo em hexadecimal para inspecao
    private static void examinarBytesIniciais(String caminho, int quantidade) {
        try (FileInputStream fis = new FileInputStream(caminho)) {
            byte[] buffer = new byte[quantidade];
            int lidos = fis.read(buffer);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lidos; i++) {
                sb.append(String.format("%02X ", buffer[i]));
                if ((i + 1) % 16 == 0) sb.append("\n");
            }
            System.out.println(sb.toString().trim());
        } catch (IOException e) {
            System.out.println("Erro ao examinar arquivo: " + e.getMessage());
        }
    }
}
