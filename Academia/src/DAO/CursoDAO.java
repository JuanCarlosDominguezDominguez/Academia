/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.Curso;
import interfacesdao.ICursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class CursoDAO implements ICursoDAO{
    private Connection conexion;
    
    @Override
    public ArrayList<Curso> obtenerCursosPorProfesor(String numeroDePersonal) {
        conexion = DataBase.getDataBaseConnection();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        String OBTENER_NRC = "SELECT* FROM profesor_Cursos WHERE numeroPersonal = ?";
        String OBTENER_CURSO = "SELECT* FROM cursos WHERE nrc = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_NRC);
            statement.setString(1, numeroDePersonal);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                Curso curso = new Curso();
                curso.setNrc(resultado.getInt("nrc"));
                statement = conexion.prepareStatement(OBTENER_CURSO);
                resultado = statement.executeQuery();
                while(resultado.next()){
                    curso.setBloque(resultado.getInt("bloque"));
                    curso.setSeccion(resultado.getInt("sección"));
                    //AGREGAR EXPERIENCIA EDUCATIVA A CURSO
                    ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
                    curso.setExperienciaEducativa(experienciaEducativaDAO.obtenerExperienciaEducativa(resultado.getString("códigoEE")));
                    //AGREGAR PERIODO A CURSO
                    PeriodoDAO periodoDAO = new PeriodoDAO();
                    curso.setPeriodo(periodoDAO.obtenerPeriodo(resultado.getString("nombrePeriodo")));
                }
            }
        }catch(SQLException excepcion){
            
        }
        return cursos;
    }

    @Override
    public Curso obtenerCursoDeExperienciaEducativa(String codigoEE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Curso obtenerCursoPorNrc(int nrc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
