package CONTROLLER;

import DAO.PROFESSOR_DAO;
import MODEL.PROFESSOR;
import VIEW.PROFESSOR_VIEW;

import java.util.ArrayList;

public class PROFESSOR_CONTROLLER {

    PROFESSOR_VIEW pv = new PROFESSOR_VIEW();
    PROFESSOR_DAO pd = new PROFESSOR_DAO();


    public PROFESSOR_CONTROLLER(PROFESSOR_VIEW pv, PROFESSOR_DAO pd) {
        this.pv = pv;
        this.pd = pd;
    }



    public void altaProfessor(PROFESSOR professor) {

        PROFESSOR p = pv.demanarDades();


    }

    public void llistarProfessors(){

        for (PROFESSOR p : professorsDam2) {
            System.out.println(p);
        }

    }


    public void actualitzarProfessors(PROFESSOR professor){

        try {
            for (PROFESSOR p : professorsDam2) {
                String actualitzarProfessor = pv.actualitzarProfessor();

                if (p.equals(professorsDam2)){
                    pv.demanaNomProfessor();
                    p.setNom(actualitzarProfessor);

                    pv.demanaCognomProfessor();
                    p.setCognom(actualitzarProfessor);

                }




            }

        }catch (Exception e){
            System.err.println("ERROR: " + e.getMessage());
        }

    }


    public void eliminarProfessors(){

    }



    //tornar menu




}
