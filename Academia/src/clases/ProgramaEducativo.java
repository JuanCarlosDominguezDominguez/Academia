/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
class ProgramaEducativo {
    private String nombrePE;
    private ArrayList<Academia> academias;

    public ProgramaEducativo() {
    }

    public ProgramaEducativo(String nombrePE, ArrayList<Academia> academias) {
        this.nombrePE = nombrePE;
        this.academias = academias;
    }

    public String getNombrePE() {
        return nombrePE;
    }

    public void setNombrePE(String nombrePE) {
        this.nombrePE = nombrePE;
    }

    public ArrayList<Academia> getAcademias() {
        return academias;
    }

    public void setAcademias(ArrayList<Academia> academias) {
        this.academias = academias;
    }
    
    
}
