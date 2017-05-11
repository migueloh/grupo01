/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package himevico2;

import Modelo.BD.AccesoBD;
import Modelo.BD.CentroBD;
import Modelo.BD.ParteBD;
import Modelo.BD.TrabajadorBD;
import Modelo.BD.VehiculoBD;
import Modelo.BD.ViajeBD;
import Modelo.BD.tAdministradorBD;
import static Parse.CogerDatosDOM.Parse;
import Parse.DOMParserPartes;
import UML.Acceso;
import UML.Centro;
import UML.Parte;
import UML.Trabajador;
import UML.Vehiculo;
import UML.Viaje;
import Vistas.VentanaAcceso;
import Vistas.VentanaVehiculo;
import Vistas.comboCentros;
import Vistas.datosTraba;
import Vistas.panelAdmin;
import Vistas.panelCentro;
import Vistas.panelFiltroParte;
import Vistas.panelLg;
import Vistas.panelParte;

import Vistas.panelViaje;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
 import java.sql.*;
import java.text.ParseException;

import javax.swing.JOptionPane;



/**
 *
 * @author Iker
 */
public class controladora {
    // PANELES
      private static comboCentros conmbC;
  
  
    private static datosTraba dT;
 private static VentanaAcceso vA;
  private static panelCentro panelC;
    private static panelAdmin PanelAdmin;
    private static panelLg panelLG;
    private static panelParte panelP;
private static panelFiltroParte panelF;
    private static panelViaje panelV;
    private static VentanaVehiculo panelVe; 
 //OBJETOS   
    private static Vehiculo v;
      private static Trabajador T;
    private static Centro C;
    private static Acceso A;
    private static Parte P;
    private static Viaje V;
    private static ArrayList listViajes;
    private static Vehiculo Ve;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws ParseException, IOException {
        
            abrirPro();
             

       
     
            
         
    }                              
    //public static void abrirmenu(){primera.setVisible(false);Vlogin=new login();primera.setVisible(true);}
    public static void abrirPro(){ vA = new VentanaAcceso();vA.setVisible(true);  }
//Termina el programa
  public static void acabarV(){ System.exit(0);}
        // TODO code application logic here
 //Coge datos de la vista para pasarlos al controlador. Para Alta Trabajador   
    public static void subirTR(String dni, String nombre, String apellido1, String apellido2, String calle, String mano, String categoria, int numeroPortal, int piso, int telEmpresa, int telPersonal, Double salario, Date fechaNacimiento,String usuario,String contraseña) throws Exception{
         A=new Acceso(usuario,contraseña,dni);
          T =new Trabajador( dni, nombre,  apellido1,  apellido2,  calle, mano, categoria, numeroPortal, piso,telEmpresa, telPersonal,  salario, fechaNacimiento,A);
         
          
           try{
         TrabajadorBD.altaT(T);}
           catch(Exception e){JOptionPane.showMessageDialog(null, "Error alta Trabajador");} 
    }
    //Lo mismo que lo anterior pero para el centro
    public static void subirCentro( String nombre, String calle, int numero, int codPostal, String ciudad, String provincia, int telefono){
           C=new Centro( nombre,calle,numero,codPostal,ciudad,provincia,telefono);
           try{
         CentroBD.altaCentro(C);}
           catch(Exception e){JOptionPane.showMessageDialog(null, "Error alta C");} 
    }
   // abre panel de administrdor
    public static void abrirPanelAdmin(){PanelAdmin=new panelAdmin();PanelAdmin.setVisible(true);}
    //recoge el valor de la operacion para hacer alta baja o moduificacion segun el boton seleccionado en la vista
    public static void selecOperacion(String operacion){
        if((operacion.compareToIgnoreCase("alta" )==0)||operacion.compareToIgnoreCase("baja")==0||operacion.compareToIgnoreCase("modicar")==0)
        { dT=new datosTraba(operacion);dT.setVisible(true);  } 
      else
            panelC=new panelCentro(operacion);  panelC.setVisible(true);}
    //abre el panel de logistica
    public static void abrirpalelogist(){
        
        panelLG=new panelLg();panelLG.setVisible(true);} 
    //carga un combo box con todos los centros
    public static  ArrayList  mostrarL()throws Exception{
         ArrayList<String>liCentros=new ArrayList();
             liCentros=CentroBD.listaCentros();
                     return liCentros;
     }
    // carga un combo con todos los vehiculos
     public static  ArrayList  mostrarV()throws Exception{
         ArrayList<String>liV=new ArrayList();
             liV=VehiculoBD.listaVehiculos();
                     return liV;
     }
     //recoge el dni del trabajador para consultar el trabajador
    public static Trabajador consultaT(String vDni){
        T=new Trabajador();
        T=tAdministradorBD.consultaT(vDni);
    return T;
    }
    //recoge el dni par adar de baja el trabajador
    public static void bajaT(String dni){
    try{
  TrabajadorBD.bajaT(dni);}
    catch (Exception e){};
    }
    //recoge los datos del trabajador para despues modificarlos
    public static void modificarT(String dni, String nombre, String apellido1, String apellido2, String calle, String mano, String categoria, int numeroPortal, int piso, int telEmpresa, int telPersonal, Double salario, Date fechaNacimiento)
    {     
        T=new Trabajador(dni, nombre,  apellido1,  apellido2,  calle, mano, categoria, numeroPortal, piso,telEmpresa, telPersonal,  salario, fechaNacimiento);
        try{
            TrabajadorBD.modificarT(T);}
        catch(Exception e){};
    
    
    }
    //recoge el nombre para consultar datos centore
    public static void consultaC(String nombre){
      CentroBD.listaCentros();
    
    }
    //recoge datos para modificar el centro
    public static void modificarC(String nombre, String calle, int numero, int codPostal, String ciudad, String provincia, int telefono){
    C=new Centro( nombre,calle,numero,codPostal,ciudad,provincia,telefono);
           try{
        CentroBD.modificaCentro(C);}
           catch(Exception e){JOptionPane.showMessageDialog(null, "Error alta C");} 
    }
    //abre panel parte con estado vieajes
    public static void iniciarP(String estadoViaje){  
        String dni_trabajador=A.getDni();
              panelP=new panelParte(estadoViaje,dni_trabajador);panelLG.setVisible(false);panelP.setVisible(true);
    }
    //recoge datos para insertar un parte 
    public static int subirP(Date fecha, Double kmInicio, Double kmFinal, String finalizado, Double gasoil, Double autopista, Double dietas, Double otrosGastos, String incidencias, Double horasTrabajadas,String vehiculo_matricula,String trabajador_dni ){ 
        int idParte=0;
        P =new Parte(fecha,kmInicio,kmFinal,finalizado,gasoil,autopista,dietas,otrosGastos,incidencias,horasTrabajadas, vehiculo_matricula,trabajador_dni);
           try {
        idParte=ParteBD.altaP(P); 
           }
           catch (Exception e){JOptionPane.showMessageDialog(null, "Error alta P");}
          return idParte; 
    }
    //recoge datos para subir un viaje
   public static void subirVI(String albaran,Date horaInicio,Date horaFin,int idParte){
            P=new Parte();
          
           V=new Viaje(albaran,horaInicio,horaFin);
           try {
          ViajeBD.altaV(V,idParte);}
           catch (Exception e){JOptionPane.showMessageDialog(null, "Error alta V");} 
    }   
      //recoge nombre para dar de baja un centro
public static void bajaCentro(String nombre){
        ArrayList<String>existeCentro=new ArrayList();
        existeCentro=CentroBD.listaCentros();
        for(int x=0;x<existeCentro.size();x++){
     if (nombre.compareToIgnoreCase(existeCentro.get(x))==0)
        try{
             CentroBD.bajaCentro(nombre);
        
        
        }
                   catch(Exception e){}
        
        }
        //preguntar si hay que sacar mensajes si el centro no existe
    
}
//abre panel viajes 

public static void abrirViaje(int idParte){

panelV=new panelViaje(idParte);panelP.setVisible(false);panelV.setVisible(true);
}
//abre panel consulta partes
public static void panleFiltroParte(){
     panelF=new panelFiltroParte();PanelAdmin.setVisible(false);panelF.setVisible(true);

}
//mostrar combobox con dni de trabajadores
public static  ArrayList  mostrarDni()throws Exception{
         ArrayList<String>lidni=new ArrayList();
             lidni=TrabajadorBD.listaDni();
                     return lidni;
     }
//recoge datos para consultar partes
public static Parte consultaP(String Dni,Date fecha1,Date fecha2){
       ParteBD.consultaSimple(Dni);
       ParteBD.consulaDoble(Dni, fecha1);
        panelF=new panelFiltroParte(P);panelF.setVisible(true);

return P;
}
//para rellenar selecitem en caso de que no se seleccione....probandol
public static Vehiculo vehiculoVacio(){
Vehiculo ve =new Vehiculo();
   ve=VehiculoBD.VehiculoObjecto();

return ve; }
//recoge dni par abuscar parte no cerrado
public static Parte partenocerrado(String dni_trabajador){
       ParteBD.nocerrado(dni_trabajador);
return P;
}

//codigo miguel:
 //CREO metodo ACCESO 
    public static int consultarCategoria(String usuario, String contrasena){

        int val = 0;
        String dni_trabajador="";
        A = new Acceso();
        A.setUsuario(usuario);
        A.setContrasen(contrasena);
            try {
           String tipo = AccesoBD.accederUsuario(A);
                if (tipo.equals("a")) {
                    JOptionPane.showMessageDialog(null, "Bienvenid@ " + usuario);
                    abrirPanelAdmin();
                }
                else {
                    if (tipo.equals("l")) {
                        JOptionPane.showMessageDialog(null, "Bienvenid@ " + usuario);
                       A= consultarAcceso(A);
                        abrirpalelogist();
                    }
                    else {
                        val = -1;
                    }
                }          
            } 
            catch (Exception e) {
                System.out.println("Error Acceso Usuario " + e.getMessage());
            }
          return val;  
    } 
 public static Acceso consultarAcceso(Acceso A){
   
     try {
          A = AccesoBD.conAcceso(A);
             } catch (Exception e) {
                     }
     return A;
 }
  public static void insertarVehiculo(String matricula, String tipo, Double km){
          Vehiculo V = new Vehiculo();  
          
          V.setMatricula(matricula);V.setTipo(tipo);V.setKm(km);
            
        try {
            VehiculoBD.insertar(V);
        } catch (Exception e) {
            System.out.println("Error al Insertar el Vehículo: " + e.getMessage());
        }
    }      
// PARA BORRAR VEHICULO
    
        public static void borrarVehiculo(String matricula){
        try {
            v = new Vehiculo(matricula);
            VehiculoBD.darBaja(v);
        } catch (Exception e) {
            System.out.println("Error al Borrar el Vehículo: " + e.getMessage());
        }
    }
        public static void abrirVentanaVehiculo(){panelVe=new VentanaVehiculo();panelVe.setVisible(true);}
       
}
