package com.jdbc;

import java.sql.*;

public class JdbcTestLocalDB {
   // JDBC driver name and database URL
   //static final String JDBC_DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	
	//https://www.callicoder.com/spring-boot-rest-api-tutorial-with-mysql-jpa-hibernate/
	
	
	static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
   static final String DB_URL = "jdbc:derby://localhost:1527/sample;create=true";
   final static String USER = "user";
   static final String PASS = "app";
   
   public static void main(String[] args) {
   Connection conn = null;
   Statement stmt = null;
   try{
      //STEP 2: Register JDBC driver
      Class.forName(JDBC_DRIVER);

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT count(*) as count FROM subcategory";
      ResultSet rs = stmt.executeQuery(sql);

      while(rs.next()){
         int count  = rs.getInt("count");
         System.out.print("Count is: " + count);
      }
      rs.close();
      stmt.close();
      conn.close();
   }catch(SQLException se){
      se.printStackTrace();
   }catch(Exception e){
      e.printStackTrace();
   }finally{
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   }//end try
}//end main
}//end FirstExample