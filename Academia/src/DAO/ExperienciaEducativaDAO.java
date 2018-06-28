/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.4.0
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
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
            //SE OBTIENE LA EXPERIENCIA EDUCATIVA
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
                //AGREGAR ACADEMIA A LA QUE PERTENECEN
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

    @Override
    public ArrayList<ExperienciaEducativa> obtenerExperienciasEducativasPorAcademia(String nombreAcademia) {
        String OBTENER_CODIGOS_EE = "SELECT* FROM experienciasEducativas_academias WHERE nombreAcademia = ?";
        String OBTENER_EXPERIENCIAS_EDUCATIVAS = "SELECT* FROM experienciasEducativas WHERE códigoEE = ?";
        conexion = DataBase.getDataBaseConnection();
        ArrayList<ExperienciaEducativa> experienciasEducativas = new ArrayList<ExperienciaEducativa>();
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_CODIGOS_EE);
            statement.setString(1, nombreAcademia);
            ResultSet resultadoCodigo = statement.executeQuery();
            String codigoEE = "";
            //OBTENER CODIGO DE LAS EXPERIENCIAS EDUCATIVAS
            while(resultadoCodigo.next()){
                codigoEE = resultadoCodigo.getString("códigoEE");
                statement = conexion.prepareStatement(OBTENER_EXPERIENCIAS_EDUCATIVAS);
                statement.setString(1, codigoEE);
                ResultSet resultadoExperiencias = statement.executeQuery();
                //SE AGREGAN LAS EXPERIENCIAS EDUCATIVAS
                while(resultadoExperiencias.next()){
                    ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
                    experienciaEducativa.setCodigo(codigoEE);
                    experienciaEducativa.setDescripcion(resultadoExperiencias.getString("descripcion"));
                    experienciaEducativa.setNombreEE(resultadoExperiencias.getString("nombreEE"));
                    experienciaEducativa.setNumeroDeCreditos(resultadoExperiencias.getInt("noCreditos"));
                    CursoDAO cursoDAO = new CursoDAO();
                    experienciaEducativa.setCurso(cursoDAO.obtenerCursoDeExperienciaEducativa(codigoEE));
                    //SE AGREGAN LOS DATOS 
                    experienciasEducativas.add(experienciaEducativa);
                }
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ExperienciaEducativaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return experienciasEducativas;
    }
    
}
