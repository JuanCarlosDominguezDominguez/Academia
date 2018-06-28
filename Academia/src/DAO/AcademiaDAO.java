/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.2.3
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package DAO;

import basedatos.DataBase;
import clases.Academia;
import clases.Profesor;
import interfacesdao.IAcademiaDAO;
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
public class AcademiaDAO implements IAcademiaDAO{
    private Connection conexion;
    @Override
    public ArrayList<Academia> obtenerTodasLasAcademiasPorProfesor(String numeroDePersonal) {
        conexion = DataBase.getDataBaseConnection();
        ArrayList<Academia> academias = new ArrayList<Academia>();
        String OBTENER_NOMBRE_ACADEMIA = "SELECT* FROM academias_Profesores WHERE numeroPersonal = ?";
        String OBTENER_COORDINADOR = "SELECT numeroCoordinador FROM academias WHERE nombreAcademia = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_NOMBRE_ACADEMIA);
            statement.setString(1, numeroDePersonal);
            ResultSet resultadoAcademia = statement.executeQuery();
            //SE OBTIENE LA ACADEMIA
            while(resultadoAcademia.next()){
                Academia academia = new Academia();
                academia.setNombreAcademia(resultadoAcademia.getString("nombreAcademia"));
                statement = conexion.prepareStatement(OBTENER_COORDINADOR);
                statement.setString(1, academia.getNombreAcademia());
                ResultSet resultadoCoordinador = statement.executeQuery();
                //SE OBTIENE EL COORDINADOR POR CADA  Y SE LE ASIGNA A CADA ACADEMIA
                while (resultadoCoordinador.next()){
                    Profesor coordinador = new Profesor();
                    coordinador.setNumeroDePersonal(resultadoCoordinador.getString("numeroCoordinador"));
                    academia.setCoordinadorDeAcademia(coordinador);
                }
                //SE AGREGAN TODAS LAS EXPERIENCIAS EDUCATIVAS POR ACADEMIA
                ExperienciaEducativaDAO experienciaEducativaDAO = new ExperienciaEducativaDAO();
                academia.setExperienciasEducativas(experienciaEducativaDAO.obtenerExperienciasEducativasPorAcademia(academia.getNombreAcademia()));
                academias.add(academia);
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return academias;
    }

    @Override
    public Academia obtenerAcademiaPorExperienciaEducativa(String codigoEE) {
        conexion = DataBase.getDataBaseConnection();
        Academia academia = new Academia();
        String OBTENER_ACADEMIA = "SELECT* FROM experienciasEducativas_academias WHERE códigoEE = ?";
        String OBTENER_COORDINADOR = "SELECT numeroCoordinador FROM academias WHERE nombreAcademia = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_ACADEMIA);
            statement.setString(1, codigoEE);
            ResultSet resultadoAcademia = statement.executeQuery();
            //SE OBTIENE LA ACADEMIA
            while(resultadoAcademia.next()){
                academia.setNombreAcademia(resultadoAcademia.getString("nombreAcademia"));
                statement = conexion.prepareStatement(OBTENER_COORDINADOR);
                statement.setString(1, academia.getNombreAcademia());
                ResultSet resultadoCoordinador = statement.executeQuery();
                //SE AGREGAR EL COORDINADOR DE DICHA ACADEMIA
                while(resultadoCoordinador.next()){
                    Profesor coordinador = new Profesor();
                    coordinador.setNumeroDePersonal(resultadoCoordinador.getString("numeroCoordinador"));
                    academia.setCoordinadorDeAcademia(coordinador);
                }
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return academia;
    }
}
