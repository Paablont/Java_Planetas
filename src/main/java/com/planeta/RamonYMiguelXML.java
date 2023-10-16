package com.planeta;

import java.awt.List;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;
import javax.swing.JOptionPane;
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
    private static final String SAT = "sat";
    private static final String NOM = "nom";
    private static final String DENSIDAD = "densidad";
    private static final String FECHA_DESCUBRIMIENTO = "fechaDescubrimiento";
    private static final String PROPERTIES = "planetas.properties";

    public static void crearXML() throws Exception {

        String rutaArchivoXML = "mis_planetas.xml";
        File archivoXML = new File(rutaArchivoXML);
        if (archivoXML.exists()) {
            if (archivoXML.delete()) {
                PlanetaApp.logger.info("Archivo XML eliminado con éxito.");
            }
        }
        // Recuperación del archivo de propiedades para su posterior trabajo
        try {
            //Creo uno vacio y lo cargo, el objeto no se puede cambiar porque es final
            RamonYMiguelXML.myProperties.load(new FileInputStream(PROPERTIES));

        } catch (IOException e) {
            PlanetaApp.logger.error("No se pueden cargar la inicialización del programa. Saliendo...");
            System.exit(100);
        }

        String fichero_original = RamonYMiguelXML.myProperties.getProperty("xml_path.old");

        /*
         * DOM
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
            doc.appendChild(rootElement);
            RamonMiguelBinario.leerPlanetaCarac();
            ArrayList<Planeta> planeta = crearArrayListPlaneta();

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
     * Creamos Nodo de planeta
     *
     * @param doc
     * @param planeta
     * @return
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
            //Importante cuando creamos planeta, lo hacemos sin satelite, si no comprobamoos antes si tiene satelites dara error
            if (planeta.getSatelite() != null && !planeta.getSatelite().isEmpty()) {
                for (Satelite satelite : planeta.getSatelite()) {
                    Element sateliteElement = doc.createElement(SAT);

                    Element nombreSateliteElement = doc.createElement(NOM);
                    nombreSateliteElement.appendChild(doc.createTextNode(String.copyValueOf(satelite.getNombreCharArray())));
                    sateliteElement.appendChild(nombreSateliteElement);

                    Element densidadSateliteElement = doc.createElement(DENSIDAD);
                    densidadSateliteElement.appendChild(doc.createTextNode(Double.toString(satelite.getDensidad())));
                    sateliteElement.appendChild(densidadSateliteElement);

                    Element fechaDescubrimientoSateliteElement = doc.createElement(FECHA_DESCUBRIMIENTO);
                    fechaDescubrimientoSateliteElement.appendChild(doc.createTextNode(satelite.getFechaDescubrimiento()));
                    sateliteElement.appendChild(fechaDescubrimientoSateliteElement);

                    satelitePlaneta.appendChild(sateliteElement);
                }
                nodePlaneta.appendChild(satelitePlaneta);
            }

        } catch (DOMException e) {
            PlanetaApp.logger.error(e.getLocalizedMessage());
            throw e;
        }

        return nodePlaneta;
    }

    public static void leerXML() {
        // Recuperación del archivo de propiedades para su posterior trabajo
        try {
            RamonYMiguelXML.myProperties.load(new FileInputStream(PROPERTIES));
        } catch (IOException e) {
            PlanetaApp.logger.error("No se pueden cargar la inicialización del programa. Saliendo...");
            System.exit(100);
        }

        String fichero_original = RamonYMiguelXML.myProperties.getProperty("xml_path.old");

        try {
            Document doc = null; // doc es de tipo Document y representa el árbol DOM

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            dbf.setIgnoringComments(true);
            dbf.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = dbf.newDocumentBuilder();
            doc = builder.parse(new File(fichero_original));
            doc.getDocumentElement().normalize();

            PlanetaApp.logger.info("Recuperación de la información de los planetas");
            Planeta planeta;
            int idplane;
            String nom;
            TipoPlaneta tpPlaneta;
            Double radio, distSolar;
            Boolean vida;

            Node raiz = doc.getFirstChild();
            NodeList listaNodosPlaneta = raiz.getChildNodes();

            for (int i = 0; i < listaNodosPlaneta.getLength(); i++) {

                Node nodoPlaneta = listaNodosPlaneta.item(i);
                if (nodoPlaneta != null && nodoPlaneta.getNodeType() == Node.ELEMENT_NODE) {
                    Element ePlaneta = (Element) nodoPlaneta;
                    idplane = Integer.parseInt(ePlaneta.getAttribute(RamonYMiguelXML.ID));
                    nom = ePlaneta.getElementsByTagName(RamonYMiguelXML.NOMBRE).item(0).getTextContent();
                    tpPlaneta = TipoPlaneta.parse(ePlaneta.getElementsByTagName(RamonYMiguelXML.TIPO).item(0).getTextContent());
                    radio = Double.parseDouble(ePlaneta.getElementsByTagName(RamonYMiguelXML.RADIO).item(0).getTextContent());
                    distSolar = Double.parseDouble(ePlaneta.getElementsByTagName(RamonYMiguelXML.DISTANCIA_SOLAR).item(0).getTextContent());
                    vida = Boolean.valueOf(ePlaneta.getElementsByTagName(RamonYMiguelXML.VIDA).item(0).getTextContent());
                    ArrayList<Satelite> satelites = new ArrayList<>();
                    NodeList listaNodosSatelite = ePlaneta.getElementsByTagName(SATELITE);
                    //Importante cuando creamos planeta, lo hacemos sin satelite, si no comprobamoos antes si tiene satelites dara error
                    if (satelites.size() > 0) {
                        for (int j = 0; j < listaNodosSatelite.getLength(); j++) {
                            Element elementoSatelite = (Element) listaNodosSatelite.item(j);
                            String nombreSatelite = elementoSatelite.getElementsByTagName(NOM).item(0).getTextContent();
                            double densidad = Double.parseDouble(elementoSatelite.getElementsByTagName(DENSIDAD).item(0).getTextContent());
                            String fechaDescubrimiento = elementoSatelite.getElementsByTagName(FECHA_DESCUBRIMIENTO).item(0).getTextContent();
                            Satelite satelite = new Satelite(nombreSatelite.toCharArray(), densidad, fechaDescubrimiento);
                            satelites.add(satelite);
                        }
                    }

                    planeta = new Planeta(idplane, nom, distSolar, radio, vida, tpPlaneta, satelites);
                    JOptionPane.showMessageDialog(null, planeta + "\n" + satelites.toString(), "Planeta_XML", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (IOException | DOMException | TransformerFactoryConfigurationError | SAXException | ParserConfigurationException e) {
            PlanetaApp.logger.error(e.getMessage());
        }
    }

    public static String ArrayToString(ArrayList<Satelite> sat) {
        StringBuilder str = new StringBuilder();
        for (Satelite strSatelite : sat) {
            str.append(strSatelite);
        }
        return str.toString();
    }

    public static ArrayList<Planeta> crearArrayListPlaneta() throws IOException {
        ArrayList<Planeta> listaObjetos = new ArrayList<>();
        File carpeta = new File(Planeta.archivoBinario);

        if (carpeta.exists() && carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();

            for (File archivo : archivos) {
                if (archivo.isFile() && archivo.getName().endsWith(".bin")) {
                    try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
                        Planeta objeto = (Planeta) ois.readObject();
                        listaObjetos.add(objeto);
                    } catch (IOException | ClassNotFoundException e) {
                    }
                }
            }
        }
        return listaObjetos;
    }
}
