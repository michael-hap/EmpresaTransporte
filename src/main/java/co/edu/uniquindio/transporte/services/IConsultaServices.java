package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.Usuario;

import java.util.List;

public interface IConsultaServices {

    List<Propietario> propietariosQueSuperanPeso(double peso);


    int contarPasajerosPorPlaca(String placa);


    long propietariosMayoresDe40();

    void registrarUsuarioEnVehiculo(String placa, Usuario usuario);
}
