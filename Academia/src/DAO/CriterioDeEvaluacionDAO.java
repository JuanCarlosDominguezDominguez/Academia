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
import java.sql.SQLException;

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
            excepcion.printStackTrace();
        }
        return agregar;
    }
    
}
