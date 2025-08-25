package co.edu.uniquindio.transporte.model;

public class VehiculoCarga extends Vehiculo {
    private double capacidadCarga; // Esta va en kg
    private int numeroEjes;

    public VehiculoCarga(String placa, String modelo, String marca, String color,
                         double capacidadCarga, int numeroEjes) {
        super(placa, modelo, marca, color);
        this.capacidadCarga = capacidadCarga;
        this.numeroEjes = numeroEjes;
    }

    public double getCapacidadCarga() { return capacidadCarga; }
    public int getNumeroEjes() { return numeroEjes; }

    @Override
    public String toString() {
        return "VehiculoCarga{" + super.toString() +
                ", Capacidad=" + capacidadCarga +
                ", Ejes=" + numeroEjes + "}";
    }
}
