package view; // Revisa si el teu paquet s'ha de dir view o VIEW

import java.util.Scanner;
import VIEW.PROFESSOR_VIEW;
import VIEW.MODUL_PROFESSIONAL_VIEW; // 👈 Importem la vista de mòduls que farà el teu company

public class APP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Gestionar professors");
            System.out.println("2. Gestionar mòduls professionals");
            System.out.println("3. Sortir");
            System.out.print("Selecciona una opció: ");
            opcio = scanner.nextInt();

            switch (opcio) {
                case 1:
                    menuGestionar("Professors", scanner);
                    break;
                case 2:
                    menuGestionar("Mòduls Professionals", scanner);
                    break;
                case 3:
                    System.out.println("Adeu!");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcio != 3);

        scanner.close();
    }

    private static void menuGestionar(String tipus, Scanner scanner) {
        // Instanciem les dues vistes. Estaran a punt segons el menú on entrem
        PROFESSOR_VIEW professorView = new PROFESSOR_VIEW();
        MODUL_PROFESSIONAL_VIEW modulView = new MODUL_PROFESSIONAL_VIEW();
        int opcioSubmenu;

        do {
            System.out.println("\n--- Gestionar " + tipus + " ---");
            System.out.println("1. Alta");
            System.out.println("2. Llistar");
            System.out.println("3. Actualitzar");
            System.out.println("4. Eliminar");
            System.out.println("5. Tornar al menú");
            System.out.print("Selecciona una opció: ");
            opcioSubmenu = scanner.nextInt();

            switch (opcioSubmenu) {
                case 1:
                    if (tipus.equals("Professors")) {
                        professorView.demanaProfessor();
                    } else {
                        //modulView.demanaModul();
                    }
                    break;
                case 2:
                    if (tipus.equals("Professors")) {
                        professorView.mostraProfessors();
                    } else {
                        //modulView.mostraModuls();
                    }
                    break;
                case 3:
                    if (tipus.equals("Professors")) {
                        professorView.modificaProfessor();
                    } else {
                        //modulView.modificaModul();
                    }
                    break;
                case 4:
                    if (tipus.equals("Professors")) {
                        professorView.eliminaProfessor();
                    } else {
                        //modulView.eliminaModul();
                    }
                    break;
                case 5:
                    System.out.println("Tornant al menú principal...");
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }
        } while (opcioSubmenu != 5);
    }
}
