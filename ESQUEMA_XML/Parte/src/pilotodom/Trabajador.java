/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotodom;

import java.util.Date;



/**
 *
 * @author Iker
 */
public class Trabajador {
 private    String dni;
 private     String nombre;
  private     String apellido1;
  private     String apellido2;
  private      String calle;
   private     String mano;
  private       String categoria;
   private      int numeroPortal;
   private      int piso;
   private      int telEmpresa;
   private      int telPersonal;
   private      Double salario;
   private     Date fechaNacimiento;
   private     Centro C;
   private     Acceso A;

    public Trabajador() {
    }

    public Trabajador(String dni, String nombre, String apellido1, String apellido2, String calle, String mano, String categoria, int numeroPortal, int piso, int telEmpresa, int telPersonal, Double salario, Date fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.calle = calle;
        this.mano = mano;
        this.categoria = categoria;
        this.numeroPortal = numeroPortal;
        this.piso = piso;
        this.telEmpresa = telEmpresa;
        this.telPersonal = telPersonal;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
     
    }

   
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getNumeroPortal() {
        return numeroPortal;
    }

    public void setNumeroPortal(int numeroPortal) {
        this.numeroPortal = numeroPortal;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public int getTelEmpresa() {
        return telEmpresa;
    }

    public void setTelEmpresa(int telEmpresa) {
        this.telEmpresa = telEmpresa;
    }

    public int getTelPersonal() {
        return telPersonal;
    }

    public void setTelPersonal(int telPersonal) {
        this.telPersonal = telPersonal;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Centro getC() {
        return C;
    }

    public void setC(Centro C) {
        this.C = C;
    }

    public Acceso getA() {
        return A;
    }

    public void setA(Acceso A) {
        this.A = A;
    }
       
       
    
}
