/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
        String userName = "root";
        String password = "12345";
        try {
            connection = (Connection)DriverManager.getConnection(url+databaseName,userName,password);
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
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
            } catch (SQLException ex) {
                Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
