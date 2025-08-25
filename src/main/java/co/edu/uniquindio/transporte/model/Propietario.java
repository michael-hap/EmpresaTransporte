package co.edu.uniquindio.transporte.model;

public class Propietario {
    private String nombre;
    private String cedula;
    private String email;
    private String celular;
    private int edad;
    private Vehiculo vehiculoPrincipal;

    public Propietario(String nombre, String cedula, String email, String celular, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.email = email;
        this.celular = celular;
        this.edad = edad;
    }

    public String getNombre() { return nombre; }
    public String getCedula() { return cedula; }
    public String getEmail()  { return email; }
    public String getCelular(){ return celular; }
    public int getEdad()      { return edad; }

    public Vehiculo getVehiculoPrincipal() { return vehiculoPrincipal; }
    public void setVehiculoPrincipal(Vehiculo v) { this.vehiculoPrincipal = v; }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", email='" + email + '\'' +
                ", celular='" + celular + '\'' +
                ", edad=" + edad +
                ", vehiculo=" + (vehiculoPrincipal != null ? vehiculoPrincipal.toString() : "sin vehiculo") +
                '}';
    }
}
