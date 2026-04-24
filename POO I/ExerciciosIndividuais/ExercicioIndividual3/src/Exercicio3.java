import java.util.ArrayList;

// Interface de pagamento
interface Pagamento {
    void processarPagamento();
}

// Implementação via cartão de crédito
class PagamentoCartao implements Pagamento {
    private String titular;
    private double valor;

    public PagamentoCartao(String titular, double valor) {
        this.titular = titular;
        this.valor = valor;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Cartao | Titular: " + titular + " | Valor: R$ " + valor);
    }
}

// Implementação via PayPal
class PagamentoPayPal implements Pagamento {
    private String email;
    private double valor;

    public PagamentoPayPal(String email, double valor) {
        this.email = email;
        this.valor = valor;
    }

    @Override
    public void processarPagamento() {
        System.out.println("PayPal | Email: " + email + " | Valor: R$ " + valor);
    }
}

// Implementação via Pix
class PagamentoPix implements Pagamento {
    private String chave;
    private double valor;

    public PagamentoPix(String chave, double valor) {
        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public void processarPagamento() {
        System.out.println("Pix    | Chave: " + chave + " | Valor: R$ " + valor);
    }
}

// Main
public class Exercicio3 {

    public static void main(String[] args) {

        // Lista polimórfica — classes independentes, sem hierarquia entre si
        ArrayList<Pagamento> pagamentos = new ArrayList<>();

        pagamentos.add(new PagamentoCartao("Ana Silva", 150.00));
        pagamentos.add(new PagamentoPayPal("joao@email.com", 89.90));
        pagamentos.add(new PagamentoPix("123.456.789-00", 200.00));
        pagamentos.add(new PagamentoCartao("Carlos Melo", 320.50));
        pagamentos.add(new PagamentoPix("carlos@banco.com", 75.00));
        pagamentos.add(new PagamentoPayPal("maria@email.com", 49.99));

        System.out.println("Processando pagamentos...\n");

        for (Pagamento p : pagamentos) {
            p.processarPagamento();
        }

        System.out.println("\nTodos os pagamentos processados.");
    }
}
