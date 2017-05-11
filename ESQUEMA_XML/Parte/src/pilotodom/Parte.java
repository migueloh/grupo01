/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotodom;

import UML.Vehiculo;
import UML.Viaje;
import java.util.ArrayList;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author Iker
 */
public class Parte {
 private    String idParte;
  private   Date fecha;
  private   Double kmInicio;
  private   Double kmFinal;
  private   boolean finalizado;
  private   Double gasoil;
   private Double autopista;
  private   Double dietas;
  private   Double otrosGastos;
   private  String incidencias;
  private   Double horasTRabajadas;
  private   tAdministrador tA;
   private  tLogistica tL;
  private   Vehiculo V;
  private   ArrayList<Viaje> listViajes;

    public Parte() {
    }

    public Parte(String idParte, Date fecha, Double kmInicio, Double kmFinal, boolean finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTRabajadas) {
        this.idParte = idParte;
        this.fecha = fecha;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.finalizado = finalizado;
        this.gasoil = gasoil;
        this.autopista = autopista;
        this.dietas = dietas;
        this.otrosGastos = otrosGastos;
        this.incidencias = incidencias;
        this.horasTRabajadas = horasTRabajadas;
        listViajes=  new ArrayList();
    }

    public Parte(String idParte, Date fecha, Double kmInicio, Double kmFinal, boolean finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTRabajadas, ArrayList<Viaje> listViajes) {
        this.idParte = idParte;
        this.fecha = fecha;
        this.kmInicio = kmInicio;
        this.kmFinal = kmFinal;
        this.finalizado = finalizado;
        this.gasoil = gasoil;
        this.autopista = autopista;
        this.dietas = dietas;
        this.otrosGastos = otrosGastos;
        this.incidencias = incidencias;
        this.horasTRabajadas = horasTRabajadas;
        this.listViajes = listViajes;
    }

    public String getIdParte() {
        return idParte;
    }

    public void setIdParte(String idParte) {
        this.idParte = idParte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(Double kmInicio) {
        this.kmInicio = kmInicio;
    }

    public Double getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(Double kmFinal) {
        this.kmFinal = kmFinal;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    public Double getGasoil() {
        return gasoil;
    }

    public void setGasoil(Double gasoil) {
        this.gasoil = gasoil;
    }

    public Double getAutopista() {
        return autopista;
    }

    public void setAutopista(Double autopista) {
        this.autopista = autopista;
    }

    public Double getDietas() {
        return dietas;
    }

    public void setDietas(Double dietas) {
        this.dietas = dietas;
    }

    public Double getOtrosGastos() {
        return otrosGastos;
    }

    public void setOtrosGastos(Double otrosGastos) {
        this.otrosGastos = otrosGastos;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public Double getHorasTRabajadas() {
        return horasTRabajadas;
    }

    public void setHorasTRabajadas(Double horasTRabajadas) {
        this.horasTRabajadas = horasTRabajadas;
    }

    public tAdministrador gettA() {
        return tA;
    }

    public void settA(tAdministrador tA) {
        this.tA = tA;
    }

    public tLogistica gettL() {
        return tL;
    }

    public void settL(tLogistica tL) {
        this.tL = tL;
    }
    
    
    
    
}
