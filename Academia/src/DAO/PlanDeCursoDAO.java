/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import basedatos.DataBase;
import clases.Bibliografia;
import clases.Curso;
import clases.PlanDeCurso;
import clases.Tema;
import clases.Unidad;
import interfacesdao.IPlanDeCursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class PlanDeCursoDAO implements IPlanDeCursoDAO{
    
    private static final String INSERTAR_PLAN = "INSERT INTO plancurso(objetivoGeneral, nrc, estado) VALUES (?,?,?)";
    private static final String INSERTAR_UNIDAD = "INSERT INTO unidades(noUnidad, nombre, fechas, tareasYPracticas, tecnicaDidactica, idPlan) VALUES (?,?,?,?,?,?)";
    private static final String INSERTAR_TEMA = "INSER INTO tema(nombreTema, idUnidad) VALUES (?,?)";
    private static final String INSERTAR_BIBLIOGRAFIA = "INSERT INTO bibliografia(autor, titulo, editorial, año, idPlan) VALUES (?,?,?,?,?)";
    private static final String OBTENER_ID_PLAN = "SELECT LAST_INSERT_ID(idPlan) FROM planCurso";
    private static final String OBTENER_ID_UNIDAD = "SELECT LAST_INSERT_ID(idUnidad) FROM unidades";
    private int idPlan = 0;
    private int idUnidad = 0;
    private Connection conexion;
    
    @Override
    public boolean agregarPlanDeCurso(PlanDeCurso planDeCurso) {
        boolean agregar = false;
        conexion = DataBase.getDataBaseConnection();
        try{
            //AGREGAR PLAN DE CURSO
            PreparedStatement statement = conexion.prepareStatement(INSERTAR_PLAN);
            statement.setString(1, planDeCurso.getObjetivoGeneral());
            statement.setInt(2, planDeCurso.getCurso().getNrc());
            statement.setString(3, planDeCurso.getEstado());
            statement.execute();
            ResultSet keyPlan = statement.executeQuery(OBTENER_ID_PLAN);
            while(keyPlan.next()){
                idPlan = keyPlan.getInt("LAST_INSERT_ID(idPlan)");
            }
            //AGREGAR UNIDAD
            for(int i = 0; i < planDeCurso.getUnidades().size(); i++){
                statement = conexion.prepareStatement(INSERTAR_UNIDAD);
                statement.setString(1, planDeCurso.getUnidades().get(i).getNumeroUnidad());
                statement.setString(2, planDeCurso.getUnidades().get(i).getNombre());
                statement.setDate(3, planDeCurso.getUnidades().get(i).getFecha());
                statement.setString(4, planDeCurso.getUnidades().get(i).getTareasYPracticas());
                statement.setString(5, planDeCurso.getUnidades().get(i).getTecnicaDidactica());
                statement.setInt(6, idPlan);
                statement.execute();
                ResultSet keyUnidad = statement.executeQuery(OBTENER_ID_UNIDAD);
                while(keyUnidad.next()){
                    idUnidad = keyUnidad.getInt("LAST_INSERT_ID(idUnidad)");
                }

                //AGREGAR TEMA
                for(int j = 0; j < planDeCurso.getUnidades().get(i).getTemas().size(); j++){
                    statement = conexion.prepareStatement(INSERTAR_TEMA);
                    statement.setString(1, planDeCurso.getUnidades().get(i).getTemas().get(j).getNombre());
                    statement.setInt(2, idUnidad);
                }
            }
            //AGREGAR BIBLIOGRAFIA
            for(int i = 0; i < planDeCurso.getBibliografias().size(); i++){
                statement = conexion.prepareStatement(INSERTAR_BIBLIOGRAFIA);
                statement.setString(1, planDeCurso.getBibliografias().get(i).getAutor());
                statement.setString(2, planDeCurso.getBibliografias().get(i).getTituloLibro());
                statement.setString(3, planDeCurso.getBibliografias().get(i).getEditorial());
                statement.setInt(4, planDeCurso.getBibliografias().get(i).getAnio());
                statement.setInt(5, idPlan);
                statement.execute();
            }
            //AGREGAR CRITERIO DE EVALUACION
            for(int i = 0; i < planDeCurso.getCriteriosDeEvaluacion().size(); i++){
                CriterioDeEvaluacionDAO criterioDeEvaluacionDAO = new CriterioDeEvaluacionDAO();
                criterioDeEvaluacionDAO.agregarCriterioDeEvaluacion(planDeCurso.getCriteriosDeEvaluacion().get(i));
            }
            agregar = true;
        }catch(SQLException excepcion){
            excepcion.printStackTrace();
        }
        return agregar;
    }

    @Override
    public PlanDeCurso obtenerPlanDeCursoPorCurso(Curso curso) {
        PlanDeCurso planDeCurso= new PlanDeCurso();
        ArrayList<Bibliografia> bibliografias = new ArrayList<Bibliografia>();
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        ArrayList<Tema> temas = new ArrayList<Tema>();
        
        String OBTENER_PLAN = "SELECT* FROM planCurso WHERE nrc = ?";
        String OBTENER_BIBLIOGRAFIAS = "SELECT* FROM bibliografia WHERE idPlan = ?";
        String OBTENER_UNIDADES = "SELECT* FROM unidades WHERE idPlan = ?";
        String OBTENER_TEMAS = "SELECT* FROM tema WHERE idUnidad = ?";
        int idPlan = 0;
        int idUnidad = 0;
        conexion = DataBase.getDataBaseConnection();
        try{
            //OBTENER PLAN DE CURSO
            PreparedStatement statement = conexion.prepareStatement(OBTENER_PLAN);
            statement.setInt(1, curso.getNrc());
            ResultSet resultadoPlan = statement.executeQuery();
            while(resultadoPlan.next()){
                planDeCurso.setObjetivoGeneral(resultadoPlan.getString("objetivoGeneral"));
                idPlan = resultadoPlan.getInt("idPlan");
            }
            //OBTENER BIBLIOGRAFIAS
            statement = conexion.prepareStatement(OBTENER_BIBLIOGRAFIAS);
            statement.setInt(1, idPlan);
            ResultSet resultadoBibliografia = statement.executeQuery();
            while(resultadoBibliografia.next()){
                Bibliografia bibliografia = new Bibliografia();
                bibliografia.setAutor(resultadoBibliografia.getString("autor"));
                bibliografia.setTituloLibro(resultadoBibliografia.getString("titulo"));
                bibliografia.setEditorial(resultadoBibliografia.getString("editorial"));
                bibliografia.setAnio(resultadoBibliografia.getInt("año"));
                bibliografias.add(bibliografia);
            }
            //OBTENER UNIDADES
            statement = conexion.prepareStatement(OBTENER_UNIDADES);
            statement.setInt(1, idPlan);
            ResultSet resultadoUnidad = statement.executeQuery();
            while(resultadoUnidad.next()){
                Unidad unidad = new Unidad();
                unidad.setFecha(resultadoUnidad.getDate("fechas"));
                unidad.setNombre(resultadoUnidad.getString("nombre"));
                unidad.setNumeroUnidad(resultadoUnidad.getString("noUnidad"));
                unidad.setTareasYPracticas(resultadoUnidad.getString("tareasYPracticas"));
                unidad.setTecnicaDidactica(resultadoUnidad.getString("tecnicaDidactica"));
                idUnidad = resultadoUnidad.getInt("idUnidad");
                //OBTENER TEMAS
                statement = conexion.prepareStatement(OBTENER_TEMAS);
                statement.setInt(1, idUnidad);
                ResultSet resultadoTema = statement.executeQuery();
                while(resultadoTema.next()){
                    Tema tema = new Tema();
                    tema.setNombre(resultadoTema.getString("nombreTema"));
                    temas.add(tema);
                }
                unidad.setTemas(temas);
                unidades.add(unidad);
            }
            //OBTENER CRITERIOS DE EVALUACION
            CriterioDeEvaluacionDAO criterioDeEvaluacionDAO = new CriterioDeEvaluacionDAO();
            
            planDeCurso.setCriteriosDeEvaluacion(criterioDeEvaluacionDAO.obtenerCriteriosDeEvaluacionPorExperienciaEducativa(curso.getExperienciaEducativa().getCodigo()));
            planDeCurso.setBibliografias(bibliografias);
            planDeCurso.setUnidades(unidades);
        }catch(SQLException excepcion){
            
        }
        return planDeCurso;
    }
    
}
