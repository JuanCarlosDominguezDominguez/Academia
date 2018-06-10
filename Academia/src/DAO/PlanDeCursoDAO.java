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
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Juuan
 */
public class PlanDeCursoDAO implements IPlanDeCursoDAO{
    
    private static final String INSERT_PLAN = "INSERT INTO plancurso(objetivoGeneral, nombrePeriodo, nrc, estado) VALUES (?,?,?,?)";
    private Connection conexion;
    
    @Override
    public boolean agregarPlanDeCurso(PlanDeCurso planDeCurso) {
        boolean agregar = false;
        conexion = DataBase.getDataBaseConnection();
        Curso curso = new Curso();
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        cursos = planDeCurso.getPeriodo().getCursos();
        for (int i=0; i < cursos.size() ; i++){
            if (cursos.get(i).getNrc() == ){
                
            }
        }
        try{
            PreparedStatement statement = conexion.prepareStatement(INSERT_PLAN);
            statement.setString(1, planDeCurso.getObjetivoGeneral());
            statement.setString(2, planDeCurso.getPeriodo().getNombrePeriodo());
            statement.setString(3, planDeCurso.getPeriodo().getCursos());
            statement.setString(4, "estado");
            
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

    @Override
    public List<PlanDeCurso> obtenerTodosLosPlanesDeCurso() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
