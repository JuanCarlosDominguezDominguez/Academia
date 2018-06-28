/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.CriterioDeEvaluacion;
import interfacesdao.ICriterioDeEvaluacionDAO;
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
public class CriterioDeEvaluacionDAO implements ICriterioDeEvaluacionDAO{
    private Connection conexion;
    private static final String INSERTAR_CRITERIO = "INSERT INTO criterioEvaluacion(unidadesEvaluadas, criterioEvaluacion, fechas, instrumento, porcentaje, códigoEE, idPlan) VALUES(?,?,?,?,?,?,?)";

    @Override
    public boolean agregarCriterioDeEvaluacion(CriterioDeEvaluacion criterioDeEvaluacion) {
        boolean agregar = false;
        conexion = DataBase.getDataBaseConnection();
        try{
            PreparedStatement statement = conexion.prepareStatement(INSERTAR_CRITERIO);
            statement.setString(1, criterioDeEvaluacion.getUnidadesEvaluadas());
            statement.setString(2, criterioDeEvaluacion.getCriterioEvaluacion());
            statement.setString(3, String.valueOf(criterioDeEvaluacion.getFecha()));
            statement.setString(4, criterioDeEvaluacion.getInstrumento());
            statement.setString(5, criterioDeEvaluacion.getPorcentaje());
            statement.setString(6, criterioDeEvaluacion.getExperienciaEducativa().getCodigo());
            statement.setInt(7, 4);
            statement.execute();
            agregar = true;
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(CriterioDeEvaluacionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CriterioDeEvaluacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return agregar;
    }

    @Override
    public ArrayList<CriterioDeEvaluacion> obtenerCriteriosDeEvaluacionPorExperienciaEducativa(String codigoEE) {
        ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion = new ArrayList<CriterioDeEvaluacion>();
        String OBTENER_CRITERIO = "SELECT* FROM criterioEvaluacion WHERE códigoEE = ?";
        conexion = DataBase.getDataBaseConnection();
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_CRITERIO);
            statement.setString(1, codigoEE);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                CriterioDeEvaluacion criterioDeEvaluacion = new CriterioDeEvaluacion();
                criterioDeEvaluacion.setUnidadesEvaluadas(resultado.getString("unidadesEvaluadas"));
                criterioDeEvaluacion.setCriterioEvaluacion(resultado.getString("criterioEvaluacion"));
                criterioDeEvaluacion.setFecha(resultado.getDate("fechas"));
                criterioDeEvaluacion.setInstrumento(resultado.getString("instrumento"));
                criterioDeEvaluacion.setPorcentaje(resultado.getString("porcentaje"));
                criteriosDeEvaluacion.add(criterioDeEvaluacion);
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(CriterioDeEvaluacionDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(CriterioDeEvaluacionDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return criteriosDeEvaluacion;
    }
    
}
