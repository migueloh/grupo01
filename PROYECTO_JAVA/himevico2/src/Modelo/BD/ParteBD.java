/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import UML.Centro;
import UML.Parte;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Date;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author Iker
 */
public class ParteBD {
    private static PreparedStatement Psentencia;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
    private static Parte P;
    public static int altaP(Parte P) throws Exception{
        Date fecha=new Date();
        int idParte=0;
        try{ 
           
            plantilla = "INSERT INTO PARTE(fecha,kmInicio,kmFinal,finalizado,gasoil,autopista,dietas,otrosGastos,incidencias,horasTrabajadas,Trabajador_dni ,Vehiculo_matricula) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
            Psentencia.setDate(1, (java.sql.Date) fecha);
            Psentencia.setDouble(2,P.getKmInicio());
            Psentencia.setDouble(3,P.getKmFinal());
             Psentencia.setString(4, P.isFinalizado());
              Psentencia.setDouble(5,P.getGasoil() );
               Psentencia.setDouble(6, P.getAutopista());
                Psentencia.setDouble(7, P.getDietas());
                Psentencia.setDouble(8, P.getOtrosGastos());
                 Psentencia.setString(9,P.getIncidencias());
                  Psentencia.setDouble(10,P.getHorasTRabajadas());
                   Psentencia.setString(11,P.getT().getDni());
                   Psentencia.setString(12,P.getV().getMatricula());
                
                
             Psentencia.executeUpdate();
            JOptionPane.showMessageDialog(null, "subido");
            GenericoBD.cerrarBD();
            plantilla="select idparte from parte where fecha=? and dni=?";
              Psentencia= GenericoBD.CONECTAR().prepareStatement(plantilla);
                Psentencia.setDate(1, (java.sql.Date) fecha);
                     Psentencia.setString(2,P.getT().getDni());
                  resultado=  Psentencia.executeQuery();
                  
                  if(resultado.next()){
                      idParte=resultado.getInt("idParte");
                      
                      
                  }
                      
                     
          }
          catch(Exception e){}
             
              GenericoBD.cerrarBD();
              return idParte;
    }
     public static void bajaP(Parte P) throws Exception{
         
            plantilla = "delete from PARTE where fecha = ?";
           Psentencia = GenericoBD.CONECTAR().prepareStatement(plantilla);
          Psentencia.setDate(1, (java.sql.Date) P.getFecha());
            
         Psentencia.executeUpdate();
            GenericoBD.cerrarBD();
    }
public static ArrayList consultaSimple(String dni){
         Double kmini; 
         Double kmFinal;
         Double horasTrabajadas;
         String matricula;
         int idparte;
         Date fecha;
         String incidencias;
         String avisos;
         String finalizado;
         double gasoil;
         double autopistas;
         double dietas;
         double otros;
         String dniintro;
         
        ArrayList<Parte>listaObjParte=new ArrayList();

try{
//proc meto un dni y me da todos sus parte 
String sql= "{ call paqueteparte.solodni (?,?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(2,OracleTypes.CURSOR); //parametro OUT
                 llamada.setString(1, dni);
                  llamada.execute();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
        P=new Parte();
        {
   kmini=res.getDouble("kmInicio");
    kmFinal=res.getDouble("kmFinal");
  horasTrabajadas=res.getDouble("horasTrabajadas");
   matricula=res.getString("MATRICULA");
   idparte=res.getInt("idParte");
   fecha=res.getDate("fecha");
   incidencias=res.getString("incidencias");
   avisos=res.getString("avisos");
   finalizado=res.getString("finalizado");
   gasoil=res.getDouble("gasoil");
   autopistas=res.getDouble("autopistas");
   dietas=res.getDouble("dietas");
   otros=res.getDouble("otrosGastos");
  dniintro=res.getString("dni");
   
   
    
    P.setHorasTRabajadas(horasTrabajadas);P.setAutopista(autopistas);
    P.setDietas(dietas);P.setFecha(fecha);P.setFinalizado(finalizado);P.setGasoil(gasoil);P.setIdParte(idparte);
    P.setIncidencias(incidencias);P.setKmFinal(kmFinal);P.setKmInicio(kmini);P.setOtrosGastos(otros);P.getT().setDni(dni);
    P.getV().setMatricula(matricula);P.setAvisos(avisos);
    
   listaObjParte.add(P);
          } 
     GenericoBD.cerrarBD();} 
        catch (Exception e) {}
//fin de mai      
return listaObjParte;
    }  
   
public static Parte consulaDoble(String dni,Date fecha){
         try{
//proc meto un dni y me da todos sus parte 
String sql= "{ call paqueteparte.partePorDni (?,?,?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(2,OracleTypes.CURSOR); //parametro OUT
                 llamada.setString(1, dni);
                 llamada.setString(3 ,sql);
                  llamada.execute();
                       
     GenericoBD.cerrarBD();}
        catch (Exception e) {}
     return P;}
     public static Parte consultaTriple(String dni,Date fecha1,Date fecha2){
     return P;}
 public static Parte nocerrado(String dni_trabajador){
         Double kmini; 
         Double kmFinal;
         Double horasTrabajadas;
         String matricula;
         int idparte;
         Date fecha;
         String incidencias;
         String avisos;
         String finalizado;
         double gasoil;
         double autopistas;
         double dietas;
         double otros;
         String dni;
try{
//proc me da el parte cuyo finalizado es f
//recibo dni para meterlo en el where

String sql= "{ call paqueteparte.parte_abierto (?,?,?,?,?,?,?,?,?,?,?,?,?,?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,Types.NUMERIC); 
              llamada.registerOutParameter(2, Types.NUMERIC); // Número empleados devuelto
                llamada.registerOutParameter(3, Types.NUMERIC);
                  llamada.executeQuery();
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//falta asignar resto de valores


        P=new Parte();
        
   kmini=llamada.getDouble("kmInicio");
    kmFinal=res.getDouble("kmFinal");
  horasTrabajadas=res.getDouble("horasTrabajadas");
   matricula=res.getString("MATRICULA");
   idparte=res.getInt("idParte");
   fecha=res.getDate("fecha");
   incidencias=res.getString("incidencias");
   avisos=res.getString("avisos");
   finalizado=res.getString("finalizado");
   gasoil=res.getDouble("gasoil");
   autopistas=res.getDouble("autopistas");
   dietas=res.getDouble("dietas");
   otros=res.getDouble("otrosGastos");
  dni=res.getString("dni");
   
   
    
    P.setHorasTRabajadas(horasTrabajadas);P.setAutopista(autopistas);
    P.setDietas(dietas);P.setFecha(fecha);P.setFinalizado(finalizado);P.setGasoil(gasoil);P.setIdParte(idparte);
    P.setIncidencias(incidencias);P.setKmFinal(kmFinal);P.setKmInicio(kmini);P.setOtrosGastos(otros);P.getT().setDni(dni);
    P.getV().setMatricula(matricula);P.setAvisos(avisos);
    
 
          
     GenericoBD.cerrarBD();} 
        catch (Exception e) {}
//fin de mai      
return P;
    }  
 public static ArrayList parteparainforme(){
  Double kmini; 
         Double kmFinal;
         Double horasTrabajadas;
         int idparte;
         Date fecha;
         String incidencias;
         String avisos;
         String finalizado;
         double gasoil;
         double autopistas;
         double dietas;
         double otros;
         double kmInicio;
        
         
        ArrayList<Parte>listaObjParte=new ArrayList();

try{
//proc meto un dni y me da todos sus parte 
String sql= "{ call generarinforme2 (?)} ";
            CallableStatement llamada = GenericoBD.CONECTAR().prepareCall(sql);
                 llamada.registerOutParameter(1,OracleTypes.CURSOR); //parametro OUT
                // llamada.setDate(1,fechasql);
            
             ResultSet res = (ResultSet)llamada.getObject (1);    
               
//ejecutar el procedimiento
while(res.next())
        P=new Parte();
        {
   kmInicio=res.getDouble("kmInicio");
    kmFinal=res.getDouble("kmFinal");
  horasTrabajadas=res.getDouble("horasTrabajadas");

   idparte=res.getInt("idParte");
   fecha=res.getDate("fecha");
   incidencias=res.getString("incidencias");
   avisos=res.getString("avisos");
   finalizado=res.getString("finalizado");
   gasoil=res.getDouble("gasoil");
   autopistas=res.getDouble("autopistas");
   dietas=res.getDouble("dietas");
   otros=res.getDouble("otrosGastos");
 
    
    P.setHorasTRabajadas(horasTrabajadas);
    P.setAutopista(autopistas);
    P.setDietas(dietas);
    P.setFecha(fecha);
    P.setFinalizado(finalizado);
    P.setGasoil(gasoil);
    P.setIdParte(idparte);
    P.setIncidencias(incidencias);
    P.setKmFinal(kmFinal);
    P.setKmInicio(kmInicio);
    P.setOtrosGastos(otros);
    P.setAvisos(avisos);
   listaObjParte.add(P);
          } 
     GenericoBD.cerrarBD();} 
        catch (Exception e) {}
//fin de mai      
return listaObjParte;}
 
 
 
 
 
 }
             
             


