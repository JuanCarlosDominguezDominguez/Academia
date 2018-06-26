/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Juuan
 */
public class Unidad {
    private String numeroUnidad;
    private String nombre;
    private Date fecha;
    private String tareasYPracticas;
    private String tecnicaDidactica;
    private ArrayList<Tema> temas;

    public Unidad() {
    }

    public Unidad(String numeroUnidad, String nombre, Date fecha, String tareasYPracticas, String tecnicaDidactica, ArrayList<Tema> temas) {
        this.numeroUnidad = numeroUnidad;
        this.nombre = nombre;
        this.fecha = fecha;
        this.tareasYPracticas = tareasYPracticas;
        this.tecnicaDidactica = tecnicaDidactica;
        this.temas = temas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNumeroUnidad() {
        return numeroUnidad;
    }

    public void setNumeroUnidad(String numeroUnidad) {
        this.numeroUnidad = numeroUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTareasYPracticas() {
        return tareasYPracticas;
    }

    public void setTareasYPracticas(String tareasYPracticas) {
        this.tareasYPracticas = tareasYPracticas;
    }

    public String getTecnicaDidactica() {
        return tecnicaDidactica;
    }

    public void setTecnicaDidactica(String tecnicaDidactica) {
        this.tecnicaDidactica = tecnicaDidactica;
    }

    public ArrayList<Tema> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<Tema> temas) {
        this.temas = temas;
    }
    
    
}
