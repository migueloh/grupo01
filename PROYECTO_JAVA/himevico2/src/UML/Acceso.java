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
public class Acceso {
private    String usuario;
 private    String contrasena;
private String dni;
private Trabajador T;


    public Acceso() {
    }

    public Acceso(String usuario, String contrasena,String dni) {
        this.usuario = usuario;
        this.contrasena = contrasena;
     
        
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasen(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Trabajador getT() {
        return T;
    }

    public void setT(Trabajador T) {
        this.T = T;
    }

    
    
    
}
