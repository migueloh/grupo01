/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;


import UML.Acceso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Iker
 */
public class AccesoBD {
   
    private static String plantilla;
  
    private static ResultSet resultado;
      private static PreparedStatement Psentencia,sentencia;
  

 
    
      public static void altaCentro(Acceso A) throws Exception{
        try{ 
           
            plantilla = "INSERT INTO Acceso(usuario,contrasena,trabajador_dni) VALUES (?,?,?)";
            Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
           
            Psentencia.setString(1,A.getUsuario());
            Psentencia.setString(2,A.getContrasena());
            Psentencia.setString(3,A.getT().getDni());
            
             Psentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "subido");
            GenericoBD.cerrarBD();
            
          }
          catch(Exception e){
             // La empresa existe, no es un problema
              // El resto de las excepciones si las relanzo
              GenericoBD.cerrarBD();
          }
    }
   
 
    
// BUSCAR EL USUARIO DE ACCESO CON LA CONTRASENA INTRODUCIDA 

 public static Acceso conAcceso(Acceso A)throws Exception{
        String dni = "";
        String contrasena = "";
        String usuario = "";
         Acceso U = new Acceso();
        try{ 

            Psentencia = GenericoBD.CONECTAR().prepareStatement("SELECT * from Acceso where CONTRASENA=? and usuario= ?");
            
            Psentencia.setString(1,A.getContrasena());
            Psentencia.setString(2,A.getUsuario());
          
      
         resultado=Psentencia.executeQuery();
            
    if (resultado.next())
          {
              
              
              dni = resultado.getString("trabajador_dni");
              contrasena = resultado.getString("contrasena");
              usuario = resultado.getString("usuario");
          }
       
        U.setDni(dni);U.setContrasen(contrasena);U.setUsuario(usuario);            }
      
        catch(Exception e){
            
            System.out.println("Error "+e.getMessage()); 
        }
    GenericoBD.cerrarBD();
       return U;
     
    }
     
 public static String accederUsuario(Acceso A) {
      
        try {
           GenericoBD.CONECTAR();
            
            String a = "";
            sentencia =    GenericoBD.CONECTAR().prepareStatement("SELECT t.Categoria FROM Trabajador t, Acceso a WHERE t.dni = a.trabajador_dni AND a.usuario = ? AND a.contrasena = ?");
            sentencia.setString(1,A.getUsuario());
            sentencia.setString(2,A.getContrasena());
            
            resultado = sentencia.executeQuery();
            
            if (resultado.next()) {
                a = resultado.getString("CATEGORIA"); 
            }
            GenericoBD.cerrarBD();
            return a;  
           
        } 
        catch (Exception e) {
            try
            {
                GenericoBD.cerrarBD();
            }
            catch(Exception ex)
            {
                return "Error al Cerrar la Conexión";
            }
            return "Error Inexperado en la Conexión";
        }
       
    }
    
}
