package co.edu.uniquindio.transporte.factory;

import co.edu.uniquindio.transporte.model.*;

public class ModelFactory {

    // Singleton
    private static ModelFactory instance;

    private ModelFactory() { }

    public static synchronized ModelFactory getInstance() {
        if (instance == null) instance = new ModelFactory();
        return instance;
    }

    // metodos factorias
    public Propietario crearPropietario(String nombre, String cedula, String email, String celular, int edad) {
        return new Propietario(nombre, cedula, email, celular, edad);
    }

    public VehiculoCarga crearVehiculoCarga(String placa, String modelo, String marca, String color,
                                            double capacidadCarga, int numeroEjes) {
        return new VehiculoCarga(placa, modelo, marca, color, capacidadCarga, numeroEjes);
    }

    public VehiculoTransporte crearVehiculoTransporte(String placa, String modelo, String marca, String color,
                                                      int maximoPasajeros) {
        return new VehiculoTransporte(placa, modelo, marca, color, maximoPasajeros);
    }

    public Usuario crearUsuario(int edad) {
        return new Usuario(edad);
    }
}
