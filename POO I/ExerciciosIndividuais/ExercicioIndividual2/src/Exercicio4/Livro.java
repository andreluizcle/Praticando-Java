package Exercicio4;

public class Livro {
    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        setPreco(preco);
    }

    public String getTitulo() { return titulo; }
    public String getAutor()  { return autor; }
    public double getPreco()  { return preco; }

    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor)   { this.autor = autor; }

    public void setPreco(double preco) {
        if (preco < 0) return;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("Livro{titulo='%s', autor='%s', preco=R$ %.2f}", titulo, autor, preco);
    }
}
