import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

class Task3 implements Serializable, Comparable<Task3> {
    private static final long serialVersionUID = 3L;

    private LocalDate date;
    private String time;
    private String description;

    public Task3(LocalDate date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public LocalDate getDate()     { return date; }
    public String getTime()        { return time; }
    public String getDescription() { return description; }

    // Delega a ordenacao ao compareTo de LocalDate (que ja implementa Comparable)
    @Override
    public int compareTo(Task3 outra) {
        return this.date.compareTo(outra.date);
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s %s] %s", date.format(fmt), time, description);
    }
}

// Classe que gerencia a lista de tarefas ordenada por data
class TaskList3 implements Serializable {
    private static final long serialVersionUID = 4L;

    private ArrayList<Task3> tarefas = new ArrayList<>();

    // Adiciona e ja reordena a lista por data
    public void adicionar(Task3 t) {
        tarefas.add(t);
        Collections.sort(tarefas); // usa o compareTo de Task3 -> LocalDate
        System.out.println("Tarefa adicionada: " + t);
    }

    public void listar() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa na lista.");
            return;
        }
        System.out.println("Tarefas na lista (" + tarefas.size() + ") em ordem de data:");
        for (int i = 0; i < tarefas.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + tarefas.get(i));
        }
    }

    // Grava a lista (ja ordenada) em arquivo usando ObjectOutputStream
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
            tarefas = (ArrayList<Task3>) ois.readObject();
            System.out.println("Lista recuperada de: " + caminho + " (" + tarefas.size() + " tarefas)");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar arquivo: " + e.getMessage());
        }
    }
}

// Main
public class Exercicio11 {

    public static void main(String[] args) {

        final String ARQUIVO = "tarefas_ordenadas.dat";

        // Tarefas inseridas FORA de ordem de data propositalmente para provar a ordenacao
        System.out.println("=== Adicionando tarefas fora de ordem de data ===\n");
        TaskList3 lista = new TaskList3();
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 27), "10:00", "Revisao de contratos juridicos"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 24), "08:00", "Revisar relatorio trimestral"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 26), "15:30", "Planejamento da sprint"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 24), "14:00", "Responder emails pendentes"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 25), "11:00", "Treinamento de seguranca"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 28), "09:00", "Entrega do projeto final"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 25), "09:00", "Apresentacao para diretoria"));
        lista.adicionar(new Task3(LocalDate.of(2025, 4, 26), "10:00", "Reuniao com equipe de QA"));

        // Listagem ja ordenada por data
        System.out.println("\n=== Listando em ordem de data ===\n");
        lista.listar();

        // Gravar em arquivo (ordem preservada)
        System.out.println("\n=== Gravando em arquivo ===\n");
        lista.gravarEmArquivo(ARQUIVO);

        // Recuperar em nova lista
        System.out.println("\n=== Recuperando do arquivo em nova lista ===\n");
        TaskList3 listaRecuperada = new TaskList3();
        listaRecuperada.recuperarDeArquivo(ARQUIVO);
        System.out.println();
        listaRecuperada.listar();

        // Examinar o arquivo gravado
        System.out.println("\n=== Examinando o arquivo gravado ===\n");
        File arquivo = new File(ARQUIVO);
        System.out.println("Nome    : " + arquivo.getName());
        System.out.println("Tamanho : " + arquivo.length() + " bytes");
        System.out.println("Caminho : " + arquivo.getAbsolutePath());
        System.out.println("\nPrimeiros 32 bytes em hexadecimal:");
        examinarBytesIniciais(ARQUIVO, 32);
        System.out.println("\nNota: 'AC ED 00 05' e a assinatura padrao de serializacao Java.");
    }

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