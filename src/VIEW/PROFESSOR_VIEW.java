package VIEW;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PROFESSOR_VIEW {
    Scanner input = new Scanner(System.in);

    public String demanaNomProfessor(){
        System.out.print("Nom del professor:" );
        String nomProfessor = input.nextLine();

        return nomProfessor;
    }

    public String demanaCognomProfessor(){
        System.out.print("Cognom del professor:" );
        String cognomProfessor = input.nextLine();

        return cognomProfessor;
    }

    public String afegirProfessor(){
        System.out.println("Quin professor vols afegir? ");
        String afegirProfessor = input.nextLine();

        return afegirProfessor;
    }

    public String actualitzarProfessor(){
        System.out.println("Quin professor vols actualitzar? ");
        String actualitzarProfessor = input.nextLine();

        return actualitzarProfessor;
    }

    public String eliminarProfessor(){
        System.out.println("Quin professor vols eliminar? ");
        String eliminarProfessor = input.nextLine();

        return eliminarProfessor;
    }

}
