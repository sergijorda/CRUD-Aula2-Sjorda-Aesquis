package VIEW;

import java.util.List;
import java.util.Scanner;
import CONTROLLER.MODUL_PROFESSIONAL_CONTROLLER;
import MODEL.MODUL_PROFESSIONAL;

public class MODUL_PROFESSIONAL_VIEW {
    private MODUL_PROFESSIONAL_CONTROLLER controller;

    public MODUL_PROFESSIONAL_VIEW() {
        this.controller = new MODUL_PROFESSIONAL_CONTROLLER();
    }

    public void demanaModul() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ALTA DE MÒDUL PROFESSIONAL ---");
        System.out.print("Introdueix el nom del mòdul (Ex: M06): ");
        String nom = scanner.nextLine();

        System.out.print("Introdueix l'ID del professor encarregat: ");
        int idProf = scanner.nextInt();

        MODUL_PROFESSIONAL nouModul = new MODUL_PROFESSIONAL(0, nom, idProf);
        controller.altaModul(nouModul);
    }

    public void mostraModuls() {
        List<MODUL_PROFESSIONAL> llista = controller.llistarModuls();

        System.out.println("\n--- LLISTAT DE MÒDULS ---");
        if (llista.isEmpty()) {
            System.out.println("No hi ha cap mòdul registrat.");
        } else {
            for (MODUL_PROFESSIONAL m : llista) {
                System.out.println("ID: " + m.getId() + " | Mòdul: " + m.getNom() + " | Professor: " + m.getNomProfessor());
            }
        }
    }

    public void modificaModul() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ACTUALITZAR MÒDUL ---");
        System.out.print("Introdueix l'ID del mòdul que vols modificar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Introdueix el nou nom del mòdul: ");
        String nouNom = scanner.nextLine();

        System.out.print("Introdueix el nou ID del professor encarregat: ");
        int nouIdProf = scanner.nextInt();

        MODUL_PROFESSIONAL modulModificat = new MODUL_PROFESSIONAL(id, nouNom, nouIdProf);
        controller.actualitzarModul(modulModificat);
    }

    public void eliminaModul() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n--- ELIMINAR MÒDUL ---");
        System.out.print("Introdueix l'ID del mòdul que vols esborrar: ");
        int id = scanner.nextInt();

        controller.eliminarModul(id);
    }
}
