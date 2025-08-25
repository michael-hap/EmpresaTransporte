package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.Usuario;
import co.edu.uniquindio.transporte.model.Vehiculo;

public interface IPropietarioCrud {

    // Ejercicio 1) Inicializar/limpiar estructuras
    void inicializarDatosDePrueba();

    // Ejercicio 2) Registrar propietario: Main construye objeto y llama.
    void registrarPropietario(Propietario propietario);

    // Ejercicio 2) Asociar/registrar un vehículo para un propietario (por cédula)
    void registrarVehiculoParaPropietario(String cedulaPropietario, Vehiculo vehiculo);

    // Ejercicio 3) Agregar usuario movilizado en placa
    void agregarUsuarioEnPlaca(String placa, Usuario usuario);

    // Ejercicio 3) Los totales
    int totalPasajerosDia();
    int totalPasajerosPorPlaca(String placa);
}
