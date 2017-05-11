/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parse;


import Modelo.BD.ParteBD;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import UML.Parte;
import java.util.Date;

/**
 * @author MIGUEL
 */

public class DOMParserPartes  {
   private ArrayList <Parte> partes;
    private Document document;
    private Element element;
   /* public void runExample2(Date fecha) throws IOException {        
       
   
       
        loadData(fecha);
        createDOMDoc();
        createDOMTree();        
        printToFile();
        //xmlHtml();
    }
    
  ///LUEGO BORRAR LO DE ABAJO
    
    private void loadData(Date fecha) throws IOException {
    partes=new ArrayList();
    partes = ParteBD.parteparainforme(fecha);
     
    }
    
    ///LUEGO BORRAR LO DE ARRIBA
   
   
  
    
    private void printToFile() {

        try {
            //print
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            //to generate output to console use this serializer
            //XMLSerializer serializer = new XMLSerializer(System.out, format);

            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("partes.xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
   private void createDOMDoc() {   
         try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                dom = docBuilder.newDocument();
		rootElement= dom.createElement("listaP");
		dom.appendChild(rootElement);
            } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
            }
    }
    private void createDOMTree() {   
        Iterator it = partes.iterator();
        while (it.hasNext()) {
            Parte P = (Parte) it.next();
            //For each Contact object  create <contacto> element and attach it to root
           
            rootElement.appendChild(createParteElement(P));
        }
    }
    private Element createParteElement(Parte P) {
       
        
         Element parte = dom.createElement("parte");
             
              
                    
                    Element idParte = dom.createElement("idParte");
                    Text idPartetext = dom.createTextNode(String.valueOf(P.getIdParte()));
                    idParte.appendChild(idPartetext);
                    parte.appendChild(idParte);
                
                    
                    Element fecha = dom.createElement("fecha");
                    Text fechatext = dom.createTextNode(String.valueOf(P.getFecha()));
                    fecha.appendChild(fechatext);
                    parte.appendChild(fecha);
                    
                   Element kmInicio = dom.createElement("kmInicio");
                    Text KMInicotext = dom.createTextNode(String.valueOf(P.getKmInicio()));
                    kmInicio.appendChild(KMInicotext);
                    parte.appendChild(kmInicio);
                    
                    Element kmFinal = dom.createElement("kmFinal");
                      Text KmFinaltext = dom.createTextNode(String.valueOf(P.getKmFinal()));
                      kmFinal.appendChild(KmFinaltext);
                    parte.appendChild(kmFinal);
                    
              
                            
                   
                             
                    Element finalizado = dom.createElement("finalizado");
                    Text fintext=dom.createTextNode(P.isFinalizado());
                  finalizado.appendChild(fintext);
                    parte.appendChild(finalizado);
                  
                    Element gasoil = dom.createElement("gasoil");
                    Text gastext=dom.createTextNode(String.valueOf(P.getGasoil()));
                     gasoil.appendChild(gastext);
                    parte.appendChild(gasoil);
                    
                    Element autopista = dom.createElement("autopista");
                    Text autotex=dom.createTextNode(String.valueOf(P.getAutopista()));
                    autopista.appendChild(autotex);
                    parte.appendChild(autopista);
                    
                    Element dietas = dom.createElement("dietas");
                      Text dietex=dom.createTextNode(String.valueOf(P.getDietas()));
                      dietas.appendChild(dietex);
                    parte.appendChild(dietas);                    
                            
                    Element otrosGastos = dom.createElement("otrosGastos");
                     Text otrostex=dom.createTextNode(String.valueOf(P.getOtrosGastos()));
                     otrosGastos.appendChild(otrostex);
                    parte.appendChild(otrosGastos); 
                    
                    
                    Element incidencias = dom.createElement("incidencias");
                      Text incitex=dom.createTextNode(P.getIncidencias());
                      incidencias.appendChild(incitex);
                    parte.appendChild(incidencias);
                
                    Element horasTrabajadas = dom.createElement("horasTRabajadas");
                     Text horastex=dom.createTextNode(String.valueOf(P.getHorasTRabajadas()));
                     horasTrabajadas.appendChild(horastex);
                    parte.appendChild(horasTrabajadas);
                   
        
                    return parte;
        
      
     
    }  */
 
   
  
   
    public void runExample() throws IOException {        
        //partes =; //consulta de partes mensuales LOAD DATA
        //controladora.
        partes = new ArrayList();
        // load Consulta
        loadData();
        createDOMDoc();
        createDOMTree();        
        printToFile();
    }
    
  ///LUEGO BORRAR LO DE ABAJO
    
    private void loadData() throws IOException {
        partes=ParteBD.parteparainforme();
      /*  int idParte=2;
        Date Date=new Date();   
        Double kmInicio=2.0;
        Double kmFinal=2.0;
        String finalizado="aaa";
        Double gasoil=3.0;
        Double autopista=8.0;
        Double dietas=10.5;
        Double otrosGastos=9.9;
        String incidencias="incidencia uno";
        Double horasTrabajadas=2.2;
        String vehiculo_matricula="9999XHK";
                String trabajador_dni="88888888y";
      partes.add(new Parte(idParte,Date, kmInicio, kmFinal, finalizado, gasoil, autopista, dietas, otrosGastos, incidencias, horasTrabajadas));
    
       // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      /*  do{
            System.out.println("Nuevo parte\n");
            System.out.println("Introduce el idparte: ");
            idParte=Integer.parseInt(br.readLine());
            System.out.println("Introduce la fecha");
            Date=SimpleDateFormat.parse(br.readLine());
               System.out.println("Introduce el km de inicio");
            kmInicio=br.readLine();     
            System.out.println("Introduce el km de final");
            kmFinal=br.readLine(); 
            System.out.println("Introduce finalizado");
            finalizado=br.readLine();
             System.out.println("Introduce gasoil");
            gasoil=br.readLine();
             System.out.println("Introduce autopista");
            autopista=br.readLine();
               System.out.println("Introduce diestas");
            dietas=br.readLine();
            System.out.println("Introduce ptrpsGastos");
            otrosGastos=br.readLine();
            System.out.println("Introduce incidencias");
            incidencias=br.readLine();
            System.out.println("Introduce horasTrabajadas");
            horasTrabajadas=br.readLine();
            do{
            System.out.println("\n¿Quieres seguir introduciendo más(S/N)? ");
            resp=br.readLine();
            }while (!resp.equals("S") && !resp.equals("N"));*/
        /*}while (resp.equals("S"));*/
    }
    
