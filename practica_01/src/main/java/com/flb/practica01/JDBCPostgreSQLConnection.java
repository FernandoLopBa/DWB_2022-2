package com.flb.practica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCPostgreSQLConnection{

    private final String url = "jdbc:postgresql://localhost:5432/customer_region";
    private final String user = "cus_reg";
    private final String password = "cus_reg";

    public Connection connect(){
	Connection conn = null;

	try{
	    conn = DriverManager.getConnection(url, user, password);

	    if(conn != null)
		System.out.println("Conexión exitosa a postgresql!");
	    else
		System.out.println("Error al conectar con la base de datos");
	}catch (SQLException e){
	    System.out.println(e.getMessage());
	}

	return conn;
    }

    public void getCustomers(){
	Customer aux;
	Connection c = null;
	Statement stmt = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(url, user, password);
	    c.setAutoCommit(false);

	    stmt = c.createStatement();
	    ResultSet rs = stmt.executeQuery("SELECT * FROM customer;");
	    while(rs.next()){
	     int id = rs.getInt("customer_id");
	     String nombre = rs.getString("name");
	     String surname = rs.getString("surname");
	     String mail = rs.getString("mail");
	     String rfc = rs.getString("rfc");
	     int region = rs.getInt("region");
	     ResultSet regS = stmt.executeQuery(String.format("SELECT * FROM region WHERE region_id=%d;",region));
	     aux = new Customer(id, nombre, surname, rfc, mail, new Region(region, regS.getString("region")));
	     System.out.println(aux.toString());
	 }
	 rs.close();
	 stmt.close();
	 c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      //System.out.println("Opened database successfully");
    }

    public void createCustomer(Customer customer){
	Connection c = null;
	Statement stmt = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(url, user, password);
	    c.setAutoCommit(false);

	    stmt = c.createStatement();
	    ResultSet rs = stmt.executeQuery(String.format("INSERT INTO customer (customer_id, name, surname, rfc, mail, region) VALUES (%s)", customer.insert()));
	 rs.close();
	 stmt.close();
	 c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
    }

    public void deleteCustomer(int customer_id){
	Connection c = null;
	Statement stmt = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(url, user, password);
	    c.setAutoCommit(false);

	    stmt = c.createStatement();
	    stmt.executeUpdate(String.format("DELETE FROM customer WHERE customer_id=%d;",customer_id));
	 stmt.close();
	 c.commit();
	 c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
    }

    public void createRegion(Region region){
	Connection c = null;
	Statement stmt = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(url, user, password);
	    c.setAutoCommit(false);

	    stmt = c.createStatement();
	    stmt.executeUpdate(String.format("INSERT INTO region (region_id, region) VALUES (%s);", region.insert()));
	 stmt.close();
	 c.commit();
	 c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
    }

    public Region getRegion(int region_id){
	Connection c = null;
	Statement stmt = null;
	Region reg = null;
	try {
	    Class.forName("org.postgresql.Driver");
	    c = DriverManager.getConnection(url, user, password);
	    c.setAutoCommit(false);

	    stmt = c.createStatement();
	    ResultSet rs = stmt.executeQuery(String.format("SELECT * FROM region WHERE region_id=%d;", region_id));
	    if(rs.next())
		reg = new Region(rs.getInt("region_id"), rs.getString("region"));
	 rs.close();
	 stmt.close();
	 c.close();
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      return reg;
    }

}
