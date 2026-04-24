import java.util.ArrayList;

// Interface
interface TarefaAutomatizada {
    void executar();
}

// Tarefa: backup de arquivos
class Backup implements TarefaAutomatizada {
    private String destino;

    public Backup(String destino) {
        this.destino = destino;
    }

    @Override
    public void executar() {
        System.out.println("[Backup] Iniciando backup...");
        System.out.println("[Backup] Copiando arquivos para: " + destino);
        System.out.println("[Backup] Backup concluido com sucesso.");
    }
}

// Tarefa: limpeza de disco
class LimpezaDisco implements TarefaAutomatizada {
    private String unidade;

    public LimpezaDisco(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public void executar() {
        System.out.println("[LimpezaDisco] Iniciando limpeza da unidade: " + unidade);
        System.out.println("[LimpezaDisco] Removendo arquivos temporarios...");
        System.out.println("[LimpezaDisco] Esvaziando lixeira...");
        System.out.println("[LimpezaDisco] Limpeza concluida. 3.2 GB liberados.");
    }
}

// Tarefa: atualizacao do sistema
class AtualizacaoSistema implements TarefaAutomatizada {
    private String versao;

    public AtualizacaoSistema(String versao) {
        this.versao = versao;
    }

    @Override
    public void executar() {
        System.out.println("[AtualizacaoSistema] Verificando atualizacoes disponiveis...");
        System.out.println("[AtualizacaoSistema] Baixando versao: " + versao);
        System.out.println("[AtualizacaoSistema] Instalando atualizacao...");
        System.out.println("[AtualizacaoSistema] Sistema atualizado com sucesso.");
    }
}

// Tarefa: verificacao de virus (exemplo de nova tarefa adicionada sem alterar o codigo existente)
class VerificacaoVirus implements TarefaAutomatizada {
    private String diretorio;

    public VerificacaoVirus(String diretorio) {
        this.diretorio = diretorio;
    }

    @Override
    public void executar() {
        System.out.println("[VerificacaoVirus] Escaneando diretorio: " + diretorio);
        System.out.println("[VerificacaoVirus] Nenhuma ameaca encontrada.");
        System.out.println("[VerificacaoVirus] Verificacao concluida.");
    }
}

// Agendador generico de tarefas
class Agendador {
    private ArrayList<TarefaAutomatizada> tarefas = new ArrayList<>();

    public void agendar(TarefaAutomatizada tarefa) {
        tarefas.add(tarefa);
    }

    public void executarTodas() {
        System.out.println("Iniciando execucao das tarefas agendadas...\n");
        for (TarefaAutomatizada t : tarefas) {
            t.executar();
            System.out.println();
        }
        System.out.println("Todas as tarefas foram concluidas.");
    }
}

// Main
public class Exercicio7 {

    public static void main(String[] args) {

        Agendador agendador = new Agendador();

        agendador.agendar(new Backup("/mnt/backup/servidor"));
        agendador.agendar(new LimpezaDisco("C:\\"));
        agendador.agendar(new AtualizacaoSistema("v14.3.1"));
        agendador.agendar(new VerificacaoVirus("C:\\Users"));

        agendador.executarTodas();
    }
}
