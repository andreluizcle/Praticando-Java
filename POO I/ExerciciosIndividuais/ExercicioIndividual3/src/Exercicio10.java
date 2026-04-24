import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

class Task2 implements Serializable {
    private static final long serialVersionUID = 1L;

    private LocalDate date;   // java.time.LocalDate implementa Serializable
    private String time;
    private String description;

    public Task2(LocalDate date, String time, String description) {
        this.date = date;
        this.time = time;
        this.description = description;
    }

    public LocalDate getDate()     { return date; }
    public String getTime()        { return time; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("[%s %s] %s", date.format(fmt), time, description);
    }
}

// Classe que gerencia a lista de tarefas
class TaskList2 implements Serializable {
    private static final long serialVersionUID = 2L;

    private ArrayList<Task2> tarefas = new ArrayList<>();

    public void adicionar(Task2 t) {
        tarefas.add(t);
        System.out.println("Tarefa adicionada: " + t);
    }

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
            tarefas = (ArrayList<Task2>) ois.readObject();
            System.out.println("Lista recuperada de: " + caminho + " (" + tarefas.size() + " tarefas)");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao recuperar arquivo: " + e.getMessage());
        }
    }
}

// Programa principal
public class Exercicio10 {

    public static void main(String[] args) {

        final String ARQUIVO = "tarefas_localdate.dat";

        // --- 1. Criar tarefas usando LocalDate.of(ano, mes, dia) ---
        System.out.println("=== Adicionando tarefas ===\n");
        TaskList2 lista = new TaskList2();
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 24), "08:00", "Revisar relatorio trimestral"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 24), "09:30", "Reuniao com equipe de desenvolvimento"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 24), "12:00", "Almoco com cliente"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 24), "14:00", "Responder emails pendentes"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 25), "09:00", "Apresentacao de resultados para diretoria"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 25), "11:00", "Treinamento de seguranca da informacao"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 26), "10:00", "Revisao de contratos com departamento juridico"));
        lista.adicionar(new Task2(LocalDate.of(2025, 4, 26), "15:30", "Planejamento da sprint da proxima semana"));

        // --- 2. Demonstrar recursos de LocalDate ---
        System.out.println("\n=== Demonstracao de recursos de LocalDate ===\n");
        LocalDate hoje = LocalDate.now();
        System.out.println("Data de hoje          : " + hoje);
        System.out.println("Data da 1a tarefa     : " + LocalDate.of(2025, 4, 24));
        System.out.println("Dia da semana         : " + LocalDate.of(2025, 4, 24).getDayOfWeek());
        System.out.println("Eh ano bissexto?      : " + LocalDate.of(2025, 4, 24).isLeapYear());
        System.out.println("3 dias depois         : " + LocalDate.of(2025, 4, 24).plusDays(3));
        System.out.println("Comparacao de datas   : 24/04 antes de 26/04? "
                + LocalDate.of(2025, 4, 24).isBefore(LocalDate.of(2025, 4, 26)));

        // --- 3. Listar em memoria ---
        System.out.println("\n=== Listando tarefas em memoria ===\n");
        lista.listar();

        // --- 4. Gravar em arquivo ---
        System.out.println("\n=== Gravando em arquivo ===\n");
        lista.gravarEmArquivo(ARQUIVO);

        // --- 5. Recuperar em nova lista ---
        System.out.println("\n=== Recuperando do arquivo em nova lista ===\n");
        TaskList2 listaRecuperada = new TaskList2();
        listaRecuperada.recuperarDeArquivo(ARQUIVO);

        System.out.println();
        listaRecuperada.listar();

        // --- 6. Examinar o arquivo gravado ---
        System.out.println("\n=== Examinando o arquivo gravado ===\n");
        File arquivo = new File(ARQUIVO);
        System.out.println("Nome    : " + arquivo.getName());
        System.out.println("Tamanho : " + arquivo.length() + " bytes");
        System.out.println("Caminho : " + arquivo.getAbsolutePath());
        System.out.println("\nPrimeiros 32 bytes em hexadecimal:");
        examinarBytesIniciais(ARQUIVO, 32);
        System.out.println("\nNota: 'AC ED 00 05' e a assinatura padrao de serializacao Java.");
        System.out.println("O nome 'LocalDate' aparece em texto no arquivo binario,");
        System.out.println("provando que o objeto foi serializado como objeto Java completo.");
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