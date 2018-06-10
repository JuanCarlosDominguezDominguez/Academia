/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;
import clases.ProgramaEducativo;
/**
 *
 * @author Juuan
 */
public interface IProgramaEducativoDAO {
    ProgramaEducativo obtenerProgramaEducativo(String nombrePE);
}
