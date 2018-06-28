/*

 *  Derechos de autor: UV-software(c)
 *  @auto: Juan Carlos Domínguez Dominguez
 *  @nombre: Control de academias
 *  @versión 0.1.2
 *  Este producto no puede ser intercambiado bajo ninguna circunstancia
	
 */

package clases;

import java.util.Date;

/**
 *
 * @author Juuan
 */
public class Periodo {
    private Date fechaInicio;
    private Date fechaFin;
    private String nombrePeriodo;

    public Periodo() {
    }

    public Periodo(Date fechaInicio, Date fechaFin, String nombrePeriodo) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.nombrePeriodo = nombrePeriodo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getNombrePeriodo() {
        return nombrePeriodo;
    }

    public void setNombrePeriodo(String nombrePeriodo) {
        this.nombrePeriodo = nombrePeriodo;
    }

    
}
