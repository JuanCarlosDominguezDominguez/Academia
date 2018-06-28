/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.2.7
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package DAO;

import basedatos.DataBase;
import clases.Periodo;
import interfacesdao.IPeriodoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author Juuan
 */
public class PeriodoDAO implements IPeriodoDAO{
    private Connection conexion;
    @Override
    public Periodo obtenerPeriodo(String nombrePeriodo) {
        conexion = DataBase.getDataBaseConnection();
        Periodo periodo = new Periodo();
        String OBTENER_PERIODO = "SELECT* FROM periodo WHERE nombrePeriodo = ?";
        try{
            PreparedStatement statement = conexion.prepareStatement(OBTENER_PERIODO);
            statement.setString(1, nombrePeriodo);
            ResultSet resultado = statement.executeQuery();
            //SE OBTIENE EL PERIODO
            while(resultado.next()){
                periodo.setNombrePeriodo(nombrePeriodo);
                periodo.setFechaFin(resultado.getDate("fechaFin"));
                periodo.setFechaInicio(resultado.getDate("fechaComienzo"));
            }
        }catch(SQLException excepcion){
            java.util.logging.Logger.getLogger(PeriodoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }catch(NullPointerException excepcion){
            java.util.logging.Logger.getLogger(PeriodoDAO.class.getName()).log(Level.SEVERE, null, excepcion);
        }finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(PeriodoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return periodo;
    }
    
}