    ///LUEGO BORRAR LO DE ARRIBA
    private void createDOMDoc() {   
         try {

		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                document = docBuilder.newDocument();
		element= document.createElement("listaPartes");
		document.appendChild(element);
            } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
            }
    }
    private void createDOMTree() {   
        Iterator it = partes.iterator();
        while (it.hasNext()) {
            Parte p = (Parte) it.next();
            //For each Contact object  create <contacto> element and attach it to root
           
            element.appendChild(createParteElement(p));
        }
    }
    private Element createParteElement(Parte p) {
        Element partes = document.createElement("partes");
        element.appendChild(partes);            
                    
                Element parte = document.createElement("parte");
                parte.setAttribute("idParte", "fecha");
                partes.appendChild(parte);
                    
                    Element idParte = document.createElement("idParte");
                    String aux= String.valueOf(p.getIdParte());
                    idParte.appendChild(document.createTextNode(aux));
                    parte.appendChild(idParte);
                    
                    Element fecha = document.createElement("fecha");
                    fecha.appendChild(document.createTextNode(p.getFecha().toString()));
                    parte.appendChild(fecha);
                    
                    Element kmInicio = document.createElement("kmInicio");
                    kmInicio.appendChild(document.createTextNode(p.getKmInicio().toString()));
                    parte.appendChild(kmInicio);
                    
                    Element kmFinal = document.createElement("kmFinal");
                    kmFinal.appendChild(document.createTextNode(p.getKmFinal().toString()));
                    parte.appendChild(kmFinal);
                    
                    // CFON ESTE CONFLICTO SOLVETAMOS A LA HORA DE COGER UN BOOLEAN DEL PARTE PARA PODER CONVERTIRLO A STRING
                            
                    String finalizadoSN = String.valueOf(p.isFinalizado());
                            
                          
                    /*if (p.isFinalizado()){
                        finalizadoSN = "true";
                    }else{
                        finalizadoSN="false";
                    }*/
                    
                            
                    Element finalizado = document.createElement("finalizado");
                    finalizado.appendChild(document.createTextNode((finalizadoSN))) ;
                    parte.appendChild(finalizado);
                  
                    Element gasoil = document.createElement("gasoil");
                    gasoil.appendChild(document.createTextNode(p.getGasoil().toString()));
                    parte.appendChild(gasoil);
                    
                    Element autopista = document.createElement("autopista");
                    autopista.appendChild(document.createTextNode(p.getAutopista().toString()));
                    parte.appendChild(autopista);
                    
                    Element dietas = document.createElement("dietas");
                    dietas.appendChild(document.createTextNode(p.getDietas().toString()));
                    parte.appendChild(dietas);                    
                            
                    Element otrosGastos = document.createElement("otrosGastos");
                    otrosGastos.appendChild(document.createTextNode(p.getOtrosGastos().toString()));
                    parte.appendChild(otrosGastos); 
                    
                    
                    Element incidencias = document.createElement("incidencias");
                    incidencias.appendChild(document.createTextNode(p.getIncidencias()));
                    parte.appendChild(incidencias);
                    
                     Element avisos = document.createElement("avisos");
                    avisos.appendChild(document.createTextNode(p.getAvisos()));
                    parte.appendChild(avisos);
                
                    Element horasTRabajadas = document.createElement("horasTRabajadas");
                    horasTRabajadas.appendChild(document.createTextNode(p.getHorasTRabajadas().toString()));
                    parte.appendChild(horasTRabajadas);
                   
        
                    return partes;
    }
    
    private void printToFile() {

        try {
            //print
            OutputFormat format = new OutputFormat(document);
            format.setIndenting(true);

            //to generate output to console use this serializer
            //XMLSerializer serializer = new XMLSerializer(System.out, format);

            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("partes.xml")), format);

            serializer.serialize(document);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
    
    
   /* public static void xmlHtml(){
        try {

    TransformerFactory tFactory = TransformerFactory.newInstance();
    // PONER SIN MAS EL NOMBRE DEL ARCHIVO Y ASI MIRAR SI LO GUARDA EN LA RUTA DEL EN DONDE SE CARGA EL PROYECTO
    Source xslDoc = new StreamSource ("C:/Users/Public/Documents/ParteMensual.xslt");
    Source xmlDoc = new StreamSource ("ParteMensual.xml");
    
    String outputFileName="ParteMensual.html";
   
    OutputStream htmlFile=new FileOutputStream(outputFileName);
    Transformer transform = tFactory.newTransformer(xslDoc);
    transform.transform(xslDoc, new StreamResult(htmlFile));
    
    }
  catch(Exception e){
    e.printStackTrace();
    }*/
  }

    
