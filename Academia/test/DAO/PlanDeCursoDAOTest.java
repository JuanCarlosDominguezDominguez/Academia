/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.9
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package DAO;

import clases.Bibliografia;
import clases.CriterioDeEvaluacion;
import clases.Curso;
import clases.ExperienciaEducativa;
import clases.PlanDeCurso;
import clases.Tema;
import clases.Unidad;
import java.sql.Date;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuan
 */
public class PlanDeCursoDAOTest {
    private PlanDeCursoDAO planDeCursoDAO;
    public PlanDeCursoDAOTest() {
        planDeCursoDAO = new PlanDeCursoDAO();
    }

    @Test
    public void agregarPlanDeCursoNull() {
        PlanDeCurso planDeCurso = new PlanDeCurso();
        planDeCurso = null;
        boolean valorObtenido = planDeCursoDAO.agregarPlanDeCurso(planDeCurso);
        boolean valorEsperado = false;
        assertEquals("Plan de curso nulo", valorEsperado, valorObtenido);
    }
    
    @Test
    public void agregarPlanDeCursoCompleto(){
        ArrayList<Tema> temas = new ArrayList<Tema>();
        ArrayList<Unidad> unidades = new ArrayList<Unidad>();
        ArrayList<CriterioDeEvaluacion> criteriosDeEvaluacion = new ArrayList<CriterioDeEvaluacion>();
        ArrayList<Bibliografia> bibliografias = new ArrayList<Bibliografia>();
        PlanDeCurso planDeCurso = new PlanDeCurso();
        Unidad unidad = new Unidad();
        Tema tema = new Tema();
        Bibliografia bibliografia = new Bibliografia();
        CriterioDeEvaluacion criterioDeEvaluacion = new CriterioDeEvaluacion();
        Curso curso = new Curso();
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        
        curso.setNrc(76655);
        experienciaEducativa.setCodigo("PCS001");
        
        tema.setNombre("Prueba Tema");
        temas.add(tema);
        Date fecha = Date.valueOf("2018-10-10");
        unidad.setFecha(fecha);
        unidad.setNombre("Prueba");
        unidad.setNumeroUnidad("1");
        unidad.setTareasYPracticas("Prueba");
        unidad.setTecnicaDidactica("Prueba");
        unidad.setTemas(temas);
        unidades.add(unidad);
        
        bibliografia.setAnio(2018);
        bibliografia.setAutor("Juan");
        bibliografia.setEditorial("Xalapa");
        bibliografia.setTituloLibro("Construccion");
        bibliografias.add(bibliografia);
        
        criterioDeEvaluacion.setCriterioEvaluacion("Prueba");
        criterioDeEvaluacion.setFecha(fecha);
        criterioDeEvaluacion.setInstrumento("Prueba");
        criterioDeEvaluacion.setPorcentaje("20");
        criterioDeEvaluacion.setUnidadesEvaluadas("1-3");
        criterioDeEvaluacion.setExperienciaEducativa(experienciaEducativa);
        criteriosDeEvaluacion.add(criterioDeEvaluacion);
        
        planDeCurso.setBibliografias(bibliografias);
        planDeCurso.setCriteriosDeEvaluacion(criteriosDeEvaluacion);
        planDeCurso.setUnidades(unidades);
        planDeCurso.setEstado("Completo");
        planDeCurso.setObjetivoGeneral("Prueba");
        planDeCurso.setCurso(curso);
        
        boolean valorObtenido = planDeCursoDAO.agregarPlanDeCurso(planDeCurso);
        boolean valorEsperado = true;
        assertEquals("Plan de curso completo", valorEsperado, valorObtenido);
    }
    
}
