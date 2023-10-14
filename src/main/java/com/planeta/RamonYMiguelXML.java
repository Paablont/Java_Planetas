/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.planeta;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author migue
 */
public class RamonYMiguelXML {
     // usamos patrón singleton para tener un único objeto properties
    private static final Properties myProperties = new Properties();
            //Declaración de constantes
    private static final String PLANETAS = "PLANETAS";
    private static final String PLANETA = "Planeta";
    private static final String NOMBRE = "Nombre";
    private static final String TIPO = "Tipo";
    private static final String RADIO = "Radio";
    private static final String DISTANCIA_SOLAR = "Distancia_solar";
    private static final String VIDA = "Vida";
    private static final String SATELITE = "Satelite";
    private static final String ID = "Id";

    public static void crearXML(ArrayList<Planeta> planeta) throws Exception {
        // Recuperación del archivo de propiedades para su posterior trabajo
        try {
            //Creo uno vacio y lo cargo, el objeto no se puede cambiar porque es final
            RamonYMiguelXML.myProperties.load(new FileInputStream("planetas.properties"));
        } catch (IOException e) {
            System.out.println("No se pueden cargar la inicialización del programa. Saliendo...");
            System.exit(100);
        }

        String fichero_original = RamonYMiguelXML.myProperties.getProperty("xml_path.old");

        /*
         * PARTE A.
         * Creamos un Document con la raíz llamada "Libros", usando el API de
         * DOM, y colgamos de esa raíz todos los elementos hijos que
         * consideremos necesarios.
         */
        Document doc = null;
        try {
            //creamos una fabrica de objetos y cogemos la varibale y la instacioamos
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //Lo creamos el documento,documento xml vacio
            doc = docBuilder.newDocument();
            //creamos el elemento raiz
            Element rootElement = doc.createElement(PLANETAS);
            //agregamos el documento vacio, se corresponde con <Libros/>
            doc.appendChild(rootElement);

            Element planetaNode;
            //Creamos un nodo
            for (Planeta plan : planeta) {
                planetaNode = RamonYMiguelXML.createNodePlaneta(doc, plan);
                rootElement.appendChild(planetaNode);
            }

            
        } catch (ParserConfigurationException | DOMException e) {
            System.out.println(e.getLocalizedMessage());
            throw e;
        }

        /*
         * PARTE B.
         * Escribimos el objeto Document, que tenemos en memoria, a un archivo
         */
        try {
            //Transforma el objeto XML a un documento en formato texto
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);
            File file = new File(fichero_original);
            if (!file.exists()) {
                file.createNewFile();
            }
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);
        } catch (TransformerFactoryConfigurationError | TransformerException | IOException e) {
            System.out.println(e.getLocalizedMessage());
            throw e;
        }
    }

    /**
     * Crea un nodo de tipo &lt;Libro&gt; con todos los datos que necesite, y lo
     * devuelve en formato Element.
     *
     * @param doc Document para ayudarnos a crear los elementos necesarios
     * @param libro libro a considerar para su transformación a XML
     * @return Element libro en formato XML
     * @throws DOMException
     */
    private static Element createNodePlaneta(Document doc, Planeta planeta) throws DOMException {
        // nodo donde colgaremos todos los datos de un libro
        Element nodePlaneta = null;
        try {
            nodePlaneta = doc.createElement(PLANETA);

            // atributo del elemento
            Attr attr = doc.createAttribute(ID);
            attr.setValue(Integer.toString(planeta.getIdPlaneta()));
            nodePlaneta.setAttributeNode(attr);

            // Titulo
            Element nombre = doc.createElement(NOMBRE);
            nombre.appendChild(doc.createTextNode(planeta.getNombre()));
            nodePlaneta.appendChild(nombre);
            
            Element tipoPlaneta = doc.createElement(TIPO);
            tipoPlaneta.appendChild(doc.createTextNode(planeta.getTipoPlaneta().toString()));
            nodePlaneta.appendChild(tipoPlaneta);
            
            Element radioPlaneta = doc.createElement(RADIO);
            radioPlaneta.appendChild(doc.createTextNode(Double.toString(planeta.getRadio())));
            nodePlaneta.appendChild(radioPlaneta);
            
            Element distanciaPlaneta = doc.createElement(DISTANCIA_SOLAR);
            distanciaPlaneta.appendChild(doc.createTextNode(Double.toString(planeta.getDistanciaSolar())));
            nodePlaneta.appendChild(distanciaPlaneta);
            
            Element vidaPlaneta = doc.createElement(VIDA);
            vidaPlaneta.appendChild(doc.createTextNode(Boolean.toString(planeta.isVida())));
            nodePlaneta.appendChild(vidaPlaneta);
            
            Element satelitePlaneta = doc.createElement(SATELITE);
            satelitePlaneta.appendChild(doc.createTextNode(planeta.getSatelite().toString()));
            nodePlaneta.appendChild(satelitePlaneta);
            
            
        } catch (DOMException e) {
            System.out.println(e.getLocalizedMessage());
            throw e;
        }

        return nodePlaneta;
    }

    public static void leerXML() {
        // Recuperación del archivo de propiedades para su posterior trabajo
        try {
            RamonYMiguelXML.myProperties.load(new FileInputStream("planetas.properties"));
        } catch (IOException e) {
            System.out.println("No se pueden cargar la inicialización del programa. Saliendo...");
            System.exit(100);
        }

        String fichero_original = RamonYMiguelXML.myProperties.getProperty( "xml_path.old");

        try {
            Document doc = null; // doc es de tipo Document y representa el árbol DOM

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = dbf.newDocumentBuilder();
            doc = builder.parse(new File(fichero_original));
            doc.getDocumentElement().normalize();

            System.out.println("Recuperación de la información de los planetas");
            Planeta planeta;
            int idplane;
            String nom; //datos a recuperar de cada libro
            TipoPlaneta tpPlaneta;
            Double radio,distSolar;
            Boolean vida;
            ArrayList<Satelite> sat = null;
            //Obtengo la raiz hijo <Libros/>
            Node raiz = doc.getFirstChild();
            //Obtenemos Libro
            NodeList listaNodosPlaneta = raiz.getChildNodes();

            for (int i = 0; i < listaNodosPlaneta.getLength(); i++) {
                
                Node nodoPlaneta = listaNodosPlaneta.item(i);
                if (nodoPlaneta != null && nodoPlaneta.getNodeType() == Node.ELEMENT_NODE) {
                    Element ePlaneta = (Element) nodoPlaneta;
                    idplane = Integer.parseInt(ePlaneta.getAttribute(RamonYMiguelXML.ID));
                    nom = ePlaneta.getElementsByTagName(RamonYMiguelXML.NOMBRE).item(0).getTextContent();
                    tpPlaneta =TipoPlaneta.parse(ePlaneta.getElementsByTagName(RamonYMiguelXML.TIPO).item(0).getTextContent());
                    radio = Double.parseDouble(ePlaneta.getElementsByTagName(RamonYMiguelXML.RADIO).item(0).getTextContent());
                    distSolar = Double.parseDouble(ePlaneta.getElementsByTagName(RamonYMiguelXML.DISTANCIA_SOLAR).item(0).getTextContent());
                    vida = Boolean.valueOf(ePlaneta.getElementsByTagName(RamonYMiguelXML.DISTANCIA_SOLAR).item(0).getTextContent());
                    
                    
                    planeta = new Planeta(idplane,nom,distSolar,radio,vida,tpPlaneta,sat);
                    System.out.println(planeta);
                }
            }
        } catch (IOException | DOMException | TransformerFactoryConfigurationError | SAXException | ParserConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

}
