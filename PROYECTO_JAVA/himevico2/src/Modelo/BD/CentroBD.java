/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import UML.Centro;
import UML.Trabajador;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Iker
 */
public class CentroBD {
     private static Centro c;
          private static Connection con;
    
    private static PreparedStatement Psentencia;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
     public static void altaCentro(Centro c) throws Exception{
        try{ 
           
            plantilla = "INSERT INTO CENTRO(nombre,calle,numero,codpostal,ciudad,PROVINCIA,TELEFONO) VALUES (?,?,?,?,?,?,?)";
            Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
           
            Psentencia.setString(1,c.getNombre());
            Psentencia.setString(2,c.getCalle());
            Psentencia.setInt(3,c.getNumero());
             Psentencia.setInt(4, c.getCodPostal());
              Psentencia.setString(5,c.getCiudad() );
               Psentencia.setString(6, c.getProvincia());
                Psentencia.setInt(7, c.getTelefono());
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
     public static void bajaCentro(String nombre) throws Exception{
          
            plantilla = "delete from CENTRO where nombre = ?";
           Psentencia = GenericoBD.CONECTAR().prepareStatement(plantilla);
          Psentencia.setString(1,nombre);
            
         Psentencia.executeUpdate();
           JOptionPane.showMessageDialog(null, "borrado");
            GenericoBD.cerrarBD();
    }
     public static void modificaCentro(Centro c)throws Exception {
     
      try{ 
           
            plantilla = "update CENTRO set idcentro=?,nombre=?,calle=?,numero=?,CodPostal=?,ciudad=?,provincia=?,telefono=?)";
            Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
             Psentencia.setString(1,c.getIdCentro());
            Psentencia.setString(2,c.getNombre());
            Psentencia.setString(3,c.getCalle());
            Psentencia.setInt(4,c.getNumero());
             Psentencia.setInt(5, c.getCodPostal());
              Psentencia.setString(6,c.getCiudad() );
               Psentencia.setString(7, c.getProvincia());
                Psentencia.setInt(8, c.getTelefono());
             Psentencia.executeUpdate();
            
            GenericoBD.cerrarBD();
            
          }
          catch(Exception e){
             // La empresa existe, no es un problema
              // El resto de las excepciones si las relanzo
              GenericoBD.cerrarBD();     
                       }
                }
     //arraylist solo con nombre centros
public static ArrayList listaCentros(){
         String lu="";
        ArrayList<String>listacentros=new ArrayList();

try{

String sql= "{ call paquetecentros.listacentros (?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,OracleTypes.CURSOR); //parametro OUT
                  llamada.execute();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
        {
    lu=res.getString("NOMBRE");
    listacentros.add(lu);
          } 
     con.close();} 
        catch (Exception e) {}
//fin de mai      
return listacentros;
    }  
//arraylist con objeto centros.
public static ArrayList objetoCentros(){
          
         String nombre="";
         String calle="";
         int numero=0;
         int codPostal=0;
         String ciudad="";
         String provincia="";
         int telefono=0;       
        ArrayList<Centro>listaObjcentros=new ArrayList();

try{

String sql= "{ call paquetecentros.listacentros (?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,OracleTypes.CURSOR); //parametro OUT
                  llamada.execute();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
        c=new Centro();
        {
    nombre=res.getString("NOMBRE");
    calle=res.getString("CALLE");
    numero=res.getInt("NUMERO");
    codPostal=res.getInt("CODPOSTAL");
    ciudad=res.getString("CIUDAD");
    provincia=res.getString("PROVINCIA");
    telefono=res.getInt("TELEFONO");
    c.setCalle(calle);c.setCiudad(ciudad);c.setCodPostal(codPostal);c.setNombre(nombre);c.setNumero(numero);c.setProvincia(provincia);c.setTelefono(telefono);
    
    listaObjcentros.add(c);
          } 
     con.close();} 
        catch (Exception e) {}
//fin de mai      
return listaObjcentros;
    }  
  //String nombre, String calle,int numero,int codPostal,  String ciudad,String provincia, int telefono
}

