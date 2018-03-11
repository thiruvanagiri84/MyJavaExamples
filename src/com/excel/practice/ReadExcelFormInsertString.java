package com.excel.practice;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcelFormInsertString {

  private String inputFile;

  public void setInputFile(String inputFile) {
    this.inputFile = inputFile;
  }

  public void read() throws IOException  {
    File inputWorkbook = new File(inputFile);
    Workbook w;
    try {
      w = Workbook.getWorkbook(inputWorkbook);
      // Get the first sheet
      Sheet sheet = w.getSheet(0);
      
      if(isValidFormat(sheet)){
    	  System.out.println("Sheet format is alright");
    	  
    	  StringBuffer sb = new StringBuffer();
    	  StringBuffer sbInsert = new StringBuffer();
    	  sbInsert.append("insert into PROFESSIONAL (profname, profemail) values ");
    	  for(int i=1;i<sheet.getRows();i++){
    		  for(int j=0;j<sheet.getColumns();j++){
    			  Cell cell = sheet.getCell(j, i); // column,row
    			  
    			  if(cell.getType() == CellType.LABEL){
    				  sb.append("'"+cell.getContents()+"',");
    			  }
    			  else{
    				  sb.append(cell.getContents()+",");
    			  }
    			  if((j+1)==sheet.getColumns()){ //when one full row is completed, send that row to insert into database
    				  String str = "("+sb.substring(0,sb.length()-1)+") , ";
    				  sb.setLength(0);
    				  sbInsert.append(str);
    				  //insertIntoDatabase(sb.toString());
    				  //sb.setLength(0); // After writing a row to DB, clear the contents of StringBuffer. We can also write - sb = new StringBuffer()
    			  }
    			  
    		  }
    	  }
    	  System.out.println("Final String: "+sbInsert.substring(0,sbInsert.length()-2));
      }
    } catch (BiffException e) {
      e.printStackTrace();
    }
  }

  private void insertIntoDatabase(String sb) {
	  //System.out.println(sb);
	  String str = sb.substring(0,sb.length()-1); // Removing the last ","
	  String insertQuery = "insert into PROFESSIONAL (profname, profemail) values ("+str+")";
	  System.out.println(insertQuery.toString());
	  
	  //Inserting into DB starts
	  final String JDBC_DRIVER = "org.apache.derby.jdbc.ClientDriver";  
	  final String DB_URL = "jdbc:derby://localhost:1527/sample;create=true";
	  final String USER = "user";
	  final String PASS = "app";
	  Connection conn = null;
	  Statement stmt = null;
	  
	  try{
		  Class.forName(JDBC_DRIVER);
	      System.out.println("Connecting to database...");
	      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	      stmt = conn.createStatement();
	      System.out.println("here");
	      int result = stmt.executeUpdate(insertQuery);
	      if(result == 0){
	    	  System.out.println("Sucess");
	      }
	      stmt.close();
	      conn.close();
	  }catch(SQLException se){
		  se.printStackTrace();
	  }catch(ClassNotFoundException ce){
		  ce.printStackTrace();
	  }
	  
	  
	  
  }

private boolean isValidFormat(Sheet sheet) {
	  boolean valid = false;
	  
	  Cell cell = sheet.getCell(0, 0);
	  if(cell.getContents().equalsIgnoreCase("profid")){
		  valid = true;
	  }else{
		  valid = false;
		  System.out.println("1st column heading is not ProfId");
	  }
	    	
	  Cell cell2 = sheet.getCell(1, 0);
	  if(cell2.getContents().equalsIgnoreCase("profname")){
		  valid = true;
	  }else{
		  valid = false;
		  System.out.println("2nd column heading is not ProfName");
	  }
	  
	  Cell cell3 = sheet.getCell(2, 0);
	  if(cell3.getContents().equalsIgnoreCase("profemail")){
		  valid = true;
	  }else{
		  valid = false;
		  System.out.println("3rd column heading is not ProfEmail");
	  }
	  
	  return valid;
}

public static void main(String[] args) throws IOException {
	ReadExcelFormInsertString test = new ReadExcelFormInsertString();
    test.setInputFile("c:/Santosh/Test.xls");
    test.read();
  }

} 
