/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;
import UML.Parte;
import UML.Centro;
import UML.Viaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.Date;
/**
 *
 * @author Iker
 */
public class ViajeBD {
     private static PreparedStatement Psentencia;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static Parte P;
     public static void altaV(Viaje V,int idParte) throws Exception{
        try{ 
           
            plantilla = "INSERT INTO Viaje(albaran,horaInicio,horaFin,parte_idParte) VALUES (?,?,?,?)";
            Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
           
            Psentencia.setString(1,V.getAlbaran());
            java.sql.Date sqlDate =  new java.sql.Date(V.getHoraInicio().getTime());
            Psentencia.setDate(2,sqlDate);
            java.sql.Date sqlDate2 =  new java.sql.Date(V.getHoraFin().getTime());
            Psentencia.setDate(3, sqlDate2);
            Psentencia.setInt(4, idParte);
            
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
    
}
