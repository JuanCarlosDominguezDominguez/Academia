/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacesdao;

import clases.PlanDeCurso;
import java.util.List;

/**
 *
 * @author Juuan
 */
public interface IPlanDeCursoDAO {
    boolean agregarPlanDeCurso(PlanDeCurso planDeCurso);
    boolean eliminarPlanDeCurso(int idPlan);
    PlanDeCurso obetenerPlanDeCurso(int idPlan);
    List<PlanDeCurso> obtenerTodosLosPlanesDeCurso();
}
