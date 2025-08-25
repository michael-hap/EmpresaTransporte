package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.Usuario;
import co.edu.uniquindio.transporte.model.Vehiculo;

public interface IPropietarioCrud {


    void inicializarDatosDePrueba();


    void registrarPropietario(Propietario propietario);

    void registrarVehiculoParaPropietario(String cedulaPropietario, Vehiculo vehiculo);

    void agregarUsuarioEnPlaca(String placa, Usuario usuario);

    int totalPasajerosDia();
    int totalPasajerosPorPlaca(String placa);
}
