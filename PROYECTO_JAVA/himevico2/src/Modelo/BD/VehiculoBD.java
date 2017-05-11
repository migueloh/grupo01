/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import UML.Vehiculo;
import Modelo.BD.*;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Miguel
 */
public class VehiculoBD extends GenericoBD{
      private static Connection con;
    
    private static PreparedStatement Psentencia;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static Vehiculo vH;
    
    
    
   // CONSULTA MATRICULA DE VEHICULO 
   public static Vehiculo buscarporVehiculo(String matricula) throws Exception{
        
        
        
            CONECTAR();
            String plantilla = "SELECT * FROM Vehiculo WHERE matricula = ?";
            
            PreparedStatement ps = GenericoBD.CONECTAR().prepareStatement(plantilla);

            ps.setString(1,vH.getMatricula());
            
            ResultSet resultado = ps.executeQuery();
            
            
                while(resultado.next()){
                    vH = new Vehiculo();
                    vH.setMatricula(resultado.getString("matricula"));
                    
                }

            GenericoBD.cerrarBD(); 
            return vH;
                    
   }
  
    public static void insertar(Vehiculo V) throws Exception{

            CONECTAR();   
            
            String plantilla;

            plantilla = "INSERT INTO Vehiculo VALUES (?, ?, ?)";

            PreparedStatement ps = GenericoBD.CONECTAR().prepareStatement(plantilla);
            ps.setString(1, V.getMatricula());
            ps.setString(2, V.getTipo());
            ps.setDouble(3, V.getKm());
       
            ps.executeUpdate();
            
            cerrarBD();   
    }
    
        public static void darBaja(Vehiculo v) throws Exception{

            CONECTAR();   
            
            String plantilla;

            plantilla = "DELETE FROM Vehiculo WHERE matricula = ?";
            

            PreparedStatement ps = GenericoBD.CONECTAR().prepareStatement(plantilla);
            ps.setString(1,v.getMatricula());
           

            ps.executeUpdate();
            
            cerrarBD();   
    }
    
   public static ArrayList listaVehiculos(){
         String ve="";
        ArrayList<String>listaV=new ArrayList();

try{

String sql= "{ call listavehiculos (?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,OracleTypes.CURSOR); //parametro OUT
                  llamada.execute();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
        {
    ve=res.getString("matricula");
    listaV.add(ve);
          } 
     con.close();} 
        catch (Exception e) {}
//fin de mai      
return listaV;
    }  
public static Vehiculo VehiculoObjecto(){
             String matricula="";
         String tipo="";     
      double km=0;
       Vehiculo V=new Vehiculo();     
        ArrayList<Vehiculo>listaObjV=new ArrayList();

try{

String sql= "{ call vehiculoObjetoVacio (?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,OracleTypes.CURSOR); //parametro OUT
                  llamada.execute();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
      
        {
    matricula=res.getString("MATRICULA");
    tipo=res.getString("TIPO");
    km=res.getDouble("KM");
  
          } 
     con.close();} 
        catch (Exception e) {}
//fin de mai      
return V;
}
}
