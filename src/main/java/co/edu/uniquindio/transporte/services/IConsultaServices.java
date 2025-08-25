package co.edu.uniquindio.transporte.services;

import co.edu.uniquindio.transporte.model.Propietario;
import co.edu.uniquindio.transporte.model.Usuario;

import java.util.List;

public interface IConsultaServices {
    // Ejercicio a) propietarios cuyos vehículos de carga superen un peso (capacidad)
    List<Propietario> propietariosQueSuperanPeso(double peso);

    // Ejercicio b) número de usuarios movilizados por placa
    int contarPasajerosPorPlaca(String placa);

    // Ejercicios c) número de propietarios mayores de 40 años
    long propietariosMayoresDe40();
}
