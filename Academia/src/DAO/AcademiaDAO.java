/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            while(resultadoAcademia.next()){
                Academia academia = new Academia();
                academia.setNombreAcademia(resultadoAcademia.getString("nombreAcademia"));
                statement = conexion.prepareStatement(OBTENER_COORDINADOR);
                statement.setString(1, academia.getNombreAcademia());
                ResultSet resultadoCoordinador = statement.executeQuery();
                while (resultadoCoordinador.next()){
                    Profesor coordinador = new Profesor();
                    coordinador.setNumeroDePersonal(resultadoCoordinador.getString("numeroCoordinador"));
                    academia.setCoordinadorDeAcademia(coordinador);
                }
                academias.add(academia);
            }
        }catch(SQLException excepcion){
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
            while(resultadoAcademia.next()){
                academia.setNombreAcademia(resultadoAcademia.getString("nombreAcademia"));
                statement = conexion.prepareStatement(OBTENER_COORDINADOR);
                statement.setString(1, academia.getNombreAcademia());
                ResultSet resultadoCoordinador = statement.executeQuery();
                while(resultadoCoordinador.next()){
                    Profesor coordinador = new Profesor();
                    coordinador.setNumeroDePersonal(resultadoCoordinador.getString("numeroCoordinador"));
                    academia.setCoordinadorDeAcademia(coordinador);
                }
            }
        }catch(SQLException excepcion){
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
