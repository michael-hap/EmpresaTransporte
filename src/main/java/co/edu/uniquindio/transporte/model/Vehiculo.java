package co.edu.uniquindio.transporte.model;

public abstract class Vehiculo {
    private String placa;
    private String modelo;
    private String marca;
    private String color;

    public Vehiculo(String placa, String modelo, String marca, String color) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
    }

    public String getPlaca() { return placa; }
    public String getModelo() { return modelo; }
    public String getMarca()  { return marca; }
    public String getColor()  { return color; }

    @Override
    public String toString() {
        return "Placa=" + placa + ", Modelo=" + modelo + ", Marca=" + marca + ", Color=" + color;
    }
}
