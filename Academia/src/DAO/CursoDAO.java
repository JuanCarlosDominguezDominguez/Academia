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
import java.util.logging.Level;

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
            ResultSet resultadoNrc = statement.executeQuery();
            while(resultadoNrc.next()){
                Curso curso = new Curso();
                curso.setNrc(resultadoNrc.getInt("nrc"));
                statement = conexion.prepareStatement(OBTENER_CURSO);
                statement.setInt(1, curso.getNrc());
                ResultSet resultadoCurso = statement.executeQuery();
                while(resultadoCurso.next()){
                    curso.setBloque(resultadoCurso.getInt("bloque"));
                    curso.setSeccion(resultadoCurso.getInt("sección"));
                    //AGREGAR EXPERIENCIA EDUCATIVA A CURSO
                    ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
                    curso.setExperienciaEducativa(experienciaEducativaDAO.obtenerExperienciaEducativa(resultadoCurso.getString("códigoEE")));
                    //AGREGAR PERIODO A CURSO
                    PeriodoDAO periodoDAO = new PeriodoDAO();
                    curso.setPeriodo(periodoDAO.obtenerPeriodo(resultadoCurso.getString("nombrePeriodo")));
                }
                cursos.add(curso);
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return cursos;
    }
    
}
