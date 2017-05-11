/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilotodom;

/**
 *
 * @author Iker
 */
public class Acceso {
private    String usuario;
 private    String contraseña;
  private   Trabajador T;
 private    String idAcceso;

    public Acceso() {
    }

    public Acceso(String usuario, String contraseña,String idAcceso) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.idAcceso=idAcceso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Trabajador getT() {
        return T;
    }

    public void setT(Trabajador T) {
        this.T = T;
    }
    
    
}
