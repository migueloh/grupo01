/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.BD;

import UML.Acceso;
import UML.Parte;
import UML.Trabajador;
import UML.Centro;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Iker
 */

    public class tAdministradorBD extends Trabajador{
       private static Trabajador t;
       private static Parte p;
       private static Centro c;
          private static Connection con;
    
    private static PreparedStatement Psentencia;
    private static String plantilla;
    private static Statement sentencia;
    private static ResultSet resultado;
   
     
     
    public static java.util.Calendar conversionTimeCalendar(java.sql.Time hora) throws Exception{
        // java.sql.Time -- String -- Calendar
        String strhora = hora.toString();
        java.util.Calendar cal = java.util.Calendar.getInstance();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss");
        cal.setTime(sdf.parse(strhora));  
        return cal;
    }
    public static java.time.LocalTime conversionTimeLocalTime(java.sql.Time hora) throws Exception{
        // Time -- String -- Calendar
        String strhora = hora.toString();
        return LocalTime.parse(strhora);
    } 
   

    
   
  
   //callables:
 





public static Trabajador consultaT(String vDni){
    t = new Trabajador();   
    try{
        GenericoBD.CONECTAR();

        String sql= "{ call consulta_trabajador (?,?)} ";
        CallableStatement llamada = con.prepareCall(sql);
            llamada.setString(1, vDni);
            llamada.registerOutParameter(2, OracleTypes.CURSOR); 
                llamada.execute();
ResultSet res = (ResultSet)llamada.getObject (2); 


if(res.next()){
    t.setDni(res.getNString("dni"));
    t.setNombre(res.getNString("nombre"));
    t.setApellido1(res.getNString("apellido1"));
    t.setApellido2(res.getNString("apellido2"));
    t.setCalle(res.getNString("calle"));
    t.setMano(res.getNString("mano"));
    t.setCategoria(res.getNString("categoria"));
    t.setNumeroPortal(res.getInt("numeroPortal"));
    t.setTelEmpresa(res.getInt("telEmpresa"));
    t.setPiso(res.getInt("piso"));
    t.setTelPersonal(res.getInt("telPersonal"));
    t.setSalario(res.getDouble("salario"));
    t.setFechaNacimiento(res.getDate("fechaNacimiento"));
}
llamada.close();

con.close();

} catch (Exception e) {e.printStackTrace();}
//fin de main
    
   return t; 
}




}
    
    
    
    
    
    
    
    
    
    
    
            
    

