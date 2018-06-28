/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.5.3
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
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
            //SE OBTIENE EL CURSO
            while(resultadoNrc.next()){
                Curso curso = new Curso();
                curso.setNrc(resultadoNrc.getInt("nrc"));
                statement = conexion.prepareStatement(OBTENER_CURSO);
                statement.setInt(1, curso.getNrc());
                ResultSet resultadoCurso = statement.executeQuery();
                while(resultadoCurso.next()){
                    curso.setBloque(resultadoCurso.getInt("bloque"));
                    curso.setSeccion(resultadoCurso.getInt("sección"));
                    //AGREGAR EXPERIENCIA EDUCATIVA POR CURSO RESPECTIVAMENTE
                    ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
                    curso.setExperienciaEducativa(experienciaEducativaDAO.obtenerExperienciaEducativa(resultadoCurso.getString("códigoEE")));
                    //AGREGAR PERIODO POR CURSO RESPECTIVAMENTE
                    PeriodoDAO periodoDAO = new PeriodoDAO();
                    curso.setPeriodo(periodoDAO.obtenerPeriodo(resultadoCurso.getString("nombrePeriodo")));
                }
                cursos.add(curso);
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
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

    @Override
    public Curso obtenerCursoDeExperienciaEducativa(String codigo) {
        conexion = DataBase.getDataBaseConnection();
        Curso curso = new Curso();
        String OBTENER_CURSO = "SELECT* FROM cursos WHERE códigoEE = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_CURSO);
            statement.setString(1, codigo);
            ResultSet resultadoCurso = statement.executeQuery();
            while(resultadoCurso.next()){
                curso.setBloque(resultadoCurso.getInt("bloque"));
                curso.setNrc(resultadoCurso.getInt("nrc"));
                curso.setSeccion(resultadoCurso.getInt("sección"));
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CursoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return curso;
    }
}
