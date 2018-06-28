/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.4
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package DAO;

import clases.CriterioDeEvaluacion;
import clases.ExperienciaEducativa;
import java.sql.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Juuan
 */
public class CriterioDeEvaluacionDAOTest {
    private CriterioDeEvaluacionDAO criterioDeEvaluacionDAO;
    
    public CriterioDeEvaluacionDAOTest() {
        criterioDeEvaluacionDAO = new CriterioDeEvaluacionDAO();
    }

    @Test
    public void agregarCriterioDeEvaluacionNull() {
        CriterioDeEvaluacion criterioDeEvaluacion = new CriterioDeEvaluacion();
        criterioDeEvaluacion = null;
        boolean valorObtenido = criterioDeEvaluacionDAO.agregarCriterioDeEvaluacion(criterioDeEvaluacion);
        boolean valorEsperado = false;
        assertEquals("Criterio De Evaluacion vacio", valorEsperado, valorObtenido);
    }
    
    @Test
    public void agregarCriterioDeEvaluacionCompleto(){
        CriterioDeEvaluacion criterioDeEvaluacion = new CriterioDeEvaluacion();
        ExperienciaEducativa experienciaEducativa = new ExperienciaEducativa();
        experienciaEducativa.setCodigo("PCS001");
        criterioDeEvaluacion.setCriterioEvaluacion("Prueba");
        criterioDeEvaluacion.setInstrumento("Prueba");
        criterioDeEvaluacion.setPorcentaje("20");
        criterioDeEvaluacion.setUnidadesEvaluadas("1-3");
        Date fecha = Date.valueOf("2018-10-10");
        criterioDeEvaluacion.setFecha(fecha);
        criterioDeEvaluacion.setExperienciaEducativa(experienciaEducativa);
        boolean valorObtenido = criterioDeEvaluacionDAO.agregarCriterioDeEvaluacion(criterioDeEvaluacion);
        boolean valorEsperado = true;
        assertEquals("Criterio de evaluacion completo", valorEsperado, valorObtenido);
    }
    
}
