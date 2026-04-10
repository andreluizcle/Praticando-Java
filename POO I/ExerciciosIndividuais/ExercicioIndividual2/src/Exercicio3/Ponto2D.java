package Exercicio3;

public class Ponto2D implements Comparable<Ponto2D> {
    private final double x;
    private final double y;

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() { return x; }
    public double getY() { return y; }

    @Override
    public int compareTo(Ponto2D outro) {
        return Double.compare(this.x, outro.x);
    }

    @Override
    public String toString() {
        return String.format("(%.2f, %.2f)", x, y);
    }
}