package VIEW;

import MODEL.PROFESSOR;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PROFESSOR_VIEW {
    Scanner input = new Scanner(System.in);


    public PROFESSOR demanarDades(){
        System.out.println("Digues el nom del professor");
        String nomProfessor = input.nextLine();


        System.out.println("Digues el cognom del professor");
        String cognomProfessor = input.nextLine();

        PROFESSOR professor = new PROFESSOR(nomProfessor, cognomProfessor);

        return professor;
    }


    public String demanarID(){
        System.out.println("Digues ID del professor");
        String id = input.nextLine();

        return id;
    }


    public void mostrarProfessors(){
        ArrayList<PROFESSOR> professorsDam2 = new ArrayList<>();

        for (PROFESSOR p : professorsDam2) {
            professorsDam2.add(p);
            System.out.println(professorsDam2);
        }

    }

    //mostrar com a anat execucio






}
