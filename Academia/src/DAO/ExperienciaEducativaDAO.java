/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.ExperienciaEducativa;
import clases.ProgramaEducativo;
import interfacesdao.IExperienciaEducativaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class ExperienciaEducativaDAO implements IExperienciaEducativaDAO{
    private Connection conexion;
    @Override
    public ExperienciaEducativa obtenerExperienciaEducativa(String codigo) {
        conexion = DataBase.getDataBaseConnection();
        String OBTENER_EXPERIENCIA = "SELECT* FROM experienciasEducativas WHERE códigoEE = ?";
        String OBTENER_PROGRAMASEDU = "SELECT* FROM programasEducativos_ExperienciasEducativas WHERE códigoEE = ?";
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_EXPERIENCIA);
            statement.setString(1, codigo);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                experienciaEducativa.setCodigo(codigo);
                experienciaEducativa.setDescripcion(resultado.getString("descripcion"));
                experienciaEducativa.setNombreEE(resultado.getString("nombreEE"));
                experienciaEducativa.setNumeroDeCreditos(resultado.getInt("noCreditos"));
                statement = conexion.prepareStatement(OBTENER_PROGRAMASEDU);
                resultado = statement.executeQuery();
                ArrayList<ProgramaEducativo> programasEducativos = new ArrayList<ProgramaEducativo>();
                while(resultado.next()){
                    //AGREGAR PROGRAMAS EDUCATIVOS A EXPERIENCIA EDUCATIVA
                    ProgramaEducativo programaEducativo = new ProgramaEducativo();
                    programaEducativo.setNombrePE(resultado.getString("nombrePE"));
                    programasEducativos.add(programaEducativo);
                }
                experienciaEducativa.setProgramasEducativos(programasEducativos);
            }
        }catch(SQLException excepcion){
            
        }
        return experienciaEducativa;
    }
    
}
