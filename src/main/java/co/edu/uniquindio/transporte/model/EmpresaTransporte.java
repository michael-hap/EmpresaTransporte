package co.edu.uniquindio.transporte.model;

import co.edu.uniquindio.transporte.services.IConsultaServices;
import co.edu.uniquindio.transporte.services.IPropietarioCrud;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpresaTransporte implements IPropietarioCrud, IConsultaServices {
    private List<Usuario> listaDeUsuarios= new ArrayList<>();
    private List<Vehiculo> vehiculos=new ArrayList<>();
    private final List<Propietario> listaPropietarios = new ArrayList<>();
    private final List<VehiculoCarga> listaVehiculosCarga = new ArrayList<>();
    private final List<VehiculoTransporte> listaVehiculosTransporte = new ArrayList<>();
    private final List<Usuario> listaUsuariosDelDia = new ArrayList<>();
    private final Map<String, List<Usuario>> usuariosPorPlaca = new HashMap<>();

    public EmpresaTransporte() {
    }

    @Override
    public void inicializarDatosDePrueba() {

        listaPropietarios.clear();
        listaVehiculosCarga.clear();
        listaVehiculosTransporte.clear();
        listaUsuariosDelDia.clear();
        usuariosPorPlaca.clear();
    }

    @Override
    public void registrarPropietario(Propietario propietario) {
        if (propietario == null) return;
        listaPropietarios.add(propietario);
    }

    @Override
    public void registrarVehiculoParaPropietario(String cedulaPropietario, Vehiculo vehiculo) {
        if (vehiculo == null || cedulaPropietario == null) return;
        Propietario encontrado = null;
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getCedula().equalsIgnoreCase(cedulaPropietario)) {
                encontrado = propietario;
                break;
            }
        }
        if (encontrado == null) {
            // si no se encuentra el propietario
            return;
        }
        encontrado.setVehiculoPrincipal(vehiculo);
        if (vehiculo instanceof VehiculoCarga) {
            listaVehiculosCarga.add((VehiculoCarga) vehiculo);
        } else if (vehiculo instanceof VehiculoTransporte) {
            VehiculoTransporte vehiculoTransporte = (VehiculoTransporte) vehiculo;
            listaVehiculosTransporte.add(vehiculoTransporte);
            if (!usuariosPorPlaca.containsKey(vehiculoTransporte.getPlaca())) {
                usuariosPorPlaca.put(vehiculoTransporte.getPlaca(), new ArrayList<Usuario>());
            }
        }
    }

    @Override
    public void agregarUsuarioEnPlaca(String placa, Usuario usuario) {
        if (placa == null || usuario == null) return;
        listaUsuariosDelDia.add(usuario);
        List<Usuario> listaDeUsuariosPorPlaca = usuariosPorPlaca.get(placa);
        if (listaDeUsuariosPorPlaca == null) {
            listaDeUsuariosPorPlaca = new ArrayList<>();
            usuariosPorPlaca.put(placa, listaDeUsuariosPorPlaca);
        }
        listaDeUsuariosPorPlaca.add(usuario);
    }

    @Override
    public int totalPasajerosDia() {
        return listaUsuariosDelDia.size();
    }

    @Override
    public int totalPasajerosPorPlaca(String placa) {
        List<Usuario> listaDeUsuariosPorPlaca = usuariosPorPlaca.get(placa);
        return (listaDeUsuariosPorPlaca == null) ? 0 : listaDeUsuariosPorPlaca.size();
    }


    @Override
    public List<Propietario> propietariosQueSuperanPeso(double peso) {
        List<Propietario> resultadoListaPeso = new ArrayList<Propietario>();
        for (Propietario propietario : listaPropietarios) {
            Vehiculo vehiculo = propietario.getVehiculoPrincipal();
            if (vehiculo instanceof VehiculoCarga) {
                VehiculoCarga vehiculoCarga = (VehiculoCarga) vehiculo;
                if (vehiculoCarga.getCapacidadCarga() > peso) {
                    resultadoListaPeso.add(propietario);
                }
            }
        }
        return resultadoListaPeso;
    }


    @Override
    public long propietariosMayoresDe40() {
        long conteo = 0;
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getEdad() > 40) conteo++;
        }
        return conteo;
    }
    public VehiculoTransporte buscarVehiculoTransportePorPlaca(String placa) {
        for (Vehiculo v : vehiculos) { // asumiendo que hay una lista de vehiculos
            if (v instanceof VehiculoTransporte && v.getPlaca().equalsIgnoreCase(placa)) {
                return (VehiculoTransporte) v;
            }
        }
        return null; // en dado caso de no encontrar lo
    }



    @Override
    public void registrarUsuarioEnVehiculo(String placa, Usuario usuario) {
        for (Propietario propietario : listaPropietarios) {
            Vehiculo vehiculo = propietario.getVehiculoPrincipal();
            if (vehiculo instanceof VehiculoTransporte && vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                VehiculoTransporte vt = (VehiculoTransporte) vehiculo;
                vt.agregarUsuario(usuario);
                System.out.println("Usuario registrado en el vehículo con placa: " + placa);
                return;
            }
        }
        System.out.println("No se encontró un vehículo de transporte con la placa: " + placa);
    }
    @Override
    public int contarPasajerosPorPlaca(String placa) {
        for (Propietario propietario : listaPropietarios) {
            Vehiculo vehiculo = propietario.getVehiculoPrincipal();
            if (vehiculo instanceof VehiculoTransporte && vehiculo.getPlaca().equals(placa)) {
                VehiculoTransporte transporte = (VehiculoTransporte) vehiculo;
                return transporte.getListaUsuarios().size();
            }
        }
        return 0;
    }
    public Propietario buscarPropietarioPorPlaca(String placa) {
        for (Propietario propietario : listaPropietarios) {
            if (propietario.getVehiculoPrincipal().getPlaca().equals(placa)) {
                return propietario;
            }
        }
        return null;
    }



    public List<Propietario> getListaPropietarios() { return listaPropietarios; }
    public List<VehiculoCarga> getListaVehiculosCarga() { return listaVehiculosCarga; }
    public List<VehiculoTransporte> getListaVehiculosTransporte() { return listaVehiculosTransporte; }
    public List<Usuario> getListaDeUsuariosPorPlaca() { return getListaDeUsuariosPorPlaca(); }
}
