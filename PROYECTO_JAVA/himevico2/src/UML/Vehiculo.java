/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

/**
 *
 * @author Iker
 */
public class Vehiculo {
 private    String matricula;
  private   String tipo;
  private   Double km;


    public Vehiculo() {
    }

    public Vehiculo(String matricula, String tipo, Double km) {
        this.matricula = matricula;
        this.tipo = tipo;

    }

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getKm() {
        return km;
    }

    public void setKm(Double km) {
        this.km = km;
    }

  
    
}
