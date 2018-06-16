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
                    System.out.println(academia.getNombreAcademia());
                }
                academias.add(academia);
            }
        }catch(SQLException excepcion){
            
        }
        return academias;
    }

    @Override
    public List<Academia> obtenerTodasLasAcademiasPorExperienciaEducativa(String codigoEE) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Academia obtenerAcademiaPorNombre(String nombreAcademia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
