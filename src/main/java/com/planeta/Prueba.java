/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.planeta;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author migue
 */
public class Prueba {
    private static final String PATH = "mis_plan";

    /**
     * @param filePath
     * @param args the command line arguments
     * @return
     * @throws java.lang.Exception
     */
   public static void leerXMLSAX(){
        File f = new File(PATH);

        try {
            SAXParserFactory spFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = spFactory.newSAXParser();

            // Se crea un manejador, que recorre el archivo SAX secuencialmente
            ManejadorSAX manejador = new ManejadorSAX();
            saxParser.parse(f, manejador);

            for (Planeta l : manejador.getPlanetas()) {
                JOptionPane.showMessageDialog(null, l, "Planeta_XML", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
