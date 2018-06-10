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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juuan
 */
public class AcademiaDAO implements IAcademiaDAO{
    private static final String OBTENER_ACADEMIA = "SELECT* FROM academia WHERE nombreAcademia = ?";
    private static final String OBTENER_NUMEROPERSONAL = "SELECT numeroPersonal FROM academias_profesores where nombreAcademia = ?";
    private Connection conexion;
    
    @Override
    public Academia obtenerAcademiaPorNombre(String nombreAcademia) {
        Academia academia = new Academia();
        ArrayList<Profesor> profesores = new ArrayList<Profesor>();
        conexion = DataBase.getDataBaseConnection();
        try{
            //OBTENER NOMBRE DE LA CADEMIA
            PreparedStatement statement = conexion.prepareStatement(OBTENER_ACADEMIA);
            statement.setString(1, nombreAcademia);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                academia.setNombreAcademia(resultado.getString("nombreAcademia"));
            }
            //OBTENER EL NUMERO DE PERSONAL DE LOS PROFESORES DE DICHA ACADEMIA
            statement = conexion.prepareStatement(OBTENER_NUMEROPERSONAL);
            statement.setString(0, nombreAcademia);
            Profesor profesor = new Profesor();
            while(resultado.next()){
                profesor.setAcademias(academia);
                profedor
            }
        }catch(SQLException excepcion){
            Logger.getLogger(AcademiaDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            DataBase.closeConnection();
        }
        return academia;
    }
    
}
