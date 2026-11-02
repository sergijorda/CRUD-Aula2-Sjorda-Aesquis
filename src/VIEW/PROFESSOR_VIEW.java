package VIEW;

import java.util.List;
import java.util.Scanner;
import CONTROLLER.PROFESSOR_CONTROLLER;
import MODEL.PROFESSOR;

public class PROFESSOR_VIEW {
    private PROFESSOR_CONTROLLER controller;

    public PROFESSOR_VIEW() {
        this.controller = new PROFESSOR_CONTROLLER();
    }

    // 1. ALTA
    public void demanaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ALTA DE PROFESSOR ---");
        System.out.print("Introdueix el nom: ");
        String nom = scanner.nextLine();

        System.out.print("Introdueix els cognoms: ");
        String cognoms = scanner.nextLine();

        // Al fer l'alta passem un 0 a l'ID, ja que la BBDD el generarà automàticament
        PROFESSOR nouProfessor = new PROFESSOR(0, nom, cognoms);

        controller.altaProfessor(nouProfessor);
    }

    // 2. LLISTAR
    public void mostraProfessors() {
        List<PROFESSOR> llista = controller.llistarProfessors();

        System.out.println("\n--- LLISTAT DE PROFESSORS ---");
        if (llista.isEmpty()) {
            System.out.println("No hi ha cap professor registrat.");
        } else {
            for (PROFESSOR p : llista) {
                System.out.println("ID: " + p.getId() + " | Nom: " + p.getNom() + " " + p.getCognom());
            }
        }
    }

    // 3. ACTUALITZAR
    public void modificaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ACTUALITZAR PROFESSOR ---");
        System.out.print("Introdueix l'ID del professor que vols modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Netegem el salt de línia del buffer

        System.out.print("Introdueix el nou nom: ");
        String nouNom = scanner.nextLine();

        System.out.print("Introdueix els nous cognoms: ");
        String nousCognoms = scanner.nextLine();

        // Creem l'objecte professor amb l'ID existent per poder modificar-lo
        PROFESSOR professorModificat = new PROFESSOR(id, nouNom, nousCognoms);

        controller.actualitzarProfessor(professorModificat);
    }

    // 4. ELIMINAR
    public void eliminaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ELIMINAR PROFESSOR ---");
        System.out.print("Introdueix l'ID del professor que vols esborrar: ");
        int id = scanner.nextInt();

        controller.eliminarProfessor(id);
    }
}
