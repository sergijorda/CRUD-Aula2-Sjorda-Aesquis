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

    public void demanaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ALTA DE PROFESSOR ---");
        System.out.print("Introdueix el nom: ");
        String nom = scanner.nextLine();

        System.out.print("Introdueix els cognoms: ");
        String cognoms = scanner.nextLine();

        PROFESSOR nouProfessor = new PROFESSOR(0, nom, cognoms);

        controller.altaProfessor(nouProfessor);
    }

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

    public void modificaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ACTUALITZAR PROFESSOR ---");
        System.out.print("Introdueix l'ID del professor que vols modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introdueix el nou nom: ");
        String nouNom = scanner.nextLine();

        System.out.print("Introdueix els nous cognoms: ");
        String nousCognoms = scanner.nextLine();

        PROFESSOR professorModificat = new PROFESSOR(id, nouNom, nousCognoms);

        controller.actualitzarProfessor(professorModificat);
    }


    public void eliminaProfessor() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ELIMINAR PROFESSOR ---");
        System.out.print("Introdueix l'ID del professor que vols esborrar: ");
        int id = scanner.nextInt();

        controller.eliminarProfessor(id);
    }
}
