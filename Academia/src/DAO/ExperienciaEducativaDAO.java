/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.Curso;
import clases.ExperienciaEducativa;
import interfacesdao.IExperienciaEducativaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Juuan
 */
public class ExperienciaEducativaDAO implements IExperienciaEducativaDAO{
    private static final String OBTENER_EE = "SELECT* FROM experienciaseducativas WHERE códigoEE = ?";
    private static final String OBTENER_CURSO = "SELECT* FROM cursos WHERE códigoEE = ?";
    private Connection conexion;
    
    @Override
    public ExperienciaEducativa obtenerExperienciaEducativa(String codigo) {
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        conexion = DataBase.getDataBaseConnection();
        try{
            //OBTENER EXPERIENCIA EDUCATIVA
            PreparedStatement statement = conexion.prepareStatement(OBTENER_EE);
            statement.setString(1, codigo);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                experienciaEducativa.setCodigo(resultado.getString("códigoEE"));
                experienciaEducativa.setDescripcion(resultado.getString("descripcion"));
                experienciaEducativa.setNombreEE(resultado.getString("nombreEE"));
                experienciaEducativa.setNumeroDeCreditos(resultado.getInt("noCreditos"));
            }
            
            //OBTENER CURSO
            Curso curso = new Curso();
            statement = conexion.prepareStatement(OBTENER_CURSO);
            statement.setString(1, codigo);
            resultado = statement.executeQuery();
            while(resultado.next()){
                curso.setBloque(resultado.getInt("bloque"));
                curso.setExperienciaEducativa(experienciaEducativa);
                curso.setNrc(resultado.getString("nrc"));
                curso.setPeriodo();
                
            }
        }catch(SQLException excepcion){
            
        }
        return experienciaEducativa;
    }
    
}
