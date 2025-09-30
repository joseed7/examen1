package com.agenda.controller;

import com.agenda.model.Agenda;
import com.agenda.model.Contacto;
import com.agenda.model.Grupo;
import com.agenda.repository.ContactoRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        ContactoRepository repo = new ContactoRepository();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== AGENDA DE CONTACTOS =====");
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Crear grupo");
            System.out.println("4. Listar grupos");
            System.out.println("5. Asignar contacto a grupo");
            System.out.println("6. Salir");
            System.out.print("Seleccione opción: ");

            int opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Dirección: ");
                    String direccion = sc.nextLine();

                    Contacto c = new Contacto(0, nombre, telefono, email, direccion);
                    repo.insertar(c);
                    agenda.agregarContacto(c);
                    System.out.println("Contacto agregado con éxito");
                }
                case 2 -> {
                    List<Contacto> contactos = repo.listar();
                    if (contactos.isEmpty()) {
                        System.out.println("No hay contactos registrados.");
                    } else {
                        contactos.forEach(System.out::println);
                    }
                }
                case 3 -> {
                    System.out.print("ID del grupo: ");
                    int idGrupo = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre del grupo: ");
                    String nombreGrupo = sc.nextLine();
                    agenda.crearGrupo(idGrupo, nombreGrupo);
                    System.out.println("Grupo creado con éxito");
                }
                case 4 -> {
                    List<Grupo> grupos = agenda.listarGrupos();
                    if (grupos.isEmpty()) {
                        System.out.println("No hay grupos registrados");
                    } else {
                        grupos.forEach(System.out::println);
                    }
                }
                case 5 -> {
                    System.out.print("Nombre del contacto: ");
                    String nombreContacto = sc.nextLine();
                    Contacto c = agenda.buscarContacto(nombreContacto);

                    if (c == null) {
                        System.out.println("No se encontró el contacto.");
                        break;
                    }

                    System.out.print("ID del grupo: ");
                    int idGrupo = sc.nextInt();
                    sc.nextLine();

                    Grupo g = agenda.listarGrupos().stream()
                            .filter(grupo -> grupo.getId() == idGrupo)
                            .findFirst()
                            .orElse(null);

                    if (g == null) {
                        System.out.println("No se encontró el grupo");
                        break;
                    }

                    agenda.asignarAGrupo(c, g);
                    System.out.println("Contacto asignado a " + g.getNombre());
                }
                case 6 -> {
                    System.out.println("Saliendo");
                    System.exit(0);
                }
                default -> System.out.println("Opción inválida");
            }
        }
    }
}

