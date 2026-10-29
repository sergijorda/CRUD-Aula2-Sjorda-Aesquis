package VIEW;

import java.util.Scanner;

public class MODUL_PROFESSIONAL_VIEW {
    Scanner input = new Scanner(System.in);

    public String nomModulProfessional(){
        System.out.println("Nom del modul professional");
        String nomModulProfessional = input.nextLine();

        return nomModulProfessional;
    }

    public String idModulProfessional(){
        System.out.println("ID del professor assignat ");
        String IDprofessorAssignat = input.nextLine();

        return IDprofessorAssignat;
    }

}
