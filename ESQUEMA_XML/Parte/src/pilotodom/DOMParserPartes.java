package pilotodom;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DOMParserPartes {

    //No generics
    private List partes,viajes;
    private Document dom;

    public DOMParserPartes() {
        //create a list to hold the notice objects
        partes = new ArrayList();
        viajes= new ArrayList();
    }

    public void runExample() throws ParseException {

        //parse the xml file and get the dom object
        parseXmlFile();

        //get each notice element and create a Noticia object
        parseDocument();

        //Iterate through the list and print the data
        printData();

    }

    private void parseXmlFile() {
        //get the factory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dom = db.parse("partes.xml");
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private void parseDocument() throws ParseException {
        //get the root elememt
        Element docEle = dom.getDocumentElement();

        //get a nodelist of <noticia> elements
        NodeList nl = docEle.getElementsByTagName("parte");
        if (nl != null && nl.getLength() > 0) {
            for (int i = 0; i < nl.getLength(); i++) {

                //get the libro element
                Element el = (Element) nl.item(i);

                //get the libro object
                Parte p = getParte(el);

                //add it to list
                partes.add(p);
            }
        }
        
        
    }

    /**
     * I take an notice element and read the values in, create an Noticia
     * object and return it
     *
     * @param notEl
     * @return
     */
    private Parte getParte(Element notEl) throws ParseException {       
              
           String idParte = getTextValue(notEl, "idParte");
           Date fecha = getDateValue(notEl, "fecha"); 
          
            int kmInicio = getIntValue(notEl, "kmInicio");
             String kmFinal = getIntValue(notEl, "kmFinal");
            String incidencias = getTextValue(notEl, "incidencias");
             String avisos = getTextValue(notEl, "avisos");
              String finalizado = getCharValue(notEl, "finalizado");
               String gasoil = getIntValue(notEl, "gasoil");
                String autopistas = getIntValue(notEl, "autopistas");
                 String dietas = getIntValue(notEl, "dietas");
                  String otrosGastos = getIntValue(notEl, "otrosGastoso");
                   String horasTrabajadas = getIntValue(notEl, "horasTrabajadas");
                    String trabajador_dni  = getTextValue(notEl, "Trabajador_dni ");
                     String vehiculo_matricula=getTextValue(notEl, "Vehiculo_matricula");
                   
           Parte p= new  Parte(idParte,fecha, kmInicio, kmFinal,finalizado,gasoil, autopista,dietas, otrosGastos, incidencias, horasTRabajadas);
           return p;
    }
 
 }
    /**
     * I take a xml element and the tag name, look for the tag and get the text
     * content i.e for <item><title>John....</title><item> xml snippet if the
     * Element points to notice node and tagName is title I will return John
     *
     * @param ele
     * @param tagName
     * @return
     */
    private String getTextValue(Element ele, String tagName) {
        String textVal = null;
        NodeList nl = ele.getElementsByTagName(tagName);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            textVal = el.getFirstChild().getNodeValue();
        }
        return textVal;
    }

    /**
     * Iterate through the list and print the content to console
     */
    private void printData() {

        System.out.println("Número de libros " + libros.size());        
        System.out.println("\nDetalles de los libros\n");        
        System.out.println("\n------------------------------------------------");
        Iterator it = libros.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    private Date getDateValue(Element notEl, String fecha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
