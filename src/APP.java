package view; // Revisa si el paquet és view o VIEW (en majúscules com a la teva imatge)

import java.util.Scanner;
import VIEW.PROFESSOR_VIEW; // Importem la vista que hem creat abans

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
    }

    private static void menuGestionar(String tipus, Scanner scanner) {
        // Instanciem la vista de professors per poder utilitzar-la al case 1
        PROFESSOR_VIEW professorView = new PROFESSOR_VIEW();
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
                        // 1. Cridem al mètode de la vista que demana les dades per consola
                        professorView.demanaProfessor();
                    } else {
                        System.out.println("Alta de Mòduls Professionals (encara no implementat)");
                    }
                    break;
                case 2:
                    System.out.println("Has triat: Llistar " + tipus);
                    break;
                case 3:
                    System.out.println("Has triat: Actualitzar " + tipus);
                    break;
                case 4:
                    System.out.println("Has triat: Eliminar " + tipus);
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
