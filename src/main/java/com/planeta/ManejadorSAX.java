
package com.planeta;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase para manejar los datos de planeta a traves del xml
 * @author migue
 */
public class ManejadorSAX extends DefaultHandler {

    private Stack<String> stack = new Stack<>();
    private Planeta cPlaneta;
    private Satelite cSatelite;
    private ArrayList<Planeta> planetas = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Rastrea los elementos de XML
        stack.push(qName);

        if (qName.equals("Planeta")) {
            cPlaneta = new Planeta();
            int idPlaneta = Integer.parseInt(attributes.getValue("Id"));
            cPlaneta.setIdPlaneta(idPlaneta);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();
        String currentElement = stack.peek();

        if (cPlaneta != null) {
            switch (currentElement) {
                case "Nombre":
                    cPlaneta.setNombre(value);
                    break;
                case "Tipo":
                    cPlaneta.setTipoPlaneta(TipoPlaneta.valueOf(value));
                    break;
                case "Radio":
                    cPlaneta.setRadio(Double.parseDouble(value));
                    break;
                case "Distancia_solar":
                    cPlaneta.setDistanciaSolar(Double.parseDouble(value));
                    break;
                case "Vida":
                    cPlaneta.setVida(Boolean.parseBoolean(value));
                    break;
            }
        }

        if (cSatelite != null) {
            switch (currentElement) {
                case "nom":
                    cSatelite.setNombre(value);
                    break;
                case "densidad":
                    cSatelite.setDensidad(Double.parseDouble(value));
                    break;
                case "fechaDescubrimiento":
                    cSatelite.setFechaDescubrimiento(value);
                    break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        stack.pop();

        if (qName.equals("Planeta")) {
            if (cSatelite != null) {
                cPlaneta.getSatelite().add(cSatelite);
                cSatelite = null;
            }
            planetas.add(cPlaneta);
            cPlaneta = null;
        }
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }
}
