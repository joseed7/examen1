package com.agenda.controller;

import com.agenda.model.Contacto;
import com.agenda.repository.ContactoRepository;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactoRepository repo = new ContactoRepository();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Salir");
            int op = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (op) {
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
                }
                case 2 -> {
                    List<Contacto> contactos = repo.listar();
                    contactos.forEach(System.out::println);
                }
                case 3 -> System.exit(0);
            }
        }
    }
}
