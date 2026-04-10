package Exercicio5;

public class Temperatura {
    private static final double ZERO_ABSOLUTO_KELVIN = 0.0;

    private double kelvin;

    public Temperatura(double kelvin) {
        setKelvin(kelvin);
    }

    public double getKelvin()     { return kelvin; }
    public double getCelsius()    { return kelvin - 273.15; }
    public double getFahrenheit() { return getCelsius() * 9.0 / 5.0 + 32; }

    public void setKelvin(double kelvin) {
        if (kelvin < ZERO_ABSOLUTO_KELVIN) return;
        this.kelvin = kelvin;
    }

    public void setCelsius(double celsius) {
        setKelvin(celsius + 273.15);
    }

    public void setFahrenheit(double fahrenheit) {
        setCelsius((fahrenheit - 32) * 5.0 / 9.0);
    }

    @Override
    public String toString() {
        return String.format("%.2f K | %.2f °C | %.2f °F", getKelvin(), getCelsius(), getFahrenheit());
    }
}