/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import java.util.ArrayList;
import java.sql.*;
import java.util.Date;
/**
 *
 * @author Iker
 */
public class Parte {
 private    int idParte;
  private   Date fecha;
  private   Double kmInicio;
  private   Double kmFinal;
  private   String finalizado;
  private   Double gasoil;
   private Double autopista;
  private   Double dietas;
  private   Double otrosGastos;
   private  String incidencias;
  private   Double horasTrabajadas;
  private String avisos;
  private   Trabajador T;
 
  private   Vehiculo Ve;
  private   ArrayList<Viaje> listaViajes;

    public Parte() {
    }

    public Parte(int idParte) {
        this.idParte = idParte;
    }

    public Parte(int idParte, Date fecha, Double kmInicio, Double kmFinal, String finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTrabajadas)
   
             {
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
        this.horasTrabajadas = horasTrabajadas;
       
    
    }

    public Parte(int idParte, Date fecha, Double kmInicio, Double kmFinal, String finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTrabajadas, String avisos) {
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
        this.horasTrabajadas = horasTrabajadas;
        this.avisos = avisos;
    }

   

   

    public Parte( Date fecha, Double kmInicio, Double kmFinal, String finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTRabajadas) {
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
        this.horasTrabajadas = horasTRabajadas;
            listaViajes = new ArrayList();;
     
    }

    public Parte(Date fecha, Double kmInicio, Double kmFinal, String finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTrabajadas, String vehiculo_matricula, String trabajador_dni) {
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
        this.horasTrabajadas = horasTrabajadas;
        //news
        Ve=new Vehiculo();
       this.Ve.setMatricula(vehiculo_matricula);
       T=new Trabajador();
       this.T.setDni(incidencias);
    }

    public String getAvisos() {
        return avisos;
    }

    public void setAvisos(String avisos) {
        this.avisos = avisos;
    }

    

    

    public Trabajador getT() {
        return T;
    }

    public void setT(Trabajador T) {
        this.T = T;
    }

    

    public Double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(Double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public Vehiculo getV() {
        return Ve;
    }

    public void setV(Vehiculo Ve) {
        this.Ve = Ve;
    }

    public ArrayList<Viaje> getListViajes() {
        return listaViajes;
    }

    public void setListViajes(ArrayList<Viaje> listViajes) {
        this.listaViajes = listViajes;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
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

    public String isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
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
        return horasTrabajadas;
    }

    public void setHorasTRabajadas(Double horasTRabajadas) {
        this.horasTrabajadas = horasTRabajadas;
    }

   
    
    
    
    
}
