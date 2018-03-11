package com.basics.practice;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DomReadXmlStringProg {
	public static void main(String[] x) throws Exception{
		String xmlString = "<company><firstname>Santosh</firstname></company>";
		 //try{
		if (xmlString != null && xmlString.trim().length() > 0) {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
           
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(new StringReader(xmlString.trim())));
                Element root = doc.getDocumentElement();
                if (!root.getTagName().equals("company")) {
                    throw new RootElementException("Invalid root tag <" + root.getTagName() +"> in the xml string.");
                }
                System.out.println("Pass");
        }
		//Commenting all catch blocks since we used throws Exception at method level
		 /*}catch(IOException io){
			io.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (RootElementException e) {
			e.printStackTrace();
		}*/
        }
}
