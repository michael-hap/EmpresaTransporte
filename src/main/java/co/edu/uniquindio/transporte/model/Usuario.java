package co.edu.uniquindio.transporte.model;

public class Usuario {
    private int edad;

    public Usuario(int edad) { this.edad = edad; }
    public int getEdad() { return edad; }

    @Override
    public String toString() { return "Usuario{edad=" + edad + "}"; }
}
