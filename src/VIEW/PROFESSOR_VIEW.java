package VIEW;

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

        // Creem l'objecte del Model
        PROFESSOR nouProfessor = new PROFESSOR(nom, cognoms);

        // El enviem al controlador
        controller.altaProfessor(nouProfessor);
    }
}
