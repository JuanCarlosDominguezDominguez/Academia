/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.Academia;
import clases.ExperienciaEducativa;
import clases.Profesor;
import clases.ProgramaEducativo;
import interfacesdao.IExperienciaEducativaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            ResultSet resultadoExperiencia = statement.executeQuery();
            while(resultadoExperiencia.next()){
                experienciaEducativa.setCodigo(codigo);
                experienciaEducativa.setDescripcion(resultadoExperiencia.getString("descripcion"));
                experienciaEducativa.setNombreEE(resultadoExperiencia.getString("nombreEE"));
                experienciaEducativa.setNumeroDeCreditos(resultadoExperiencia.getInt("noCreditos"));
                //AGREGAR PROGRAMAS EDUCATIVOS A EXPERIENCIA EDUCATIVA
                statement = conexion.prepareStatement(OBTENER_PROGRAMASEDU);
                statement.setString(1, codigo);
                ResultSet resultadoPrograma = statement.executeQuery();
                ArrayList<ProgramaEducativo> programasEducativos = new ArrayList<ProgramaEducativo>();
                while(resultadoPrograma.next()){
                    ProgramaEducativo programaEducativo = new ProgramaEducativo();
                    programaEducativo.setNombrePE(resultadoPrograma.getString("nombrePE"));
                    programasEducativos.add(programaEducativo);
                }
                experienciaEducativa.setProgramasEducativos(programasEducativos);
                AcademiaDAO academiaDAO = new AcademiaDAO();
                experienciaEducativa.setAcademia(academiaDAO.obtenerAcademiaPorExperienciaEducativa(experienciaEducativa.getCodigo()));
            }
        }catch(SQLException excepcion){
            Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException excepcion) {
                System.out.println("hola");
                java.util.logging.Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
            }
        }
        
        return experienciaEducativa;
    }
    
}
