/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotodom;

import java.util.ArrayList;

/**
 *
 * @author Iker
 */
public class Centro {
  private   String idCentro;
  private    String nombre;
  private     String calle;
   private     String ciudad;
   private      String provincia;
    private     int numero;
    private     int codPostal;
    private     int telefono;
    private     ArrayList<Trabajador> listaTrabajadores;

    public Centro() {
    }

    public Centro( String nombre, String calle, String ciudad, String provincia, int numero, int codPostal, int telefono) {
      
        this.nombre = nombre;
        this.calle = calle;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.numero = numero;
        this.codPostal = codPostal;
        this.telefono = telefono;
        this.listaTrabajadores = listaTrabajadores;
        listaTrabajadores=new ArrayList();
        
    }

    public String getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(String idCentro) {
        this.idCentro = idCentro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(int codPostal) {
        this.codPostal = codPostal;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public ArrayList<Trabajador> getListaTrabajadores() {
        return listaTrabajadores;
    }

    public void setListaTrabajadores(ArrayList<Trabajador> listaTrabajadores) {
        this.listaTrabajadores = listaTrabajadores;
    }
        
    
    
}
