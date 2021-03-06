package com.basics.xmlValidation;

import java.io.File;
import java.io.IOException;
 
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
 
import org.xml.sax.SAXException;
 
@SuppressWarnings("restriction")
public class XMLValidation {
 
    public static void main(String[] args) {
         
      // .xsd and .xml files are present in path: C:\Santosh\WorkSpaces\Practice\Basics
      System.out.println("EmployeeRequest.xml validates against Employee.xsd? "+validateXMLSchema("employee.xsd", "employeeRequest.xml"));
      System.out.println("EmployeeResponse.xml validates against Employee.xsd? "+validateXMLSchema("employee.xsd", "employeeResponse.xml"));
      System.out.println("employee.xml validates against Employee.xsd? "+validateXMLSchema("employee.xsd", "employee.xml"));
       
      }
     
    public static boolean validateXMLSchema(String xsdPath, String xmlPath){
         
        try {
            SchemaFactory factory = 
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));
        } catch (SAXException e) {
            System.out.println("Exception: "+e.getMessage());
            return false;
        } catch (IOException e) {
			e.printStackTrace();
		}
        return true;
    }
}