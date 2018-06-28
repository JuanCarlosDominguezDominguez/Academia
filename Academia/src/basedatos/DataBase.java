/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.6
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juuan
 */
public class DataBase {
    private static Connection connection;   
    
    private static void makeConnection(){
        String url= "jdbc:mysql://localhost/";
        String databaseName = "academia";
        String userName = "juan";
        String password = "12345";
        try {
            connection = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
        } catch (SQLException excepcion) {
            java.util.logging.Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, excepcion);
        } 
    }
    
    public static Connection getDataBaseConnection() {        
        makeConnection();
        return DataBase.connection;
 
    }
    
    public static void closeConnection(){
        if(connection!=null){
            try {
                if(!connection.isClosed()){
                    connection.close();                
                }
            } catch (SQLException excepcion) {
                java.util.logging.Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, excepcion);
            }
        }
    }
}
