/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.4.6
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package DAO;

import basedatos.DataBase;
import clases.Profesor;
import interfacesdao.IProfesorDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Juuan
 */
public class ProfesorDAO implements IProfesorDAO{
    private Connection conexion;
    @Override
    public Profesor obtenerProfesor(String numeroDePersonal) {
        conexion = DataBase.getDataBaseConnection();
        Profesor profesor = new Profesor();
        String OBTENER_PROFESOR = "SELECT* FROM profesores WHERE numeroPersonal = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_PROFESOR);
            statement.setString(1, numeroDePersonal);
            ResultSet resultado  = statement.executeQuery();
            //SE OBTIENE EL PROFESOR
            while(resultado.next()){
                profesor.setNumeroDePersonal(numeroDePersonal);
                profesor.setNombre(resultado.getString("Nombre"));
                profesor.setGradoAcademico(resultado.getString("gradoAcadémico"));
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ProfesorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return profesor;
    }
    
}
