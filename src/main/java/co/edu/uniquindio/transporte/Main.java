package co.edu.uniquindio.transporte;

import co.edu.uniquindio.transporte.factory.ModelFactory;
import co.edu.uniquindio.transporte.model.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ModelFactory factory = ModelFactory.getInstance();
        EmpresaTransporte empresa = new EmpresaTransporte();

        // No datos quemados: empresa inicia vacía
        empresa.inicializarDatosDePrueba();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ =====");
            System.out.println("1) Registrar Propietario + Vehículo de Carga");
            System.out.println("2) Registrar Propietario + Vehículo de Transporte");
            System.out.println("3) Capturar usuarios movilizados hoy (por placa de transporte)");
            System.out.println("4) Total pasajeros hoy");
            System.out.println("5) Total pasajeros por placa");
            System.out.println("6) (a) Propietarios con capacidad de carga > peso");
            System.out.println("7) (b) Número de usuarios movilizados por placa");
            System.out.println("8) (c) Número de propietarios mayores de 40 años");
            System.out.println("9) Listar propietarios");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            String op = sc.nextLine().trim();

            try {
                if ("1".equals(op)) {
                    // Registrar propietario + vehículo de carga
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Cédula: "); String cedula = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Celular: "); String celular = sc.nextLine();
                    System.out.print("Edad: "); int edad = readInt(sc);

                    System.out.print("Placa: "); String placa = sc.nextLine();
                    System.out.print("Modelo: "); String modelo = sc.nextLine();
                    System.out.print("Marca: "); String marca = sc.nextLine();
                    System.out.print("Color: "); String color = sc.nextLine();
                    System.out.print("Capacidad de carga (ej. kg): "); double capacidad = readDouble(sc);
                    System.out.print("Número de ejes: "); int ejes = readInt(sc);

                    Propietario p = factory.crearPropietario(nombre, cedula, email, celular, edad);
                    VehiculoCarga vc = factory.crearVehiculoCarga(placa, modelo, marca, color, capacidad, ejes);
                    p.setVehiculoPrincipal(vc);
                    empresa.registrarPropietario(p);

                    System.out.println(" Propietario y vehículo de carga registrados.");

                } else if ("2".equals(op)) {
                    // Registrar propietario + vehículo de transporte
                    System.out.print("Nombre: "); String nombre = sc.nextLine();
                    System.out.print("Cédula: "); String cedula = sc.nextLine();
                    System.out.print("Email: "); String email = sc.nextLine();
                    System.out.print("Celular: "); String celular = sc.nextLine();
                    System.out.print("Edad: "); int edad = readInt(sc);

                    System.out.print("Placa: "); String placa = sc.nextLine();
                    System.out.print("Modelo: "); String modelo = sc.nextLine();
                    System.out.print("Marca: "); String marca = sc.nextLine();
                    System.out.print("Color: "); String color = sc.nextLine();
                    System.out.print("Máximo de pasajeros: "); int maxPas = readInt(sc);

                    Propietario p = factory.crearPropietario(nombre, cedula, email, celular, edad);
                    VehiculoTransporte vt = factory.crearVehiculoTransporte(placa, modelo, marca, color, maxPas);
                    p.setVehiculoPrincipal(vt);
                    empresa.registrarPropietario(p);

                    System.out.println(" Propietario y vehículo de transporte registrados.");

                } else if ("3".equals(op)) {
                    // Capturar usuarios por placa
                    System.out.print("Placa del vehículo de transporte: "); String placa = sc.nextLine();
                    VehiculoTransporte vt = empresa.buscarVehiculoTransportePorPlaca(placa);
                    if (vt == null) {
                        System.out.println(" No existe vehículo de transporte con esa placa.");
                    } else {
                        System.out.print("¿Cuántos usuarios se movilizaron hoy en " + placa + "? ");
                        int n = readInt(sc);
                        for (int i = 1; i <= n; i++) {
                            System.out.print("Edad del usuario " + i + ": ");
                            int edadU = readInt(sc);
                            Usuario u = factory.crearUsuario(edadU);
                            empresa.agregarUsuarioEnPlaca(placa, u);
                        }
                        System.out.println("Registrados " + empresa.totalPasajerosPorPlaca(placa) + " usuarios en la placa " + placa);
                    }

                } else if ("4".equals(op)) {
                    System.out.println("Total pasajeros hoy: " + empresa.totalPasajerosDia());

                } else if ("5".equals(op)) {
                    System.out.print("Placa: "); String placa = sc.nextLine();
                    System.out.println("Pasajeros por " + placa + ": " + empresa.totalPasajerosPorPlaca(placa));

                } else if ("6".equals(op)) {
                    System.out.print("Peso mínimo en kg: "); double peso = readDouble(sc);
                    List<Propietario> lista = empresa.propietariosQueSuperanPeso(peso);
                    if (lista.isEmpty()) System.out.println("Ningún propietario supera ese valor.");
                    else {
                        System.out.println("Propietarios que superan " + peso + ":");
                        for (Propietario p : lista) System.out.println(" - " + p);
                    }

                } else if ("7".equals(op)) {
                    System.out.print("Placa: "); String placa = sc.nextLine();
                    System.out.println("Usuarios movilizados en " + placa + ": " + empresa.totalPasajerosPorPlaca(placa));

                } else if ("8".equals(op)) {
                    System.out.println("Cantidad de propietarios > 40 años: " + empresa.propietariosMayoresDe40());

                } else if ("9".equals(op)) {
                    System.out.println("=== Propietarios registrados ===");
                    for (Propietario p : empresa.getListaPropietarios()) {
                        System.out.println(" - " + p);
                    }

                } else if ("0".equals(op)) {
                    salir = true;
                } else {
                    System.out.println("Opción inválida");
                }
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }

        System.out.println("\nGracias por usar el sistema.");
        sc.close();
    }

    // --- helpers de lectura (evitan problemas con nextInt/nextLine) ---
    private static int readInt(Scanner sc) {
        while (true) {
            String s = sc.nextLine();
            try {
                return Integer.parseInt(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Número inválido. Intenta de nuevo: ");
            }
        }
    }

    private static double readDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine();
            try {
                return Double.parseDouble(s.trim());
            } catch (NumberFormatException e) {
                System.out.print("Número decimal inválido. Intenta de nuevo: ");
            }
        }
    }
}
