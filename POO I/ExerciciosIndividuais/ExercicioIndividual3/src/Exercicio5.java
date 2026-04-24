import java.util.ArrayList;

// Interface
interface Mensagem {
    void enviar();
}

// Envio via e-mail
class Email implements Mensagem {
    private String destinatario;
    private String assunto;
    private String corpo;

    public Email(String destinatario, String assunto, String corpo) {
        this.destinatario = destinatario;
        this.assunto = assunto;
        this.corpo = corpo;
    }

    @Override
    public void enviar() {
        System.out.println("Email enviado para: " + destinatario);
        System.out.println("  Assunto: " + assunto);
        System.out.println("  Corpo: " + corpo);
    }
}

// Envio via SMS
class SMS implements Mensagem {
    private String numero;
    private String texto;

    public SMS(String numero, String texto) {
        this.numero = numero;
        this.texto = texto;
    }

    @Override
    public void enviar() {
        System.out.println("SMS enviado para: " + numero);
        System.out.println("  Texto: " + texto);
    }
}

// Envio via notificacao de aplicativo
class NotificacaoApp implements Mensagem {
    private String usuario;
    private String titulo;
    private String mensagem;

    public NotificacaoApp(String usuario, String titulo, String mensagem) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.mensagem = mensagem;
    }

    @Override
    public void enviar() {
        System.out.println("Notificacao enviada para: " + usuario);
        System.out.println("  Titulo: " + titulo);
        System.out.println("  Mensagem: " + mensagem);
    }
}

// Main
public class Exercicio5 {

    public static void main(String[] args) {

        // Lista polimórfica de mensagens
        ArrayList<Mensagem> mensagens = new ArrayList<>();

        mensagens.add(new Email("ana@email.com", "Bem-vinda!", "Sua conta foi criada com sucesso."));
        mensagens.add(new SMS("+55 11 99999-0001", "Seu codigo de verificacao e: 482910"));
        mensagens.add(new NotificacaoApp("joao_silva", "Novo pedido", "Seu pedido #1042 foi aprovado."));
        mensagens.add(new Email("carlos@email.com", "Fatura disponivel", "Sua fatura de março esta pronta."));
        mensagens.add(new SMS("+55 21 98888-0002", "Promoção! 50% off ate meia-noite."));
        mensagens.add(new NotificacaoApp("maria_luz", "Lembrete", "Voce tem uma consulta amanha as 14h."));

        System.out.println("Enviando mensagens...\n");

        // Polimorfismo: enviar() correto e chamado sem conhecer o tipo exato
        for (Mensagem m : mensagens) {
            m.enviar();
            System.out.println();
        }

        System.out.println("Todas as mensagens enviadas.");
    }
}
