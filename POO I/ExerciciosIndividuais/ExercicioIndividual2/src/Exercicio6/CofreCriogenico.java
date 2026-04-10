package Exercicio6;

import Exercicio5.Temperatura;

public class CofreCriogenico {
    private static final double TEMPERATURA_MAXIMA = -196.0;
    private static final double ZERO_ABSOLUTO = -273.15;

    private Temperatura temperatura;
    private String carga;

    public CofreCriogenico() {
        this.temperatura = new Temperatura(0);
        this.temperatura.setCelsius(-196.0);
        this.carga = "vazio";
    }

    public CofreCriogenico(double tempCelsius, String carga) {
        this.temperatura = new Temperatura(0);
        if (tempCelsius > TEMPERATURA_MAXIMA) {
            this.temperatura.setCelsius(TEMPERATURA_MAXIMA);
        } else {
            this.temperatura.setCelsius(tempCelsius);
        }
        this.carga = carga;
    }

    public Temperatura getTemperatura() { return temperatura; }
    public String getCarga()            { return carga; }

    public void abrePorta() {
        temperatura.setCelsius(temperatura.getCelsius() + 3.0);
    }

    public void fechaPorta() {}

    public void mantemFrio() {
        double novaTemp = temperatura.getCelsius() - 0.5;
        if (novaTemp < ZERO_ABSOLUTO) return;
        temperatura.setCelsius(novaTemp);
    }

    public void abrePorta(String novaCarga) throws IllegalStateException {
        if (temperatura.getCelsius() > TEMPERATURA_MAXIMA) {
            throw new IllegalStateException(
                    String.format("Temperatura atual (%.2f °C) acima do limite permitido (%.2f °C). Chame mantemFrio() antes de abrir.",
                            temperatura.getCelsius(), TEMPERATURA_MAXIMA)
            );
        }
        this.carga = novaCarga;
        abrePorta();
    }

    @Override
    public String toString() {
        return String.format("CofreCriogenico{temperatura=%.2f °C, carga='%s'}", temperatura.getCelsius(), carga);
    }
}
