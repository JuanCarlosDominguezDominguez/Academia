/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Juuan
 */
public class conexion {
    private static final String USUARIO = "revo";
	private static final String PASS = "elrevo";
	private static final String HOST = "localhost";
	private static final String PORT = "3306";
	private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/academia?zeroDateTimeBehavior=CONVERT_TO_NULL&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(URL, USUARIO, PASS);
	}
}
