/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UML;

import pilotodom.Parte;
import sun.util.calendar.LocalGregorianCalendar.Date;

/**
 *
 * @author Iker
 */
public class Viaje {
 private    String albaran;
  private   Date horaInicio;
  private   Date horaFin;
 private    Parte P;

    public Viaje() {
    }

    public Viaje(String albaran, Date horaInicio, Date horaFin, Parte P) {
        this.albaran = albaran;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.P = P;
    }

    public String getAlbaran() {
        return albaran;
    }

    public void setAlbaran(String albaran) {
        this.albaran = albaran;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Parte getP() {
        return P;
    }

    public void setP(Parte P) {
        this.P = P;
    }
    
}
