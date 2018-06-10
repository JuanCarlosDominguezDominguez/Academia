/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.ProgramaEducativo;
import interfacesdao.IProgramaEducativoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juuan
 */
public class ProgramaEducativoDAO implements IProgramaEducativoDAO{
    private static final String OBTENER = "SELECT* FROM programaseducativos WHERE nombrePE = ?";
    private Connection conexion;
    
    @Override
    public ProgramaEducativo obtenerProgramaEducativo(String nombrePE) {
        ProgramaEducativo programaEducativo = new ProgramaEducativo();
        conexion = DataBase.getDataBaseConnection();
        try{
            //OBTENER EL NOMBRE DEL PROGRAMA EDUCATIVO
            PreparedStatement statement = conexion.prepareStatement(OBTENER);
            statement.setString(1, nombrePE);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                programaEducativo.setNombrePE(resultado.getString("nombrePE"));
            }
        }catch(SQLException excepcion){
            
        }
        return programaEducativo;
    }
    
}
