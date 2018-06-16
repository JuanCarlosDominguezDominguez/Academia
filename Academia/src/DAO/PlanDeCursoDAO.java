/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.Curso;
import clases.PlanDeCurso;
import interfacesdao.IPlanDeCursoDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juuan
 */
public class PlanDeCursoDAO implements IPlanDeCursoDAO{
    
    private static final String INSERTAR_PLAN = "INSERT INTO plancurso(objetivoGeneral, nombrePeriodo, nrc, estado) VALUES (?,?,?,?)";
    private static final String INSERTAR_UNIDAD = "INSERT INTO unidades(noUnidad, nombre, fechas, tareasYPracticas, tecnicaDidactica, idPlan) VALUES (?,?,?,?,?,?)";
    private static final String INSERTAR_TEMA = "INSER INTO tema(nombreTema, idUnidad) VALUES (?,?)";
    private static final String INSERTAR_BIBLIOGRAFIA = "INSERT INTO bibliografia(autor, titulo, editorial, año) VALUES (?,?,?,?)";
    private static final String INSERTAR_BIBLIOGRAFIA_PLAN = "INSERT INTO bibliografia_planCurso(bibliografia_idLibro, idPlan) VALUES(?,?)"; 
    private static final String INSERTAR_CRITERIO = "INSERT INTO criterioEvaluacion(noUnidad, creterioEvaluacion, fechas, istrumento, porcentaje, códigoEE, idPlan) VALUES(?,?,?,?,?,?,?S)";
    private Connection conexion;
    
    @Override
    public boolean agregarPlanDeCurso(PlanDeCurso planDeCurso) {
        boolean agregar = false;
        conexion = DataBase.getDataBaseConnection();
        try{
            //AGREGAR PLAN DE CURSO
            PreparedStatement statement = conexion.prepareStatement(INSERTAR_PLAN);
            statement.setString(1, planDeCurso.getObjetivoGeneral());
            statement.setString(2, planDeCurso.getCurso().getPeriodo().getNombrePeriodo());
            statement.setInt(3, planDeCurso.getCurso().getNrc());
            statement.setString(4, planDeCurso.getEstado());
            statement.execute();
            ResultSet keyPlan = statement.getGeneratedKeys();
            //AGREGAR UNIDAD
            for(int i = 0; i < planDeCurso.getUnidades().size(); i++){
                statement = conexion.prepareStatement(INSERTAR_UNIDAD);
                statement.setString(1, planDeCurso.getUnidades().get(i).getNumeroUnidad());
                statement.setString(2, planDeCurso.getUnidades().get(i).getNombre());
                statement.setDate(3, (Date)planDeCurso.getUnidades().get(i).getFecha());
                statement.setString(4, planDeCurso.getUnidades().get(i).getTareasYPracticas());
                statement.setString(5, planDeCurso.getUnidades().get(i).getTecnicaDidactica());
                statement.setInt(6, keyPlan.getInt("idPlan"));
                statement.execute();
                ResultSet keyUnidad = statement.getGeneratedKeys();
                //AGREGAR TEMA
                for(int j = 0; j < planDeCurso.getUnidades().get(i).getTemas().size(); i++){
                    statement = conexion.prepareStatement(INSERTAR_TEMA);
                    statement.setString(1, planDeCurso.getUnidades().get(i).getTemas().get(j).getNombre());
                    statement.setInt(2, keyUnidad.getInt("idUnidad"));
                }
            }
            //AGREGAR BIBLIOGRAFIA
            for(int i = 0; i < planDeCurso.getBibliografias().size(); i++){
                statement = conexion.prepareStatement(INSERTAR_BIBLIOGRAFIA);
                statement.setString(1, planDeCurso.getBibliografias().get(i).getAutor());
                statement.setString(2, planDeCurso.getBibliografias().get(i).getTituloLibro());
                statement.setString(3, planDeCurso.getBibliografias().get(i).getEditorial());
                statement.setInt(4, planDeCurso.getBibliografias().get(i).getAnio());
                statement.execute();
                ResultSet keyBibliografia = statement.getGeneratedKeys();
                statement = conexion.prepareStatement(INSERTAR_BIBLIOGRAFIA_PLAN);
                statement.setInt(1, keyBibliografia.getInt("bibliografia_idLibro"));
                statement.setInt(2, keyPlan.getInt("idPlan"));
            }
            //AGREGAR CRITERIO DE EVALUACION
            agregar = true;
        }catch(SQLException excepcion){
            
        }
        return agregar;
    }

    @Override
    public boolean eliminarPlanDeCurso(int idPlan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanDeCurso obetenerPlanDeCurso(int idPlan) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
