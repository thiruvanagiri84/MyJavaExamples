package com.basics.xmlValidation;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

@SuppressWarnings("restriction")
public class ValidateXML {

 public static void main (String[] args) {
  
	 String xsdPath = "C:\\Santosh\\WorkSpaces\\Practice\\Basics\\src\\com\\basics\\xmlValidation\\catalog.xsd";
	 String xmlPath = "C:\\Santosh\\WorkSpaces\\Practice\\Basics\\src\\com\\basics\\xmlValidation\\catalog.xml";
	 System.out.println("catalog.xml validates against catalog.xsd: "+validateXMLSchema(xsdPath,xmlPath));
	 
 }
 
 public static boolean validateXMLSchema(String xsdPath, String xmlPath){
     
     try {
    	 
    	 // SchemaFactory for schema language W3C XML Schema 1.0
         SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
         Source xmlFile = new StreamSource(new File(xmlPath));
         // Parse xsd a provides a schema object
         Schema schema = factory.newSchema(new File(xsdPath));
         // Processor to check XML is valid against schema
         Validator validator = schema.newValidator();
         // Validates the specified input
         validator.validate(xmlFile);
         
     } catch (SAXException e) {
         System.out.println("Exception: "+e.getMessage());
         return false;
     } catch (IOException e) {
			e.printStackTrace();
		}
     return true;
 }
 
}
