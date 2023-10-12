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

/**
 *
 * @author migue
 */
public class RamonYMiguelXML {
     // usamos patrón singleton para tener un único objeto properties
    private static final Properties myProperties = new Properties();

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
            Element rootElement = doc.createElement("PLANETAS");
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
            File file = new File("XML_" + fichero_original);
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
        Element nodeLibro = null;
        try {
            nodeLibro = doc.createElement("PLANETA");

            // atributo del elemento
            Attr attr = doc.createAttribute("NOMBRE");
            attr.setValue(planeta.getNombre());
            nodeLibro.setAttributeNode(attr);

            // Titulo
            Element titulo = doc.createElement("TIPO");
            titulo.appendChild(doc.createTextNode(planeta.getTipoPlaneta().toString()));
            nodeLibro.appendChild(titulo);
        } catch (DOMException e) {
            System.out.println(e.getLocalizedMessage());
            throw e;
        }

        return nodeLibro;
    }
}
