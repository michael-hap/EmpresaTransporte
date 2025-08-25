package co.edu.uniquindio.transporte.model;
import java.util.ArrayList;
import java.util.List;

public class VehiculoTransporte extends Vehiculo {
    private int maximoPasajeros;
    private List<Usuario> listaUsuarios;
    public VehiculoTransporte(String placa, String modelo, String marca, String color,
                              int maximoPasajeros) {
        super(placa, modelo, marca, color);
        this.maximoPasajeros = maximoPasajeros;
        this.listaUsuarios = new ArrayList<>();
    }

    public int getMaximoPasajeros() { return maximoPasajeros; }

    @Override
    public String toString() {
        return "VehiculoTransporte{" + super.toString() +
                ", MaxPasajeros=" + maximoPasajeros + "}";
    }
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }


    public void agregarUsuario(Usuario usuario){
        listaUsuarios.add(usuario);
    }

}
