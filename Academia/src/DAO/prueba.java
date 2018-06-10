/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import clases.ProgramaEducativo;

/**
 *
 * @author Juuan
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProgramaEducativoDAO p = new ProgramaEducativoDAO();
        p.obtenerProgramaEducativo("Ingeniería de software");
        System.out.println(p.obtenerProgramaEducativo("Ingeniería de software").getNombrePE());
    }
    
}
